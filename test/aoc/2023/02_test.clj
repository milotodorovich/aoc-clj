(ns aoc.2023.02-test
  (:require
   [clojure.test :as t]
   [aoc.2023.02 :as sut]))

(def input
  "Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green
Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue
Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red
Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red
Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green")

(t/deftest part-1-test
  (t/testing "part 1"
    (t/is (= 8 (sut/part-1 input))))
  (t/testing "parse turns"
    (t/is (= [{:blue 1, :green 2} {:green 3, :blue 4, :red 1} {:green 1, :blue 1}]
             (:turns (sut/parse-game "Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue"))))
    (t/is (= [{:red 6, :blue 1, :green 3} {:blue 2, :red 1, :green 2}]
             (:turns (sut/parse-game "Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green")))))
  (t/testing "parse game id"
    (t/is (= 1
             (:game-id (sut/parse-game "Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green"))))
    (t/is (= 3
             (:game-id (sut/parse-game "Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red")))))
  (t/testing "grap"
    (t/is (= {:blue 1 :green 2}
             (sut/->grab "1 blue, 2 green")))))

(t/deftest part-2-test
  (t/testing "part 2"
    (t/is (= 2286 (sut/part-2 input)))))

(comment

  (sut/part-1 "")
  (clojure.test/run-tests)
  (clojure.test/run-test part-1-test)
  ;;

  (re-find #"\d+" "Game 10"))
