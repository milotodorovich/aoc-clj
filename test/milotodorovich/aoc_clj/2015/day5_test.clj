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