import visitor.*;
import nano.syntaxtree.*;
// import static CPSHelper.*;

import java.util.Enumeration;
import java.util.List;
import java.util.ArrayList;
import java.util.Vector;
import java.util.Set;
import java.util.HashSet;

public class ContinuationMaker {
    syntaxtree.NodeListOptional trailingStatements;
    syntaxtree.MethodDeclaration parentMethod;
    Transformer transformer;

    MethodDeclaration continuationMethod;
    ClassExtendsDeclaration continuationClass;
    NodeListOptional initStatements;

    String kName;
    String continuationMethodName;
    String className;
    public static String ORIG_OBJECT_NAME = "object";
    public static String CALL_METHOD_NAME = "call";
    public static final String CONTINUATION_CLASS_NAME_PREFIX = "___ContinuationClass";

    public static final int MAX_NUMBER_CONTINUATIONS = 50;

    public ContinuationMaker(syntaxtree.NodeListOptional trailingStatements,
                             syntaxtree.MethodDeclaration parentMethod,
                             Transformer transformer,
                             String kName,
                             String continuationMethodName) {
        this.trailingStatements = trailingStatements;
        this.parentMethod = parentMethod;
        this.transformer = transformer;
        this.kName = kName;
        this.continuationMethodName = continuationMethodName;

        className = CONTINUATION_CLASS_NAME_PREFIX + continuationMethodName;

        makeContinuationMethod();
        makeContinuationClass();
        makeInitStatements();
    }

    public void makeContinuationMethod(){
        // Add parameters
        syntaxtree.FormalParameterList parameterList = null;
        if (parentMethod.f4.present()){
            syntaxtree.FormalParameterList parentParameterList =
                    (syntaxtree.FormalParameterList) parentMethod.f4.node;
            parameterList = CPSHelper.getCopy(parentParameterList);
        }

        // Local VarDeclarations which are live in trailingStatements
        syntaxtree.NodeListOptional restParameters = new syntaxtree.NodeListOptional();

        // System.out.println("makeContinuationMethod:"); 
        // System.out.println("CPSHelper.getMicroFormattedString(parentMethod): " + CPSHelper.getMicroFormattedString(parentMethod));

        syntaxtree.NodeListOptional localVars = new syntaxtree.NodeListOptional();

        for (syntaxtree.Node node : parentMethod.f7.nodes){
            syntaxtree.VarDeclaration currVarDeclaration = (syntaxtree.VarDeclaration) node;
            LiveVariableFinder currFinder = new LiveVariableFinder(
                CPSHelper.getIdentifierName(currVarDeclaration.f1));

            // Variables that are found in trailingStatements and
            // whose initial value is being used
            if (trailingStatements.accept(currFinder)){
                if (currFinder.isLive){
                    restParameters.addNode(new syntaxtree.FormalParameterRest(
                        CPSHelper.getFormalParameter(currVarDeclaration)));
                }
                else{
                    localVars.addNode(CPSHelper.getCopy(currVarDeclaration));
                }
            }
        }

        // Add initialized local variables to the parameters
        if (parameterList != null){
            parameterList.f1.nodes.addAll(restParameters.nodes);
        } else {
            if (restParameters.present()){
                syntaxtree.NodeListOptional remainingRestParameters =
                        new syntaxtree.NodeListOptional();
                remainingRestParameters.nodes.addAll(
                    restParameters.nodes.subList(1, restParameters.nodes.size()));
                parameterList = new syntaxtree.FormalParameterList(
                    ((syntaxtree.FormalParameterRest) restParameters.nodes.get(0)).f1,
                    remainingRestParameters);
            }
        }
        
        syntaxtree.NodeOptional parameters = new syntaxtree.NodeOptional(parameterList);

        syntaxtree.MethodDeclaration tempMethod = new syntaxtree.MethodDeclaration(
            CPSHelper.getNewMicroIdentifier(continuationMethodName),
            parameters,
            localVars,
            // new syntaxtree.NodeListOptional(),
            trailingStatements);

        // System.out.println("CPSHelper.getMicroFormattedString(tempMethod): " + CPSHelper.getMicroFormattedString(tempMethod));
        continuationMethod = (MethodDeclaration) tempMethod.accept(transformer);
        // System.out.println("CPSHelper.getFormattedString(continuationMethod): " + CPSHelper.getFormattedString(continuationMethod));

        // System.out.println("Before adding normal local vars"); 
        // System.out.println("CPSHelper.getFormattedString(continuationMethod.f7): "
        //                    + CPSHelper.getFormattedString(continuationMethod.f7));

        // VVIP: you need to include the code in the JumpPoint of the
        // Nano method too.
        syntaxtree.NodeListOptional methodMicroBody = CPSHelper.getMicroMethodDeclaration(
            CPSHelper.getFormattedString(continuationMethod.f8)
            + CPSHelper.getFormattedString(continuationMethod.f9)).f8;

        NodeListOptional actualLocalVars = new NodeListOptional();
        
        for (Node node : continuationMethod.f7.nodes){
            VarDeclaration currVarDeclaration = (VarDeclaration) node;
            LiveVariableFinder currFinder = new LiveVariableFinder(
                CPSHelper.getIdentifierName(currVarDeclaration.f1));

            // Variables that are found in methodMicroBody and
            // whose initial value is NOT being used
            if (methodMicroBody.accept(currFinder) && !currFinder.isLive){
                // We'll deal with continuation variables separately
                if (CPSHelper.getFormattedString(currVarDeclaration.f0).startsWith(
                        CONTINUATION_CLASS_NAME_PREFIX)){
                    continue;
                }

                actualLocalVars.addNode(currVarDeclaration);
            }
        }

        // System.out.println("CPSHelper.getFormattedString(actualLocalVars): " + CPSHelper.getFormattedString(actualLocalVars));

        // System.out.println("CPSHelper.getMicroFormattedString(methodMicroBody): " + CPSHelper.getMicroFormattedString(methodMicroBody));
        // Hack to get local continuation variables 
        NodeListOptional continuationVars = CPSHelper.getNanoVarDeclarations(
            ContinuationMaker.getContinuationVarDeclarations(methodMicroBody));

        // f7.nodes.addAll(continuationVars.nodes);

        Set<String> currVarSet = new HashSet<String>();
        for (Node node : actualLocalVars.nodes){
            currVarSet.add(CPSHelper.getFormattedString(node));
        }
        // System.out.println("currVarSet: " + currVarSet);

        // Remove elements of continuationVars that are already in currVarSet
        for (Node node : continuationVars.nodes){
            // System.out.println("CPSHelper.getFormattedString(node): "
                               // + CPSHelper.getFormattedString(node));
            if (!currVarSet.contains(CPSHelper.getFormattedString(node))){
                // System.out.println("Chosen node"); 
                // TODO: Should I update currVarSet too?? Assuming
                // that there are no duplicates in continuationVars
                actualLocalVars.addNode(node);
            }
        }

        continuationMethod.f7 = actualLocalVars;

        // continuationMethod.f7.nodes.addAll(
        //     CPSHelper.getNanoVarDeclarations(localVars).nodes);

        // System.out.println("Before adding Continuations local vars"); 
        // System.out.println("CPSHelper.getFormattedString(continuationMethod.f7): "
        //                    + CPSHelper.getFormattedString(continuationMethod.f7));

        // // Hack to get local continuation variables 
        // NodeListOptional continuationVars = CPSHelper.getNanoVarDeclarations(
        //     getContinuationVarDeclarations(
        //         CPSHelper.getMicroStatementList(continuationMethod.f8)));
        // continuationMethod.f7.nodes.addAll(continuationVars.nodes);
    }

    public void makeContinuationClass(){
        NodeListOptional varDeclarations = CPSHelper.getVarDeclarationsFromParameterList(
            continuationMethod.f4.node);

        // Object to hold the reference to original class
        varDeclarations.addNode(new VarDeclaration(
            CPSHelper.getNewType(transformer.currClassName),
            CPSHelper.getNewIdentifier(ORIG_OBJECT_NAME)));

        // System.out.println("CPSHelper.getFormattedString(varDeclarations): " + CPSHelper.getFormattedString(varDeclarations));

        MethodDeclaration callMethod = new MethodDeclaration(
            CPSHelper.getNewIdentifier(CALL_METHOD_NAME),
            new NodeOptional(),
            new NodeListOptional(),
            new NodeListOptional(),
            new NodeOptional(new JumpPoint(new NodeChoice(
                new MessageSendStatement(CPSHelper.getNewIdentifier(ORIG_OBJECT_NAME),
                                         CPSHelper.getCopy(continuationMethod.f2),
                                         CPSHelper.getArgs(continuationMethod.f4.node)), 1))));
        
        continuationClass = new ClassExtendsDeclaration(
            CPSHelper.getNewIdentifier(className),
            CPSHelper.getNewIdentifier(transformer.CONTINUATION_BASE_CLASS_NAME),
            varDeclarations,
            new NodeListOptional(callMethod));
    }

    // TODO: Damn. You have to make sure the new "Continuation kName" has been
    // declared in the method.
    public void makeInitStatements(){
        initStatements = new NodeListOptional();

        // k2 = new Continuation1();
        initStatements.addNode(new Statement(new NodeChoice(new AssignmentStatement(
            new VarRef(
                new NodeChoice(CPSHelper.getNewIdentifier(kName), 1)),
            new Expression(new NodeChoice(
                new PrimaryExpression(new NodeChoice(new AllocationExpression(CPSHelper.getNewIdentifier(className)), 6)), 6))), 0)));

        // k2.foo = foo;
        for (Node node : continuationClass.f5.nodes){
            VarDeclaration currVarDeclaration = (VarDeclaration) node;

            // Ignore the "object" variable cos you're gonna set it to "this"
            if (CPSHelper.getIdentifierName(currVarDeclaration.f1).equals(ORIG_OBJECT_NAME)){
                initStatements.addNode(new Statement(new NodeChoice(
                    new AssignmentStatement(
                        new VarRef(new NodeChoice(
                            new DotExpression(CPSHelper.getNewIdentifier(kName),
                                              CPSHelper.getCopy(currVarDeclaration.f1)),
                            0)),
                        new Expression(new NodeChoice(new PrimaryExpression(
                            new NodeChoice(
                                new ThisExpression(), 4)), 6))), 0)));
            } else {
                initStatements.addNode(new Statement(new NodeChoice(
                    new AssignmentStatement(new VarRef(new NodeChoice(
                        new DotExpression(CPSHelper.getNewIdentifier(kName),
                                          CPSHelper.getCopy(currVarDeclaration.f1)),
                        0)), CPSHelper.getExpression(currVarDeclaration)), 0)));
            }
        }
    }

    /** 
     * @return true iff expression if of the form "new ContinuationClass()"
     */
    public static boolean isContinuationAllocation(
        syntaxtree.Expression expression){

        if (expression.f0.which == 6){
            syntaxtree.PrimaryExpression primaryExpression =
                    (syntaxtree.PrimaryExpression) expression.f0.choice;
            if (primaryExpression.f0.which == 6){
                String allocationClassString = CPSHelper.getIdentifierName(
                    ((syntaxtree.AllocationExpression) primaryExpression.f0.choice).f1);
                return allocationClassString.startsWith(CONTINUATION_CLASS_NAME_PREFIX);
            }
        }
        return false;
    }

    /** 
     * @return VarDeclaration for each continuation that is instantiated in bodyStatements.
     */
    public static syntaxtree.NodeListOptional getContinuationVarDeclarations(
        syntaxtree.NodeListOptional bodyStatements){

        syntaxtree.NodeListOptional continuationLocalVars = new syntaxtree.NodeListOptional();
        
        // VVIP: MAJOR HACK ahead: I need to know which continuation
        // variables have been instantiated in bodyStatements. But
        // they won't be declared in parentMethod. So, just running
        // over possible continuation variable names and seeing if
        // they are instantiated in bodyStatements.
        for (int i = 0; i < MAX_NUMBER_CONTINUATIONS; i++){
            LiveVariableFinder currFinder = new LiveVariableFinder(
                Transformer.getContinuationName(i));
            currFinder.isContinuationVar = true;

            // If it is found in bodyStatements and is
            // instantiated only inside bodyStatements
            if (bodyStatements.accept(currFinder) && !currFinder.isLive){
                syntaxtree.VarDeclaration localVar = new syntaxtree.VarDeclaration(
                    CPSHelper.getNewMicroType(
                        currFinder.continuationClassName),
                    CPSHelper.getNewMicroIdentifier(Transformer.getContinuationName(i)));
                continuationLocalVars.addNode(localVar);

                // System.out.println("Yoboyz"); 
                // System.out.println("CPSHelper.getMicroFormattedString(localVar): " + CPSHelper.getMicroFormattedString(localVar));
            }
        }

        // System.out.println("After adding Continuations local vars"); 
        // System.out.println("CPSHelper.getMicroFormattedString(continuationLocalVars): " + CPSHelper.getMicroFormattedString(continuationLocalVars));

        return continuationLocalVars;
    }

}
