(ns tic-tac-toe.game
  (:require [tic-tac-toe.board :as board]
            [tic-tac-toe.player :as player]
            [tic-tac-toe.console.input :as console.input]
            [tic-tac-toe.console.output :as console.output]))

(def ^:private empty-state
  {:board board/empty-board
   :player player/player-1})

(def ^:private state
  (atom empty-state))

(defn ^:private restart!
  []
  (swap! state merge empty-state))

(defn play!
  [position]
  (let [{:keys [board player]} @state
        updated-board          (board/update-board board position player)
        next-player            (player/switch-player player)
        player-won?            (player/won? updated-board player)]
    (cond
      (nil? updated-board) (board/board->result board "the position passed not is valid, plase try again")
      (true? player-won?)  (board/board->result updated-board (str "The player " (name player) " is the winner!"))
      :else                (do (swap! state merge {:board updated-board :player next-player})
                               (board/board->result updated-board)))))
(defn start!
  []
  (loop [command (console.input/get-command!)]
    (case command
      :restart (do (restart!)
                   (recur (console.input/get-command!)))
      :exit nil
      (do
        (console.output/print-pretty-result! (play! command))
        (recur (console.input/get-command!))))))
