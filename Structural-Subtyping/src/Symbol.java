public class Symbol implements Comparable<Symbol> {
    String name;
    
    public Symbol(String name) {
        this.name = name;
    }

    public boolean equals(Object o) {
        if (o instanceof Symbol) {
            Symbol other = (Symbol) o;
            return this.name.equals(other.name);
        }
        return false;
    }

    public String toString(){
        String result = "";
        result += name;
        return result;
    }

    public int hashCode(){
        return name == null? 0: name.hashCode();
    }

    public int compareTo(Symbol other){
        return this.name.compareTo(other.name);
    }
}
