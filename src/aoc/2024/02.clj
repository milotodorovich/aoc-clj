(ns aoc.2024.02
  (:require [clojure.java.io :as io]
            [clojure.string :as str]))

(defn report->levels [s]
  (str/split s #" "))

(defn report->options [s]
  (let [levels (report->levels s)]
    (->> (range (count levels))
         (map #(concat (take % levels) (drop (inc %) levels)))
         (map #(str/join " " %)))))

(defn report->numbers [s]
  (->> (report->levels s)
       (map #(java.lang.Long/parseLong %))
       (partition 2 1)
       (map (fn [[a b]] (- b a)))))

(defn safe? [s]
  (let [numbers (report->numbers s)]
    (and (or (every? pos-int? numbers)
             (every? neg-int? numbers))
         (every? (fn [x] (contains? #{1 2 3} (abs x))) numbers))))

(defn tolerant-safe? [s]
  (or (safe? s)
      (->> (report->options s)
           (some safe?))))

(defn part-1 [input]
  (->> (str/split input #"\n")
       (filter safe?)
       count))

(defn part-2 [input]
  (->> (str/split input #"\n")
       (filter tolerant-safe?)
       count))

(defn run [& _]
  (let [data (-> "2024/02.txt"
                 (io/resource)
                 (slurp))]
    (println "Solving 2024 day 02.")
    (println (part-1 data))
    (println (part-2 data))))

