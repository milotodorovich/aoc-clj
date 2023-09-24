(ns milotodorovich.aoc-clj.2015.day3
  (:require [clojure.java.io :as io]
            [clojure.set :refer [union]]))

(defn next-pos [pos direction]
  (cond
    (= direction \^)
    (merge pos {:y (inc (:y pos))})
    (= direction \>)
    (merge pos {:x (inc (:x pos))})
    (= direction \v)
    (merge pos {:y (dec (:y pos))})
    (= direction \<)
    (merge pos {:x (dec (:x pos))})))


(defn add-move [acc direction]
  (let [next-pos (next-pos (:current acc) direction)]
    (merge acc {:current next-pos
                :visits (conj (:visits acc) next-pos)})))

(defn travel [input]
  (let [start-pos {:x 0 :y 0}
        results {:current start-pos
                 :visits #{start-pos}}]
    (->> (seq input)
         (reduce add-move results))))

(defn part-1 [input]
  (-> (travel input)
      (:visits)
      (count)))

(defn part-2 [input]
  (let [parts (partition-all 2 input)
        santa-moves (map first parts)
        robot-moves (map last parts)
        santa-visits (-> (travel santa-moves)
                         (:visits))
        robot-visits (-> (travel robot-moves)
                         (:visits))]
    (count (union santa-visits robot-visits))))

(defn -main [& _]
  (let [data (-> "2015/day3.txt"
                 (io/resource)
                 (slurp))]
    (println "Solving 2015 day 1.")
    (println (part-1 data))
    (println (part-2 data))))