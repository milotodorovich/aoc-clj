(ns milotodorovich.aoc-clj.2015.day2
  (:require [clojure.java.io :as io]
            [clojure.string :as str]))

(defn input->dimensions [input]
  (->> (str/split input #"x")
       (map #(Integer/parseInt %))))

(defn area [a b]
  (* a b))

(defn perimeter [a b]
  (+ a a b b))

(defn volume [a b c]
  (* a b c))

(defn part-1 [input]
  (let [[l w h] (input->dimensions input)
        a1 (area l w)
        a2 (area l h)
        a3 (area w h)
        extra (min a1 a2 a3)]
    (+ extra (* 2 (+ a1 a2 a3)))))

(defn part-2 [input]
  (let [[l w h] (input->dimensions input)
        p1 (perimeter l w)
        p2 (perimeter l h)
        p3 (perimeter w h)]
    (+ (volume l w h) (min p1 p2 p3))))

(defn -main [& _]
  (let [data (-> "2015/day2.txt"
                 (io/resource)
                 (slurp)
                 (str/split #"\n"))]
    (println "Solving 2015 day 2.")
    (println (->> data
                  (map part-1)
                  (reduce + 0)))
    (println (->> data
                  (map part-2)
                  (reduce + 0)))))
