import syntaxtree.*;
import visitor.*;

public class P5 {
   public static void main(String [] args) {
      try {
         Node root = new MicroJavaParser(System.in).Goal();
         nano.syntaxtree.Node result = root.accept(new Transformer());
         System.out.println(CPSHelper.getFormattedString(result));
      }
      catch (ParseException e) {
         System.out.println(e.toString());
      }
   }
} 
