class NestedTest {
    public static void main ( String [ ] a ) {
        new NewMainClass ( ) . Main ( 0 , new Continuation() ) ;
    }
}
class NewMainClass {
    int fib ;
    public void Main (int arglength , Continuation k ) {
        NewMainClass curr ;
        NewMainClass pseudoThis ;
        ContinuationClass_ContinuationMethod0 k1 ;
        pseudoThis = this;
        curr = this;
        k1 = new ContinuationClass_ContinuationMethod0();
        k1. arglength = arglength;
        k1.k = k;
        k1.object = this;
        curr.fib(8 , k1);
    }
    public void fib (int n , Continuation k) {
        int temp ;
        NewMainClass curr ;
        NewMainClass
                pseudoThis ;
        ContinuationClass_ContinuationMethod1 k1 ;
        pseudoThis = this;
        if ( n < 3 ) {
            fib = 1;
            k.call();
        }
        else {
            curr = this;
            k1 = new ContinuationClass_ContinuationMethod1();
            k1.n = n ;
            k1.curr = curr;
            k1.k = k;
            k1.object = this;
            curr.fib(n - 1 , k1);
        }
    }
    public void continuationMethod0 (int arglength ,
                                     Continuation k ) {
        NewMainClass pseudoThis ;
        pseudoThis = this;
        System.out.println ( fib ) ;
        k.call();
    }
    public void
    continuationMethod2 (int n , NewMainClass curr , int temp ,
                         Continuation k ) {
        NewMainClass pseudoThis ;
        pseudoThis = this;
        fib = temp + fib;
        k.call();
    }
    public void
    continuationMethod1 (int n , NewMainClass curr , Continuation
                         k ) {
        int temp ;
        NewMainClass pseudoThis ;
        ContinuationClass_ContinuationMethod2 k1 ;
        pseudoThis = this;
        temp = fib;
        k1 = new ContinuationClass_ContinuationMethod2();
        k1.n = n;
        k1.curr = curr;
        k1.temp = temp;
        k1.k = k;
        k1.object = this;
        curr.fib(n - 2 , k1);
    }
}
class ContinuationClass_ContinuationMethod0 extends Continuation {
    int
    arglength ;
    Continuation k ;
    NewMainClass object ;
    public void call () {
        object.continuationMethod0(arglength , k);
    }
}
class ContinuationClass_ContinuationMethod2 extends Continuation {
    int n ;
    NewMainClass curr ;
    int temp ;
    Continuation k ;
    NewMainClass object ;
    public void call () {
        object. continuationMethod2(n , curr , temp , k);
    }
}
class ContinuationClass_ContinuationMethod1 extends Continuation {
    int n ;
    NewMainClass curr ;
    Continuation k ;
    NewMainClass
    object ;
    public void call () {
        object.continuationMethod1(n , curr , k);
    }
}
class Continuation {
    public void call () {
    }
}
