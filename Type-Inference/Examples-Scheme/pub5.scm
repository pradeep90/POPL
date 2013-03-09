/* (t1->(t2->(t3->int))) */
(let ( (high
( lambda ( x )
     ( let (
             ( q ( lambda ( y )
                     (lambda(z)
                         (lambda(a)
                            ( let(
                                (b (lambda (c)
                                        ( + 1 2 )
                                   )
                                )
                                     )
                                (set! b 2)
                            )
                         )
                      )
                  )
               )
           )
         (q #f)
       )
)

)

)

( let ( ( low ( lambda(w)
                   ( lambda(v)
                        (lambda(u)
                                10
                        )
                   )
              )
        )
      )
      (high (low #f))
)
)
