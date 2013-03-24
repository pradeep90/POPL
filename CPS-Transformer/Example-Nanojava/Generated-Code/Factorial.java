class Factorial {
    public static void main ( String [ ] a ) {
        new ____NewMainClass____ ( ) . ____Main____ ( 5 , new Continuation() ) ;
    }
}
class Fac {
    int  ____1234ComputeFac4321____ ;
    public void ComputeFac (int
                            num , Continuation  k  ) {
        int  num_aux ;
        int  ____writeable____num ;
        int
                ____tmp0 ;
        Fac  ___tmp4 ;
        int  ___tmp3 ;
        ContinuationClasscontinuationMethod0  k1 ;
        ContinuationClasscontinuationMethod1  k2 ;
        ____writeable____num = num;
        System.out.println("ComputeFac method"); 
        System.out.println("____writeable____num: " + ____writeable____num);
        if (
                ____writeable____num < 1 ) {
            num_aux = 1;
            k1 = new
                    ContinuationClasscontinuationMethod0();
            k1.num = num;
            k1.num_aux = num_aux
                    ;
            k1.k = k;
            k1.object = this;
            k1.call();
        }
        else {
            ___tmp4 = this;
            k2 =
                    new ContinuationClasscontinuationMethod1();
            k2.num = num;
            k2.
                    ____writeable____num = ____writeable____num;
            k2.___tmp4 = ___tmp4;
            k2.k =
                    k;
            k2.object = this;
            ___tmp4.ComputeFac(____writeable____num - 1 , k2);
        }
    }
    public void continuationMethod0 (int  num , int  num_aux   , Continuation
                                     k  ) {
        int  ____writeable____num ;
        int  ____tmp0 ;
        Fac  ___tmp4 ;
        int
                ___tmp3 ;
        System.out.println("continuationMethod0"); 
        System.out.println("____1234ComputeFac4321____: " + ____1234ComputeFac4321____);
        ____1234ComputeFac4321____ = num_aux;
        k.call();
    }
    public void
    continuationMethod1 (int  num , int  ____writeable____num   , Fac  ___tmp4
                         , Continuation  k  ) {
        int  num_aux ;
        int  ____tmp0 ;
        int  ___tmp3 ;
        ContinuationClasscontinuationMethod0  k1 ;

        System.out.println("continuationMethod1"); 
        System.out.println("____writeable____num: " + ____writeable____num);

        ___tmp3 = ___tmp4.
                ____1234ComputeFac4321____;
        ____tmp0 = ___tmp3;
        num_aux =
                ____writeable____num * ____tmp0;
        System.out.println("num_aux: " + num_aux);
        k1 = new
                ContinuationClasscontinuationMethod0();
        k1.num = num;
        k1.num_aux = num_aux
                ;
        k1.k = k;
        k1.object = this;
        k.call();
    }
}
class ____NewMainClass____ {
    public void ____Main____ (int  ____arg_length____
                              , Continuation  k  ) {
        int  ____printMe____ ;
        Fac  ___tmp6 ;
        int  ___tmp5
                ;
        ContinuationClasscontinuationMethod2  k1 ;
        ___tmp6 = new Fac();
        k1 = new
                ContinuationClasscontinuationMethod2();
        k1.____arg_length____ =
                ____arg_length____;
        k1.___tmp6 = ___tmp6;
        k1.k = k;
        k1.object = this;
        ___tmp6.ComputeFac(2 , k1);
    }
    public void continuationMethod2 (int
                                     ____arg_length____ , Fac  ___tmp6   , Continuation  k  ) {
        int
                ____printMe____ ;
        int  ___tmp5 ;
        ___tmp5 = ___tmp6.
                ____1234ComputeFac4321____;
        System.out.println("continuationMethod2"); 
        System.out.println("___tmp5: " + ___tmp5);
        ____printMe____ = ___tmp5;
        System.out.println ( ____printMe____ ) ;
        k.call();
    }
}
class ContinuationClasscontinuationMethod0 extends Continuation {
    int  num ;
    int  num_aux ;
    Continuation  k ;
    Fac  object ;
    public void call () {
        object.
                continuationMethod0(num , num_aux , k);
    }
}
class ContinuationClasscontinuationMethod1 extends Continuation {
    int  num ;
    int  ____writeable____num ;
    Fac  ___tmp4 ;
    Continuation  k ;
    Fac  object ;
    public void call () {
        object.continuationMethod1(num , ____writeable____num
                                   , ___tmp4 , k);
    }
}
class ContinuationClasscontinuationMethod2 extends Continuation {
    int
    ____arg_length____ ;
    Fac  ___tmp6 ;
    Continuation  k ;
    ____NewMainClass____
    object ;
    public void call () {
        object.continuationMethod2(____arg_length____
                                   , ___tmp6 , k);
    }
}
class Continuation {
    public void call () {
    }
}
