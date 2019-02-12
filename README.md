# frac-tree

A Quil sketch designed for CincyFP kata night.

## KATA Description

The goal of this kata is to build the best fractal tree possible using
functional techniques.

The system is setup to so that you can use any language and this code
will render the tree for you automatically.  Once launched this will
try to load the file frac-tree.json each second and display the
results.  This allows you to use any language to generate the json
file while not worrying about how the code to actually draw the tree.

This is a sample of a static tree with two branches in `edn` format.

```clj
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
                                  :length 60}]}]}}
```

## Usage

REPL - run `(require 'frac-tree.core)`.

## License

Copyright © 2016 Creighton Kirkendall

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
