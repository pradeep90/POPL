import microjavaparser.syntaxtree.*;

/** 
 * Class to represent a Node along with other prerequisite
 * Nodes that precede it.
 * 
 */
public class ExpansionNode{
    public Node node;
    public NodeListOptional precedingNodes;

    public ExpansionNode(Node node) {
        this(node, new NodeListOptional());
    }

    public ExpansionNode(Node currNode, NodeListOptional precedingNodes) {
        this.precedingNodes = precedingNodes;
        this.node = currNode;
    }

    public Node toNode(){
        return node;
    }

    public boolean hasPrecedingNodes(){
        return precedingNodes.present();
    }

    public NodeListOptional getPrecedingNodes(){
        return precedingNodes;
    }

}

