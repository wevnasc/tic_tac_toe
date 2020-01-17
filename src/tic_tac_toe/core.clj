(ns tic-tac-toe.core
  (:gen-class)
  (:require [tic-tac-toe.game :as game]))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (game/start!))
