class BlockTest1 {
    public static void main ( String [ ] a ) {
        new ____NewMainClass____ ( ) . ____Main____ ( 0  ) ;
    }
}
class
____NewMainClass____ {
    public void ____Main____ (int  ____arg_length____ ,
                              Continuation  k  ) {
        int  ____printMe____ ;
        int  ___tmp5 ;
        Continuation
                k1 ;
        Continuation  k2 ;
        Continuation  k3 ;
        Continuation  k4 ;
        Continuation  k5 ;
        Continuation  k6 ;
        Continuation  k7 ;
        Continuation  k8
                ;
        Continuation  k9 ;
        Continuation  k10 ;
        ____printMe____ = 5;
        System.out.println ( ____printMe____ ) ;
        k.call();
    }
    public void method2 (
        int  a , int  b   , Continuation  k  ) {
        int  c ;
        int  d ;
        Foo  foo ;
        Continuation  k1 ;
        Continuation  k2 ;
        Continuation  k3 ;
        Continuation  k4
                ;
        Continuation  k5 ;
        Continuation  k6 ;
        Continuation  k7 ;
        Continuation
                k8 ;
        Continuation  k9 ;
        Continuation  k10 ;
        c = a + b;
        k1 = new
                ContinuationClasscontinuationMethod0();
        k1.a = a;
        k1.b = b;
        k1.c = c;
        k1
                .d = d;
        k1.foo = foo;
        k1.k = k;
        foo.bar(k1 );
    }
    public void method3 (int
                         a , int  b   , Continuation  k  ) {
        int  c ;
        int  d ;
        Foo  foo ;
        Continuation  k1 ;
        Continuation  k2 ;
        Continuation  k3 ;
        Continuation  k4
                ;
        Continuation  k5 ;
        Continuation  k6 ;
        Continuation  k7 ;
        Continuation
                k8 ;
        Continuation  k9 ;
        Continuation  k10 ;
        c = a + b;
        d = 4;
        k1 = new
                ContinuationClasscontinuationMethod1();
        k1.a = a;
        k1.b = b;
        k1.c = c;
        k1
                .d = d;
        k1.foo = foo;
        k1.k = k;
        foo.bar(k1 );
    }
    public void method4 (int
                         a , int  b   , Continuation  k  ) {
        int  c ;
        boolean  d ;
        Continuation  k1
                ;
        Continuation  k2 ;
        Continuation  k3 ;
        Continuation  k4 ;
        Continuation
                k5 ;
        Continuation  k6 ;
        Continuation  k7 ;
        Continuation  k8 ;
        Continuation  k9 ;
        Continuation  k10 ;
        c = a + b;
        d = true;
        k.call();
    }
    public void method5 (Continuation  k ) {
        int  x ;
        boolean  y ;
        Continuation  k1 ;
        Continuation  k2 ;
        Continuation  k3 ;
        Continuation  k4
                ;
        Continuation  k5 ;
        Continuation  k6 ;
        Continuation  k7 ;
        Continuation
                k8 ;
        Continuation  k9 ;
        Continuation  k10 ;
        k.call();
    }
    public void
    method6 (int  m , int  n   , Continuation  k  ) {
        Continuation  k1 ;
        Continuation  k2 ;
        Continuation  k3 ;
        Continuation  k4 ;
        Continuation  k5
                ;
        Continuation  k6 ;
        Continuation  k7 ;
        Continuation  k8 ;
        Continuation
                k9 ;
        Continuation  k10 ;
        System.out.println ( m + n ) ;
        k.call();
    }
    public
    void method7 (Continuation  k ) {
        Continuation  k1 ;
        Continuation  k2 ;
        Continuation  k3 ;
        Continuation  k4 ;
        Continuation  k5 ;
        Continuation  k6
                ;
        Continuation  k7 ;
        Continuation  k8 ;
        Continuation  k9 ;
        Continuation
                k10 ;
        k.call();
    }
    public void methodNestedIfs (Continuation  k ) {
        Continuation  k1 ;
        Continuation  k2 ;
        Continuation  k3 ;
        Continuation  k4
                ;
        Continuation  k5 ;
        Continuation  k6 ;
        Continuation  k7 ;
        Continuation
                k8 ;
        Continuation  k9 ;
        Continuation  k10 ;
        k1 = new
                ContinuationClasscontinuationMethod2();
        k1.k = k;
        if ( x < 1 ) {
            a = 4;
            k2
                    = new ContinuationClasscontinuationMethod3();
            k2.k = k;
            if ( y < 1 ) {
                k3 =
                        new ContinuationClasscontinuationMethod4();
                k3.k = k;
                if ( z < 2 ) {
                    x =
                            101;
                    k3.call();
                }
                else {
                    x = 102;
                    k3.call();
                }
            }
            else {
                c = 6;
                k2.call();
            }
        }
        else {
            e = 8;
            k2 = new ContinuationClasscontinuationMethod5();
            k2.k
                    = k;
            if ( y < 100 ) {
                f = 9;
                k2.call();
            }
            else {
                g = 10;
                k2.call();
            }
        }
    }
    public void continuationMethod0 (int  a , int  b   , int  c   , int  d   ,
                                     Foo  foo   , Continuation  k  ) {
        Continuation  k1 ;
        Continuation  k2 ;
        Continuation  k3 ;
        Continuation  k4 ;
        Continuation  k5 ;
        Continuation  k6
                ;
        Continuation  k7 ;
        Continuation  k8 ;
        Continuation  k9 ;
        Continuation
                k10 ;
        c = a + 3;
        d = c + b;
        k.call();
    }
    public void continuationMethod1 (
        int  a , int  b   , int  c   , int  d   , Foo  foo   , Continuation  k  ) {
        Continuation  k1 ;
        Continuation  k2 ;
        Continuation  k3 ;
        Continuation  k4
                ;
        Continuation  k5 ;
        Continuation  k6 ;
        Continuation  k7 ;
        Continuation
                k8 ;
        Continuation  k9 ;
        Continuation  k10 ;
        c = 77;
        d = a + b;
        foo.baz(k
                );
    }
    public void continuationMethod2 (Continuation  k ) {
        Continuation  k1
                ;
        Continuation  k2 ;
        Continuation  k3 ;
        Continuation  k4 ;
        Continuation
                k5 ;
        Continuation  k6 ;
        Continuation  k7 ;
        Continuation  k8 ;
        Continuation  k9 ;
        Continuation  k10 ;
        i = 12;
        k.call();
    }
    public void
    continuationMethod3 (Continuation  k ) {
        Continuation  k1 ;
        Continuation
                k2 ;
        Continuation  k3 ;
        Continuation  k4 ;
        Continuation  k5 ;
        Continuation  k6 ;
        Continuation  k7 ;
        Continuation  k8 ;
        Continuation  k9
                ;
        Continuation  k10 ;
        d = 7;
        k.call();
    }
    public void continuationMethod4 (
        Continuation  k ) {
        Continuation  k1 ;
        Continuation  k2 ;
        Continuation  k3
                ;
        Continuation  k4 ;
        Continuation  k5 ;
        Continuation  k6 ;
        Continuation
                k7 ;
        Continuation  k8 ;
        Continuation  k9 ;
        Continuation  k10 ;
        b = 5;
        k.
                call();
    }
    public void continuationMethod5 (Continuation  k ) {
        Continuation
                k1 ;
        Continuation  k2 ;
        Continuation  k3 ;
        Continuation  k4 ;
        Continuation  k5 ;
        Continuation  k6 ;
        Continuation  k7 ;
        Continuation  k8
                ;
        Continuation  k9 ;
        Continuation  k10 ;
        h = 11;
        k.call();
    }
}
class ContinuationClasscontinuationMethod0 extends Continuation {
    int  a ;
    int
    b ;
    int  c ;
    int  d ;
    Foo  foo ;
    Continuation  k ;
    ____NewMainClass____
    object ;
    public void call () {
        object.continuationMethod0(a , b , c , d ,
                                   foo , k);
    }
}
class ContinuationClasscontinuationMethod1 extends Continuation {
    int  a ;
    int
    b ;
    int  c ;
    int  d ;
    Foo  foo ;
    Continuation  k ;
    ____NewMainClass____
    object ;
    public void call () {
        object.continuationMethod1(a , b , c , d ,
                                   foo , k);
    }
}
class ContinuationClasscontinuationMethod2 extends Continuation {
    Continuation
    k ;
    ____NewMainClass____  object ;
    public void call () {
        object.
                continuationMethod2(k );
    }
}
class ContinuationClasscontinuationMethod3 extends Continuation {
    Continuation
    k ;
    ____NewMainClass____  object ;
    public void call () {
        object.
                continuationMethod3(k );
    }
}
class ContinuationClasscontinuationMethod4 extends Continuation {
    Continuation
    k ;
    ____NewMainClass____  object ;
    public void call () {
        object.
                continuationMethod4(k );
    }
}
class ContinuationClasscontinuationMethod5 extends Continuation {
    Continuation
    k ;
    ____NewMainClass____  object ;
    public void call () {
        object.
                continuationMethod5(k );
    }
}
class Continuation {
    public void call () {
    }
}
