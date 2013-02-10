import syntaxtree.*;

public class Binding {
    String name;
    Value value;

    public Binding(String name, Value value) {
        this.name = name;
        this.value = value;
    }

    public String toString(){
        String result = "";
        result += name + ": " + value;
        return result;
    }
}
