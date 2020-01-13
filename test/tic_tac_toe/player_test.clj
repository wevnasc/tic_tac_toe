(ns tic-tac-toe.player-test
  (:require [tic-tac-toe.player :as player]
            [clojure.test :refer [is deftest testing]]))

(deftest player-win
  (testing "when play the same value on horizontal"
    (let [board [[:x, :x, :x] [nil, nil, nil] [nil, nil, nil]]]
      (is (player/won? board :x)))
    (let [board [[nil, nil, nil] [:x, :x, :x] [nil, nil, nil]]]
      (is (player/won? board :x)))
    (let [board [[nil, nil, nil] [nil, nil, nil] [:x, :x, :x]]]
      (is (player/won? board :x))))

  (testing "when play the same value on vertical"
    (let [board [[:x, nil, nil] [:x, nil, nil] [:x, nil, nil]]]
      (is (player/won? board :x)))
    (let [board [[nil, :x, nil] [nil, :x, nil] [nil, :x, nil]]]
      (is (player/won? board :x)))
    (let [board [[nil, nil, :x] [nil, nil, :x] [nil, nil, :x]]]
      (is (player/won? board :x))))

  (testing "when play the same value on diagonal and oposite diagonal"
    (let [board [[:x, nil, nil] [nil, :x, nil] [nil, nil, :x]]]
      (is (player/won? board :x)))
    (let [board [[nil, nil, :x] [nil, :x, nil] [:x, nil, nil]]]
      (is (player/won? board :x)))))

(deftest player-not-win
  (testing "when play values that not match with a diagonal horizontal or vertical"
    (let [board [[nil, :x, :x] [nil, nil, nil] [nil, nil, nil]]]
      (is (not (player/won? board :x))))
    (let [board [[:x, nil, nil] [nil, :x, :x] [nil, :x, nil]]]
      (is (not (player/won? board :x))))
    (let [board [[:x, nil, nil] [:x, nil, nil] [nil, :x, :x]]]
      (is (not (player/won? board :x))))))

(deftest switch-player
  (testing "to player 1"
    (is (= player/player-1 (player/switch-player player/player-2))))
  (testing "to player 2"
    (is (= player/player-2 (player/switch-player player/player-1)))))
