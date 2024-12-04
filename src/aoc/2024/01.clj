
(ns aoc.2024.01
  (:require [clojure.java.io :as io]
            [clojure.string :as str])
  (:import java.lang.Long))

(defn part-1 [input]
  (->> input
       str/split-lines
       (map str/trim)
       (map #(str/split % #" +"))
       (apply map list)
       (map sort)
       (apply interleave)
       (map #(Long/parseLong %))
       (partition 2)
       (map (fn [[a b]] (abs (- a b))))
       (reduce +)))

(defn part-2 [input]
  (let [[left right] (->> input
                          str/split-lines
                          (map str/trim)
                          (map #(str/split % #" +"))
                          (apply map list))
        right-map (->> right
                       (group-by identity)
                       (into {} (map (fn [[k v]] [k (count v)]))))
       ;;
        answer (->> left
                    (map (fn [x] [(Long/parseLong x) (get right-map x 0)]))
                    (map (fn [[k v]] (* k v)))
                    (reduce +))]
    answer))

(defn run [& _]
  (let [data (-> "2024/01.txt"
                 (io/resource)
                 (slurp))]
    (println "Solving 2024 day 1.")
    (println (part-1 data))
    (println (part-2 data))))
