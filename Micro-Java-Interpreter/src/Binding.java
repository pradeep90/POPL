import syntaxtree.*;

public class Binding {
    Identifier identifier;
    Location value;

    public Binding(Identifier identifier, Location value) {
        this.identifier = identifier;
        this.value = value;
    }

    public Binding(String identifierName, Location value){
        this(new Identifier(new NodeToken(identifierName)),
             value);
    }
}
