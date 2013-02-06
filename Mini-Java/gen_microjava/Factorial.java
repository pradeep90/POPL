class Factorial {

    public static void main ( String [ ] a ) {

        new ____NewMainClass____ ( ) . ____Main____ ( 0  ) ;
    }
}
class Fac {
    int
    ____1234ComputeFac4321____ ;
    public void ComputeFac ( int  num  ) {
        int
                num_aux ;
        Fac  ___tmp31 ;
        int  ___tmp32 ;
        if ( num < 1 ) num_aux = 1 ;

        else {
            ___tmp31 = this ;
            ___tmp31 . ComputeFac ( num - 1  ) ;
            ___tmp32 =
                    ___tmp31 . ____1234ComputeFac4321____ ;
            num_aux = num * ( ___tmp32 ) ;
        }

        ____1234ComputeFac4321____ = num_aux ;
    }
}

class ____NewMainClass____ {
    public void ____Main____ ( int  ____arg_length____
                               ) {
        Fac  ___tmp29 ;
        int  ___tmp30 ;
        ___tmp29 = new Fac ( ) ;
        ___tmp29 .
                ComputeFac ( 10  ) ;
        ___tmp30 = ___tmp29 . ____1234ComputeFac4321____ ;

        System.out.println ( ___tmp30 ) ;
    }
}
 
