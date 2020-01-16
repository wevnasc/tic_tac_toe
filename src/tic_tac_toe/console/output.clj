(ns tic-tac-toe.console.output)

(defn ^:private print-pretty-board!
  [board]
  (doseq [lines board]
    (->> lines
         (map #(if (nil? %) " " (name %)))
         println)))

(defn print-pretty-result!
  [{:keys [board message]}]
  (println (str "message: " message))
  (print-pretty-board! board))
