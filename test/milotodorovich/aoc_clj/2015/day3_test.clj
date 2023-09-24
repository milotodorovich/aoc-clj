(ns milotodorovich.aoc-clj.2015.day3-test
  (:require [clojure.test :refer [deftest are testing]]
            [milotodorovich.aoc-clj.2015.day3 :as day3]))

(deftest day3-part-1-test
  (testing "day 3 test"
    (are [input result] (= (day3/part-1 input) result)
      "" 1
      "^" 2
      ">" 2
      "<" 2
      "v" 2
      "^>v<" 4
      "^v^v^v^v^v" 2)))

(deftest day-3-part-2-test
  (testing "day 3 test"
    (are [input result] (= (day3/part-2 input) result)
      "^v" 3
      "^>v<" 3
      "^v^v^v^v^v" 11)))