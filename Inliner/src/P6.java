import inliner.*;
import inliner.syntaxtree.*;
import inliner.visitor.*;

public class P6 {
   public static void main(String [] args) {
      try {
         Node root = new MicroJavaParser(System.in).Goal();
         FlowBasedInliner flowBasedInliner = new FlowBasedInliner((Goal) root);
         flowBasedInliner.compute();
         System.out.println(InlinerHelper.getFormattedString(flowBasedInliner.finalParseTree));
      }
      catch (ParseException e) {
         System.out.println(e.toString());
      }
   }
} 
