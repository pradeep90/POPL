class LinkedList {
    public static void main ( String [ ] a ) {
        new ____NewMainClass____ ( ) . ____Main____ ( 0 , new Continuation() ) ;
    }
}
class Element {
    int  Age ;
    int  Salary ;
    boolean  Married ;
    boolean
    ____1234Init4321____ ;
    int  ____1234GetAge4321____ ;
    int
    ____1234GetSalary4321____ ;
    boolean  ____1234GetMarried4321____ ;
    boolean  ____1234Equal4321____ ;
    boolean  ____1234Compare4321____ ;
    public
    void Init (int  v_Age , int  v_Salary   , boolean  v_Married   ,
               Continuation  ___k  ) {
        int  ____writeable____v_Age ;
        boolean
                ____writeable____v_Married ;
        int  ____writeable____v_Salary ;
        Element
                ___pseudoThis ;
        ___pseudoThis = this;
        ____writeable____v_Salary = v_Salary;
        ____writeable____v_Married = v_Married;
        ____writeable____v_Age = v_Age;
        Age = ____writeable____v_Age;
        Salary = ____writeable____v_Salary;
        Married
                = ____writeable____v_Married;
        ____1234Init4321____ = true;
        ___k.call();
    }
    public void GetAge (Continuation  ___k ) {
        Element  ___pseudoThis ;
        ___pseudoThis = this;
        ____1234GetAge4321____ = Age;
        ___k.call();
    }
    public
    void GetSalary (Continuation  ___k ) {
        Element  ___pseudoThis ;
        ___pseudoThis = this;
        ____1234GetSalary4321____ = Salary;
        ___k.call();
    }
    public void GetMarried (Continuation  ___k ) {
        Element  ___pseudoThis ;
        ___pseudoThis = this;
        ____1234GetMarried4321____ = Married;
        ___k.call();
    }
    public void Equal (Element  other , Continuation  ___k  ) {
        boolean  ret_val
                ;
        int  aux01 ;
        int  aux02 ;
        int  nt ;
        Element  ____writeable____other ;
        int  ___tmp0 ;
        int  ___tmp2 ;
        boolean  ___tmp4 ;
        boolean  ___tmp6 ;
        Element  ___tmp9 ;
        boolean  ___tmp8 ;
        Element  ___tmp11 ;
        boolean
                ___tmp10 ;
        Element  ___pseudoThis ;
        ___ContinuationClasscontinuationMethod0  ___k1 ;
        ___pseudoThis = this;
        ____writeable____other = other;
        ret_val = true;
        ____writeable____other =
                ____writeable____other;
        ___k1 = new ___ContinuationClasscontinuationMethod0
                ();
        ___k1.other = other;
        ___k1.____writeable____other =
                ____writeable____other;
        ___k1.___k = ___k;
        ___k1.object = this;
        ____writeable____other.GetAge(___k1 );
    }
    public void Compare (int  num1 ,
                         int  num2   , Continuation  ___k  ) {
        boolean  retval ;
        int  aux02 ;
        int
                ____writeable____num2 ;
        int  ____writeable____num1 ;
        boolean  ____tmp12 ;
        Element  ___pseudoThis ;
        ___ContinuationClasscontinuationMethod11  ___k1 ;
        ___ContinuationClasscontinuationMethod12  ___k2 ;
        ___pseudoThis = this;
        ____writeable____num1 = num1;
        ____writeable____num2 = num2;
        retval = false
                ;
        aux02 = ____writeable____num2 + 1;
        if ( ____writeable____num1 <
             ____writeable____num2 ) {
            retval = false;
            ___k1 = new
                    ___ContinuationClasscontinuationMethod11();
            ___k1.num1 = num1;
            ___k1.num2
                    = num2;
            ___k1.retval = retval;
            ___k1.___k = ___k;
            ___k1.object = this;
            ___k1.call();
        }
        else {
            ____tmp12 = ____writeable____num1 < aux02;
            if ( !
                 ____tmp12 ) {
                retval = false;
                ___k2 = new
                        ___ContinuationClasscontinuationMethod12();
                ___k2.num1 = num1;
                ___k2.num2
                        = num2;
                ___k2.retval = retval;
                ___k2.___k = ___k;
                ___k2.object = this;
                ___k2.call();
            }
            else {
                retval = true;
                ___k2 = new
                        ___ContinuationClasscontinuationMethod12();
                ___k2.num1 = num1;
                ___k2.num2
                        = num2;
                ___k2.retval = retval;
                ___k2.___k = ___k;
                ___k2.object = this;
                ___k2.call();
            }
        }
    }
    public void continuationMethod2 (Element  other ,
                                     Element  ____writeable____other   , Element  ___tmp11   , boolean  ret_val
                                     , Continuation  ___k  ) {
        Element  ___pseudoThis ;
        ___pseudoThis = this;
        ____1234Equal4321____ = ret_val;
        ___k.call();
    }
    public void
    continuationMethod5 (Element  other , Element  ____writeable____other   ,
                         Element  ___tmp11   , Element  ___tmp9   , boolean  ret_val   , Continuation
                         ___k  ) {
        Element  ___pseudoThis ;
        ___ContinuationClasscontinuationMethod2
                ___k1 ;
        ___pseudoThis = this;
        ___k1 = new
                ___ContinuationClasscontinuationMethod2();
        ___k1.other = other;
        ___k1.
                ____writeable____other = ____writeable____other;
        ___k1.___tmp11 = ___tmp11;
        ___k1.ret_val = ret_val;
        ___k1.___k = ___k;
        ___k1.object = this;
        ___k1.
                call();
    }
    public void continuationMethod6 (Element  other , Element
                                     ____writeable____other   , Element  ___tmp11   , Element  ___tmp9   ,
                                     boolean  ret_val   , Continuation  ___k  ) {
        Element  ___pseudoThis ;
        ___ContinuationClasscontinuationMethod5  ___k1 ;
        ___pseudoThis = this;
        ___k1 = new ___ContinuationClasscontinuationMethod5();
        ___k1.other = other;
        ___k1.____writeable____other = ____writeable____other;
        ___k1.___tmp11 =
                ___tmp11;
        ___k1.___tmp9 = ___tmp9;
        ___k1.ret_val = ret_val;
        ___k1.___k =
                ___k;
        ___k1.object = this;
        ___k1.call();
    }
    public void continuationMethod8
    (Element  other , Element  ____writeable____other   , Element  ___tmp11   ,
     Element  ___tmp9   , boolean  ret_val   , Continuation  ___k  ) {
        Element
                ___pseudoThis ;
        ___ContinuationClasscontinuationMethod6  ___k2 ;
        ___pseudoThis = this;
        ___k2 = new ___ContinuationClasscontinuationMethod6()
                ;
        ___k2.other = other;
        ___k2.____writeable____other =
                ____writeable____other;
        ___k2.___tmp11 = ___tmp11;
        ___k2.___tmp9 = ___tmp9
                ;
        ___k2.ret_val = ret_val;
        ___k2.___k = ___k;
        ___k2.object = this;
        ___k2.
                call();
    }
    public void continuationMethod7 (Element  other , Element
                                     ____writeable____other   , Element  ___tmp11   , Element  ___tmp9   ,
                                     Continuation  ___k  ) {
        boolean  ret_val ;
        int  nt ;
        boolean  ___tmp4 ;
        Element  ___pseudoThis ;
        ___ContinuationClasscontinuationMethod8  ___k1 ;
        ___pseudoThis = this;
        ___tmp4 = ____writeable____other.
                ____1234GetMarried4321____;
        if ( ! ___tmp4 ) {
            ret_val = false;
            ___k1 = new
                    ___ContinuationClasscontinuationMethod8();
            ___k1.other = other;
            ___k1.
                    ____writeable____other = ____writeable____other;
            ___k1.___tmp11 = ___tmp11;
            ___k1.___tmp9 = ___tmp9;
            ___k1.ret_val = ret_val;
            ___k1.___k = ___k;
            ___k1.object = this;
            ___k1.call();
        }
        else {
            nt = 0;
            ___k1 = new
                    ___ContinuationClasscontinuationMethod8();
            ___k1.other = other;
            ___k1.
                    ____writeable____other = ____writeable____other;
            ___k1.___tmp11 = ___tmp11;
            ___k1.___tmp9 = ___tmp9;
            ___k1.ret_val = ret_val;
            ___k1.___k = ___k;
            ___k1.object = this;
            ___k1.call();
        }
    }
    public void continuationMethod10 (
        Element  other , Element  ____writeable____other   , Element  ___tmp11   ,
        Element  ___tmp9   , boolean  ret_val   , Continuation  ___k  ) {
        Element
                ___pseudoThis ;
        ___ContinuationClasscontinuationMethod6  ___k2 ;
        ___pseudoThis = this;
        ___k2 = new ___ContinuationClasscontinuationMethod6()
                ;
        ___k2.other = other;
        ___k2.____writeable____other =
                ____writeable____other;
        ___k2.___tmp11 = ___tmp11;
        ___k2.___tmp9 = ___tmp9
                ;
        ___k2.ret_val = ret_val;
        ___k2.___k = ___k;
        ___k2.object = this;
        ___k2.
                call();
    }
    public void continuationMethod9 (Element  other , Element
                                     ____writeable____other   , Element  ___tmp11   , Element  ___tmp9   ,
                                     Continuation  ___k  ) {
        boolean  ret_val ;
        int  nt ;
        boolean  ___tmp6 ;
        Element  ___pseudoThis ;
        ___ContinuationClasscontinuationMethod10  ___k1 ;
        ___pseudoThis = this;
        ___tmp6 = ____writeable____other.
                ____1234GetMarried4321____;
        if ( ___tmp6 ) {
            ret_val = false;
            ___k1 = new
                    ___ContinuationClasscontinuationMethod10();
            ___k1.other = other;
            ___k1.
                    ____writeable____other = ____writeable____other;
            ___k1.___tmp11 = ___tmp11;
            ___k1.___tmp9 = ___tmp9;
            ___k1.ret_val = ret_val;
            ___k1.___k = ___k;
            ___k1.object = this;
            ___k1.call();
        }
        else {
            nt = 0;
            ___k1 = new
                    ___ContinuationClasscontinuationMethod10();
            ___k1.other = other;
            ___k1.
                    ____writeable____other = ____writeable____other;
            ___k1.___tmp11 = ___tmp11;
            ___k1.___tmp9 = ___tmp9;
            ___k1.ret_val = ret_val;
            ___k1.___k = ___k;
            ___k1.object = this;
            ___k1.call();
        }
    }
    public void continuationMethod4 (
        Element  other , Element  ____writeable____other   , Element  ___tmp11   ,
        Element  ___tmp9   , Continuation  ___k  ) {
        boolean  ret_val ;
        boolean
                ___tmp8 ;
        Element  ___pseudoThis ;
        ___ContinuationClasscontinuationMethod5
                ___k1 ;
        ___ContinuationClasscontinuationMethod7  ___k3 ;
        ___ContinuationClasscontinuationMethod9  ___k4 ;
        ___pseudoThis = this;
        ___tmp8 = ___tmp9.____1234Compare4321____;
        if ( ! ___tmp8 ) {
            ret_val =
                    false;
            ___k1 = new ___ContinuationClasscontinuationMethod5();
            ___k1.other
                    = other;
            ___k1.____writeable____other = ____writeable____other;
            ___k1.
                    ___tmp11 = ___tmp11;
            ___k1.___tmp9 = ___tmp9;
            ___k1.ret_val = ret_val;
            ___k1.___k = ___k;
            ___k1.object = this;
            ___k1.call();
        }
        else {
            if (
                    Married ) {
                ____writeable____other = ____writeable____other;
                ___k3 = new
                        ___ContinuationClasscontinuationMethod7();
                ___k3.other = other;
                ___k3.
                        ____writeable____other = ____writeable____other;
                ___k3.___tmp11 = ___tmp11;
                ___k3.___tmp9 = ___tmp9;
                ___k3.___k = ___k;
                ___k3.object = this;
                ____writeable____other.GetMarried(___k3 );
            }
            else {
                ____writeable____other
                        = ____writeable____other;
                ___k4 = new
                        ___ContinuationClasscontinuationMethod9();
                ___k4.other = other;
                ___k4.
                        ____writeable____other = ____writeable____other;
                ___k4.___tmp11 = ___tmp11;
                ___k4.___tmp9 = ___tmp9;
                ___k4.___k = ___k;
                ___k4.object = this;
                ____writeable____other.GetMarried(___k4 );
            }
        }
    }
    public void
    continuationMethod3 (Element  other , Element  ____writeable____other   ,
                         Element  ___tmp11   , Continuation  ___k  ) {
        int  aux02 ;
        int  ___tmp2 ;
        Element  ___tmp9 ;
        Element  ___pseudoThis ;
        ___ContinuationClasscontinuationMethod4  ___k1 ;
        ___pseudoThis = this;
        ___tmp2 = ____writeable____other.____1234GetSalary4321____;
        aux02 = ___tmp2
                ;
        ___tmp9 = this;
        ___k1 = new ___ContinuationClasscontinuationMethod4();
        ___k1.other = other;
        ___k1.____writeable____other = ____writeable____other;
        ___k1.___tmp11 = ___tmp11;
        ___k1.___tmp9 = ___tmp9;
        ___k1.___k = ___k;
        ___k1.object = this;
        ___tmp9.Compare(aux02 , Salary , ___k1);
    }
    public void
    continuationMethod1 (Element  other , Element  ____writeable____other   ,
                         Element  ___tmp11   , Continuation  ___k  ) {
        boolean  ret_val ;
        boolean
                ___tmp10 ;
        Element  ___pseudoThis ;
        ___ContinuationClasscontinuationMethod2  ___k1 ;
        ___ContinuationClasscontinuationMethod3  ___k2 ;
        ___pseudoThis = this;
        ___tmp10 = ___tmp11.____1234Compare4321____;
        if ( ! ___tmp10 ) {
            ret_val =
                    false;
            ___k1 = new ___ContinuationClasscontinuationMethod2();
            ___k1.other
                    = other;
            ___k1.____writeable____other = ____writeable____other;
            ___k1.
                    ___tmp11 = ___tmp11;
            ___k1.ret_val = ret_val;
            ___k1.___k = ___k;
            ___k1.
                    object = this;
            ___k1.call();
        }
        else {
            ____writeable____other =
                    ____writeable____other;
            ___k2 = new ___ContinuationClasscontinuationMethod3
                    ();
            ___k2.other = other;
            ___k2.____writeable____other =
                    ____writeable____other;
            ___k2.___tmp11 = ___tmp11;
            ___k2.___k = ___k;
            ___k2.object = this;
            ____writeable____other.GetSalary(___k2 );
        }
    }
    public
    void continuationMethod0 (Element  other , Element  ____writeable____other
                              , Continuation  ___k  ) {
        int  aux01 ;
        int  ___tmp0 ;
        Element  ___tmp11 ;
        Element  ___pseudoThis ;
        ___ContinuationClasscontinuationMethod1  ___k1 ;
        ___pseudoThis = this;
        ___tmp0 = ____writeable____other.
                ____1234GetAge4321____;
        aux01 = ___tmp0;
        ___tmp11 = this;
        ___k1 = new
                ___ContinuationClasscontinuationMethod1();
        ___k1.other = other;
        ___k1.
                ____writeable____other = ____writeable____other;
        ___k1.___tmp11 = ___tmp11;
        ___k1.___k = ___k;
        ___k1.object = this;
        ___tmp11.Compare(aux01 , Age ,
                         ___k1);
    }
    public void continuationMethod11 (int  num1 , int  num2   ,
                                      boolean  retval   , Continuation  ___k  ) {
        Element  ___pseudoThis ;
        ___pseudoThis = this;
        ____1234Compare4321____ = retval;
        ___k.call();
    }
    public void continuationMethod12 (int  num1 , int  num2   , boolean  retval
                                      , Continuation  ___k  ) {
        Element  ___pseudoThis ;
        ___ContinuationClasscontinuationMethod11  ___k1 ;
        ___pseudoThis = this;
        ___k1 = new ___ContinuationClasscontinuationMethod11();
        ___k1.num1 = num1;
        ___k1.num2 = num2;
        ___k1.retval = retval;
        ___k1.___k = ___k;
        ___k1.object
                = this;
        ___k1.call();
    }
}
class List {
    Element  elem ;
    List  next ;
    boolean  end ;
    boolean
    ____1234Init4321____ ;
    boolean  ____1234InitNew4321____ ;
    List
    ____1234Insert4321____ ;
    boolean  ____1234SetNext4321____ ;
    List
    ____1234Delete4321____ ;
    int  ____1234Search4321____ ;
    boolean
    ____1234GetEnd4321____ ;
    Element  ____1234GetElem4321____ ;
    List
    ____1234GetNext4321____ ;
    boolean  ____1234Print4321____ ;
    public void
    Init (Continuation  ___k ) {
        List  ___pseudoThis ;
        ___pseudoThis = this;
        end = true;
        ____1234Init4321____ = true;
        ___k.call();
    }
    public void
    InitNew (Element  v_elem , List  v_next   , boolean  v_end   , Continuation
             ___k  ) {
        boolean  ____writeable____v_end ;
        List  ____writeable____v_next ;
        Element  ____writeable____v_elem ;
        List  ___pseudoThis ;
        ___pseudoThis =
                this;
        ____writeable____v_elem = v_elem;
        ____writeable____v_next = v_next;
        ____writeable____v_end = v_end;
        end = ____writeable____v_end;
        elem =
                ____writeable____v_elem;
        next = ____writeable____v_next;
        ____1234InitNew4321____ = true;
        ___k.call();
    }
    public void Insert (Element
                        new_elem , Continuation  ___k  ) {
        boolean  ret_val ;
        List  aux03 ;
        List
                aux02 ;
        Element  ____writeable____new_elem ;
        boolean  ___tmp13 ;
        List
                ___pseudoThis ;
        ___ContinuationClasscontinuationMethod13  ___k1 ;
        ___pseudoThis = this;
        ____writeable____new_elem = new_elem;
        aux03 = this;
        aux02 = new List();
        aux02 = aux02;
        ___k1 = new
                ___ContinuationClasscontinuationMethod13();
        ___k1.new_elem = new_elem;
        ___k1.aux02 = aux02;
        ___k1.___k = ___k;
        ___k1.object = this;
        aux02.InitNew
                (____writeable____new_elem , aux03 , false , ___k1);
    }
    public void SetNext
    (List  v_next , Continuation  ___k  ) {
        List  ____writeable____v_next ;
        List  ___pseudoThis ;
        ___pseudoThis = this;
        ____writeable____v_next =
                v_next;
        next = ____writeable____v_next;
        ____1234SetNext4321____ = true;
        ___k.call();
    }
    public void Delete (Element  e , Continuation  ___k  ) {
        List  my_head ;
        boolean  ret_val ;
        boolean  aux05 ;
        List  aux01 ;
        List
                prev ;
        boolean  var_end ;
        Element  var_elem ;
        int  aux04 ;
        int  nt ;
        Element  ____writeable____e ;
        boolean  ____tmp15 ;
        boolean  ____tmp16 ;
        List  ___tmp17 ;
        boolean  ___tmp19 ;
        List  ___tmp21 ;
        boolean  ___tmp23 ;
        List  ___tmp25 ;
        boolean  ___tmp27 ;
        Element  ___tmp29 ;
        List
                ___pseudoThis ;
        ___ContinuationClasscontinuationMethod14  ___k1 ;
        ___pseudoThis = this;
        ____writeable____e = e;
        my_head = this;
        ret_val =
                false;
        aux04 = 0 - 1;
        aux01 = this;
        prev = this;
        var_end = end;
        var_elem = elem;
        ____tmp15 = ! var_end;
        ____tmp16 = ! ret_val;
        ___k1 =
                new ___ContinuationClasscontinuationMethod14();
        ___k1.e = e;
        ___k1.my_head
                = my_head;
        ___k1.___k = ___k;
        ___k1.object = this;
        ___pseudoThis.
                whileMethod1(e , aux01 , prev , var_elem , aux04 , ____writeable____e ,
                             ____tmp15 , ____tmp16 , ___k1);
    }
    public void Search (Element  e ,
                        Continuation  ___k  ) {
        int  int_ret_val ;
        List  aux01 ;
        Element  var_elem
                ;
        boolean  var_end ;
        int  nt ;
        Element  ____writeable____e ;
        boolean
                ___tmp31 ;
        List  ___tmp33 ;
        boolean  ___tmp35 ;
        Element  ___tmp37 ;
        List
                ___pseudoThis ;
        ___ContinuationClasscontinuationMethod25  ___k1 ;
        ___pseudoThis = this;
        ____writeable____e = e;
        int_ret_val = 0;
        aux01 =
                this;
        var_end = end;
        var_elem = elem;
        ___k1 = new
                ___ContinuationClasscontinuationMethod25();
        ___k1.e = e;
        ___k1.int_ret_val
                = int_ret_val;
        ___k1.___k = ___k;
        ___k1.object = this;
        ___pseudoThis.
                whileMethod2(e , aux01 , var_elem , var_end , ____writeable____e , ___k1);
    }
    public void GetEnd (Continuation  ___k ) {
        List  ___pseudoThis ;
        ___pseudoThis = this;
        ____1234GetEnd4321____ = end;
        ___k.call();
    }
    public
    void GetElem (Continuation  ___k ) {
        List  ___pseudoThis ;
        ___pseudoThis =
                this;
        ____1234GetElem4321____ = elem;
        ___k.call();
    }
    public void GetNext (
        Continuation  ___k ) {
        List  ___pseudoThis ;
        ___pseudoThis = this;
        ____1234GetNext4321____ = next;
        ___k.call();
    }
    public void Print (
        Continuation  ___k ) {
        List  aux01 ;
        boolean  var_end ;
        Element  var_elem
                ;
        int  ___tmp39 ;
        List  ___tmp41 ;
        boolean  ___tmp43 ;
        Element  ___tmp45
                ;
        List  ___pseudoThis ;
        ___ContinuationClasscontinuationMethod31  ___k1 ;
        ___pseudoThis = this;
        aux01 = this;
        var_end = end;
        var_elem = elem;
        ___k1 = new ___ContinuationClasscontinuationMethod31();
        ___k1.___k = ___k;
        ___k1.object = this;
        ___pseudoThis.whileMethod3(aux01 , var_end , var_elem ,
                                   ___k1);
    }
    public void continuationMethod13 (Element  new_elem , List  aux02
                                      , Continuation  ___k  ) {
        boolean  ret_val ;
        boolean  ___tmp13 ;
        List
                ___pseudoThis ;
        ___pseudoThis = this;
        ___tmp13 = aux02.
                ____1234InitNew4321____;
        ret_val = ___tmp13;
        ____1234Insert4321____ =
                aux02;
        ___k.call();
    }
    public void continuationMethod14 (Element  e , List
                                      my_head   , Continuation  ___k  ) {
        List  ___pseudoThis ;
        ___pseudoThis =
                this;
        ____1234Delete4321____ = my_head;
        ___k.call();
    }
    public void
    continuationMethod17 (Element  e , List  aux01   , List  prev   , Element
                          var_elem   , int  aux04   , Element  ____writeable____e   , boolean
                          ____tmp15   , boolean  ____tmp16   , boolean  ret_val   , boolean  var_end
                          , Continuation  ___k  ) {
        List  ___pseudoThis ;
        ___pseudoThis = this;
        ____tmp15 = ! var_end;
        ____tmp16 = ! ret_val;
        ___pseudoThis.whileMethod1(e
                                   , aux01 , prev , var_elem , aux04 , ____writeable____e , ____tmp15 ,
                                   ____tmp16 , ___k);
    }
    public void continuationMethod20 (Element  e , List
                                      aux01   , List  prev   , Element  var_elem   , int  aux04   , Element
                                      ____writeable____e   , boolean  ____tmp15   , boolean  ____tmp16   , boolean
                                      ret_val   , boolean  var_end   , Continuation  ___k  ) {
        Element  ___tmp29 ;
        List  ___pseudoThis ;
        ___ContinuationClasscontinuationMethod17  ___k1 ;
        ___pseudoThis = this;
        ___tmp29 = aux01.____1234GetElem4321____;
        var_elem =
                ___tmp29;
        aux04 = 1;
        ___k1 = new ___ContinuationClasscontinuationMethod17(
   );
        ___k1.e = e;
        ___k1.aux01 = aux01;
        ___k1.prev = prev;
        ___k1.var_elem =
                var_elem;
        ___k1.aux04 = aux04;
        ___k1.____writeable____e =
                ____writeable____e;
        ___k1.____tmp15 = ____tmp15;
        ___k1.____tmp16 =
                ____tmp16;
        ___k1.ret_val = ret_val;
        ___k1.var_end = var_end;
        ___k1.___k =
                ___k;
        ___k1.object = this;
        ___k1.call();
    }
    public void
    continuationMethod19 (Element  e , List  aux01   , List  prev   , Element
                          var_elem   , int  aux04   , Element  ____writeable____e   , boolean
                          ____tmp15   , boolean  ____tmp16   , boolean  ret_val   , Continuation  ___k
                          ) {
        boolean  var_end ;
        boolean  ___tmp27 ;
        List  ___pseudoThis ;
        ___ContinuationClasscontinuationMethod20  ___k1 ;
        ___pseudoThis = this;
        ___tmp27 = aux01.____1234GetEnd4321____;
        var_end = ___tmp27;
        aux01 = aux01
                ;
        ___k1 = new ___ContinuationClasscontinuationMethod20();
        ___k1.e = e;
        ___k1.aux01 = aux01;
        ___k1.prev = prev;
        ___k1.var_elem = var_elem;
        ___k1.
                aux04 = aux04;
        ___k1.____writeable____e = ____writeable____e;
        ___k1.
                ____tmp15 = ____tmp15;
        ___k1.____tmp16 = ____tmp16;
        ___k1.ret_val =
                ret_val;
        ___k1.var_end = var_end;
        ___k1.___k = ___k;
        ___k1.object = this;
        aux01.GetElem(___k1 );
    }
    public void continuationMethod18 (Element  e ,
                                      List  aux01   , List  prev   , Element  var_elem   , int  aux04   , Element
                                      ____writeable____e   , boolean  ____tmp15   , boolean  ____tmp16   , boolean
                                      ret_val   , Continuation  ___k  ) {
        List  ___tmp25 ;
        List  ___pseudoThis ;
        ___ContinuationClasscontinuationMethod19  ___k1 ;
        ___pseudoThis = this;
        ___tmp25 = aux01.____1234GetNext4321____;
        aux01 = ___tmp25;
        aux01 = aux01;
        ___k1 = new ___ContinuationClasscontinuationMethod19();
        ___k1.e = e;
        ___k1
                .aux01 = aux01;
        ___k1.prev = prev;
        ___k1.var_elem = var_elem;
        ___k1.aux04
                = aux04;
        ___k1.____writeable____e = ____writeable____e;
        ___k1.____tmp15 =
                ____tmp15;
        ___k1.____tmp16 = ____tmp16;
        ___k1.ret_val = ret_val;
        ___k1.
                ___k = ___k;
        ___k1.object = this;
        aux01.GetEnd(___k1 );
    }
    public void
    continuationMethod16 (Element  e , List  aux01   , List  prev   , Element
                          var_elem   , int  aux04   , Element  ____writeable____e   , boolean
                          ____tmp15   , boolean  ____tmp16   , boolean  ret_val   , Continuation  ___k
                          ) {
        int  nt ;
        List  ___pseudoThis ;
        ___ContinuationClasscontinuationMethod17  ___k1 ;
        ___ContinuationClasscontinuationMethod18  ___k2 ;
        ___pseudoThis = this;
        if (
                ! ret_val ) {
            prev = aux01;
            aux01 = aux01;
            ___k2 = new
                    ___ContinuationClasscontinuationMethod18();
            ___k2.e = e;
            ___k2.aux01 =
                    aux01;
            ___k2.prev = prev;
            ___k2.var_elem = var_elem;
            ___k2.aux04 = aux04;
            ___k2.____writeable____e = ____writeable____e;
            ___k2.____tmp15 = ____tmp15;
            ___k2.____tmp16 = ____tmp16;
            ___k2.ret_val = ret_val;
            ___k2.___k = ___k;
            ___k2.object = this;
            aux01.GetNext(___k2 );
        }
        else {
            nt = 0;
            ___k1 = new
                    ___ContinuationClasscontinuationMethod17();
            ___k1.e = e;
            ___k1.aux01 =
                    aux01;
            ___k1.prev = prev;
            ___k1.var_elem = var_elem;
            ___k1.aux04 = aux04;
            ___k1.____writeable____e = ____writeable____e;
            ___k1.____tmp15 = ____tmp15;
            ___k1.____tmp16 = ____tmp16;
            ___k1.ret_val = ret_val;
            ___k1.var_end =
                    var_end;
            ___k1.___k = ___k;
            ___k1.object = this;
            ___k1.call();
        }
    }
    public void continuationMethod21 (Element  e , List  aux01   , List  prev
                                      , Element  var_elem   , int  aux04   , Element  ____writeable____e   ,
                                      boolean  ____tmp15   , boolean  ____tmp16   , boolean  ret_val   ,
                                      Continuation  ___k  ) {
        List  ___pseudoThis ;
        ___ContinuationClasscontinuationMethod16  ___k1 ;
        ___pseudoThis = this;
        ___k1 = new ___ContinuationClasscontinuationMethod16();
        ___k1.e = e;
        ___k1
                .aux01 = aux01;
        ___k1.prev = prev;
        ___k1.var_elem = var_elem;
        ___k1.aux04
                = aux04;
        ___k1.____writeable____e = ____writeable____e;
        ___k1.____tmp15 =
                ____tmp15;
        ___k1.____tmp16 = ____tmp16;
        ___k1.ret_val = ret_val;
        ___k1.
                ___k = ___k;
        ___k1.object = this;
        ___k1.call();
    }
    public void
    continuationMethod22 (Element  e , List  aux01   , List  prev   , Element
                          var_elem   , int  aux04   , Element  ____writeable____e   , boolean
                          ____tmp15   , boolean  ____tmp16   , boolean  ret_val   , Continuation  ___k
                          ) {
        List  my_head ;
        List  ___tmp17 ;
        List  ___pseudoThis ;
        ___ContinuationClasscontinuationMethod21  ___k2 ;
        ___pseudoThis = this;
        ___tmp17 = aux01.____1234GetNext4321____;
        my_head = ___tmp17;
        ___k2 = new
                ___ContinuationClasscontinuationMethod21();
        ___k2.e = e;
        ___k2.aux01 =
                aux01;
        ___k2.prev = prev;
        ___k2.var_elem = var_elem;
        ___k2.aux04 = aux04;
        ___k2.____writeable____e = ____writeable____e;
        ___k2.____tmp15 = ____tmp15;
        ___k2.____tmp16 = ____tmp16;
        ___k2.ret_val = ret_val;
        ___k2.___k = ___k;
        ___k2.object = this;
        ___k2.call();
    }
    public void continuationMethod24 (
        Element  e , List  aux01   , List  prev   , Element  var_elem   , int  aux04
        , Element  ____writeable____e   , boolean  ____tmp15   , boolean  ____tmp16
        , boolean  ret_val   , Continuation  ___k  ) {
        boolean  aux05 ;
        boolean
                ___tmp19 ;
        List  ___pseudoThis ;
        ___ContinuationClasscontinuationMethod21
                ___k2 ;
        ___pseudoThis = this;
        ___tmp19 = prev.____1234SetNext4321____;
        aux05 = ___tmp19;
        System.out.println ( 0 - 555 ) ;
        ___k2 = new
                ___ContinuationClasscontinuationMethod21();
        ___k2.e = e;
        ___k2.aux01 =
                aux01;
        ___k2.prev = prev;
        ___k2.var_elem = var_elem;
        ___k2.aux04 = aux04;
        ___k2.____writeable____e = ____writeable____e;
        ___k2.____tmp15 = ____tmp15;
        ___k2.____tmp16 = ____tmp16;
        ___k2.ret_val = ret_val;
        ___k2.___k = ___k;
        ___k2.object = this;
        ___k2.call();
    }
    public void continuationMethod23 (
        Element  e , List  aux01   , List  prev   , Element  var_elem   , int  aux04
        , Element  ____writeable____e   , boolean  ____tmp15   , boolean  ____tmp16
        , boolean  ret_val   , Continuation  ___k  ) {
        List  ___tmp21 ;
        List
                ___pseudoThis ;
        ___ContinuationClasscontinuationMethod24  ___k1 ;
        ___pseudoThis = this;
        ___tmp21 = aux01.____1234GetNext4321____;
        ___k1 =
                new ___ContinuationClasscontinuationMethod24();
        ___k1.e = e;
        ___k1.aux01 =
                aux01;
        ___k1.prev = prev;
        ___k1.var_elem = var_elem;
        ___k1.aux04 = aux04;
        ___k1.____writeable____e = ____writeable____e;
        ___k1.____tmp15 = ____tmp15;
        ___k1.____tmp16 = ____tmp16;
        ___k1.ret_val = ret_val;
        ___k1.___k = ___k;
        ___k1.object = this;
        prev.SetNext(___tmp21 , ___k1);
    }
    public void
    continuationMethod15 (Element  e , List  aux01   , List  prev   , Element
                          var_elem   , int  aux04   , Element  ____writeable____e   , boolean
                          ____tmp15   , boolean  ____tmp16   , Continuation  ___k  ) {
        boolean
                ret_val ;
        int  nt ;
        boolean  ___tmp23 ;
        List  ___pseudoThis ;
        ___ContinuationClasscontinuationMethod16  ___k1 ;
        ___ContinuationClasscontinuationMethod22  ___k3 ;
        ___ContinuationClasscontinuationMethod23  ___k4 ;
        ___pseudoThis = this;
        ___tmp23 = ____writeable____e.____1234Equal4321____;
        if ( ___tmp23 ) {
            ret_val = true;
            if ( aux04 < 0 ) {
                aux01 = aux01;
                ___k3 = new
                        ___ContinuationClasscontinuationMethod22();
                ___k3.e = e;
                ___k3.aux01 =
                        aux01;
                ___k3.prev = prev;
                ___k3.var_elem = var_elem;
                ___k3.aux04 = aux04;
                ___k3.____writeable____e = ____writeable____e;
                ___k3.____tmp15 = ____tmp15;
                ___k3.____tmp16 = ____tmp16;
                ___k3.ret_val = ret_val;
                ___k3.___k = ___k;
                ___k3.object = this;
                aux01.GetNext(___k3 );
            }
            else {
                System.out.println ( 0
                                     - 555 ) ;
                prev = prev;
                aux01 = aux01;
                ___k4 = new
                        ___ContinuationClasscontinuationMethod23();
                ___k4.e = e;
                ___k4.aux01 =
                        aux01;
                ___k4.prev = prev;
                ___k4.var_elem = var_elem;
                ___k4.aux04 = aux04;
                ___k4.____writeable____e = ____writeable____e;
                ___k4.____tmp15 = ____tmp15;
                ___k4.____tmp16 = ____tmp16;
                ___k4.ret_val = ret_val;
                ___k4.___k = ___k;
                ___k4.object = this;
                aux01.GetNext(___k4 );
            }
        }
        else {
            nt = 0;
            ___k1 =
                    new ___ContinuationClasscontinuationMethod16();
            ___k1.e = e;
            ___k1.aux01 =
                    aux01;
            ___k1.prev = prev;
            ___k1.var_elem = var_elem;
            ___k1.aux04 = aux04;
            ___k1.____writeable____e = ____writeable____e;
            ___k1.____tmp15 = ____tmp15;
            ___k1.____tmp16 = ____tmp16;
            ___k1.ret_val = ret_val;
            ___k1.___k = ___k;
            ___k1.object = this;
            ___k1.call();
        }
    }
    public void whileMethod1 (Element
                              e , List  aux01   , List  prev   , Element  var_elem   , int  aux04   ,
                              Element  ____writeable____e   , boolean  ____tmp15   , boolean  ____tmp16
                              , Continuation  ___k  ) {
        List  my_head ;
        boolean  ret_val ;
        boolean
                aux05 ;
        boolean  var_end ;
        int  nt ;
        List  ___tmp17 ;
        boolean  ___tmp19
                ;
        List  ___tmp21 ;
        boolean  ___tmp23 ;
        List  ___tmp25 ;
        boolean
                ___tmp27 ;
        Element  ___tmp29 ;
        List  ___pseudoThis ;
        ___ContinuationClasscontinuationMethod15  ___k1 ;
        ___pseudoThis = this;
        if (
                ____tmp15 & ____tmp16  ) {
            ____writeable____e = ____writeable____e;
            ___k1 =
                    new ___ContinuationClasscontinuationMethod15();
            ___k1.e = e;
            ___k1.aux01 =
                    aux01;
            ___k1.prev = prev;
            ___k1.var_elem = var_elem;
            ___k1.aux04 = aux04;
            ___k1.____writeable____e = ____writeable____e;
            ___k1.____tmp15 = ____tmp15;
            ___k1.____tmp16 = ____tmp16;
            ___k1.___k = ___k;
            ___k1.object = this;
            ____writeable____e.Equal(var_elem , ___k1);
        }
        else {
            ___k.call();
        }
    }
    public void continuationMethod25 (Element  e , int  int_ret_val   ,
                                      Continuation  ___k  ) {
        List  ___pseudoThis ;
        ___pseudoThis = this;
        ____1234Search4321____ = int_ret_val;
        ___k.call();
    }
    public void
    continuationMethod30 (Element  e , List  aux01   , Element  var_elem   ,
                          boolean  var_end   , Element  ____writeable____e   , Continuation  ___k  ) {
        Element  ___tmp37 ;
        List  ___pseudoThis ;
        ___pseudoThis = this;
        ___tmp37 =
                aux01.____1234GetElem4321____;
        var_elem = ___tmp37;
        ___pseudoThis.
                whileMethod2(e , aux01 , var_elem , var_end , ____writeable____e , ___k);
    }
    public void continuationMethod29 (Element  e , List  aux01   , Element
                                      var_elem   , boolean  var_end   , Element  ____writeable____e   ,
                                      Continuation  ___k  ) {
        boolean  ___tmp35 ;
        List  ___pseudoThis ;
        ___ContinuationClasscontinuationMethod30  ___k1 ;
        ___pseudoThis = this;
        ___tmp35 = aux01.____1234GetEnd4321____;
        var_end = ___tmp35;
        aux01 = aux01
                ;
        ___k1 = new ___ContinuationClasscontinuationMethod30();
        ___k1.e = e;
        ___k1.aux01 = aux01;
        ___k1.var_elem = var_elem;
        ___k1.var_end = var_end;
        ___k1.____writeable____e = ____writeable____e;
        ___k1.___k = ___k;
        ___k1.
                object = this;
        aux01.GetElem(___k1 );
    }
    public void continuationMethod28 (
        Element  e , List  aux01   , Element  var_elem   , boolean  var_end   ,
        Element  ____writeable____e   , Continuation  ___k  ) {
        List  ___tmp33 ;
        List  ___pseudoThis ;
        ___ContinuationClasscontinuationMethod29  ___k1 ;
        ___pseudoThis = this;
        ___tmp33 = aux01.____1234GetNext4321____;
        aux01 =
                ___tmp33;
        aux01 = aux01;
        ___k1 = new
                ___ContinuationClasscontinuationMethod29();
        ___k1.e = e;
        ___k1.aux01 =
                aux01;
        ___k1.var_elem = var_elem;
        ___k1.var_end = var_end;
        ___k1.
                ____writeable____e = ____writeable____e;
        ___k1.___k = ___k;
        ___k1.object =
                this;
        aux01.GetEnd(___k1 );
    }
    public void continuationMethod27 (Element  e
                                      , List  aux01   , Element  var_elem   , boolean  var_end   , Element
                                      ____writeable____e   , Continuation  ___k  ) {
        List  ___pseudoThis ;
        ___ContinuationClasscontinuationMethod28  ___k1 ;
        ___pseudoThis = this;
        aux01 = aux01;
        ___k1 = new ___ContinuationClasscontinuationMethod28();
        ___k1.e = e;
        ___k1.aux01 = aux01;
        ___k1.var_elem = var_elem;
        ___k1.
                var_end = var_end;
        ___k1.____writeable____e = ____writeable____e;
        ___k1.
                ___k = ___k;
        ___k1.object = this;
        aux01.GetNext(___k1 );
    }
    public void
    continuationMethod26 (Element  e , List  aux01   , Element  var_elem   ,
                          boolean  var_end   , Element  ____writeable____e   , Continuation  ___k  ) {
        int  int_ret_val ;
        int  nt ;
        boolean  ___tmp31 ;
        List  ___pseudoThis ;
        ___ContinuationClasscontinuationMethod27  ___k1 ;
        ___pseudoThis = this;
        ___tmp31 = ____writeable____e.____1234Equal4321____;
        if ( ___tmp31 ) {
            int_ret_val = 1;
            ___k1 = new ___ContinuationClasscontinuationMethod27();
            ___k1.e = e;
            ___k1.aux01 = aux01;
            ___k1.var_elem = var_elem;
            ___k1.
                    var_end = var_end;
            ___k1.____writeable____e = ____writeable____e;
            ___k1.
                    ___k = ___k;
            ___k1.object = this;
            ___k1.call();
        }
        else {
            nt = 0;
            ___k1 =
                    new ___ContinuationClasscontinuationMethod27();
            ___k1.e = e;
            ___k1.aux01 =
                    aux01;
            ___k1.var_elem = var_elem;
            ___k1.var_end = var_end;
            ___k1.
                    ____writeable____e = ____writeable____e;
            ___k1.___k = ___k;
            ___k1.object =
                    this;
            ___k1.call();
        }
    }
    public void whileMethod2 (Element  e , List  aux01
                              , Element  var_elem   , boolean  var_end   , Element  ____writeable____e   ,
                              Continuation  ___k  ) {
        int  int_ret_val ;
        int  nt ;
        boolean  ___tmp31 ;
        List  ___tmp33 ;
        boolean  ___tmp35 ;
        Element  ___tmp37 ;
        List
                ___pseudoThis ;
        ___ContinuationClasscontinuationMethod26  ___k1 ;
        ___pseudoThis = this;
        if ( ! var_end ) {
            ____writeable____e =
                    ____writeable____e;
            ___k1 = new ___ContinuationClasscontinuationMethod26();
            ___k1.e = e;
            ___k1.aux01 = aux01;
            ___k1.var_elem = var_elem;
            ___k1.
                    var_end = var_end;
            ___k1.____writeable____e = ____writeable____e;
            ___k1.
                    ___k = ___k;
            ___k1.object = this;
            ____writeable____e.Equal(var_elem , ___k1
                                     );
        }
        else {
            ___k.call();
        }
    }
    public void continuationMethod31 (
        Continuation  ___k ) {
        List  ___pseudoThis ;
        ___pseudoThis = this;
        ____1234Print4321____ = true;
        ___k.call();
    }
    public void
    continuationMethod35 (List  aux01 , boolean  var_end   , Element  var_elem
                          , Continuation  ___k  ) {
        Element  ___tmp45 ;
        List  ___pseudoThis ;
        ___pseudoThis = this;
        ___tmp45 = aux01.____1234GetElem4321____;
        var_elem =
                ___tmp45;
        ___pseudoThis.whileMethod3(aux01 , var_end , var_elem , ___k);
    }
    public void continuationMethod34 (List  aux01 , boolean  var_end   , Element
                                      var_elem   , Continuation  ___k  ) {
        boolean  ___tmp43 ;
        List
                ___pseudoThis ;
        ___ContinuationClasscontinuationMethod35  ___k1 ;
        ___pseudoThis = this;
        ___tmp43 = aux01.____1234GetEnd4321____;
        var_end =
                ___tmp43;
        aux01 = aux01;
        ___k1 = new
                ___ContinuationClasscontinuationMethod35();
        ___k1.aux01 = aux01;
        ___k1.
                var_end = var_end;
        ___k1.var_elem = var_elem;
        ___k1.___k = ___k;
        ___k1.
                object = this;
        aux01.GetElem(___k1 );
    }
    public void continuationMethod33 (
        List  aux01 , boolean  var_end   , Element  var_elem   , Continuation  ___k
                                      ) {
        List  ___tmp41 ;
        List  ___pseudoThis ;
        ___ContinuationClasscontinuationMethod34  ___k1 ;
        ___pseudoThis = this;
        ___tmp41 = aux01.____1234GetNext4321____;
        aux01 = ___tmp41;
        aux01 = aux01;
        ___k1 = new ___ContinuationClasscontinuationMethod34();
        ___k1.aux01 = aux01
                ;
        ___k1.var_end = var_end;
        ___k1.var_elem = var_elem;
        ___k1.___k = ___k;
        ___k1.object = this;
        aux01.GetEnd(___k1 );
    }
    public void
    continuationMethod32 (List  aux01 , boolean  var_end   , Element  var_elem
                          , Continuation  ___k  ) {
        int  ___tmp39 ;
        List  ___pseudoThis ;
        ___ContinuationClasscontinuationMethod33  ___k1 ;
        ___pseudoThis = this;
        ___tmp39 = var_elem.____1234GetAge4321____;
        System.out.println ( ___tmp39 )
                ;
        aux01 = aux01;
        ___k1 = new ___ContinuationClasscontinuationMethod33();
        ___k1.aux01 = aux01;
        ___k1.var_end = var_end;
        ___k1.var_elem = var_elem;
        ___k1.___k = ___k;
        ___k1.object = this;
        aux01.GetNext(___k1 );
    }
    public
    void whileMethod3 (List  aux01 , boolean  var_end   , Element  var_elem   ,
                       Continuation  ___k  ) {
        int  ___tmp39 ;
        List  ___tmp41 ;
        boolean  ___tmp43
                ;
        Element  ___tmp45 ;
        List  ___pseudoThis ;
        ___ContinuationClasscontinuationMethod32  ___k1 ;
        ___pseudoThis = this;
        if (
                ! var_end ) {
            var_elem = var_elem;
            ___k1 = new
                    ___ContinuationClasscontinuationMethod32();
            ___k1.aux01 = aux01;
            ___k1.
                    var_end = var_end;
            ___k1.var_elem = var_elem;
            ___k1.___k = ___k;
            ___k1.
                    object = this;
            var_elem.GetAge(___k1 );
        }
        else {
            ___k.call();
        }
    }
}
class LL {
    int  ____1234Start4321____ ;
    public void Start (Continuation  ___k )
    {
        List  head ;
        List  last_elem ;
        boolean  aux01 ;
        Element  el01 ;
        Element  el02 ;
        Element  el03 ;
        boolean  ___tmp47 ;
        boolean  ___tmp49 ;
        boolean  ___tmp51 ;
        boolean  ___tmp53 ;
        List  ___tmp55 ;
        boolean
                ___tmp57 ;
        boolean  ___tmp59 ;
        List  ___tmp61 ;
        boolean  ___tmp63 ;
        boolean  ___tmp65 ;
        List  ___tmp67 ;
        boolean  ___tmp69 ;
        boolean
                ___tmp71 ;
        int  ___tmp73 ;
        int  ___tmp75 ;
        boolean  ___tmp77 ;
        List
                ___tmp79 ;
        boolean  ___tmp81 ;
        List  ___tmp83 ;
        boolean  ___tmp85 ;
        List
                ___tmp87 ;
        boolean  ___tmp89 ;
        LL  ___pseudoThis ;
        ___ContinuationClasscontinuationMethod36  ___k1 ;
        ___pseudoThis = this;
        last_elem = new List();
        last_elem = last_elem;
        ___k1 = new
                ___ContinuationClasscontinuationMethod36();
        ___k1.last_elem = last_elem;
        ___k1.___k = ___k;
        ___k1.object = this;
        last_elem.Init(___k1 );
    }
    public
    void continuationMethod57 (List  last_elem , List  head   , Element  el01
                               , Element  el02   , Element  el03   , Continuation  ___k  ) {
        boolean  aux01
                ;
        boolean  ___tmp89 ;
        LL  ___pseudoThis ;
        ___pseudoThis = this;
        ___tmp89
                = head.____1234Print4321____;
        aux01 = ___tmp89;
        System.out.println (
            44440000 ) ;
        ____1234Start4321____ = 0;
        ___k.call();
    }
    public void
    continuationMethod56 (List  last_elem , List  head   , Element  el01   ,
                          Element  el02   , Element  el03   , Continuation  ___k  ) {
        List  ___tmp87 ;
        LL  ___pseudoThis ;
        ___ContinuationClasscontinuationMethod57  ___k1 ;
        ___pseudoThis = this;
        ___tmp87 = head.____1234Delete4321____;
        head =
                ___tmp87;
        head = head;
        ___k1 = new
                ___ContinuationClasscontinuationMethod57();
        ___k1.last_elem = last_elem;
        ___k1.head = head;
        ___k1.el01 = el01;
        ___k1.el02 = el02;
        ___k1.el03 =
                el03;
        ___k1.___k = ___k;
        ___k1.object = this;
        head.Print(___k1 );
    }
    public void continuationMethod55 (List  last_elem , List  head   , Element
                                      el01   , Element  el02   , Element  el03   , Continuation  ___k  ) {
        boolean
                aux01 ;
        boolean  ___tmp85 ;
        LL  ___pseudoThis ;
        ___ContinuationClasscontinuationMethod56  ___k1 ;
        ___pseudoThis = this;
        ___tmp85 = head.____1234Print4321____;
        aux01 = ___tmp85;
        System.out.println ( 33300000 ) ;
        head = head;
        ___k1 = new
                ___ContinuationClasscontinuationMethod56();
        ___k1.last_elem = last_elem;
        ___k1.head = head;
        ___k1.el01 = el01;
        ___k1.el02 = el02;
        ___k1.el03 =
                el03;
        ___k1.___k = ___k;
        ___k1.object = this;
        head.Delete(el01 , ___k1);
    }
    public void continuationMethod54 (List  last_elem , List  head   , Element
                                      el01   , Element  el02   , Element  el03   , Continuation  ___k  ) {
        List
                ___tmp83 ;
        LL  ___pseudoThis ;
        ___ContinuationClasscontinuationMethod55
                ___k1 ;
        ___pseudoThis = this;
        ___tmp83 = head.____1234Delete4321____;
        head
                = ___tmp83;
        head = head;
        ___k1 = new
                ___ContinuationClasscontinuationMethod55();
        ___k1.last_elem = last_elem;
        ___k1.head = head;
        ___k1.el01 = el01;
        ___k1.el02 = el02;
        ___k1.el03 =
                el03;
        ___k1.___k = ___k;
        ___k1.object = this;
        head.Print(___k1 );
    }
    public void continuationMethod53 (List  last_elem , List  head   , Element
                                      el01   , Element  el02   , Element  el03   , Continuation  ___k  ) {
        boolean
                aux01 ;
        boolean  ___tmp81 ;
        LL  ___pseudoThis ;
        ___ContinuationClasscontinuationMethod54  ___k1 ;
        ___pseudoThis = this;
        ___tmp81 = head.____1234Print4321____;
        aux01 = ___tmp81;
        System.out.println ( 2220000 ) ;
        head = head;
        ___k1 = new
                ___ContinuationClasscontinuationMethod54();
        ___k1.last_elem = last_elem;
        ___k1.head = head;
        ___k1.el01 = el01;
        ___k1.el02 = el02;
        ___k1.el03 =
                el03;
        ___k1.___k = ___k;
        ___k1.object = this;
        head.Delete(el02 , ___k1);
    }
    public void continuationMethod52 (List  last_elem , List  head   , Element
                                      el01   , Element  el02   , Element  el03   , Continuation  ___k  ) {
        List
                ___tmp79 ;
        LL  ___pseudoThis ;
        ___ContinuationClasscontinuationMethod53
                ___k1 ;
        ___pseudoThis = this;
        ___tmp79 = head.____1234Insert4321____;
        head
                = ___tmp79;
        head = head;
        ___k1 = new
                ___ContinuationClasscontinuationMethod53();
        ___k1.last_elem = last_elem;
        ___k1.head = head;
        ___k1.el01 = el01;
        ___k1.el02 = el02;
        ___k1.el03 =
                el03;
        ___k1.___k = ___k;
        ___k1.object = this;
        head.Print(___k1 );
    }
    public void continuationMethod51 (List  last_elem , List  head   , Element
                                      el01   , Element  el02   , Element  el03   , Continuation  ___k  ) {
        boolean
                aux01 ;
        boolean  ___tmp77 ;
        LL  ___pseudoThis ;
        ___ContinuationClasscontinuationMethod52  ___k1 ;
        ___pseudoThis = this;
        ___tmp77 = el01.____1234Init4321____;
        aux01 = ___tmp77;
        head = head;
        ___k1 = new ___ContinuationClasscontinuationMethod52();
        ___k1.last_elem =
                last_elem;
        ___k1.head = head;
        ___k1.el01 = el01;
        ___k1.el02 = el02;
        ___k1.el03 = el03;
        ___k1.___k = ___k;
        ___k1.object = this;
        head.Insert(
            el01 , ___k1);
    }
    public void continuationMethod50 (List  last_elem , List
                                      head   , Element  el01   , Element  el02   , Element  el03   , Continuation
                                      ___k  ) {
        int  ___tmp75 ;
        LL  ___pseudoThis ;
        ___ContinuationClasscontinuationMethod51  ___k1 ;
        ___pseudoThis = this;
        ___tmp75 = head.____1234Search4321____;
        System.out.println ( ___tmp75 ) ;
        System.out.println ( 10000000 ) ;
        el01 = new Element();
        el01 = el01;
        ___k1 = new ___ContinuationClasscontinuationMethod51();
        ___k1.last_elem =
                last_elem;
        ___k1.head = head;
        ___k1.el01 = el01;
        ___k1.el02 = el02;
        ___k1.el03 = el03;
        ___k1.___k = ___k;
        ___k1.object = this;
        el01.Init(28 ,
                  35000 , false , ___k1);
    }
    public void continuationMethod49 (List  last_elem
                                      , List  head   , Element  el01   , Element  el02   , Element  el03   ,
                                      Continuation  ___k  ) {
        int  ___tmp73 ;
        LL  ___pseudoThis ;
        ___ContinuationClasscontinuationMethod50  ___k1 ;
        ___pseudoThis = this;
        ___tmp73 = head.____1234Search4321____;
        System.out.println ( ___tmp73 ) ;
        head = head;
        ___k1 = new ___ContinuationClasscontinuationMethod50();
        ___k1
                .last_elem = last_elem;
        ___k1.head = head;
        ___k1.el01 = el01;
        ___k1.el02
                = el02;
        ___k1.el03 = el03;
        ___k1.___k = ___k;
        ___k1.object = this;
        head.
                Search(el03 , ___k1);
    }
    public void continuationMethod48 (List  last_elem ,
                                      List  head   , Element  el01   , Element  el02   , Element  el03   ,
                                      Continuation  ___k  ) {
        boolean  aux01 ;
        boolean  ___tmp71 ;
        LL
                ___pseudoThis ;
        ___ContinuationClasscontinuationMethod49  ___k1 ;
        ___pseudoThis = this;
        ___tmp71 = el03.____1234Init4321____;
        aux01 =
                ___tmp71;
        head = head;
        ___k1 = new
                ___ContinuationClasscontinuationMethod49();
        ___k1.last_elem = last_elem;
        ___k1.head = head;
        ___k1.el01 = el01;
        ___k1.el02 = el02;
        ___k1.el03 =
                el03;
        ___k1.___k = ___k;
        ___k1.object = this;
        head.Search(el02 , ___k1);
    }
    public void continuationMethod47 (List  last_elem , List  head   , Element
                                      el01   , Element  el02   , Continuation  ___k  ) {
        boolean  aux01 ;
        Element
                el03 ;
        boolean  ___tmp69 ;
        LL  ___pseudoThis ;
        ___ContinuationClasscontinuationMethod48  ___k1 ;
        ___pseudoThis = this;
        ___tmp69 = head.____1234Print4321____;
        aux01 = ___tmp69;
        el03 = new
                Element();
        el03 = el03;
        ___k1 = new
                ___ContinuationClasscontinuationMethod48();
        ___k1.last_elem = last_elem;
        ___k1.head = head;
        ___k1.el01 = el01;
        ___k1.el02 = el02;
        ___k1.el03 =
                el03;
        ___k1.___k = ___k;
        ___k1.object = this;
        el03.Init(27 , 34000 , false
                  , ___k1);
    }
    public void continuationMethod46 (List  last_elem , List  head
                                      , Element  el01   , Element  el02   , Continuation  ___k  ) {
        List  ___tmp67
                ;
        LL  ___pseudoThis ;
        ___ContinuationClasscontinuationMethod47  ___k1 ;
        ___pseudoThis = this;
        ___tmp67 = head.____1234Insert4321____;
        head =
                ___tmp67;
        head = head;
        ___k1 = new
                ___ContinuationClasscontinuationMethod47();
        ___k1.last_elem = last_elem;
        ___k1.head = head;
        ___k1.el01 = el01;
        ___k1.el02 = el02;
        ___k1.___k =
                ___k;
        ___k1.object = this;
        head.Print(___k1 );
    }
    public void
    continuationMethod45 (List  last_elem , List  head   , Element  el01   ,
                          Element  el02   , Continuation  ___k  ) {
        boolean  aux01 ;
        boolean
                ___tmp65 ;
        LL  ___pseudoThis ;
        ___ContinuationClasscontinuationMethod46
                ___k1 ;
        ___pseudoThis = this;
        ___tmp65 = el01.____1234Init4321____;
        aux01
                = ___tmp65;
        head = head;
        ___k1 = new
                ___ContinuationClasscontinuationMethod46();
        ___k1.last_elem = last_elem;
        ___k1.head = head;
        ___k1.el01 = el01;
        ___k1.el02 = el02;
        ___k1.___k =
                ___k;
        ___k1.object = this;
        head.Insert(el01 , ___k1);
    }
    public void
    continuationMethod44 (List  last_elem , List  head   , Element  el01   ,
                          Element  el02   , Continuation  ___k  ) {
        boolean  aux01 ;
        boolean
                ___tmp63 ;
        LL  ___pseudoThis ;
        ___ContinuationClasscontinuationMethod45
                ___k1 ;
        ___pseudoThis = this;
        ___tmp63 = head.____1234Print4321____;
        aux01
                = ___tmp63;
        System.out.println ( 10000000 ) ;
        el01 = new Element();
        el01
                = el01;
        ___k1 = new ___ContinuationClasscontinuationMethod45();
        ___k1.
                last_elem = last_elem;
        ___k1.head = head;
        ___k1.el01 = el01;
        ___k1.el02 =
                el02;
        ___k1.___k = ___k;
        ___k1.object = this;
        el01.Init(22 , 34000 , false
                  , ___k1);
    }
    public void continuationMethod43 (List  last_elem , List  head
                                      , Element  el01   , Element  el02   , Continuation  ___k  ) {
        List  ___tmp61
                ;
        LL  ___pseudoThis ;
        ___ContinuationClasscontinuationMethod44  ___k1 ;
        ___pseudoThis = this;
        ___tmp61 = head.____1234Insert4321____;
        head =
                ___tmp61;
        head = head;
        ___k1 = new
                ___ContinuationClasscontinuationMethod44();
        ___k1.last_elem = last_elem;
        ___k1.head = head;
        ___k1.el01 = el01;
        ___k1.el02 = el02;
        ___k1.___k =
                ___k;
        ___k1.object = this;
        head.Print(___k1 );
    }
    public void
    continuationMethod42 (List  last_elem , List  head   , Element  el01   ,
                          Continuation  ___k  ) {
        boolean  aux01 ;
        Element  el02 ;
        boolean  ___tmp59
                ;
        LL  ___pseudoThis ;
        ___ContinuationClasscontinuationMethod43  ___k1 ;
        ___pseudoThis = this;
        ___tmp59 = el01.____1234Init4321____;
        aux01 =
                ___tmp59;
        el02 = el01;
        head = head;
        ___k1 = new
                ___ContinuationClasscontinuationMethod43();
        ___k1.last_elem = last_elem;
        ___k1.head = head;
        ___k1.el01 = el01;
        ___k1.el02 = el02;
        ___k1.___k =
                ___k;
        ___k1.object = this;
        head.Insert(el01 , ___k1);
    }
    public void
    continuationMethod41 (List  last_elem , List  head   , Element  el01   ,
                          Continuation  ___k  ) {
        boolean  aux01 ;
        boolean  ___tmp57 ;
        LL
                ___pseudoThis ;
        ___ContinuationClasscontinuationMethod42  ___k1 ;
        ___pseudoThis = this;
        ___tmp57 = head.____1234Print4321____;
        aux01 =
                ___tmp57;
        System.out.println ( 10000000 ) ;
        el01 = new Element();
        el01 =
                el01;
        ___k1 = new ___ContinuationClasscontinuationMethod42();
        ___k1.
                last_elem = last_elem;
        ___k1.head = head;
        ___k1.el01 = el01;
        ___k1.___k =
                ___k;
        ___k1.object = this;
        el01.Init(39 , 42000 , true , ___k1);
    }
    public
    void continuationMethod40 (List  last_elem , List  head   , Element  el01
                               , Continuation  ___k  ) {
        List  ___tmp55 ;
        LL  ___pseudoThis ;
        ___ContinuationClasscontinuationMethod41  ___k1 ;
        ___pseudoThis = this;
        ___tmp55 = head.____1234Insert4321____;
        head = ___tmp55;
        head = head;
        ___k1 = new ___ContinuationClasscontinuationMethod41();
        ___k1.last_elem =
                last_elem;
        ___k1.head = head;
        ___k1.el01 = el01;
        ___k1.___k = ___k;
        ___k1.object = this;
        head.Print(___k1 );
    }
    public void continuationMethod39
    (List  last_elem , List  head   , Element  el01   , Continuation  ___k  ) {
        boolean  aux01 ;
        boolean  ___tmp53 ;
        LL  ___pseudoThis ;
        ___ContinuationClasscontinuationMethod40  ___k1 ;
        ___pseudoThis = this;
        ___tmp53 = el01.____1234Init4321____;
        aux01 = ___tmp53;
        head = head;
        ___k1 = new ___ContinuationClasscontinuationMethod40();
        ___k1.last_elem =
                last_elem;
        ___k1.head = head;
        ___k1.el01 = el01;
        ___k1.___k = ___k;
        ___k1.object = this;
        head.Insert(el01 , ___k1);
    }
    public void
    continuationMethod38 (List  last_elem , List  head   , Continuation  ___k  )
    {
        boolean  aux01 ;
        Element  el01 ;
        boolean  ___tmp51 ;
        LL  ___pseudoThis
                ;
        ___ContinuationClasscontinuationMethod39  ___k1 ;
        ___pseudoThis = this;
        ___tmp51 = head.____1234Print4321____;
        aux01 = ___tmp51;
        el01 = new
                Element();
        el01 = el01;
        ___k1 = new
                ___ContinuationClasscontinuationMethod39();
        ___k1.last_elem = last_elem;
        ___k1.head = head;
        ___k1.el01 = el01;
        ___k1.___k = ___k;
        ___k1.object =
                this;
        el01.Init(25 , 37000 , false , ___k1);
    }
    public void
    continuationMethod37 (List  last_elem , List  head   , Continuation  ___k  )
    {
        boolean  aux01 ;
        boolean  ___tmp49 ;
        LL  ___pseudoThis ;
        ___ContinuationClasscontinuationMethod38  ___k1 ;
        ___pseudoThis = this;
        ___tmp49 = head.____1234Init4321____;
        aux01 = ___tmp49;
        head = head;
        ___k1 = new ___ContinuationClasscontinuationMethod38();
        ___k1.last_elem =
                last_elem;
        ___k1.head = head;
        ___k1.___k = ___k;
        ___k1.object = this;
        head.Print(___k1 );
    }
    public void continuationMethod36 (List  last_elem ,
                                      Continuation  ___k  ) {
        List  head ;
        boolean  aux01 ;
        boolean  ___tmp47 ;
        LL  ___pseudoThis ;
        ___ContinuationClasscontinuationMethod37  ___k1 ;
        ___pseudoThis = this;
        ___tmp47 = last_elem.____1234Init4321____;
        aux01 =
                ___tmp47;
        head = last_elem;
        head = head;
        ___k1 = new
                ___ContinuationClasscontinuationMethod37();
        ___k1.last_elem = last_elem;
        ___k1.head = head;
        ___k1.___k = ___k;
        ___k1.object = this;
        head.Init(___k1
                  );
    }
}
class ____NewMainClass____ {
    public void ____Main____ (int  ____arg_length____
                              , Continuation  ___k  ) {
        int  ____printMe____ ;
        LL  ___tmp92 ;
        int
                ___tmp91 ;
        ____NewMainClass____  ___pseudoThis ;
        ___ContinuationClasscontinuationMethod58  ___k1 ;
        ___pseudoThis = this;
        ___tmp92 = new LL();
        ___k1 = new ___ContinuationClasscontinuationMethod58()
                ;
        ___k1.____arg_length____ = ____arg_length____;
        ___k1.___tmp92 = ___tmp92
                ;
        ___k1.___k = ___k;
        ___k1.object = this;
        ___tmp92.Start(___k1 );
    }
    public void continuationMethod58 (int  ____arg_length____ , LL  ___tmp92   ,
                                      Continuation  ___k  ) {
        int  ____printMe____ ;
        int  ___tmp91 ;
        ____NewMainClass____  ___pseudoThis ;
        ___pseudoThis = this;
        ___tmp91 =
                ___tmp92.____1234Start4321____;
        ____printMe____ = ___tmp91;
        System.out.println ( ____printMe____ ) ;
        ___k.call();
    }
}
class ___ContinuationClasscontinuationMethod2 extends Continuation {
    Element
    other ;
    Element  ____writeable____other ;
    Element  ___tmp11 ;
    boolean
    ret_val ;
    Continuation  ___k ;
    Element  object ;
    public void call () {
        object.continuationMethod2(other , ____writeable____other , ___tmp11 ,
                                   ret_val , ___k);
    }
}
class ___ContinuationClasscontinuationMethod5 extends Continuation {
    Element
    other ;
    Element  ____writeable____other ;
    Element  ___tmp11 ;
    Element
    ___tmp9 ;
    boolean  ret_val ;
    Continuation  ___k ;
    Element  object ;
    public
    void call () {
        object.continuationMethod5(other , ____writeable____other ,
                                   ___tmp11 , ___tmp9 , ret_val , ___k);
    }
}
class ___ContinuationClasscontinuationMethod6 extends Continuation {
    Element
    other ;
    Element  ____writeable____other ;
    Element  ___tmp11 ;
    Element
    ___tmp9 ;
    boolean  ret_val ;
    Continuation  ___k ;
    Element  object ;
    public
    void call () {
        object.continuationMethod6(other , ____writeable____other ,
                                   ___tmp11 , ___tmp9 , ret_val , ___k);
    }
}
class ___ContinuationClasscontinuationMethod8 extends Continuation {
    Element
    other ;
    Element  ____writeable____other ;
    Element  ___tmp11 ;
    Element
    ___tmp9 ;
    boolean  ret_val ;
    Continuation  ___k ;
    Element  object ;
    public
    void call () {
        object.continuationMethod8(other , ____writeable____other ,
                                   ___tmp11 , ___tmp9 , ret_val , ___k);
    }
}
class ___ContinuationClasscontinuationMethod7 extends Continuation {
    Element
    other ;
    Element  ____writeable____other ;
    Element  ___tmp11 ;
    Element
    ___tmp9 ;
    Continuation  ___k ;
    Element  object ;
    public void call () {
        object.continuationMethod7(other , ____writeable____other , ___tmp11 ,
                                   ___tmp9 , ___k);
    }
}
class ___ContinuationClasscontinuationMethod10 extends Continuation {
    Element
    other ;
    Element  ____writeable____other ;
    Element  ___tmp11 ;
    Element
    ___tmp9 ;
    boolean  ret_val ;
    Continuation  ___k ;
    Element  object ;
    public
    void call () {
        object.continuationMethod10(other , ____writeable____other ,
                                    ___tmp11 , ___tmp9 , ret_val , ___k);
    }
}
class ___ContinuationClasscontinuationMethod9 extends Continuation {
    Element
    other ;
    Element  ____writeable____other ;
    Element  ___tmp11 ;
    Element
    ___tmp9 ;
    Continuation  ___k ;
    Element  object ;
    public void call () {
        object.continuationMethod9(other , ____writeable____other , ___tmp11 ,
                                   ___tmp9 , ___k);
    }
}
class ___ContinuationClasscontinuationMethod4 extends Continuation {
    Element
    other ;
    Element  ____writeable____other ;
    Element  ___tmp11 ;
    Element
    ___tmp9 ;
    Continuation  ___k ;
    Element  object ;
    public void call () {
        object.continuationMethod4(other , ____writeable____other , ___tmp11 ,
                                   ___tmp9 , ___k);
    }
}
class ___ContinuationClasscontinuationMethod3 extends Continuation {
    Element
    other ;
    Element  ____writeable____other ;
    Element  ___tmp11 ;
    Continuation
    ___k ;
    Element  object ;
    public void call () {
        object.continuationMethod3(
            other , ____writeable____other , ___tmp11 , ___k);
    }
}
class ___ContinuationClasscontinuationMethod1 extends Continuation {
    Element
    other ;
    Element  ____writeable____other ;
    Element  ___tmp11 ;
    Continuation
    ___k ;
    Element  object ;
    public void call () {
        object.continuationMethod1(
            other , ____writeable____other , ___tmp11 , ___k);
    }
}
class ___ContinuationClasscontinuationMethod0 extends Continuation {
    Element
    other ;
    Element  ____writeable____other ;
    Continuation  ___k ;
    Element
    object ;
    public void call () {
        object.continuationMethod0(other ,
                                   ____writeable____other , ___k);
    }
}
class ___ContinuationClasscontinuationMethod11 extends Continuation {
    int  num1
    ;
    int  num2 ;
    boolean  retval ;
    Continuation  ___k ;
    Element  object ;
    public void call () {
        object.continuationMethod11(num1 , num2 , retval ,
                                    ___k);
    }
}
class ___ContinuationClasscontinuationMethod12 extends Continuation {
    int  num1
    ;
    int  num2 ;
    boolean  retval ;
    Continuation  ___k ;
    Element  object ;
    public void call () {
        object.continuationMethod12(num1 , num2 , retval ,
                                    ___k);
    }
}
class ___ContinuationClasscontinuationMethod13 extends Continuation {
    Element
    new_elem ;
    List  aux02 ;
    Continuation  ___k ;
    List  object ;
    public void
    call () {
        object.continuationMethod13(new_elem , aux02 , ___k);
    }
}
class ___ContinuationClasscontinuationMethod14 extends Continuation {
    Element
    e ;
    List  my_head ;
    Continuation  ___k ;
    List  object ;
    public void call ()
    {
        object.continuationMethod14(e , my_head , ___k);
    }
}
class ___ContinuationClasscontinuationMethod17 extends Continuation {
    Element
    e ;
    List  aux01 ;
    List  prev ;
    Element  var_elem ;
    int  aux04 ;
    Element
    ____writeable____e ;
    boolean  ____tmp15 ;
    boolean  ____tmp16 ;
    boolean
    ret_val ;
    boolean  var_end ;
    Continuation  ___k ;
    List  object ;
    public void
    call () {
        object.continuationMethod17(e , aux01 , prev , var_elem , aux04 ,
                                    ____writeable____e , ____tmp15 , ____tmp16 , ret_val , var_end , ___k);
    }
}
class ___ContinuationClasscontinuationMethod20 extends Continuation {
    Element
    e ;
    List  aux01 ;
    List  prev ;
    Element  var_elem ;
    int  aux04 ;
    Element
    ____writeable____e ;
    boolean  ____tmp15 ;
    boolean  ____tmp16 ;
    boolean
    ret_val ;
    boolean  var_end ;
    Continuation  ___k ;
    List  object ;
    public void
    call () {
        object.continuationMethod20(e , aux01 , prev , var_elem , aux04 ,
                                    ____writeable____e , ____tmp15 , ____tmp16 , ret_val , var_end , ___k);
    }
}
class ___ContinuationClasscontinuationMethod19 extends Continuation {
    Element
    e ;
    List  aux01 ;
    List  prev ;
    Element  var_elem ;
    int  aux04 ;
    Element
    ____writeable____e ;
    boolean  ____tmp15 ;
    boolean  ____tmp16 ;
    boolean
    ret_val ;
    Continuation  ___k ;
    List  object ;
    public void call () {
        object.
                continuationMethod19(e , aux01 , prev , var_elem , aux04 ,
                                     ____writeable____e , ____tmp15 , ____tmp16 , ret_val , ___k);
    }
}
class ___ContinuationClasscontinuationMethod18 extends Continuation {
    Element
    e ;
    List  aux01 ;
    List  prev ;
    Element  var_elem ;
    int  aux04 ;
    Element
    ____writeable____e ;
    boolean  ____tmp15 ;
    boolean  ____tmp16 ;
    boolean
    ret_val ;
    Continuation  ___k ;
    List  object ;
    public void call () {
        object.
                continuationMethod18(e , aux01 , prev , var_elem , aux04 ,
                                     ____writeable____e , ____tmp15 , ____tmp16 , ret_val , ___k);
    }
}
class ___ContinuationClasscontinuationMethod16 extends Continuation {
    Element
    e ;
    List  aux01 ;
    List  prev ;
    Element  var_elem ;
    int  aux04 ;
    Element
    ____writeable____e ;
    boolean  ____tmp15 ;
    boolean  ____tmp16 ;
    boolean
    ret_val ;
    Continuation  ___k ;
    List  object ;
    public void call () {
        object.
                continuationMethod16(e , aux01 , prev , var_elem , aux04 ,
                                     ____writeable____e , ____tmp15 , ____tmp16 , ret_val , ___k);
    }
}
class ___ContinuationClasscontinuationMethod21 extends Continuation {
    Element
    e ;
    List  aux01 ;
    List  prev ;
    Element  var_elem ;
    int  aux04 ;
    Element
    ____writeable____e ;
    boolean  ____tmp15 ;
    boolean  ____tmp16 ;
    boolean
    ret_val ;
    Continuation  ___k ;
    List  object ;
    public void call () {
        object.
                continuationMethod21(e , aux01 , prev , var_elem , aux04 ,
                                     ____writeable____e , ____tmp15 , ____tmp16 , ret_val , ___k);
    }
}
class ___ContinuationClasscontinuationMethod22 extends Continuation {
    Element
    e ;
    List  aux01 ;
    List  prev ;
    Element  var_elem ;
    int  aux04 ;
    Element
    ____writeable____e ;
    boolean  ____tmp15 ;
    boolean  ____tmp16 ;
    boolean
    ret_val ;
    Continuation  ___k ;
    List  object ;
    public void call () {
        object.
                continuationMethod22(e , aux01 , prev , var_elem , aux04 ,
                                     ____writeable____e , ____tmp15 , ____tmp16 , ret_val , ___k);
    }
}
class ___ContinuationClasscontinuationMethod24 extends Continuation {
    Element
    e ;
    List  aux01 ;
    List  prev ;
    Element  var_elem ;
    int  aux04 ;
    Element
    ____writeable____e ;
    boolean  ____tmp15 ;
    boolean  ____tmp16 ;
    boolean
    ret_val ;
    Continuation  ___k ;
    List  object ;
    public void call () {
        object.
                continuationMethod24(e , aux01 , prev , var_elem , aux04 ,
                                     ____writeable____e , ____tmp15 , ____tmp16 , ret_val , ___k);
    }
}
class ___ContinuationClasscontinuationMethod23 extends Continuation {
    Element
    e ;
    List  aux01 ;
    List  prev ;
    Element  var_elem ;
    int  aux04 ;
    Element
    ____writeable____e ;
    boolean  ____tmp15 ;
    boolean  ____tmp16 ;
    boolean
    ret_val ;
    Continuation  ___k ;
    List  object ;
    public void call () {
        object.
                continuationMethod23(e , aux01 , prev , var_elem , aux04 ,
                                     ____writeable____e , ____tmp15 , ____tmp16 , ret_val , ___k);
    }
}
class ___ContinuationClasscontinuationMethod15 extends Continuation {
    Element
    e ;
    List  aux01 ;
    List  prev ;
    Element  var_elem ;
    int  aux04 ;
    Element
    ____writeable____e ;
    boolean  ____tmp15 ;
    boolean  ____tmp16 ;
    Continuation
    ___k ;
    List  object ;
    public void call () {
        object.continuationMethod15(e ,
                                    aux01 , prev , var_elem , aux04 , ____writeable____e , ____tmp15 , ____tmp16
                                    , ___k);
    }
}
class ___ContinuationClasscontinuationMethod25 extends Continuation {
    Element
    e ;
    int  int_ret_val ;
    Continuation  ___k ;
    List  object ;
    public void call
    () {
        object.continuationMethod25(e , int_ret_val , ___k);
    }
}
class ___ContinuationClasscontinuationMethod30 extends Continuation {
    Element
    e ;
    List  aux01 ;
    Element  var_elem ;
    boolean  var_end ;
    Element
    ____writeable____e ;
    Continuation  ___k ;
    List  object ;
    public void call ()
    {
        object.continuationMethod30(e , aux01 , var_elem , var_end ,
                                    ____writeable____e , ___k);
    }
}
class ___ContinuationClasscontinuationMethod29 extends Continuation {
    Element
    e ;
    List  aux01 ;
    Element  var_elem ;
    boolean  var_end ;
    Element
    ____writeable____e ;
    Continuation  ___k ;
    List  object ;
    public void call ()
    {
        object.continuationMethod29(e , aux01 , var_elem , var_end ,
                                    ____writeable____e , ___k);
    }
}
class ___ContinuationClasscontinuationMethod28 extends Continuation {
    Element
    e ;
    List  aux01 ;
    Element  var_elem ;
    boolean  var_end ;
    Element
    ____writeable____e ;
    Continuation  ___k ;
    List  object ;
    public void call ()
    {
        object.continuationMethod28(e , aux01 , var_elem , var_end ,
                                    ____writeable____e , ___k);
    }
}
class ___ContinuationClasscontinuationMethod27 extends Continuation {
    Element
    e ;
    List  aux01 ;
    Element  var_elem ;
    boolean  var_end ;
    Element
    ____writeable____e ;
    Continuation  ___k ;
    List  object ;
    public void call ()
    {
        object.continuationMethod27(e , aux01 , var_elem , var_end ,
                                    ____writeable____e , ___k);
    }
}
class ___ContinuationClasscontinuationMethod26 extends Continuation {
    Element
    e ;
    List  aux01 ;
    Element  var_elem ;
    boolean  var_end ;
    Element
    ____writeable____e ;
    Continuation  ___k ;
    List  object ;
    public void call ()
    {
        object.continuationMethod26(e , aux01 , var_elem , var_end ,
                                    ____writeable____e , ___k);
    }
}
class ___ContinuationClasscontinuationMethod31 extends Continuation {
    Continuation  ___k ;
    List  object ;
    public void call () {
        object.
                continuationMethod31(___k );
    }
}
class ___ContinuationClasscontinuationMethod35 extends Continuation {
    List
    aux01 ;
    boolean  var_end ;
    Element  var_elem ;
    Continuation  ___k ;
    List
    object ;
    public void call () {
        object.continuationMethod35(aux01 , var_end ,
                                    var_elem , ___k);
    }
}
class ___ContinuationClasscontinuationMethod34 extends Continuation {
    List
    aux01 ;
    boolean  var_end ;
    Element  var_elem ;
    Continuation  ___k ;
    List
    object ;
    public void call () {
        object.continuationMethod34(aux01 , var_end ,
                                    var_elem , ___k);
    }
}
class ___ContinuationClasscontinuationMethod33 extends Continuation {
    List
    aux01 ;
    boolean  var_end ;
    Element  var_elem ;
    Continuation  ___k ;
    List
    object ;
    public void call () {
        object.continuationMethod33(aux01 , var_end ,
                                    var_elem , ___k);
    }
}
class ___ContinuationClasscontinuationMethod32 extends Continuation {
    List
    aux01 ;
    boolean  var_end ;
    Element  var_elem ;
    Continuation  ___k ;
    List
    object ;
    public void call () {
        object.continuationMethod32(aux01 , var_end ,
                                    var_elem , ___k);
    }
}
class ___ContinuationClasscontinuationMethod57 extends Continuation {
    List
    last_elem ;
    List  head ;
    Element  el01 ;
    Element  el02 ;
    Element  el03 ;
    Continuation  ___k ;
    LL  object ;
    public void call () {
        object.
                continuationMethod57(last_elem , head , el01 , el02 , el03 , ___k);
    }
}
class ___ContinuationClasscontinuationMethod56 extends Continuation {
    List
    last_elem ;
    List  head ;
    Element  el01 ;
    Element  el02 ;
    Element  el03 ;
    Continuation  ___k ;
    LL  object ;
    public void call () {
        object.
                continuationMethod56(last_elem , head , el01 , el02 , el03 , ___k);
    }
}
class ___ContinuationClasscontinuationMethod55 extends Continuation {
    List
    last_elem ;
    List  head ;
    Element  el01 ;
    Element  el02 ;
    Element  el03 ;
    Continuation  ___k ;
    LL  object ;
    public void call () {
        object.
                continuationMethod55(last_elem , head , el01 , el02 , el03 , ___k);
    }
}
class ___ContinuationClasscontinuationMethod54 extends Continuation {
    List
    last_elem ;
    List  head ;
    Element  el01 ;
    Element  el02 ;
    Element  el03 ;
    Continuation  ___k ;
    LL  object ;
    public void call () {
        object.
                continuationMethod54(last_elem , head , el01 , el02 , el03 , ___k);
    }
}
class ___ContinuationClasscontinuationMethod53 extends Continuation {
    List
    last_elem ;
    List  head ;
    Element  el01 ;
    Element  el02 ;
    Element  el03 ;
    Continuation  ___k ;
    LL  object ;
    public void call () {
        object.
                continuationMethod53(last_elem , head , el01 , el02 , el03 , ___k);
    }
}
class ___ContinuationClasscontinuationMethod52 extends Continuation {
    List
    last_elem ;
    List  head ;
    Element  el01 ;
    Element  el02 ;
    Element  el03 ;
    Continuation  ___k ;
    LL  object ;
    public void call () {
        object.
                continuationMethod52(last_elem , head , el01 , el02 , el03 , ___k);
    }
}
class ___ContinuationClasscontinuationMethod51 extends Continuation {
    List
    last_elem ;
    List  head ;
    Element  el01 ;
    Element  el02 ;
    Element  el03 ;
    Continuation  ___k ;
    LL  object ;
    public void call () {
        object.
                continuationMethod51(last_elem , head , el01 , el02 , el03 , ___k);
    }
}
class ___ContinuationClasscontinuationMethod50 extends Continuation {
    List
    last_elem ;
    List  head ;
    Element  el01 ;
    Element  el02 ;
    Element  el03 ;
    Continuation  ___k ;
    LL  object ;
    public void call () {
        object.
                continuationMethod50(last_elem , head , el01 , el02 , el03 , ___k);
    }
}
class ___ContinuationClasscontinuationMethod49 extends Continuation {
    List
    last_elem ;
    List  head ;
    Element  el01 ;
    Element  el02 ;
    Element  el03 ;
    Continuation  ___k ;
    LL  object ;
    public void call () {
        object.
                continuationMethod49(last_elem , head , el01 , el02 , el03 , ___k);
    }
}
class ___ContinuationClasscontinuationMethod48 extends Continuation {
    List
    last_elem ;
    List  head ;
    Element  el01 ;
    Element  el02 ;
    Element  el03 ;
    Continuation  ___k ;
    LL  object ;
    public void call () {
        object.
                continuationMethod48(last_elem , head , el01 , el02 , el03 , ___k);
    }
}
class ___ContinuationClasscontinuationMethod47 extends Continuation {
    List
    last_elem ;
    List  head ;
    Element  el01 ;
    Element  el02 ;
    Continuation  ___k
    ;
    LL  object ;
    public void call () {
        object.continuationMethod47(last_elem ,
                                    head , el01 , el02 , ___k);
    }
}
class ___ContinuationClasscontinuationMethod46 extends Continuation {
    List
    last_elem ;
    List  head ;
    Element  el01 ;
    Element  el02 ;
    Continuation  ___k
    ;
    LL  object ;
    public void call () {
        object.continuationMethod46(last_elem ,
                                    head , el01 , el02 , ___k);
    }
}
class ___ContinuationClasscontinuationMethod45 extends Continuation {
    List
    last_elem ;
    List  head ;
    Element  el01 ;
    Element  el02 ;
    Continuation  ___k
    ;
    LL  object ;
    public void call () {
        object.continuationMethod45(last_elem ,
                                    head , el01 , el02 , ___k);
    }
}
class ___ContinuationClasscontinuationMethod44 extends Continuation {
    List
    last_elem ;
    List  head ;
    Element  el01 ;
    Element  el02 ;
    Continuation  ___k
    ;
    LL  object ;
    public void call () {
        object.continuationMethod44(last_elem ,
                                    head , el01 , el02 , ___k);
    }
}
class ___ContinuationClasscontinuationMethod43 extends Continuation {
    List
    last_elem ;
    List  head ;
    Element  el01 ;
    Element  el02 ;
    Continuation  ___k
    ;
    LL  object ;
    public void call () {
        object.continuationMethod43(last_elem ,
                                    head , el01 , el02 , ___k);
    }
}
class ___ContinuationClasscontinuationMethod42 extends Continuation {
    List
    last_elem ;
    List  head ;
    Element  el01 ;
    Continuation  ___k ;
    LL  object ;
    public void call () {
        object.continuationMethod42(last_elem , head , el01 ,
                                    ___k);
    }
}
class ___ContinuationClasscontinuationMethod41 extends Continuation {
    List
    last_elem ;
    List  head ;
    Element  el01 ;
    Continuation  ___k ;
    LL  object ;
    public void call () {
        object.continuationMethod41(last_elem , head , el01 ,
                                    ___k);
    }
}
class ___ContinuationClasscontinuationMethod40 extends Continuation {
    List
    last_elem ;
    List  head ;
    Element  el01 ;
    Continuation  ___k ;
    LL  object ;
    public void call () {
        object.continuationMethod40(last_elem , head , el01 ,
                                    ___k);
    }
}
class ___ContinuationClasscontinuationMethod39 extends Continuation {
    List
    last_elem ;
    List  head ;
    Element  el01 ;
    Continuation  ___k ;
    LL  object ;
    public void call () {
        object.continuationMethod39(last_elem , head , el01 ,
                                    ___k);
    }
}
class ___ContinuationClasscontinuationMethod38 extends Continuation {
    List
    last_elem ;
    List  head ;
    Continuation  ___k ;
    LL  object ;
    public void call
    () {
        object.continuationMethod38(last_elem , head , ___k);
    }
}
class ___ContinuationClasscontinuationMethod37 extends Continuation {
    List
    last_elem ;
    List  head ;
    Continuation  ___k ;
    LL  object ;
    public void call
    () {
        object.continuationMethod37(last_elem , head , ___k);
    }
}
class ___ContinuationClasscontinuationMethod36 extends Continuation {
    List
    last_elem ;
    Continuation  ___k ;
    LL  object ;
    public void call () {
        object.
                continuationMethod36(last_elem , ___k);
    }
}
class ___ContinuationClasscontinuationMethod58 extends Continuation {
    int
    ____arg_length____ ;
    LL  ___tmp92 ;
    Continuation  ___k ;
    ____NewMainClass____  object ;
    public void call () {
        object.
                continuationMethod58(____arg_length____ , ___tmp92 , ___k);
    }
}
class Continuation {
    public void call () {
    }
}
