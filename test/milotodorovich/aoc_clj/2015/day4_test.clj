(ns milotodorovich.aoc-clj.2015.day4-test
  (:require [clojure.test :refer [is are deftest testing]]
            [milotodorovich.aoc-clj.2015.day4 :as day4]))

(deftest first-md5
  (testing "underlying function"
    (are [input result] (= result (day4/first-md5-with-leading input "00"))
      "abc" 18
      "efg" 380
      "xyz" 437)))

;; (deftest day-4-part-1-test
;;   (testing "day 4 test"
;;     (are [input result] (= (day4/part-1 input) result)
;;       "abcdef" 609043
;;       "pqrstuv" 1048970
;;       "ckczppom" 117946)))

;; (deftest day-4-part-2-test
;;   (testing "day 4 test"
;;     (is (= 3938038 (day4/part-2 "ckczppom")))))