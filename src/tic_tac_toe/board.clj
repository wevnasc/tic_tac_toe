(ns tic-tac-toe.board)

(def empty-board
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
  [board position value]
  (let [fit?            (every? valid-board-value? position)
        position-empty? (nil? (get-in board position))]
    (when (and fit? position-empty?)
      (assoc-in board position value))))

