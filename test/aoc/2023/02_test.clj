(ns aoc.2023.02-test
  (:require [clojure.pprint :as pp]
            [clojure.string :as s]
            [clojure.test :as t]))

(defn ->game-id [input]
  (->> (s/split input #" ")
       last
       bigdec
       int))

(defn ->grab [input]
  (->> (s/split (s/trim input) #" ")
       (reverse)))

(defn ->turn [input]
  (->> (s/split (s/trim input) #";")
       (mapcat ->grab)))

(defn ->turns [input]
  (->> (s/split (s/trim input) #";")
       (map ->turn)))

(defn parse-game [input]
  (let [[game-s turns-s] (->> (s/split input #":"))
        game-id (->game-id game-s)
        turns (->turns turns-s)]
    (pp/pprint turns)
    {:game-id game-id
     :turns turns}))

(defn part-1 [input]
  0)

(t/deftest part-1-test
  (t/testing "parse game id"
    (t/is (= 1
             (:game-id (parse-game "Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green"))))
    (t/is (= 3
             (:game-id (parse-game "Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red"))))
    (t/testing "parse turns"
      (t/is (= []
               (:turns (parse-game "Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue"))))
      (t/is (= []
               (:turns (parse-game "Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green")))))

    (t/testing "part 1")
    (t/is (= 1 1))))

(t/deftest part-2-test
  (t/testing "part 2"
    (t/is (= 1 1))))

(comment

  (part-1 "")
  (clojure.test/run-tests)
  (clojure.test/run-test part-1-test)
  ;;
  )
