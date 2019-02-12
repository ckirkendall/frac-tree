(ns frac-tree.core
  (:require [quil.core :as q]
            [quil.middleware :as m]
            [cheshire.core :as json]
            [clojure.java.io :as io]))

(defn setup []
  (q/frame-rate 1))

(defn update-state [state]
  (let [file (io/as-file "frac-tree.json")]
    (when (.exists file)
      (println "loading file")
      (json/parse-string (slurp "frac-tree.json") true))))

(defn calc-line-points [angle [x y] length]
  (let [x-delta (* length (q/sin (q/radians angle)))
        y-delta (* length (q/cos (q/radians angle)))]
    [x
     y
     (+ x x-delta)
     (+ y y-delta)]))

(defn draw-branch [{:keys [stroke rotation length branches]}
                   angle
                   start]
  (let [new-angle (+ angle rotation)
        [x1 y1 x2 y2] (calc-line-points new-angle
                                        start
                                        length)]
    (q/stroke 255)
    (q/stroke-weight stroke)
    (q/line x1 y1 x2 y2)
    (doseq [branch branches]
      (draw-branch branch new-angle [x2 y2]))))

(defn draw-state [{:keys [tree start]}]
  (q/background 0)
  (when (and tree start)
    (draw-branch tree 0 start)))

(q/defsketch frac-tree
  :title "Tree"
  :size [500 500]
  :setup setup
  :update update-state
  :draw draw-state
  :features [:keep-on-top]
  :middleware [m/fun-mode])
