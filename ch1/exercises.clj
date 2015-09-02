(ns sicp.ch1)

;; Exercise 1.2. Translate the following expression into prefix form
;; (5 + 4 + (2 - (3 - (6 + 4/5))))/3(6 - 2)(2 - 7)

(def ex_one_two
  (/
   (+ 5 4
      (- 2
         (- 3
            (+ 6
               (/ 4 5)))))
   (* 3
      (- 6 2)
      (- 2 7 ))))

;; -37/150

;; Exercise 1.3. Define a procedure that takes three numbers as arguments and
;; returns the sum of the squares of the two larger numbers.

(defn get_larger_numbers
  [num1 num2 num3]
  (def args [num1 num2 num3])
  (def drop-nth (.indexOf args (apply min args)))
  (concat (subvec args 0 drop-nth) (subvec args (+ drop-nth 1))))

(defn sum_of_square
  [&args]
  (reduce + (map square &args)))

(defn square
  [num]
  (* num num))

(defn sum_of_larger_numbers
  [num1 num2 num3]
  (sum_of_square (get_larger_numbers num1 num2 num3)))
