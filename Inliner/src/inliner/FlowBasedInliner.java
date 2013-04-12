package inliner;

import inliner.syntaxtree.*;
import inliner.visitor.*;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;

import static inliner.InlinerHelper.*;

/** 
 * Class to inline methods in Microjava code.
 */
public class FlowBasedInliner {
    Goal originalParseTree;

    // Result
    public Goal finalParseTree;
    
    public FlowBasedInliner(Goal originalParseTree){
        this.originalParseTree = originalParseTree;
    }

    public void compute(){
        ConstraintGenerator constraintGenerator = new ConstraintGenerator();
        VarNameUniquifier varNameUniquifier = new VarNameUniquifier();
        Environment env = new Environment();
        
        Goal uniquifiedParseTree = (Goal) originalParseTree.accept(
            varNameUniquifier, env);

        uniquifiedParseTree.accept(constraintGenerator);
        
        Solver solver = new Solver(constraintGenerator);
        solver.computeFlowSets();
        
        MethodInliner methodInliner = new MethodInliner(uniquifiedParseTree,
                                                        varNameUniquifier,
                                                        solver.flowSetMap);
        finalParseTree = (Goal) uniquifiedParseTree.accept(methodInliner);
    }
}
