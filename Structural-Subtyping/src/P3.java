import syntaxtree.*;
import visitor.*;

public class P3 {
   public static void main(String [] args) {
      try {
         Node root = new InterfaceParser(System.in).Goal();
         System.out.println("Program parsed successfully");
         root.accept(new GJNoArguDepthFirst());
      }
      catch (ParseException e) {
         System.out.println(e.toString());
      }
   }
} 



