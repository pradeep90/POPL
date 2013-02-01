import microjavaparser.syntaxtree.*;

/** 
 * Class to represent a Node plus the other prerequisite Nodes that
 * precede it.
 * 
 */
public class ExpansionNode implements Node{
    public Node node;
    public NodeListOptional varDeclarations;
    public NodeListOptional precedingNodes;

    public ExpansionNode() {
        this(null, new NodeListOptional(), new NodeListOptional());
    }

    public ExpansionNode(Node node) {
        this(node, new NodeListOptional(), new NodeListOptional());
    }

    public ExpansionNode(Node currNode,
                         NodeListOptional varDeclarations,
                         NodeListOptional precedingNodes) {
        this.node = currNode;
        this.varDeclarations = varDeclarations;
        this.precedingNodes = precedingNodes;
    }

    public Node toNode(){
        return node;
    }

    public boolean hasPrecedingNodes(){
        return precedingNodes.present();
    }

    public boolean hasVarDeclarations(){
        return varDeclarations.present();
    }

    /** 
     * Add varDeclarations and precedingNodes of expansionNode to this
     * ExpansionNode.
     */
    public void extendAuxiliary(ExpansionNode expansionNode){
        for (Node n : expansionNode.varDeclarations.nodes){
            this.varDeclarations.addNode(n);
        }
        for (Node n : expansionNode.precedingNodes.nodes){
            this.precedingNodes.addNode(n);
        }
    }


    public void accept(microjavaparser.visitor.Visitor v) {
        node.accept(v);
    }
    public <R,A> R accept(microjavaparser.visitor.GJVisitor<R,A> v, A argu) {
        return node.accept(v,argu);
    }
    public <R> R accept(microjavaparser.visitor.GJNoArguVisitor<R> v) {
        return node.accept(v);
    }
    public <A> void accept(microjavaparser.visitor.GJVoidVisitor<A> v, A argu) {
        node.accept(v,argu);
    }

}

