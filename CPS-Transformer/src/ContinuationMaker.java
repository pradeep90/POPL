import visitor.*;
import nano.syntaxtree.*;

import java.util.Enumeration;
import java.util.List;
import java.util.ArrayList;
import java.util.Vector;

public class ContinuationMaker {
    syntaxtree.NodeListOptional trailingStatements;
    syntaxtree.MethodDeclaration parentMethod;
    Transformer transformer;

    MethodDeclaration continuationMethod;
    String kName;
    String continuationMethodName;

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
    }

    public void makeContinuationMethod(){
        // TODO: Take all the params and local variables of the
        // original method and make them params for the Continuation method

        // Add parameters
        syntaxtree.FormalParameterList parameterList = null;
        if (parentMethod.f4.present()){
            syntaxtree.FormalParameterList parentParameterList =
                    (syntaxtree.FormalParameterList) parentMethod.f4.node;
            parameterList = new syntaxtree.FormalParameterList(parentParameterList.f0,
                                                               parentParameterList.f1);
        }

        syntaxtree.NodeListOptional restParameters = new syntaxtree.NodeListOptional();
        for (syntaxtree.Node node : parentMethod.f7.nodes){
            syntaxtree.VarDeclaration currVarDeclaration = (syntaxtree.VarDeclaration) node;
            restParameters.addNode(new syntaxtree.FormalParameterRest(
                new syntaxtree.FormalParameter(currVarDeclaration.f0, currVarDeclaration.f1)));
        }

        // Add local variables
        if (parameterList != null){
            parameterList.f1.nodes.addAll(restParameters.nodes);
        } else {
            syntaxtree.NodeListOptional remainingRestParameters =
                    new syntaxtree.NodeListOptional();
            remainingRestParameters.nodes.addAll(
                restParameters.nodes.subList(1, restParameters.nodes.size()));
            parameterList = new syntaxtree.FormalParameterList(
                ((syntaxtree.FormalParameterRest) restParameters.nodes.get(0)).f1,
                remainingRestParameters);
        }
        
        syntaxtree.NodeOptional parameters = new syntaxtree.NodeOptional(parameterList);

        syntaxtree.MethodDeclaration tempMethod = new syntaxtree.MethodDeclaration(
            // TODO: Get a unique name for each method
            CPSHelper.getNewMicroIdentifier("TEMP_METHOD"),
            parameters,
            new syntaxtree.NodeListOptional(),
            trailingStatements);

        continuationMethod = (MethodDeclaration) tempMethod.accept(transformer);
    }

    public void makeContinuationClass(){
        // TODO: Use the method's parameters as your fields
    }

    public void makeInitStatements(){
        // TODO: Have a Statement to set each field of continuationClass.
        NodeListOptional initStatements = new NodeListOptional();
    }
}
