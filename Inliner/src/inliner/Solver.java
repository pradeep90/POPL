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
 * Class to get the Flow Set for each FlowVar.
 */
public class Solver extends IdentityVisitor {

    List<BeginningConstraint> beginningConstraints;
    List<PropagationConstraint> propagationConstraints;
    List<ConditionalConstraint> conditionalConstraints;

    List<String> classNames;
    List<FlowVar> flowVars;

    HashMap<String, Integer> classIndexMap;
    HashMap<FlowVar, ArrayList<Boolean>> flowBitVector;
    HashMap<FlowVar, ArrayList<ConditionalConstraint>> flowConstraints;
    
    public HashMap<FlowVar, List<String>> flowSetMap;

    public Solver(){}

    public Solver(Set<BeginningConstraint> beginningConstraints,
                  Set<PropagationConstraint> propagationConstraints,
                  Set<ConditionalConstraint> conditionalConstraints) {

        this.beginningConstraints = new ArrayList<BeginningConstraint>(
            beginningConstraints);
        this.propagationConstraints = new ArrayList<PropagationConstraint>(
            propagationConstraints);
        this.conditionalConstraints = new ArrayList<ConditionalConstraint>(
            conditionalConstraints);

        classNames = getClassNames();
        flowVars = getFlowVars();

        classIndexMap = new HashMap<String, Integer>();
        flowBitVector = new HashMap<FlowVar, ArrayList<Boolean>>();
        flowConstraints = new HashMap<FlowVar, ArrayList<ConditionalConstraint>>();
        flowSetMap = new HashMap<FlowVar, List<String>>();
    }

    public List<String> getClassNames(){
        Set<String> classNames = new HashSet<String>();
        for (BeginningConstraint beginningConstraint : beginningConstraints){
            classNames.add(beginningConstraint.className);
        }

        for (ConditionalConstraint conditionalConstraint : conditionalConstraints){
            classNames.add(conditionalConstraint.className);
        }
        return new ArrayList<String>(classNames);
    }

    public List<FlowVar> getFlowVars(){
        Set<FlowVar> flowVars = new HashSet<FlowVar>();
        for (BeginningConstraint beginningConstraint : beginningConstraints){
            flowVars.add(beginningConstraint.var);
        }

        for (PropagationConstraint propagationConstraint : propagationConstraints){
            flowVars.add(propagationConstraint.lhs);
            flowVars.add(propagationConstraint.rhs);
        }

        for (ConditionalConstraint conditionalConstraint : conditionalConstraints){
            flowVars.add(conditionalConstraint.mainFlowVar);
            flowVars.add(conditionalConstraint.antecedent);
            flowVars.add(conditionalConstraint.consequent);
        }
        return new ArrayList<FlowVar>(flowVars);
    }

    public void propagate(FlowVar v, int classIndex){
        // if (flowBitVector.get(v).get(classIndex)){
        //     return;
        // }
        // flowBitVector.get(v).get(classIndex).
    }
}
