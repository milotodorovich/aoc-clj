(ns aoc.2015.day4
  (:require [clj-commons.digest :as digest]
            [clojure.java.io :as io]
            [clojure.string :as str]))

(defn first-md5-with-leading [input starts-with]
  (loop [x 0]
    (let [result (digest/md5 (str input x))]
      (if (str/starts-with? (str result) starts-with)
        x
        (recur (inc x))))))

(defn part-1 [input]
  (first-md5-with-leading input "00000"))

(defn part-2 [input]
  (first-md5-with-leading input "000000"))

(defn -main [& _]
  (let [data (-> "2015/day4.txt"
                 (io/resource)
                 (slurp))]
    (println "Solving 2015 day 4.")
    (println (part-1 data))
    (println (part-2 data))))