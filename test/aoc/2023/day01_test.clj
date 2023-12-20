(ns aoc.2023.day01-test
  (:require [clojure.test :refer [deftest are testing]]
            [aoc.2023.day01 :as day01]))

(deftest day-01-test
  (testing "line input values")
  (are [input expected] (= expected (day01/line->number input))
    "1abc2" 12
    "pqr3stu8vwx" 38
    "a1b2c3d4e5f" 15
    "treb7uchet" 77))