(ns aoc.2024.04-test
  (:require [aoc.2024.04 :as sut]
            [clojure.test :as t]))

(def input "MMMSXXMASM
MSAMXMSMSA
AMXSXMAAMM
MSAMASMSMX
XMASAMXAMM
XXAMMXXAMA
SMSMSASXSS
SAXAMASAAA
MAMMMXMMMM
MXMXAXMASX")

(t/deftest part-1-test
  (t/testing 'char-match?
    (t/is (sut/char-match? (sut/->data input) \X 0 5))
    (t/is (sut/char-match? (sut/->data input) \M 0 6))
    (t/is (sut/char-match? (sut/->data input) \A 0 7))
    (t/is (sut/char-match? (sut/->data input) \S 0 8))
    (t/is (sut/char-match? (sut/->data input) \X 5 0)))

  (t/testing 'xmas-count
    (t/is (= 2 (sut/xmas-count (sut/->data input) 3 9)))
    (t/is (= 3 (sut/xmas-count (sut/->data input) 9 5)))
    (t/is (= 2 (sut/xmas-count (sut/->data input) 9 9))))

  (t/testing 'xmas?
    (t/is (sut/xmas? (sut/->data input) 0 5) "forwards")
    (t/is (sut/xmas? (sut/->data input) 1 4) "backwards")
    (t/is (sut/xmas? (sut/->data input) 9 9) "up")
    (t/is (sut/xmas? (sut/->data input) 3 9) "down")

    (t/is (sut/xmas? (sut/->data input) 0 4) "SE")
    (t/is (sut/xmas? (sut/->data input) 3 9) "SW")
    (t/is (sut/xmas? (sut/->data input) 9 3) "NE")
    (t/is (sut/xmas? (sut/->data input) 9 9) "NW")
    (t/is (not (sut/xmas? (sut/->data input) 0 0)))

    ;;
    )

  (t/testing 'integration
    (t/is (= (sut/part-1 input) 18))))

(def input2 ".M.S......
..A..MSMS.
.M.S.MAA..
..A.ASMSM.
.M.S.M....
..........
S.S.S.S.S.
.A.A.A.A..
M.M.M.M.M.
..........")

(t/deftest part-2-test

  (t/testing 'x-mas?
    (t/is (not (sut/x-mas? (sut/->data "S.S\n.A.\nS.M") 1 1)) "M-s right")
    (t/is (not (sut/x-mas? (sut/->data "S.S\n.A.\nM.S") 1 1)) "M-s left")
    (t/is (not (sut/x-mas? (sut/->data "S.M\n.A.\nS.S") 1 1)) "M-s top")
    (t/is (not (sut/x-mas? (sut/->data "M.S\n.A.\nM.M") 1 1)) "M-s bottom")
    (t/is (sut/x-mas? (sut/->data "S.M\n.A.\nS.M") 1 1) "M-s right")
    (t/is (sut/x-mas? (sut/->data "M.S\n.A.\nM.S") 1 1) "M-s left")
    (t/is (sut/x-mas? (sut/->data "M.M\n.A.\nS.S") 1 1) "M-s top")
    (t/is (sut/x-mas? (sut/->data "S.S\n.A.\nM.M") 1 1) "M-s bottom")
    (t/is (sut/x-mas? (sut/->data input) 1 2) "M-s left")
    (t/is (sut/x-mas? (sut/->data input) 3 4) "M-s right")
    (t/is (sut/x-mas? (sut/->data input) 2 6) "M-s top")
    (t/is (sut/x-mas? (sut/->data input) 2 7) "M-s top 2")
    (t/is (sut/x-mas? (sut/->data input) 7 3) "M-s bottom"))
  (t/testing 'integration
    (t/is (= (sut/part-2 input2) 9))))


