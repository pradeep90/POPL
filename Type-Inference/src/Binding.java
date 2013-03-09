import syntaxtree.*;

public class Binding {
    String name;
    Type type;

    public Binding(String name, Type type) {
        this.name = name;
        this.type = type;
    }

    public String toString(){
        String result = "";
        result += name + ": " + type;
        return result;
    }

    public boolean equals(Object o) {
        if (o instanceof Binding) {
            Binding other = (Binding) o;
            return this.name.equals(other.name) && this.type.equals(other.type);
        }
        return false;
    }

}
