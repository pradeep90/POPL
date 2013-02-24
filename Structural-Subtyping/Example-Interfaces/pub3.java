I1 <= I2 ?
I2 <= I1 ?
I3 <= I4 ?
I5 <= I6 ?
I1 <= I5 ?
I3 <= I1 ?

interface I1{
        boolean a(boolean b);
}

interface I2{
        boolean a(boolean v);
}

interface I3{
        int a(boolean b);
}

interface I4{
        int a(boolean b);
}

interface I5{
        boolean a(int b);
}

interface I6{
        boolean a(int b);
}
