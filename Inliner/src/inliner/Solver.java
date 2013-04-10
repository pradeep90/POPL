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
    ArrayList<ArrayList<Boolean>> flowBitVector;
    ArrayList<ArrayList<ConditionalConstraint>> flowConstraints;
    
    public HashMap<FlowVar, List<String>> flowSetMap;

    public Solver(){}

    public Solver(Set<BeginningConstraint> beginningConstraints,
                  Set<PropagationConstraint> propagationConstraints,
                  Set<ConditionalConstraint> conditionalConstraints) {

        this.beginningConstraints = new ArrayList<BeginningConstraint>(beginningConstraints);
        this.propagationConstraints = new ArrayList<PropagationConstraint>(propagationConstraints);
        this.conditionalConstraints = new ArrayList<ConditionalConstraint>(conditionalConstraints);

        classNames = getClassNames();

        // TODO: Initialize these after you know the number of flow
        // variables and number of classes
        // classIndexMap = new HashMap<String, Integer>();
        // flowBitVector = new ArrayList<ArrayList<Boolean>>();
        // flowConstraints = new ArrayList<ArrayList<ConditionalConstraint>>();
        // flowSetMap = new HashMap<FlowVar, List<String>>();
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
}
