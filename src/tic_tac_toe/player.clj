(ns tic-tac-toe.player)

(def player-1 :x)

(def player-2 :o)

(def winner-combinations
  [[[0 0] [0 1] [0 2]]
   [[1 0] [1 1] [1 2]]
   [[2 0] [2 1] [2 2]]
   [[0 0] [1 0] [2 0]]
   [[0 1] [1 1] [2 1]]
   [[0 2] [1 2] [2 2]]
   [[0 0] [1 1] [2 2]]
   [[2 0] [1 1] [0 2]]])

(defn won?
  ([board player]
   (won? board player winner-combinations))
  ([board player winner-list]
   (let [is-player?    #(= % player)
         current-plays (map #(get-in board %) (first winner-list))]
     (when-not (empty? current-plays)
       (or
        (every? is-player? current-plays)
        (recur board player (rest winner-list)))))))

