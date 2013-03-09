/* (t1->(t2->(t3->(t4->t5)))) */
( lambda ( x )
     ( let (
             ( q ( lambda ( y )
                     (lambda(z)
                         (lambda(a)
                            ( letrec (
                                (b (lambda (c)
                                        (b c)
                                   )
                                )
                                     )
                                b
                            )
                         )
                      )
                  )
               )
           )
         (q #f)
       )
)
