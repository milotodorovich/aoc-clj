(ns aoc.2015.day2-test
  (:require [clojure.test :refer [deftest are testing]]
            [aoc.2015.day2 :as day2]))

(deftest day2-part-1-test
  (testing "day 2 test"
    (are [input result] (= (day2/part-1 input) result)
      "2x3x4" 58
      "1x1x10" 43)))


(deftest day2-part-2-test
  (testing "day 2 test"
    (are [input result] (= (day2/part-2 input) result)
      "2x3x4" 34
      "1x1x10" 14)))
