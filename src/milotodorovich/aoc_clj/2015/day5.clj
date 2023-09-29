(ns milotodorovich.aoc-clj.2015.day5
  (:require [clojure.java.io :as io]
            [clojure.string :as str]))

(def vowels {\a 1 \e 1 \i 1 \o 1 \u 1})

(defn three-vowels? [input]
  (let [num-vowels
        (->> input
             (seq)
             (map vowels)
             (filter identity)
             (reduce + 0))]
    (>= num-vowels 3)))

(defn ends-equal? [input]
  (if (= (first input) (last input))
    1
    0))

(defn double-letters? [input]
  (->> input
       (seq)
       (partition 2 1)
       (map ends-equal?)
       (reduce + 0)
       (< 0)))

(def disallowed '("ab" "cd" "pq" "xy"))

(defn no-disallowed? [input]
  (not-any? (fn [pair] (str/includes? input pair)) disallowed))

(defn part-1 [input]
  (and (three-vowels? input)
       (double-letters? input)
       (no-disallowed? input)))

(defn paired-triplets? [input]
  (->> input
       (seq)
       (partition 3 1)
       (map ends-equal?)
       (reduce + 0)
       (< 0)))

(defn two-pair-non-overlapping? [input]
;;   (let [possible-pairs (->> input
;;                             (seq)
;;                             (partition 2 1))]
    ;; (not= (count possible-pairs)
    ;;       (count (group-by identity possible-pairs))))
   (let [first (first input)
         second (second input)
         first-rest (rest input)
         remain (rest (str/join first-rest))
         two-pair? (str/includes? (str/join remain) (str first second))]
     (if two-pair?
       true
       (if (seq first-rest)
         (two-pair-non-overlapping? (str/join (rest input)))
         false)
       ) 
    ))

(defn part-2 [input]
  (and (paired-triplets? input)
       (two-pair-non-overlapping? input)))

(defn -main [& _]
  (let [data (-> "2015/day5.txt"
                 (io/resource)
                 (slurp)
                 (str/split #"\n"))]
    (println "Solving 2015 day 5.")
    (println (->> data
                  (map part-1)
                  (filter identity)
                  (count)))
    (println (->> data
                  (map part-2)
                  (filter identity)
                  (count)))))