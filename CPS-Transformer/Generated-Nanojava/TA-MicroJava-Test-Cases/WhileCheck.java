 class WhileCheck {
public static void main ( String [ ] a ) {
new WCTest ( ) . ____Main____ ( new Continuation()  ) ; } }  class WCTest { int
   a ;   int  b ; public void ____Main____ (Continuation  ___k ) { boolean
   check ;  WCTest  ___pseudoThis ; ___pseudoThis = this;  a = 1;  b = 100;
   check = false; ___pseudoThis.whileMethod1(___k ); }  public void
   whileMethod1 (Continuation  ___k ) { boolean  check ;  WCTest  ___pseudoThis
   ; ___pseudoThis = this; if ( a < b ) { a = a + 10;  System.out.println ( a )
   ; ___pseudoThis.whileMethod1(___k ); }  else { ___k.call(); }  }}
class Continuation { public void call () { }} 