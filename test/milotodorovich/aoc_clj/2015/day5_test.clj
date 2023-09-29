(ns milotodorovich.aoc-clj.2015.day5-test
  (:require [clojure.test :refer [are deftest testing]]
            [milotodorovich.aoc-clj.2015.day5 :as day5]))


(deftest day-5-part-1
  (testing "day 5 part 1"
    (are [input expected] (= expected (day5/part-1 input))
      "ugknbfddgicrmopn" true
      "aaa" true
      "jchzalrnumimnmhp" false
      "haegwjzuvuyypxyu" false
      "dvszwmarrgswjxmb" false)))

(deftest day-5-part-2
  (testing "day 5 part 1"
    (are [input expected] (= expected (day5/part-2 input))
      "qjhvhtzxzqqjkmpb" true
      "xxyxx" true
      "uurcxstgmygtbstg" false
      "ieodomkazucvgmuy" false
      "aaaayzy" true
      "aaayzy" false
      "jbcccjb" true
      "jbccjb" false))
  (testing "two pair non-overlapping"
    (are [input expected] (= expected (day5/two-pair-non-overlapping? input))
      "aaaa" true
      "aaa" false
      "jbcccjb" true
      "jbccjb" true)))