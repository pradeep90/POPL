import syntaxtree.*;
import visitor.*;
import microjavaparser.*;

public class Main {
   public static void main(String [] args) {
      try {
         Node root = new MiniJavaParser(System.in).Goal();
         System.out.println("Program parsed successfully");
         System.out.println("Yo, Boyz!"); 
         MicroJavaOutputter<microjavaparser.syntaxtree.Node> outputter = new MicroJavaOutputter<microjavaparser.syntaxtree.Node>();
         microjavaparser.syntaxtree.Node microJavaRoot = root.accept(outputter);
         
         System.out.println("outputter.getMicroJavaCode(): " + outputter.getMicroJavaCode());
         System.out.println("outputter.outputCodeString: " + outputter.outputCodeString);
         // System.out.println("MicroJavaOutputter.getFormattedString(microJavaRoot): " + MicroJavaOutputter.getFormattedString(microJavaRoot));
         // System.out.println("outputter.getFullMicroJavaCode(): " + outputter.getFullMicroJavaCode());
      }
      catch (ParseException e) {
         System.out.println(e.toString());
      }
   }
} 
