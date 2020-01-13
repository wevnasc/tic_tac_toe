(ns tic-tac-toe.game-test
  (:require [clojure.test :refer :all]
            [tic-tac-toe.game :as game]))

(deftest play!
  (testing "player 1 should win the game"
    (game/start!)
    (game/play! [0 0])
    (game/play! [0 1])
    (game/play! [1 1])
    (game/play! [0 2])
    (is (= "The player :x is the winner!" (game/play! [2 2])))))

(deftest play!
  (testing "should return a error when position is invalid"
    (game/start!)
    (game/play! [0 0])
    (is (= "the position passed not is valid, plase try again" (game/play! [-1 0])))
    (is (= "the position passed not is valid, plase try again" (game/play! [0 0])))))
