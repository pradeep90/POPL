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

    int MAX_NUMBER_CONTINUATIONS = 10;

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

        className = "ContinuationClass" + continuationMethodName;

        makeContinuationMethod();
        makeContinuationClass();
        makeInitStatements();
    }

    public void makeContinuationMethod(){
        System.out.println("CPSHelper.getMicroFormattedString(trailingStatements): " + CPSHelper.getMicroFormattedString(trailingStatements));
        // Add parameters
        syntaxtree.FormalParameterList parameterList = null;
        if (parentMethod.f4.present()){
            syntaxtree.FormalParameterList parentParameterList =
                    (syntaxtree.FormalParameterList) parentMethod.f4.node;
            parameterList = CPSHelper.getCopy(parentParameterList);
        }

        // Local VarDeclarations which are live in trailingStatements
        syntaxtree.NodeListOptional restParameters = new syntaxtree.NodeListOptional();
        // Local variables which are not live in trailingStatements
        syntaxtree.NodeListOptional localVars = new syntaxtree.NodeListOptional();

        System.out.println("CPSHelper.getMicroFormattedString(trailingStatements): " + CPSHelper.getMicroFormattedString(trailingStatements));

        for (syntaxtree.Node node : parentMethod.f7.nodes){
            syntaxtree.VarDeclaration currVarDeclaration = (syntaxtree.VarDeclaration) node;
            LiveVariableFinder currFinder = new LiveVariableFinder(
                CPSHelper.getIdentifierName(currVarDeclaration.f1));

            if (trailingStatements.accept(currFinder) && currFinder.isLive){
                restParameters.addNode(new syntaxtree.FormalParameterRest(
                    getFormalParameter(currVarDeclaration)));
                    
            } else {
                localVars.addNode(CPSHelper.getCopy(currVarDeclaration));
            }
        }

        // VVIP: MAJOR HACK ahead: I need to know which continuation
        // variables have been instantiated in trailingStatements. But
        // they won't be declared in parentMethod. So, just running
        // over possible continuation variable names and seeing if
        // they are instantiated in trailingStatements.
        for (int i = 0; i < MAX_NUMBER_CONTINUATIONS; i++){
            LiveVariableFinder currFinder = new LiveVariableFinder(
                Transformer.getContinuationName(i));

            // If it is found in trailingStatements and is
            // instantiated only inside trailingStatements
            if (trailingStatements.accept(currFinder) && !currFinder.isLive){
                localVars.addNode(new syntaxtree.VarDeclaration(
                    CPSHelper.getNewMicroType(
                        getContinuationTypeName(trailingStatements,
                                            Transformer.getContinuationName(i))),
                    CPSHelper.getNewMicroIdentifier(Transformer.getContinuationName(i))));
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
    }

    public void makeContinuationClass(){
        NodeListOptional varDeclarations = getVarDeclarationsFromParameterList(
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
                                         getArgs(continuationMethod.f4.node)), 1))));
        
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
                        0)), getExpression(currVarDeclaration)), 0)));
            }
        }
    }

    public NodeListOptional getVarDeclarationsFromParameterList(
        Node parameters){

        NodeListOptional varDeclarations = new NodeListOptional();
        if (parameters == null){
            return varDeclarations;
        }

        FormalParameterList actualParams = (FormalParameterList) parameters;
        varDeclarations.addNode(getVarDeclaration(actualParams.f0));
        for (Node node : actualParams.f1.nodes){
            varDeclarations.addNode(getVarDeclaration(((FormalParameterRest) node).f1));
        }

        return varDeclarations;
    }

    public VarDeclaration getVarDeclaration(FormalParameter parameter){
        return new VarDeclaration(CPSHelper.getCopy(parameter.f0),
                                  CPSHelper.getCopy(parameter.f1));
    }

    /** 
     * @return Expression for VarRef of parameter's identifier
     */
    public Expression getExpression(FormalParameter parameter){
        return new Expression(new NodeChoice(new PrimaryExpression(
            new NodeChoice(new VarRef(new NodeChoice(CPSHelper.getCopy(parameter.f1), 1)),
                           3)), 6));
    }

    /** 
     * @return Expression for Identifier of currVarDeclaration.
     */
    public Expression getExpression(VarDeclaration currVarDeclaration){
        return new Expression(new NodeChoice(
            new PrimaryExpression(new NodeChoice(
                new VarRef(new NodeChoice(CPSHelper.getCopy(currVarDeclaration.f1), 1)),
                3)), 6));
    }

    /** 
     * Return the arguments for the call() method of the continuation class.
     *
     * Note: Guaranteed that parameters has at least one parameter (i.e., k).
     */
    public NodeOptional getArgs(Node parameters){
        FormalParameterList actualParams = (FormalParameterList) parameters;
        NodeListOptional restExpressions = new NodeListOptional();
        for (Node node : actualParams.f1.nodes){
            restExpressions.addNode(new ExpressionRest(
                getExpression(((FormalParameterRest) node).f1)));
        }
        return new NodeOptional(new ExpressionList(getExpression(actualParams.f0),
                                                   restExpressions));
    }

    public syntaxtree.FormalParameter getFormalParameter(
        syntaxtree.VarDeclaration varDeclaration){

        return new syntaxtree.FormalParameter(CPSHelper.getCopy(varDeclaration.f0),
                                              CPSHelper.getCopy(varDeclaration.f1));
    }

    /** 
     * Get the type of continuation being instantiated within statementList.
     *
     * e.g., "k2 = new FooContinuation()" -> "FooContinuation"
     */
    public String getContinuationTypeName(syntaxtree.NodeListOptional statementList,
                                          String continuationVarName){
        for (syntaxtree.Node node : statementList.nodes){
            syntaxtree.Statement currStatement = (syntaxtree.Statement) node;
            if (currStatement.f0.which == 1){
                // AssignmentStatement
                syntaxtree.AssignmentStatement assignmentStatement =
                        (syntaxtree.AssignmentStatement) currStatement.f0.choice;
                if (CPSHelper.getMicroFormattedString(
                        assignmentStatement.f0).equals(continuationVarName)){
                    syntaxtree.Expression expression = assignmentStatement.f2;
                    if (expression.f0.which == 6){
                        syntaxtree.PrimaryExpression primaryExpression =
                                (syntaxtree.PrimaryExpression) expression.f0.choice;
                        if (primaryExpression.f0.which == 6){
                            return CPSHelper.getIdentifierName(
                                ((syntaxtree.AllocationExpression) primaryExpression.f0.choice).f1);
                        }
                    }
                }
            }
        }
        return null;
    }

}
