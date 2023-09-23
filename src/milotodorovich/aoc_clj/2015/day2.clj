(ns milotodorovich.aoc-clj.2015.day2
  (:require [clojure.java.io :as io]
            [clojure.string :as str]))

(defn part-1 [input]
  (let [dims (str/split input #"x")
        ints (map #(Integer/parseInt %) dims)
        [l w h] ints
        a1 (* l w)
        a2 (* l h)
        a3 (* w h)
        extra (min a1 a2 a3)]
    (+ extra (* 2 (+ a1 a2 a3)))))


(defn part-2 [input]
  (let [dims (str/split input #"x")
        ints (map #(Integer/parseInt %) dims)
        [l w h] ints
        p1 (+ l w l w)
        p2 (+ l h l h)
        p3 (+ w h w h)
        volume (* l w h)]
    (+ volume (min p1 p2 p3))))

(defn -main [& _]
  (let [data (str/split (slurp (io/resource "2015/day2.txt")) #"\n")]
    (println "Solving 2015 day 2.")
    (println (->> data
                  (map part-1)
                  (reduce + 0)))
    (println (->> data
                  (map part-2)
                  (reduce + 0)))))
