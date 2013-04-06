package inliner;

import inliner.syntaxtree.*;
import inliner.visitor.*;

public class P6 {
   public static void main(String [] args) {
      try {
         Node root = new MicroJavaParser(System.in).Goal();
         root.accept(new GJNoArguDepthFirst<Integer>());
      }
      catch (ParseException e) {
         System.out.println(e.toString());
      }
   }
} 
