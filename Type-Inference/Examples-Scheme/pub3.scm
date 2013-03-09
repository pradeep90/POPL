/* Y combinator -- Does not type check. */
(lambda (f) ((lambda (x) (f (x x)))(lambda (x) (f (x x)))))
