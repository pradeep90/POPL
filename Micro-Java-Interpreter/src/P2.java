import syntaxtree.*;
import visitor.*;

public class P2 {
   public static void main(String [] args) {
      try {
         Node root = new MicroJavaParser(System.in).Goal();
         Interpreter interpreter = new Interpreter();
         Environment env = new Environment();
         interpreter.visit((Goal) root, env);
      }
      catch (ParseException e) {
         System.out.println(e.toString());
      }
   }
} 



