(ns tic-tac-toe.console.input)

(defn get-command!
  []
  (read-string (read-line)))
