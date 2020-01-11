(ns tic-tac-toe.player-test
  (:require [clojure.test :refer [is deftest testing]]
            [tic-tac-toe.player :as player]
            [tic-tac-toe.board :as board]))

(deftest player-win
  (testing "when play the same value on horizontal"
    (with-redefs [board/board [[:x, :x, :x] [nil, nil, nil] [nil, nil, nil]]]
      (is (player/won? :x)))
    (with-redefs [board/board [[nil, nil, nil] [:x, :x, :x] [nil, nil, nil]]]
      (is (player/won? :x)))
    (with-redefs [board/board [[nil, nil, nil] [nil, nil, nil] [:x, :x, :x]]]
      (is (player/won? :x))))

  (testing "when play the same value on vertical"
    (with-redefs [board/board [[:x, nil, nil] [:x, nil, nil] [:x, nil, nil]]]
      (is (player/won? :x)))
    (with-redefs [board/board [[nil, :x, nil] [nil, :x, nil] [nil, :x, nil]]]
      (is (player/won? :x)))
    (with-redefs [board/board [[nil, nil, :x] [nil, nil, :x] [nil, nil, :x]]]
      (is (player/won? :x))))

  (testing "when play the same value on diagonal and oposite diagonal"
    (with-redefs [board/board [[:x, nil, nil] [nil, :x, nil] [nil, nil, :x]]]
      (is (player/won? :x)))
    (with-redefs [board/board [[nil, nil, :x] [nil, :x, nil] [:x, nil, nil]]]
      (is (player/won? :x)))))

(deftest player-not-win
  (testing "when play values that not match with a diagonal horizontal or vertical"
    (with-redefs [board/board [[nil, :x, :x] [nil, nil, nil] [nil, nil, nil]]]
      (is (not (player/won? :x))))
    (with-redefs [board/board [[:x, nil, nil] [nil, :x, :x] [nil, :x, nil]]]
      (is (not (player/won? :x))))
    (with-redefs [board/board [[:x, nil, nil] [:x, nil, nil] [nil, :x, :x]]]
      (is (not (player/won? :x))))))
