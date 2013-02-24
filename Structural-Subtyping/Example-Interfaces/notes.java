A <= B ?  // No
B <= A ?  // Yes
C <= D ?  // No
D <= C ?  // Yes

interface A {
  A m(int a);
}

interface B {
  B m(int a);
  void p(boolean a);
}

interface C {
  int q(B a);
}

interface D {
  int q(A a);
  void r(int a);
}

