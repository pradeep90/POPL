package inliner;

import inliner.syntaxtree.*;
import inliner.visitor.*;

/** 
 * Visitor to simply build up a copy of the original Microjava tree.
 *
 * Other Visitors that only modify a few visit() functions can extend
 * this Visitor.
 */
public class IdentityVisitor extends GJNoArguDepthFirst<Node> {
    public IdentityVisitor() {
        
    }
}
