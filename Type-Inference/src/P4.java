import syntaxtree.*;
import visitor.*;

public class P4 {
    public static void main(String [] args) {
        try {
            Node root = new MiniSchemeParser(System.in).Goal();
            root.accept(new TypeEquationCollector(), null);
        }
        catch (ParseException e) {
            System.out.println(e.toString());
        }
    }
} 



