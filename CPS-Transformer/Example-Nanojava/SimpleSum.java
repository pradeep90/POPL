class SimpleSum {
    public static void main(String [] a){
        new ____NewMainClass____().____Main____(0, new IdentityCont());
    }
}

class Continuation {
    
    public void constructorContinuation() {
        
    }

    public void call(){}
}


class IdentityCont extends Continuation {
    
    public void constructorIdentityCont() {
        
    }

    public void call(){}
}

class SumCont1 extends Continuation{
    Sum object;
    Continuation k;
    int number;
    
    public void constructorSumCont1(Sum object, Continuation k, int number) {
        SumCont1 current;
        current = this;
        current.object = object;
        current.k = k;
        current.number = number;
    }

    public void call(){
        object.continuationSumMethod(number, k);
    }
}

class Sum {
    int ___1234sum4321___;
    
    public void sum(int number, Continuation k){
        Sum current;
        current = this;
        if (number < 1){
            k.call();
        }
        else{
            current.sumCreateCont(number, k);
        }
    }

    public void sumCreateCont(int number, Continuation k){
        Sum current;
        SumCont1 k2;
        k2 = new SumCont1();
        k2.object = this;
        k2.k = k;
        k2.number = number;
        current = this;
        current.sum(number - 1, k2);
    }

    public void continuationSumMethod(int number, Continuation k){
        ___1234sum4321___ = ___1234sum4321___ + number;
        k.call();
    }
}

class PrintCont1 extends Continuation{
    ____NewMainClass____ object;
    Continuation k;
    Sum sum;
    
    public void constructorPrintCont1(____NewMainClass____ object, Continuation k, Sum sum) {
        PrintCont1 current;
        current = this;
        
        current.object = object;
        current.k = k;
        current.sum = sum;
    }

    public void call(){
        object.continuationPrintMethod(sum, k);
    }
}

class ____NewMainClass____{

    public void continuationPrintMethod(Sum sum, Continuation k){
        System.out.println(sum.___1234sum4321___);
        k.call();
    }

    public void ____Main____(int ____arg_length____, Continuation k){
        int ____printMe____;
        Sum sum;
        int ___tmp5;
        PrintCont1 k2;

        sum = new Sum();
        k2 = new PrintCont1();
        k2.object = this;
        k2.k = k;
        k2.sum = sum;
        sum.sum(10, k2);
    }
}
