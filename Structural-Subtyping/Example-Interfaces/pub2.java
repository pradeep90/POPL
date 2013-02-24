C <= D ?
D <= C ?

interface A {
  A m(int a);
}                                                                                                                                                                                             
interface B {
  B m(int a);
  void p(boolean a);
}                                                                                                                                                                                             
interface C {                                                                                                                                                                                   int q(B a);
}                                                                                                                                                                                             
interface D {
  int q(A a);                                                                                                                                                                                   void r(int a);
}
