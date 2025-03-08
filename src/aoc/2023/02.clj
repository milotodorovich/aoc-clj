(ns aoc.2023.02
  (:require [clojure.java.io :as io]
            [clojure.string :as s]))

(def available {:red 12
                :green 13
                :blue 14})

(defn ->game-id [input]
  (Integer/parseInt (re-find #"\d+" input)))

(defn ->grab [input]
  (->> (s/split (s/trim input) #",")
       (map s/trim)
       (map #(s/split % #" "))
       (map (fn [[v k]] [(keyword k) (Integer/parseInt v)]))
       (into {})))

(defn ->turns [input]
  (->> (s/split (s/trim input) #";")
       (map ->grab)))

(defn parse-game [input]
  (let [[game turns] (->> (s/split input #":"))]
    {:game-id (->game-id game)
     :turns (->turns turns)}))

(defn valid-turn? [turn]
  (not (or (> (:red turn 0) (:red available))
           (> (:green turn 0) (:green available))
           (> (:blue turn 0) (:blue available)))))

(defn valid? [game]
  (every? valid-turn? (:turns game)))

(defn ->min [game k]
  (->> (:turns game)
       (map #(get % k 0))
       (apply max)))

(defn minimum-bag [game]
  [(->min game :red)
   (->min game :green)
   (->min game :blue)])

(defn part-1 [input]
  (->> (s/split input #"\n")
       (map parse-game)
       (filter valid?)
       (map :game-id)
       (apply +)))

(defn part-2 [input]
  (->> (s/split input #"\n")
       (map parse-game)
       (map minimum-bag)
       (map #(apply * %))
       (apply +)))

(defn run [& _]
  (let [data (-> "2023/02.txt"
                 (io/resource)
                 (slurp))]
    (println "Solving 2023 day 02.")

    (println (part-1 data))
    (println (part-2 data))))
