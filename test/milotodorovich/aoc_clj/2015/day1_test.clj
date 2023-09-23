(ns milotodorovich.aoc-clj.2015.day1-test
  (:require [clojure.test :refer [deftest are testing]]
            [milotodorovich.aoc-clj.2015.day1 :as day1]))

(deftest day1-test
  (testing "day1 test"
    (are [input result] (= (day1/part-1 input) result)
        "" 0
        "(" 1
        ")" -1
        "()" 0
        "(())" 0
        "()()" 0
        "(((" 3
        "(()(()(" 3
        "))(((((" 3
        "())" -1
        "))(" -1
        ")))" -3
        ")())())" -3
    )))

(deftest day1-part2-test
  (testing "day 1 part 2"
    (are [input result] (= (day1/part-2 input) result)
      ")" 1
      "()())" 5
      "()())(((())))" 5)))