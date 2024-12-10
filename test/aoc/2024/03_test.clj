(ns aoc.2024.03-test
  (:require [aoc.2024.03 :as sut]
            [clojure.test :as t]))

(def input "xmul(2,4)%&mul[3,7]!@^do_not_mul(5,5)+mul(32,64then(mul(11,8)mul(8,5)))")

(t/deftest part-1-test
  (t/testing 'integration
    (t/is (= (sut/part-1 input) 161))))

(t/deftest part-2-test
  (t/testing 'integration
    (let [input "xmul(2,4)&mul[3,7]!^don't()_mul(5,5)+mul(32,64)(mul(11,8)undo()?mul(8,5))"]
      (t/is (= (sut/part-2 input) 48)))))


