import visitor.*;
import nano.syntaxtree.*;

import java.util.Enumeration;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

public class Transformer extends GJNoArguDepthFirst<Node> {
    public String CONTINUATION_BASE_CLASS_NAME = "Continuation";
    public String CONTINUATION_METHOD_PREFIX = "continuationMethod";
    public String WHILE_METHOD_PREFIX = "whileMethod";

    public static final String CURRENT_CONTINUATION_NAME = "k";
    public static final String pseudoThisPointerName = "___pseudoThis";

    public List<MethodDeclaration> currentClassContinuationMethods =
            new ArrayList<MethodDeclaration>();
    public List<ClassExtendsDeclaration> continuationClasses =
            new ArrayList<ClassExtendsDeclaration>();

    public List<VarDeclaration> currentMethodContinuationDeclarations =
            new ArrayList<VarDeclaration>();

    syntaxtree.NodeListOptional initStatementsMicro = new syntaxtree.NodeListOptional();

    public NodeListOptional currInitStatements = new NodeListOptional();
    
    public int counter = 0;
    public int whileCounter = 0;
    public int tempCounter = 0;
    public int maxKCounter = 10;

    public int kNameCounter = 0;
    public int initKNameCounter = 0;
    public int elseStartKNameCounter = -1;

    // TODO: 
    public ClassDeclaration baseContinuationClass;

    public syntaxtree.MethodDeclaration currMethod;
    public String currClassName;

    public Transformer() {
        MethodDeclaration baseCallMethod = new MethodDeclaration(
            CPSHelper.getNewIdentifier(ContinuationMaker.CALL_METHOD_NAME),
            new NodeOptional(),
            new NodeListOptional(),
            new NodeListOptional(),
            new NodeOptional());
        baseContinuationClass = new ClassDeclaration(
            CPSHelper.getNewIdentifier(CONTINUATION_BASE_CLASS_NAME),
            new NodeListOptional(),
            new NodeListOptional(baseCallMethod));
    }

    public static String getContinuationName(int kNumber){
        String name;
        if (kNumber == 0){
            name = CURRENT_CONTINUATION_NAME;
        } else {
            name = CURRENT_CONTINUATION_NAME + kNumber;
        }
        return "___" + name;
    }

    public String getNextTempVarName(){
        return "___temp" + ++tempCounter;
    }

    public String getCurrentTempVarName(){
        return "___temp" + tempCounter;
    }


    public String getNextWhileMethodName(){
        return WHILE_METHOD_PREFIX + ++whileCounter;
    }

    public String getCurrentWhileMethodName(){
        return WHILE_METHOD_PREFIX + whileCounter;
    }


    public String getCurrentContinuationName(){
        if (kNameCounter == elseStartKNameCounter){
            return getContinuationName(initKNameCounter);
        } else{
            return getContinuationName(kNameCounter);
        }
    }

    public MessageSendStatement getDefaultContinuationCall(){
        return new MessageSendStatement(
            CPSHelper.getNewIdentifier(getCurrentContinuationName()),
            CPSHelper.getNewIdentifier("call"),
            new NodeOptional());
    }

    /** 
     * @return NodeListOptional containing node.
     */
    public syntaxtree.NodeListOptional makeNodeListOptional(syntaxtree.Node node){
        syntaxtree.NodeListOptional temp = new syntaxtree.NodeListOptional();
        temp.addNode(node);
        return temp;
    }

    /** 
     * Wrap statement in a Microjava block and return it.
     *
     * If it is already a block, don't wrap it.
     * 
     * @return 
     */
    public syntaxtree.Block getWrappedMicroBlock(syntaxtree.Statement statement){
        if (statement.f0.which == 0){
            return (syntaxtree.Block) statement.f0.choice;
        } else {
            return new syntaxtree.Block(
                new syntaxtree.NodeListOptional(statement));
        }
    }


    /**
     * Wrap statement in a Block and return the Nano equivalent.
     * 
     * Unless the statement is already a Block, in which case just
     * return the Nano equivalent of that block.
     * 
     * @return Nano equivalent of Block{statement}.
     */
    public Block getNanoBlock(syntaxtree.Statement statement){
        return (Block) getWrappedMicroBlock(statement).accept(this);
    }

    /**
     * Note: Considering MessageSendStatement to be a tailform statement.
     * 
     * @return true iff node is a non-tailform statement
     */
    public boolean isSimpleStatement(syntaxtree.Node node){
        syntaxtree.Statement statement = (syntaxtree.Statement) node;

        switch(statement.f0.which){
            case 1:
            case 2:
            case 5:
                return true;
            default:
                return false;
        }
    }

    /** 
     * Make a ClassDeclaration to represent current Continuation.
     */
    public ClassDeclaration makeContinuationClass(MethodDeclaration continuationMethod){
        return null;
    }

    public List<Identifier> getIntersection(List<Identifier> list1, List<Identifier> list2){
        List<Identifier> difference = new ArrayList<Identifier>(list1);
        difference.removeAll(list2);
        List<Identifier> intersection = new ArrayList<Identifier>(list1);
        intersection.removeAll(difference);
        return intersection;
    }

    public static syntaxtree.Statement tryFlattenBlock(syntaxtree.Block block){
        if (block.f1.nodes.size() == 1){
            syntaxtree.Statement currStatement = (syntaxtree.Statement) block.f1.nodes.get(0);
            if (currStatement.f0.which == 0){
                return tryFlattenBlock((syntaxtree.Block) currStatement.f0.choice);
            }
            else {
                return currStatement;
            }
        }

        syntaxtree.NodeListOptional statements = new syntaxtree.NodeListOptional();
        for (syntaxtree.Node node : block.f1.nodes){
            syntaxtree.Statement currStatement = (syntaxtree.Statement) node;
            syntaxtree.Statement innerStatement = tryFlattenBlock(new syntaxtree.Block(
                new syntaxtree.NodeListOptional(currStatement)));
            if (innerStatement.f0.which == 0){
                statements.nodes.addAll(
                    ((syntaxtree.Block) innerStatement.f0.choice).f1.nodes);
            }
            else {
                statements.addNode(innerStatement);
            }
        }
        return new syntaxtree.Statement(
            new syntaxtree.NodeChoice(new syntaxtree.Block(statements), 0));
    }

    //
    // Auto class visitors--probably don't need to be overridden.
    //
    public Node visit(syntaxtree.NodeList n) {
        Node _ret=null;
        int _count=0;
        for ( Enumeration<syntaxtree.Node> e = n.elements(); e.hasMoreElements(); ) {
            e.nextElement().accept(this);
            _count++;
        }
        return _ret;
    }

    public Node visit(syntaxtree.NodeListOptional n) {
        Node _ret;
        NodeListOptional nodeListOptional = new NodeListOptional();
        if ( n.present() ) {
            for (syntaxtree.Node node : n.nodes){
                nodeListOptional.addNode(node.accept(this));
            }
        }
        _ret = nodeListOptional;
        return _ret;
    }

    public Node visit(syntaxtree.NodeOptional n) {
        if ( n.present() )
            return n.node.accept(this);
        else
            // Cos the caller is gonna do "new NodeOptional(return value)" anyway
            return null;
    }

    public Node visit(syntaxtree.NodeSequence n) {
        Node _ret=null;
        int _count=0;
        for ( Enumeration<syntaxtree.Node> e = n.elements(); e.hasMoreElements(); ) {
            e.nextElement().accept(this);
            _count++;
        }
        return _ret;
    }

    public Node visit(syntaxtree.NodeToken n) {
        return new NodeToken(n.tokenImage);
    }

    //
    // User-generated visitor methods below
    //

    /**
     * f0 -> MainClass()
     * f1 -> ( TypeDeclaration() )*
     * f2 -> <EOF>
     */
    public Node visit(syntaxtree.Goal n) {
        Node _ret=null;
        MainClass f0 = (MainClass) n.f0.accept(this);
        NodeListOptional f1 = (NodeListOptional) n.f1.accept(this);
        if (f1.present()){
            // Add all the auxiliary Continuation classes 
            for (ClassExtendsDeclaration currContinuationClass : continuationClasses){
                f1.addNode(new TypeDeclaration(
                    new NodeChoice(currContinuationClass, 1)));
            }
            f1.addNode(new TypeDeclaration(new NodeChoice(baseContinuationClass, 0)));
        }

        _ret = new Goal(f0, f1);
        return _ret;
    }

    /**
     * f0 -> "class"
     * f1 -> Identifier()
     * f2 -> "{"
     * f3 -> "public"
     * f4 -> "static"
     * f5 -> "void"
     * f6 -> "main"
     * f7 -> "("
     * f8 -> "String"
     * f9 -> "["
     * f10 -> "]"
     * f11 -> Identifier()
     * f12 -> ")"
     * f13 -> "{"
     * f14 -> "new"
     * f15 -> Identifier()
     * f16 -> "("
     * f17 -> ")"
     * f18 -> "."
     * f19 -> Identifier()
     * f20 -> "("
     * f21 -> ( ExpressionList() )?
     * f22 -> ")"
     * f23 -> ";"
     * f24 -> "}"
     * f25 -> "}"
     */
    public Node visit(syntaxtree.MainClass n) {
        Node _ret=null;
        Identifier f1 = (Identifier) n.f1.accept(this);
        Identifier f11 = (Identifier) n.f11.accept(this);
        Identifier f15 = (Identifier) n.f15.accept(this);
        Identifier f19 = (Identifier) n.f19.accept(this);
        NodeOptional f21 = new NodeOptional(n.f21.accept(this));
        if (f21.present()){
            ((ExpressionList) f21.node).f1.addNode(new ExpressionRest(
                new Expression(new NodeChoice(new PrimaryExpression(new NodeChoice(new AllocationExpression(CPSHelper.getNewIdentifier(CONTINUATION_BASE_CLASS_NAME)), 6)), 6))));
        } else {
            f21 = new NodeOptional(new ExpressionList(new Expression(
                new NodeChoice(new PrimaryExpression(new NodeChoice(new AllocationExpression(CPSHelper.getNewIdentifier(CONTINUATION_BASE_CLASS_NAME)), 6)), 6)),
                                                      new NodeListOptional()));
        }

        _ret = new MainClass(f1, f11, f15, f19, f21);
        return _ret;
    }

    /**
     * f0 -> ClassDeclaration()
     *       | ClassExtendsDeclaration()
     */
    public Node visit(syntaxtree.TypeDeclaration n) {
        Node _ret=null;
        _ret = new TypeDeclaration(new NodeChoice(n.f0.accept(this), n.f0.which));
        return _ret;
    }

    /**
     * f0 -> "class"
     * f1 -> Identifier()
     * f2 -> "{"
     * f3 -> ( VarDeclaration() )*
     * f4 -> ( MethodDeclaration() )*
     * f5 -> "}"
     */
    public Node visit(syntaxtree.ClassDeclaration n) {
        Node _ret=null;
        Identifier f1 = (Identifier) n.f1.accept(this);
        currClassName = CPSHelper.getIdentifierName(f1);
        NodeListOptional f3 = (NodeListOptional) n.f3.accept(this);
        currentClassContinuationMethods.clear();
        NodeListOptional f4 = (NodeListOptional) n.f4.accept(this);
        for (MethodDeclaration method : currentClassContinuationMethods){
            f4.addNode(method);
        }
        _ret = new ClassDeclaration(f1, f3, f4);
        return _ret;
    }

    /**
     * f0 -> "class"
     * f1 -> Identifier()
     * f2 -> "extends"
     * f3 -> Identifier()
     * f4 -> "{"
     * f5 -> ( VarDeclaration() )*
     * f6 -> ( MethodDeclaration() )*
     * f7 -> "}"
     */
    public Node visit(syntaxtree.ClassExtendsDeclaration n) {
        Node _ret=null;
        Identifier f1 = (Identifier) n.f1.accept(this);
        currClassName = CPSHelper.getIdentifierName(f1);
        Identifier f3 = (Identifier) n.f3.accept(this);
        NodeListOptional f5 = (NodeListOptional) n.f3.accept(this);
        currentClassContinuationMethods.clear();
        NodeListOptional f6 = (NodeListOptional) n.f4.accept(this);
        for (MethodDeclaration method : currentClassContinuationMethods){
            f6.addNode(method);
        }

        _ret = new ClassExtendsDeclaration(f1, f3, f5, f6);
        return _ret;
    }

    /**
     * f0 -> Type()
     * f1 -> Identifier()
     * f2 -> ";"
     */
    public Node visit(syntaxtree.VarDeclaration n) {
        Node _ret=null;
        _ret = new VarDeclaration((Type) n.f0.accept(this), (Identifier) n.f1.accept(this));
        return _ret;
    }

    /**
     * f0 -> "public"
     * f1 -> "void"
     * f2 -> Identifier()
     * f3 -> "("
     * f4 -> ( FormalParameterList() )?
     * f5 -> ")"
     * f6 -> "{"
     * f7 -> ( VarDeclaration() )*
     * f8 -> ( Statement() )*
     * f9 -> "}"
     */
    public Node visit(syntaxtree.MethodDeclaration n) {
        List<VarDeclaration> prevMethodContinuationDeclarations = currentMethodContinuationDeclarations;
        currentMethodContinuationDeclarations = new ArrayList<VarDeclaration>();

        syntaxtree.MethodDeclaration prevMethod = currMethod;
        currMethod = n;

        int prevKNameCounter = kNameCounter;
        kNameCounter = 0;

        Node _ret=null;
        Identifier f2 = (Identifier) n.f2.accept(this);
        NodeOptional f4 = new NodeOptional(n.f4.accept(this));
        FormalParameter kParam = new FormalParameter(
            CPSHelper.getNewType(CONTINUATION_BASE_CLASS_NAME),
            CPSHelper.getNewIdentifier(getCurrentContinuationName()));

        if (f4.present()){
            FormalParameterRest restParam = new FormalParameterRest(kParam);
            ((FormalParameterList) f4.node).f1.addNode(restParam);
        }
        else{
            f4 = new NodeOptional(
                new FormalParameterList(kParam, new NodeListOptional()));
        }

        syntaxtree.NodeListOptional varDeclarations = new syntaxtree.NodeListOptional();
        varDeclarations.nodes.addAll(n.f7.nodes);

        syntaxtree.VarDeclaration pseudoThisVarDeclaration = new syntaxtree.VarDeclaration(
            CPSHelper.getNewMicroType(currClassName),
            CPSHelper.getNewMicroIdentifier(pseudoThisPointerName));

        varDeclarations.addNode(pseudoThisVarDeclaration);

        NodeListOptional f7 = (NodeListOptional) varDeclarations.accept(this);

        syntaxtree.NodeListOptional bodyStatements = new syntaxtree.NodeListOptional();
        bodyStatements.nodes.addAll(n.f8.nodes);

        syntaxtree.Statement pseudoThisEqualsThis =
                new syntaxtree.Statement(
                    new syntaxtree.NodeChoice(new syntaxtree.AssignmentStatement(
                        new syntaxtree.VarRef(
                            new syntaxtree.NodeChoice(
                                CPSHelper.getNewMicroIdentifier(pseudoThisPointerName), 1)),
                        new syntaxtree.Expression(
                            new syntaxtree.NodeChoice(
                                new syntaxtree.PrimaryExpression(
                                    new syntaxtree.NodeChoice(
                                        new syntaxtree.ThisExpression(), 4)), 6))), 1));

        bodyStatements.nodes.add(0, pseudoThisEqualsThis);

        // Make a new block out of the statement list and extract the
        // resultant NanoJava statement list and JumpPoint.
        // TODO: Flatten the inner blocks
        Block tempBlock = (Block) (new syntaxtree.Block(bodyStatements)).accept(this);

        // f7.nodes.addAll(currentMethodContinuationDeclarations);

        String tempBlockString = CPSHelper.getFormattedString(tempBlock);

        // System.out.println("CPSHelper.getMicroFormattedString(CPSHelper.getMicroMethodDeclaration(tempBlockString)): " + CPSHelper.getMicroFormattedString(CPSHelper.getMicroMethodDeclaration(tempBlockString)));

        // System.out.println("CPSHelper.getMicroFormattedString(ContinuationMaker.getContinuationVarDeclarations(CPSHelper.getMicroMethodDeclaration(tempBlockString).f8)): " + CPSHelper.getMicroFormattedString(ContinuationMaker.getContinuationVarDeclarations(CPSHelper.getMicroMethodDeclaration(tempBlockString).f8)));

        // Hack to get local continuation variables 
        // Note: tempBlockString contains the ENTIRE representation of
        // the block cos you converted it to a string
        NodeListOptional continuationVars = CPSHelper.getNanoVarDeclarations(
            ContinuationMaker.getContinuationVarDeclarations(
                CPSHelper.getMicroMethodDeclaration(tempBlockString).f8));

        // System.out.println("CPSHelper.getFormattedString(continuationVars): " + CPSHelper.getFormattedString(continuationVars));

        // Take only those continuationVars that don't already occur in f7
        Set<String> currVarSet = new HashSet<String>();
        for (Node node : f7.nodes){
            currVarSet.add(CPSHelper.getFormattedString(node));
        }

        for (Node node : continuationVars.nodes){
            if (!currVarSet.contains(CPSHelper.getFormattedString(node))){
                f7.addNode(node);
            }
        }
        // System.out.println("CPSHelper.getFormattedString(f7): " + CPSHelper.getFormattedString(f7));

        _ret = new MethodDeclaration(f2, f4, f7,
                                     tempBlock.f1,
                                     new NodeOptional(tempBlock.f2));
        currMethod = prevMethod;
        kNameCounter = prevKNameCounter;
        currentMethodContinuationDeclarations = prevMethodContinuationDeclarations;
        return _ret;
    }

    /**
     * f0 -> FormalParameter()
     * f1 -> ( FormalParameterRest() )*
     */
    public Node visit(syntaxtree.FormalParameterList n) {
        Node _ret=null;
        _ret = new FormalParameterList((FormalParameter) n.f0.accept(this),
                                       (NodeListOptional) n.f1.accept(this));
        return _ret;
    }

    /**
     * f0 -> Type()
     * f1 -> Identifier()
     */
    public Node visit(syntaxtree.FormalParameter n) {
        Node _ret=null;
        _ret = new FormalParameter((Type) n.f0.accept(this), (Identifier) n.f1.accept(this));
        return _ret;
    }

    /**
     * f0 -> ","
     * f1 -> FormalParameter()
     */
    public Node visit(syntaxtree.FormalParameterRest n) {
        Node _ret=null;
        _ret = new FormalParameterRest((FormalParameter) n.f1.accept(this));
        return _ret;
    }

    /**
     * f0 -> ArrayType()
     *       | BooleanType()
     *       | IntegerType()
     *       | Identifier()
     */
    public Node visit(syntaxtree.Type n) {
        Node _ret=null;
        Node f0 = n.f0.accept(this);
        _ret = new Type(new NodeChoice(f0, n.f0.which));
        return _ret;
    }

    /**
     * f0 -> "int"
     * f1 -> "["
     * f2 -> "]"
     */
    public Node visit(syntaxtree.ArrayType n) {
        Node _ret=null;
        _ret = new ArrayType();
        return _ret;
    }

    /**
     * f0 -> "boolean"
     */
    public Node visit(syntaxtree.BooleanType n) {
        Node _ret=null;
        _ret = new BooleanType();
        return _ret;
    }

    /**
     * f0 -> "int"
     */
    public Node visit(syntaxtree.IntegerType n) {
        Node _ret=null;
        _ret = new IntegerType();
        return _ret;
    }

    /**
     * f0 -> Block()
     *       | AssignmentStatement()
     *       | ArrayAssignmentStatement()
     *       | IfStatement()
     *       | WhileStatement()
     *       | PrintStatement()
     *       | MessageSendStatement()
     */
    public Node visit(syntaxtree.Statement n) {
        Node _ret=null;
        switch(n.f0.which){
            case 1:
            case 2:
            case 5:
                // Simple Statements
                Node f0 = n.f0.accept(this);
                _ret = new Statement(new NodeChoice(f0, n.f0.which));
                break;
            default:
                // Tail-form Statements - return the NanoJava specific Node 
                _ret = n.f0.accept(this);
        }

        return _ret;
    }

    /**
     * f0 -> "{"
     * f1 -> ( Statement() )*
     * f2 -> "}"
     */
    public Node visit(syntaxtree.Block n) {
        Node _ret=null;
        // System.out.println("Block:"); 
        // System.out.println("CPSHelper.getMicroFormattedString(n): " + CPSHelper.getMicroFormattedString(n));

        // String prevContinuationName = getCurrentContinuationName();

        // int prevKNameCounter = kNameCounter;

        NodeListOptional finalStatementList = new NodeListOptional();
        JumpPoint jumpPoint = null;
        int i;

        for (i = 0; i < n.f1.nodes.size(); i++){
            syntaxtree.Node currNode = n.f1.nodes.get(i);
            syntaxtree.Statement currStatement = (syntaxtree.Statement)
                    n.f1.nodes.get(i);

            if (isSimpleStatement(currNode)){
                finalStatementList.addNode(currNode.accept(this));
            }
            else {
                // Make a continuation out of the rest of the nodes  
                syntaxtree.NodeListOptional remainingStatements = new syntaxtree.NodeListOptional();
                remainingStatements.nodes.addAll(
                    n.f1.nodes.subList(i + 1, n.f1.nodes.size()));

                // If there are statements after currMethod, make a
                // continuation out of them
                if (remainingStatements.present()){
                    // TODO: See if you need to abstract this more
                    kNameCounter++;

                    String currKName = getCurrentContinuationName();
                    ContinuationMaker newContinuationMaker = new ContinuationMaker(
                        remainingStatements,
                        currMethod,
                        this,
                        currKName,
                        CONTINUATION_METHOD_PREFIX + counter++);

                    currentClassContinuationMethods.add(
                        newContinuationMaker.continuationMethod);
                    continuationClasses.add(newContinuationMaker.continuationClass);
                    currentMethodContinuationDeclarations.add(new VarDeclaration(
                        CPSHelper.getNewType(newContinuationMaker.className),
                        CPSHelper.getNewIdentifier(currKName)));
                    
                    currInitStatements = new NodeListOptional();
                    currInitStatements.nodes.addAll(newContinuationMaker.initStatements.nodes);
                } 

                if (currInitStatements.present()){
                    if (currStatement.f0.which != 3){
                        // Not IfStatement => put the currInitStatements right here
                        finalStatementList.nodes.addAll(currInitStatements.nodes);
                        currInitStatements = new NodeListOptional();
                    } else if (currStatement.f0.which == 3){
                        // IfStatement

                        // Make currStatement have the initStatements
                        // at the end of the if-else
                    }

                    // TODO: else if part for WhileStatement
                }
                // TODO: Modify currNode to have the initStatements at
                // the end of the if-else blocks or the else-block in
                // WhileStatement

                // VVIP: Assuming that the node isn't a nested block
                jumpPoint = (JumpPoint) currStatement.accept(this);
                break;
            }
        }

        if (jumpPoint == null){
            jumpPoint = new JumpPoint(new NodeChoice(getDefaultContinuationCall(), 1));
        }

        // kNameCounter = prevKNameCounter;

        _ret = new Block(finalStatementList, jumpPoint);
        return _ret;
    }

    /**
     * f0 -> VarRef()
     * f1 -> "="
     * f2 -> Expression()
     * f3 -> ";"
     */
    public Node visit(syntaxtree.AssignmentStatement n) {
        Node _ret=null;
        VarRef f0 = (VarRef) n.f0.accept(this);
        if (ContinuationMaker.isContinuationAllocation(n.f2)){
            // Assuming that n is of the form "k2 = new
            // ContinuationClass()" i.e., not DotExpression in the LHS
            String varName = CPSHelper.getMicroFormattedString(n.f0);
            String numString = varName.substring(("___" + CURRENT_CONTINUATION_NAME).length(), varName.length());
            if (numString.isEmpty()){
                kNameCounter = 0;
            } else {
                kNameCounter = Integer.parseInt(numString);
            }
        }

        Expression f2 = (Expression) n.f2.accept(this);
        _ret = new AssignmentStatement(f0, f2);
        return _ret;
    }

    /**
     * f0 -> Identifier()
     * f1 -> "["
     * f2 -> Expression()
     * f3 -> "]"
     * f4 -> "="
     * f5 -> Expression()
     * f6 -> ";"
     */
    public Node visit(syntaxtree.ArrayAssignmentStatement n) {
        Node _ret=null;
        Identifier f0 = (Identifier) n.f0.accept(this);
        Expression f2 = (Expression) n.f2.accept(this);
        Expression f5 = (Expression) n.f5.accept(this);
        _ret = new ArrayAssignmentStatement(f0, f2, f5);
        return _ret;
    }

    /**
     * f0 -> "if"
     * f1 -> "("
     * f2 -> Expression()
     * f3 -> ")"
     * f4 -> Statement()
     * f5 -> "else"
     * f6 -> Statement()
     */
    public Node visit(syntaxtree.IfStatement n) {
        Node _ret=null;
        Expression f2 = (Expression) n.f2.accept(this);

        syntaxtree.Statement flattenedIfStatement = tryFlattenBlock(
            new syntaxtree.Block(makeNodeListOptional(n.f4)));
        syntaxtree.Block ifBlock = getWrappedMicroBlock(flattenedIfStatement);
        ifBlock.f1.nodes.addAll(CPSHelper.getMicroStatementList(currInitStatements).nodes);

        syntaxtree.Statement flattenedElseStatement = tryFlattenBlock(
            new syntaxtree.Block(makeNodeListOptional(n.f6)));
        syntaxtree.Block elseBlock = getWrappedMicroBlock(flattenedElseStatement);
        elseBlock.f1.nodes.addAll(CPSHelper.getMicroStatementList(currInitStatements).nodes);
        currInitStatements = new NodeListOptional();

        initKNameCounter = kNameCounter;
        elseStartKNameCounter = -1;
        
        Block f4 = (Block) ifBlock.accept(this);

        elseStartKNameCounter = kNameCounter;
        
        // Get those variables initialized in the else Block
        Block f6 = (Block) elseBlock.accept(this);

        elseStartKNameCounter = -1;
        initKNameCounter = 0;

        currInitStatements = new NodeListOptional();
        _ret = new JumpPoint(new NodeChoice(new IfStatement(f2, f4, f6), 0));
        return _ret;
    }

    /** 
     * Create a recursive method representing a While loop.
     * 
     */
    public MethodDeclaration makeWhileMethod(syntaxtree.MethodDeclaration parentMethod,
                                             syntaxtree.Expression whileExpression,
                                             syntaxtree.Statement whileBodyStatement){
        syntaxtree.Statement elseStatement = new syntaxtree.Statement(
            new syntaxtree.NodeChoice(
                new syntaxtree.Block(
                    CPSHelper.getMicroStatementList(
                        currInitStatements)), 0));

        // TODO: 
        // syntaxtree.Statement elseStatement = tryFlattenBlock(new syntaxtree.Block(
        //     CPSHelper.getMicroStatementList(
        //         currInitStatements)));

        syntaxtree.NodeListOptional tempWhileBody = new syntaxtree.NodeListOptional();
        tempWhileBody.addNode(whileBodyStatement);
        syntaxtree.Statement cleanedUpWhileBodyStatement = tryFlattenBlock(new syntaxtree.Block(tempWhileBody));
        syntaxtree.Statement ifStatement = new syntaxtree.Statement(
            new syntaxtree.NodeChoice(new syntaxtree.IfStatement(
                whileExpression, whileBodyStatement, elseStatement), 3));
        // whileExpression, cleanedUpWhileBodyStatement, elseStatement), 3));

        syntaxtree.NodeListOptional trailingStatements = new syntaxtree.NodeListOptional();
        trailingStatements.addNode(ifStatement);
        
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

        for (syntaxtree.Node node : parentMethod.f7.nodes){
            syntaxtree.VarDeclaration currVarDeclaration = (syntaxtree.VarDeclaration) node;
            LiveVariableFinder currFinder = new LiveVariableFinder(
                CPSHelper.getIdentifierName(currVarDeclaration.f1));

            if (trailingStatements.accept(currFinder) && currFinder.isLive){
                restParameters.addNode(new syntaxtree.FormalParameterRest(
                    CPSHelper.getFormalParameter(currVarDeclaration)));
                    
            } else {
                localVars.addNode(CPSHelper.getCopy(currVarDeclaration));
            }
        }

        // VVIP: MAJOR HACK ahead: I need to know which continuation
        // variables have been instantiated in trailingStatements. But
        // they won't be declared in parentMethod. So, just running
        // over possible continuation variable names and seeing if
        // they are instantiated in trailingStatements.
        for (int i = 0; i < ContinuationMaker.MAX_NUMBER_CONTINUATIONS; i++){
            LiveVariableFinder currFinder = new LiveVariableFinder(
                Transformer.getContinuationName(i));
            currFinder.isContinuationVar = true;

            // If it is found in trailingStatements and is
            // instantiated only inside trailingStatements
            if (trailingStatements.accept(currFinder) && !currFinder.isLive){
                localVars.addNode(new syntaxtree.VarDeclaration(
                    CPSHelper.getNewMicroType(currFinder.continuationClassName),
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

        String currWhileMethodName = getNextWhileMethodName();
        // String tempVarName = getNextTempVarName();

        syntaxtree.MessageSendStatement recursiveWhileCall =
                new syntaxtree.MessageSendStatement(
                    CPSHelper.getNewMicroIdentifier(pseudoThisPointerName),
                    CPSHelper.getNewMicroIdentifier(currWhileMethodName),
                    CPSHelper.getArgs(parameters));

        // System.out.println("CPSHelper.getMicroFormattedString(recursiveWhileCall): " + CPSHelper.getMicroFormattedString(recursiveWhileCall));

        // trailingStatements.addNode(new syntaxtree.Statement(
        //     new syntaxtree.NodeChoice(recursiveWhileCall, 6)));

        // Add recursiveWhileCall to the end of the if-block in ifStatement
        syntaxtree.NodeListOptional newIfBlockStatements = new syntaxtree.NodeListOptional();
        newIfBlockStatements.addNode(((syntaxtree.IfStatement) ifStatement.f0.choice).f4);
        newIfBlockStatements.addNode(new syntaxtree.Statement(
            new syntaxtree.NodeChoice(recursiveWhileCall, 6)));

        // if-part-statement = flat Block(previous-if-part-statement, recursiveWhileCall);
        ((syntaxtree.IfStatement) ifStatement.f0.choice).f4 =
                tryFlattenBlock(new syntaxtree.Block(newIfBlockStatements));

        syntaxtree.MethodDeclaration tempMethod = new syntaxtree.MethodDeclaration(
            CPSHelper.getNewMicroIdentifier(currWhileMethodName),
            parameters,
            localVars,
            trailingStatements);

        // System.out.println("CPSHelper.getMicroFormattedString(tempMethod): " + CPSHelper.getMicroFormattedString(tempMethod));
        MethodDeclaration continuationMethod = (MethodDeclaration) tempMethod.accept(this);
        // System.out.println("CPSHelper.getFormattedString(continuationMethod): " + CPSHelper.getFormattedString(continuationMethod));

        return continuationMethod;
    }

    /**
     * f0 -> "while"
     * f1 -> "("
     * f2 -> Expression()
     * f3 -> ")"
     * f4 -> Statement()
     */
    // TODO: 
    public Node visit(syntaxtree.WhileStatement n) {
        Node _ret=null;

        MethodDeclaration whileMethod = makeWhileMethod(currMethod, n.f2, n.f4);

        // TODO: HACK - putting whileMethod in
        // currentClassContinuationMethods cos putting it in a new
        // global list would mean saving and restoring it in
        // MethodDeclaration... n-pain
        currentClassContinuationMethods.add(whileMethod);

        // System.out.println("WhileStatement"); 
        // String args = CPSHelper.getMicroFormattedString(CPSHelper.getArgs(currMethod.f4));
        // System.out.println("getArgs:" + args);
        // System.out.println("CPSHelper.getMicroFormattedString(CPSHelper.getMicroArgs(CPSHelper.getArgs(whileMethod.f4.node))): " + CPSHelper.getMicroFormattedString(CPSHelper.getMicroArgs(CPSHelper.getArgs(whileMethod.f4.node))));
        // System.out.println("CPSHelper.getFormattedString(whileMethod.f4): " + CPSHelper.getFormattedString(whileMethod.f4));

        syntaxtree.MessageSendStatement recursiveWhileCall =
                new syntaxtree.MessageSendStatement(
                    CPSHelper.getNewMicroIdentifier(pseudoThisPointerName),
                    CPSHelper.getNewMicroIdentifier(getCurrentWhileMethodName()),
                    CPSHelper.getMicroArgs(CPSHelper.getArgs(whileMethod.f4.node)));

        // Doing this instead of directly constructing a NanoJava
        // MessageSendStatement cos we want to use the
        // currentContinuation instead of blindly __k which
        // getArgs(nanoJavaMethod.parameters) would give us
        _ret = recursiveWhileCall.accept(this);
        return _ret;
    }

    /**
     * f0 -> "System.out.println"
     * f1 -> "("
     * f2 -> Expression()
     * f3 -> ")"
     * f4 -> ";"
     */
    public Node visit(syntaxtree.PrintStatement n) {
        Node _ret=null;
        Expression f2 = (Expression) n.f2.accept(this);
        _ret = new PrintStatement(f2);
        return _ret;
    }

    /**
     * f0 -> Identifier()
     * f1 -> "."
     * f2 -> Identifier()
     * f3 -> "("
     * f4 -> ( ExpressionList() )?
     * f5 -> ")"
     * f6 -> ";"
     */
    public Node visit(syntaxtree.MessageSendStatement n) {
        Node _ret=null;
        Identifier f0 = (Identifier) n.f0.accept(this);
        Identifier f2 = (Identifier) n.f2.accept(this);
        NodeOptional f4 = new NodeOptional(n.f4.accept(this));

        // Note: Add the currentContinuation as the last argument.
        Expression currContinuationVarRef = new Expression(new NodeChoice(
            new PrimaryExpression(
                new NodeChoice(
                    new VarRef(
                        new NodeChoice(CPSHelper.getNewIdentifier(
                            getCurrentContinuationName()), 1)),
                    3)), 6));
        if (!f4.present()){
            f4 = new NodeOptional(new ExpressionList(
                currContinuationVarRef,
                new NodeListOptional()));
        } else {
            ((ExpressionList) f4.node).f1.addNode(
                new ExpressionRest(currContinuationVarRef));
        }
        
        _ret = new JumpPoint(new NodeChoice(new MessageSendStatement(f0, f2, f4), 1));
        return _ret;
    }

    /**
     * f0 -> AndExpression()
     *       | CompareExpression()
     *       | PlusExpression()
     *       | MinusExpression()
     *       | TimesExpression()
     *       | ArrayLookup()
     *       | PrimaryExpression()
     */
    public Node visit(syntaxtree.Expression n) {
        Node _ret=null;
        Node f0 = n.f0.accept(this);
        _ret = new Expression(new NodeChoice(f0, n.f0.which));
        return _ret;
    }

    /**
     * f0 -> PrimaryExpression()
     * f1 -> "&"
     * f2 -> PrimaryExpression()
     */
    public Node visit(syntaxtree.AndExpression n) {
        Node _ret=null;
        PrimaryExpression f0 = (PrimaryExpression) n.f0.accept(this);
        PrimaryExpression f2 = (PrimaryExpression) n.f2.accept(this);
        _ret = new AndExpression(f0, f2);
        return _ret;
    }

    /**
     * f0 -> PrimaryExpression()
     * f1 -> "<"
     * f2 -> PrimaryExpression()
     */
    public Node visit(syntaxtree.CompareExpression n) {
        Node _ret=null;
        PrimaryExpression f0 = (PrimaryExpression) n.f0.accept(this);
        PrimaryExpression f2 = (PrimaryExpression) n.f2.accept(this);
        _ret = new CompareExpression(f0, f2);
        return _ret;
    }

    /**
     * f0 -> PrimaryExpression()
     * f1 -> "+"
     * f2 -> PrimaryExpression()
     */
    public Node visit(syntaxtree.PlusExpression n) {
        Node _ret=null;
        PrimaryExpression f0 = (PrimaryExpression) n.f0.accept(this);
        PrimaryExpression f2 = (PrimaryExpression) n.f2.accept(this);
        _ret = new PlusExpression(f0, f2);
        return _ret;
    }

    /**
     * f0 -> PrimaryExpression()
     * f1 -> "-"
     * f2 -> PrimaryExpression()
     */
    public Node visit(syntaxtree.MinusExpression n) {
        Node _ret=null;
        PrimaryExpression f0 = (PrimaryExpression) n.f0.accept(this);
        PrimaryExpression f2 = (PrimaryExpression) n.f2.accept(this);
        _ret = new MinusExpression(f0, f2);
        return _ret;
    }

    /**
     * f0 -> PrimaryExpression()
     * f1 -> "*"
     * f2 -> PrimaryExpression()
     */
    public Node visit(syntaxtree.TimesExpression n) {
        Node _ret=null;
        PrimaryExpression f0 = (PrimaryExpression) n.f0.accept(this);
        PrimaryExpression f2 = (PrimaryExpression) n.f2.accept(this);
        _ret = new TimesExpression(f0, f2);
        return _ret;
    }

    /**
     * f0 -> PrimaryExpression()
     * f1 -> "["
     * f2 -> PrimaryExpression()
     * f3 -> "]"
     */
    public Node visit(syntaxtree.ArrayLookup n) {
        Node _ret=null;
        PrimaryExpression f0 = (PrimaryExpression) n.f0.accept(this);
        PrimaryExpression f2 = (PrimaryExpression) n.f2.accept(this);
        _ret = new ArrayLookup(f0, f2);
        return _ret;
    }

    /**
     * f0 -> Expression()
     * f1 -> ( ExpressionRest() )*
     */
    public Node visit(syntaxtree.ExpressionList n) {
        Node _ret=null;
        Expression f0 = (Expression) n.f0.accept(this);
        NodeListOptional f1 = (NodeListOptional) n.f1.accept(this);
        _ret = new ExpressionList(f0, f1);
        return _ret;
    }

    /**
     * f0 -> ","
     * f1 -> Expression()
     */
    public Node visit(syntaxtree.ExpressionRest n) {
        Node _ret=null;
        Expression f1 = (Expression) n.f1.accept(this);
        _ret = new ExpressionRest(f1);
        return _ret;
    }

    /**
     * f0 -> IntegerLiteral()
     *       | TrueLiteral()
     *       | FalseLiteral()
     *       | VarRef()
     *       | ThisExpression()
     *       | ArrayAllocationExpression()
     *       | AllocationExpression()
     *       | NotExpression()
     *       | BracketExpression()
     */
    public Node visit(syntaxtree.PrimaryExpression n) {
        Node _ret=null;
        Node f0 = n.f0.accept(this);
        _ret = new PrimaryExpression(new NodeChoice(f0, n.f0.which));
        return _ret;
    }

    /**
     * f0 -> <INTEGER_LITERAL>
     */
    public Node visit(syntaxtree.IntegerLiteral n) {
        Node _ret=null;
        NodeToken f0 = (NodeToken) n.f0.accept(this);
        _ret = new IntegerLiteral(f0);
        return _ret;
    }

    /**
     * f0 -> "true"
     */
    public Node visit(syntaxtree.TrueLiteral n) {
        Node _ret=null;
        // n.f0.accept(this);
        _ret = new TrueLiteral();
        return _ret;
    }

    /**
     * f0 -> "false"
     */
    public Node visit(syntaxtree.FalseLiteral n) {
        Node _ret=null;
        // n.f0.accept(this);
        _ret = new FalseLiteral();
        return _ret;
    }

    /**
     * f0 -> <IDENTIFIER>
     */
    public Node visit(syntaxtree.Identifier n) {
        Node _ret=null;
        _ret = CPSHelper.getNewIdentifier(CPSHelper.getIdentifierName(n));
        return _ret;
    }

    /**
     * f0 -> "this"
     */
    public Node visit(syntaxtree.ThisExpression n) {
        Node _ret=null;
        _ret = new ThisExpression();
        return _ret;
    }

    /**
     * f0 -> "new"
     * f1 -> "int"
     * f2 -> "["
     * f3 -> Expression()
     * f4 -> "]"
     */
    public Node visit(syntaxtree.ArrayAllocationExpression n) {
        Node _ret=null;
        Expression f3 = (Expression) n.f3.accept(this);
        _ret = new ArrayAllocationExpression(f3);
        return _ret;
    }

    /**
     * f0 -> "new"
     * f1 -> Identifier()
     * f2 -> "("
     * f3 -> ")"
     */
    public Node visit(syntaxtree.AllocationExpression n) {
        Node _ret=null;
        Identifier f1 = (Identifier) n.f1.accept(this);
        _ret = new AllocationExpression(f1);
        return _ret;
    }

    /**
     * f0 -> "!"
     * f1 -> Expression()
     */
    public Node visit(syntaxtree.NotExpression n) {
        Node _ret=null;
        Expression f1 = (Expression) n.f1.accept(this);
        _ret = new NotExpression(f1);
        return _ret;
    }

    /**
     * f0 -> "("
     * f1 -> Expression()
     * f2 -> ")"
     */
    public Node visit(syntaxtree.BracketExpression n) {
        Node _ret=null;
        Expression f1 = (Expression) n.f1.accept(this);
        _ret = new BracketExpression(f1);
        return _ret;
    }

    /**
     * f0 -> DotExpression()
     *       | Identifier()
     */
    public Node visit(syntaxtree.VarRef n) {
        Node _ret=null;
        Node f0 = n.f0.accept(this);
        _ret = new VarRef(new NodeChoice(f0, n.f0.which));
        return _ret;
    }

    /**
     * f0 -> Identifier()
     * f1 -> "."
     * f2 -> Identifier()
     */
    public Node visit(syntaxtree.DotExpression n) {
        Node _ret=null;
        Identifier f0 = (Identifier) n.f0.accept(this);
        Identifier f2 = (Identifier) n.f2.accept(this);
        _ret = new DotExpression(f0, f2);
        return _ret;
    }
}
