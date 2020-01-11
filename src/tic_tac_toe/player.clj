(ns tic-tac-toe.player
  (:require
   [tic-tac-toe.board :as board]))

(def player-1 :x)

(def player-2 :o)

(defn won?
  ([player]
   (won? player board/winner-combinations))
  ([player winner-list]
   (let [is-player?    #(= % player)
         current-plays (map #(get-in board/board %) (first winner-list))]
     (when-not (empty? current-plays)
       (or
        (every? is-player? current-plays)
        (recur player (rest winner-list)))))))

