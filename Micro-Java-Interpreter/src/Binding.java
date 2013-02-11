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

    public boolean equals(Object o) {
        if (o instanceof Binding) {
            Binding other = (Binding) o;
            return this.name.equals(other.name) && this.value.equals(other.value);
        }
        return false;
    }

}
