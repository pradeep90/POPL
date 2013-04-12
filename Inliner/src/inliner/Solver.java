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
    HashMap<FlowVar, HashMap<String, HashSet<PropagationConstraint>>> flowConstraints;
    
    HashMap<FlowVar, HashSet<FlowVar>> edges;

    public HashMap<FlowVar, HashSet<String>> flowSetMap;

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

        classIndexMap = getClassIndexMap(classNames);

        flowConstraints = new HashMap<FlowVar, HashMap<String, HashSet<PropagationConstraint>>>();
        for (FlowVar var : flowVars){
            flowConstraints.put(var, new HashMap<String, HashSet<PropagationConstraint>>());
            for (String className : classNames){
                flowConstraints.get(var).put(className, new HashSet<PropagationConstraint>());
            }
        }

        edges = new HashMap<FlowVar, HashSet<FlowVar>>();
        for (FlowVar var : flowVars){
            edges.put(var, new HashSet<FlowVar>());
        }

        flowSetMap = new HashMap<FlowVar, HashSet<String>>();

        for (FlowVar var : flowVars){
            flowSetMap.put(var, new HashSet<String>());
        }
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

    public static HashMap<String, Integer> getClassIndexMap(
        List<String> classNames){

        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for (int i = 0; i < classNames.size(); i++){
            map.put(classNames.get(i), i);
        }
        return map;
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
            flowVars.add(conditionalConstraint.propagationConstraint.lhs);
            flowVars.add(conditionalConstraint.propagationConstraint.rhs);
        }
        return new ArrayList<FlowVar>(flowVars);
    }

    public void computeFlowSets(){
        for (BeginningConstraint beginningConstraint : beginningConstraints){
            insert(beginningConstraint);
        }

        for (PropagationConstraint propagationConstraint : propagationConstraints){
            insert(propagationConstraint);
        }

        for (ConditionalConstraint conditionalConstraint : conditionalConstraints){
            insert(conditionalConstraint);
        }

        // for (FlowVar var : flowSetMap.keySet()){
        //     for (int i = 0; i < flowSetMap.get(var).size(); i++){
        //         if (flowSetMap.get(var).get(i)){
        //             addClassName(var, classNames.get(i));
        //         }
        //     }
        // }
    }

    public void addClassName(FlowVar var, String className){
        if (!flowSetMap.containsKey(var)){
            flowSetMap.put(var, new HashSet<String>());
        }

        flowSetMap.get(var).add(className);
    }

    public void propagate(FlowVar v, String className){
        if (flowSetMap.get(v).contains(className)){
            return;
        }

        flowSetMap.get(v).add(className);
        
        for (FlowVar neighbour : edges.get(v)){
            propagate(neighbour, className);
        }
        
        for (PropagationConstraint propagationConstraint :
                     flowConstraints.get(v).get(className)){
            insert(propagationConstraint);
        }

        flowConstraints.get(v).get(className).clear();
    }

    public void insert(BeginningConstraint beginningConstraint){
        propagate(beginningConstraint.var,
                  beginningConstraint.className);
    }

    public void insert(PropagationConstraint propagationConstraint){
        addEdge(propagationConstraint.lhs, propagationConstraint.rhs);
        for (String className : flowSetMap.get(propagationConstraint.lhs)){
            propagate(propagationConstraint.rhs, className);
        }
    }

    public void insert(ConditionalConstraint conditionalConstraint){
        if (flowSetMap.get(conditionalConstraint.mainFlowVar).contains(
                conditionalConstraint.className)){

            insert(conditionalConstraint.propagationConstraint);
        } else {
            flowConstraints.get(conditionalConstraint.mainFlowVar).get(conditionalConstraint.className).add(conditionalConstraint.propagationConstraint);
        }
       
    }

    public void addEdge(FlowVar from, FlowVar to){
        if (!edges.containsKey(from)){
            edges.put(from, new HashSet<FlowVar>());
        }

        edges.get(from).add(to);
    }
}
