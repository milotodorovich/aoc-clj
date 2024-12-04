
(ns aoc.2024.01-test
  (:require [aoc.2024.01 :as sut]
            [clojure.test :as t]))

(def input
  "3   4
4   3
2   5
1   3
3   9
3   3")

(t/deftest part-1-test
  (t/testing 'integration
    (t/is (= (sut/part-1 input) 11))))

(t/deftest part-2-test
  (t/testing 'integration
    (t/is (= (sut/part-2 input) 31))))

(comment

  (t/run-tests 'aoc.2024.01-test)
  (sut/part-1 "")
  (sut/part-2 "")

  ;;
  )
