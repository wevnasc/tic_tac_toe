(ns tic-tac-toe.board)

(def board
  [[nil, nil, nil]
   [nil, nil, nil]
   [nil, nil, nil]])

(def winner-combinations
  [[[0 0] [0 1] [0 2]]
   [[1 0] [1 1] [1 2]]
   [[2 0] [2 1] [2 2]]
   [[0 0] [1 0] [2 0]]
   [[0 1] [1 1] [2 1]]
   [[0 2] [1 2] [2 2]]
   [[0 0] [1 1] [2 2]]
   [[2 0] [1 1] [0 2]]])

(defn ^:private range-validator
  [min max]
  (fn [value]
    (and
     (>= value min)
     (<= value max))))

(def ^:private valid-board-value?
  (range-validator 0 2))

(defn update
  [value [x y]]
  (when (every? valid-board-value? [x y])
    (assoc-in board [x y] value)))

