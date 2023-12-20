(ns aoc.2023.day01 
  (:require [clojure.string :as str]))

(defn line->number
  [input]
  (let [numbers (->> (seq input)
                     (map str)
                     (map parse-long)
                     (keep identity)
                     )]
    (->> [(first numbers) (last numbers)]
         (map str)
         (str/join)
         (parse-long))))