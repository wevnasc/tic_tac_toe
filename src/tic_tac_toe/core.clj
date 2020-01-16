(ns tic-tac-toe.core
  (:gen-class)
  (:require [tic-tac-toe.game :as game]))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (game/play! [0 0])
  (game/play! [0 1])
  (game/play! [1 1])
  (game/play! [0 2])
  (game/play! [2 2]))

(-main)
