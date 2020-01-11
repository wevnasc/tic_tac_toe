(ns tic-tac-toe.board)

(def board
  [[nil, nil, nil]
   [nil, nil, nil]
   [nil, nil, nil]])

(defn ^:private range-validator
  [min max]
  (fn [value]
    (and
     (>= value min)
     (<= value max))))

(def ^:private valid-board-value?
  (range-validator 0 2))

(defn update-board
  [board [x y] value]
  (when (every? valid-board-value? [x y])
    (assoc-in board [x y] value)))

