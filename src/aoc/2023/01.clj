(ns aoc.2023.01
  (:require [clojure.java.io :as io]
            [clojure.string :as str]))

(def name-number {"one" "o1e"
                  "two" "t2o"
                  "three" "t3e"
                  "four" "f4r"
                  "five" "f5e"
                  "six" "s6x"
                  "seven" "s7n"
                  "eight" "e8t"
                  "nine" "n9e"})

(defn line->number
  [input]
  (let [numbers (->> (seq input)
                     (map str)
                     (map parse-long)
                     (keep identity))]
    (->> [(first numbers) (last numbers)]
         (map str)
         (str/join)
         (parse-long))))

(defn replace-names
  [input]
  (reduce-kv str/replace input name-number))

(defn line->better-number
  [input]
  (let [output (-> input
                   replace-names
                   line->number)]
    output))

(defn part-1 [input]
  (->> input
       (str/split-lines)
       (map line->number)
       (reduce +)))

(defn part-2 [input]
  (->> input
       (str/split-lines)
       (map line->better-number)
       (reduce +)))

(defn run [& _]
  (let [data (-> "2023/01.txt"
                 (io/resource)
                 (slurp))]
    (println "Solving 2023 day 1.")
    (println (part-1 data))
    (println (part-2 data))))
