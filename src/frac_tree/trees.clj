(ns frac-tree.trees
  (:require [cheshire.core :as json]))

(def static-tree
  {:start [250 0]
   :tree {:stroke 3
          :rotation 0
          :length 100
          :branches [{:stroke 3
                      :rotation 30
                      :length 60
                      :branches [{:stroke 3
                                  :rotation 30
                                  :length 60}
                                 {:stroke 3
                                  :rotation -30
                                  :length 60}]}
                     {:stroke 3
                      :rotation -30
                      :length 60
                      :branches [{:stroke 3
                                  :rotation 10
                                  :length 60}
                                 {:stroke 3
                                  :rotation -30
                                  :length 60}]}]}})

(defn write-out-tree [tree]
  (let [js-tree (json/generate-string tree)]
    (spit "frac-tree.json" js-tree)))
