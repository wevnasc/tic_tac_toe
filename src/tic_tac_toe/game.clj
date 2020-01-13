(ns tic-tac-toe.game
  (:require [tic-tac-toe.board :as board]
            [tic-tac-toe.player :as player]
            [clojure.pprint :as p]))

(def empty-state
  {:board board/empty-board
   :player player/player-1})

(def state
  (atom empty-state))

(defn start!
  []
  (swap! state merge empty-state))

(defn play!
  [position]
  (let [{:keys [board player]} @state
        updated-board          (board/update-board board position player)
        next-player            (player/switch-player player)
        player-won?            (player/won? updated-board player)]
    (cond
      (nil? updated-board) "the position passed not is valid, plase try again"
      (true? player-won?)  (str "The player " player " is the winner!")
      :else                (swap! state merge {:board updated-board :player next-player}))))
