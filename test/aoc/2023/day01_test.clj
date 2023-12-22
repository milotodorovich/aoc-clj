(ns aoc.2023.day01-test
  (:require [aoc.2023.day01 :as day01]
            [clojure.test :refer [are deftest is testing]]))

(def sample-input "1abc2
pqr3stu8vwx
a1b2c3d4e5f
treb7uchet")

(def other-sample "two1nine
eightwothree
abcone2threexyz
xtwone3four
4nineeightseven2
zoneight234
7pqrstsixteen")

(deftest day-01-test
  (testing "line input values"
    (are [input expected] (= expected (day01/line->better-number input))
      "1abc2" 12
      "pqr3stu8vwx" 38
      "a1b2c3d4e5f" 15
      "treb7uchet" 77))

  (is (= 142 (day01/part-1 sample-input))))

(deftest day-01-part2
  (testing "replace names"
    (are [input expected] (= expected (day01/replace-names input))
      "nineight" "n9e8t"
      "sevenine" "s7n9e"))
  (testing "line input values"
    (are [input expected] (= expected (day01/line->better-number input))
      "two1nine" 29
      "eightwothree" 83
      "abcone2threexyz" 13
      "xtwone3four" 24
      "4nineeightseven2" 42
      "zoneight234" 14
      "zoneight" 18
      "7pqrstsixteen" 76
      "2rnxbqrrfiveoneightgsc" 28
      "eighthree" 83
      "sevenine" 79))
  (is (= 281 (day01/part-2 other-sample))))