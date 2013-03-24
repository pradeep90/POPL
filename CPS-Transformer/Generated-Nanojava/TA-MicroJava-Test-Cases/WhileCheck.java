 class WhileCheck {
public static void main ( String [ ] a ) {
new WCTest ( ) . ____Main____ ( new Continuation()  ) ; } }  class WCTest { int
   a ;   int  b ; public void ____Main____ (Continuation  ___k ) { boolean
   check ; a = 1;  b = 100;  check = false; ___k.call(); }}
class Continuation { public void call () { }} 