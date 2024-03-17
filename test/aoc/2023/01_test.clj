(ns aoc.2023.01-test
  (:require [aoc.2023.01 :as sut]
            [clojure.test :as t]))

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

(t/deftest day-01-test
  (t/testing "line input values"
    (t/are [input expected] (= expected (sut/line->better-number input))
      "1abc2" 12
      "pqr3stu8vwx" 38
      "a1b2c3d4e5f" 15
      "treb7uchet" 77))

  (t/is (= 142 (sut/part-1 sample-input))))

(t/deftest day-01-part2
  (t/testing "replace names"
    (t/are [input expected] (= expected (sut/replace-names input))
      "nineight" "n9e8t"
      "sevenine" "s7n9e"))
  (t/testing "line input values"
    (t/are [input expected] (= expected (sut/line->better-number input))
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
  (t/is (= 281 (sut/part-2 other-sample))))

(comment

  (t/run-tests)

  (t/run-all-tests)

  ;;
  )
