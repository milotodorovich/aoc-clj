(ns aoc.2024.03
  (:require [clojure.java.io :as io]
            [clojure.pprint :as pp]
            [clojure.string :as str])
  (:import java.lang.Integer))

(defn part-1 [input]
  (->> (re-seq #"mul\(\d{1,3},\d{1,3}\)" input)
       (map #(re-seq #"\d{1,3}" %))
       (map (fn [a] (* (java.lang.Integer/parseInt (first a))
                       (java.lang.Integer/parseInt (last a)))))
       (reduce +)))

(defn part-2 [input]
  (let [keys (re-seq #"(do\(\)|don't\(\))" input)
        keys (cons ["do()"] keys)
        vals (str/split input #"(do\(\)|don't\(\))")]
    (->> (map (fn [k v]
                (if (= "do()" (first k))
                  (part-1 v)
                  0)) keys vals)
         (reduce +))))

(defn run [& _]
  (let [data (-> "2024/03.txt"
                 (io/resource)
                 (slurp))]
    (println "Solving 2024 day 03.")
    (println (part-1 data))
    (clojure.pprint/pprint (part-2 data))))


