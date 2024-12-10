(ns aoc.2024.04
  (:require [clojure.java.io :as io]
            [clojure.string :as str]
            [clojure.pprint :as pp]))

(defn char-match?
  ([data c x y]
   (try (= c (aget data x y))
        (catch Exception _
          false)))
  ([data c x y i j]
   (char-match? data c (+ x i) (+ y j))))

(defn xmas-count [data x y]
  (cond->> []
    (and (char-match? data \X x y)
         (char-match? data \M x y 0 1)
         (char-match? data \A x y 0 2)
         (char-match? data \S x y 0 3))
    (cons 1)
    (and (char-match? data \X x y)
         (char-match? data \M x y 0 -1)
         (char-match? data \A x y 0 -2)
         (char-match? data \S x y 0 -3))
    (cons 1)
    (and (char-match? data \X x y)
         (char-match? data \M x y 1 0)
         (char-match? data \A x y 2 0)
         (char-match? data \S x y 3 0))
    (cons 1)
    (and (char-match? data \X x y)
         (char-match? data \M x y -1 0)
         (char-match? data \A x y -2 0)
         (char-match? data \S x y -3 0))
    (cons 1)
    (and (char-match? data \X x y)
         (char-match? data \M x y 1 -1)
         (char-match? data \A x y 2 -2)
         (char-match? data \S x y 3 -3))
    (cons 1)
    (and (char-match? data \X x y)
         (char-match? data \M x y 1 1)
         (char-match? data \A x y 2 2)
         (char-match? data \S x y 3 3))
    (cons 1)
    (and (char-match? data \X x y)
         (char-match? data \M x y -1 -1)
         (char-match? data \A x y -2 -2)
         (char-match? data \S x y -3 -3))
    (cons 1)
    (and (char-match? data \X x y)
         (char-match? data \M x y -1 1)
         (char-match? data \A x y -2 2)
         (char-match? data \S x y -3 3))
    (cons 1)
    true count))

(defn xmas? [data x y]
  (or (and (char-match? data \X x y)
           (char-match? data \M x y 0 1)
           (char-match? data \A x y 0 2)
           (char-match? data \S x y 0 3))
      (and (char-match? data \X x y)
           (char-match? data \M x y 0 -1)
           (char-match? data \A x y 0 -2)
           (char-match? data \S x y 0 -3))
      (and (char-match? data \X x y)
           (char-match? data \M x y 1 0)
           (char-match? data \A x y 2 0)
           (char-match? data \S x y 3 0))
      (and (char-match? data \X x y)
           (char-match? data \M x y -1 0)
           (char-match? data \A x y -2 0)
           (char-match? data \S x y -3 0))
      (and (char-match? data \X x y)
           (char-match? data \M x y 1 -1)
           (char-match? data \A x y 2 -2)
           (char-match? data \S x y 3 -3))
      (and (char-match? data \X x y)
           (char-match? data \M x y 1 1)
           (char-match? data \A x y 2 2)
           (char-match? data \S x y 3 3))
      (and (char-match? data \X x y)
           (char-match? data \M x y -1 -1)
           (char-match? data \A x y -2 -2)
           (char-match? data \S x y -3 -3))
      (and (char-match? data \X x y)
           (char-match? data \M x y -1 1)
           (char-match? data \A x y -2 2)
           (char-match? data \S x y -3 3))))

(defn x-mas? [data x y]
  (and (char-match? data \A x y)
       (or (and (char-match? data \M x y 1 1)
                (char-match? data \S x y -1 -1)
                (char-match? data \M x y 1 -1)
                (char-match? data \S x y -1 1))
           (and (char-match? data \M x y 1 1)
                (char-match? data \S x y -1 -1)
                (char-match? data \M x y -1 1)
                (char-match? data \S x y 1 -1))
           (and (char-match? data \M x y -1 -1)
                (char-match? data \S x y 1 1)
                (char-match? data \M x y -1 1)
                (char-match? data \S x y 1 -1))
           (and (char-match? data \M x y -1 -1)
                (char-match? data \S x y 1 1)
                (char-match? data \M x y 1 -1)
                (char-match? data \S x y -1 1)))))

(defn ->data [input]
  (->> (str/split-lines input)
       (map char-array)
       to-array))

(defn part-1 [input]
  (let [data (->data input)
        result (map-indexed (fn [x row]
                              (map-indexed (fn [y _]
                                             (xmas-count data x y))
                                           row))
                            data)]
    (->> (apply concat result)
         (reduce + 0))
    ;;
    ))

(defn part-2 [input]
  (->> (map-indexed (fn [x row]
                      (map-indexed (fn [y _]
                                     (x-mas? (->data input) x y))
                                   row)) (->data input))
       (apply concat)
       (filter identity)
       count))

(defn run [& _]
  (let [data (-> "2024/04.txt"
                 (io/resource)
                 (slurp))]
    (println "Solving 2024 day 04.")

    (println (part-1 data))
    (println "Day 2 hint 3463 is too high")
    (println (part-2 data))))


