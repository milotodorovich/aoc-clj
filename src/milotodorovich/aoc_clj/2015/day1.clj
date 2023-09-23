(ns milotodorovich.aoc-clj.2015.day1
  (:require [clojure.java.io :as io]
            [clojure.string :as str]))

(defn part-1 [input]
  (->> (seq input)
       (map {\( 1 \) -1})
       (reduce + 0)))

(defn- going-negative [acc val]
  (if (= -1 (:floor acc))
    acc
    (merge acc
           {:index (inc (:index acc))}
           {:floor (+ (:floor acc) val)})))

(defn part-2 [input]
  (->> (seq input)
       (map {\( 1 \) -1})
       (reduce going-negative {:index 0 :floor 0})
       :index))

(defn -main [& args]
  (let [data (slurp (io/resource "2015/day1.txt"))]
    (println "Solving 2015 day 1.")
    (println (part-1 data))
    (println (part-2 data))))
