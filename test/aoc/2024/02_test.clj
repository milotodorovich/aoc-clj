(ns aoc.2024.02-test
  (:require [aoc.2024.02 :as sut]
            [clojure.pprint :as pp]
            [clojure.test :as t]))

(def input "7 6 4 2 1
1 2 7 8 9
9 7 6 2 1
1 3 2 4 5
8 6 4 4 1
1 3 6 7 9")

(t/deftest part-1-test
  (t/testing 'safe?
    (t/is (sut/safe? "7 6 4 2 1"))
    (t/is (not (sut/safe? "1 2 7 8 9")))
    (t/is (not (sut/safe? "9 7 6 2 1")))
    (t/is (not (sut/safe? "1 3 2 4 5")))
    (t/is (not (sut/safe? "8 6 4 4 1")))
    (t/is (sut/safe? "1 3 6 7 9")))

  (t/testing 'integration
    (t/is (= (sut/part-1 input) 2))))

(t/deftest part-2-test
  (t/testing 'numbers->options
    (t/is (= (sut/report->options "8 6 4 4 1")
             ["6 4 4 1"
              "8 4 4 1"
              "8 6 4 1"
              "8 6 4 1"
              "8 6 4 4"])))

  (t/testing 'tolerant-safe?
    (t/is (sut/tolerant-safe? "7 6 4 2 1"))
    (t/is (not (sut/tolerant-safe? "1 2 7 8 9")))
    (t/is (not (sut/tolerant-safe? "9 7 6 2 1")))
    (t/is (sut/tolerant-safe? "1 3 2 4 5"))
    (t/is (sut/tolerant-safe? "8 6 4 4 1"))
    (t/is (sut/tolerant-safe? "1 3 6 7 9")))

  (t/testing 'integration
    (t/is (= (sut/part-2 input) 4))))


