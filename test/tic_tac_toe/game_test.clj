(ns tic-tac-toe.game-test
  (:require [clojure.test :refer :all]
            [tic-tac-toe.game :as game]))

(deftest play!
  (testing "player 1 should win the game"
    (#'game/restart!)
    (game/play! [0 0])
    (game/play! [0 1])
    (game/play! [1 1])
    (game/play! [0 2])
    (is (= {:board [[:x :o :o] [nil :x nil] [nil nil :x]]
            :message "the position passed not is valid, plase try again"}
           (game/play! [2 2])))))

(deftest play!
  (testing "should return a error when position is invalid"
    (#'game/restart!)
    (game/play! [0 0])
    (is (= {:board [[:x nil nil] [nil nil nil] [nil nil nil]]
            :message "the position passed not is valid, plase try again"}
           (game/play! [-1 0])))
    (is (= {:board [[:x nil nil] [nil nil nil] [nil nil nil]]
            :message "the position passed not is valid, plase try again"}
           (game/play! [0 0])))))
