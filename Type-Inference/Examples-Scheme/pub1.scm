;; /* int->int */
(lambda (n)
  (letrec (
	   (sum (lambda (x)
		  (+ (sum (+ x 1)) x )))
	   )
    (sum n)))
