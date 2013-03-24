 class SimpleMain {
public static void main ( String [ ] a ) {
new ____NewMainClass____ ( ) . ____Main____ ( 0 , new Continuation() ) ; } }
   class ____NewMainClass____ { public void ____Main____ (int
   ____arg_length____ , Continuation  ___k  ) { System.out.println ( 9 ) ; ___k
   .call(); }}
class Continuation { public void call () { }} 