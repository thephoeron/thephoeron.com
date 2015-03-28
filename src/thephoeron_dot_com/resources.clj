(ns thephoeron-dot-com.resources
  (:use hiccup.core
        hiccup.element
        hiccup.form
        hiccup.page
        hiccup.util)
  (:require [thephoeron-dot-com.templates :as tmpl]))

(def quotes [{:quote "Of all that is written, I love only what a man has written with his blood.  Write with blood and you will find that blood is spirit." :author "Friedrich Nietzsche" :source "Thus Spake Zarathustra"}
             {:quote "Fear is the mind-killer." :author "Frank Herbert" :source "Dune"}
             {:quote "Still he'd see the matrix in his sleep, bright lattices of logic unfolding across that colorless void..." :author "William Gibson" :source "Neuromancer"}
             {:quote "Magic is dangerous or it is nothing." :author "William S. Burroughs" :source "Between Spaces"}
             {:quote "Free will is a golden thread running through the frozen matrix of fixed events." :author "Robert A. Heinlein" :source "The Rolling Stones"}])

(defn random-quote "Get a pseudo-random quote from QUOTES and render as HTML."
  []
  (let [q (rand-nth quotes)]
    (html5
     [:blockquote [:p (str (:quote q))]
      [:footer
       (if (:source q)
         (html5
          (:author q) ", "
          [:em (str (:source q) ".")])
         (html5 (:author q)))]])))

(defn splash "//thephoeron.com/ splash page"
  [req]
  (tmpl/default-page req {:title "Home"}
    (random-quote)))

(defn quantum-computing "//thephoeron.com/ quantum computing page"
  [req]
  (tmpl/default-page req {:title "Quantum Computing"}
    (html5
     [:h2 {:align "center"} "Quantum Computing"]
     [:p.lead "Quantum Hardware Designs:" [:br]
      [:small {:style "color: #777;"}
       "The VoRTeX Platform optical gate-model quantum computer" [:br]
       "The Philosopher's Stone optical&ndash;lattice quantum computer" [:br]
       "The Decoherence Machine" [:br]
       ]]
     [:p.lead "Quantum Computer Programming and Software Libraries:" [:br]
      [:small {:style "color: #777;"}
       "BRAKET/Φ, a Quantum/Classical Universal Computing Language:" [:br] [:a {:href "http://braket-phi.org/" :target "_blank"} "braket-phi.org"] [:br]
       "BLACK-STONE, specification and implementation of Quantum Common Lisp:" [:br] [:a {:href "http://github.com/thephoeron/black-stone" :target "_blank"} "github.com/thephoeron/black-stone"] [:br]
       "SILVER-SWORD, a Common Lisp interface to D-Wave's Python Pack:" [:br] [:a {:href "http://github.com/thephoeron/silver-sword" :target "_blank"} "github.com/thephoeron/silver-sword" [:br]]]]
     [:p.lead "Resources:" [:br]
      [:small
       [:a {:href "http://www.mathstat.dal.ca/~selinger/quipper/" :target "_blank"} "Quipper Quantum Programming Language"] [:br]
       [:a {:href "http://www.mathstat.dal.ca/~selinger/papers/" :target "_blank"} "Papers by Peter Selinger (incl., Quantum Lambda Calculus)"] [:br]]])))

(defn physics "//thephoeron.com/ physics page"
  [req]
  (tmpl/default-page req {:title "Physics"}
    (html5
     [:h2 {:align "center"} "Physics"]
     [:p.lead "Research and Projects:" [:br]
      [:small {:style "color: #777;"}
       "The Singularity Equation" [:br]
       "Producing Neutron-Degenerate Matter" [:br]
       "Quantum Properties of Optical Metamaterials" [:br]
       "Photonic Crystals" [:br]
       "Fusion and Fusors" [:br]
       "Home-made Particle Accelators" [:br]]]
     [:p.lead "Resources:" [:br]
      [:small {:style "color: #777;"}
       "M-Theory" [:br]
       "Quantum Mechanics" [:br]
       "Astrophysics" [:br]]])))

(defn programming "//thephoeron.com/ programming page"
  [req]
  (tmpl/default-page req {:title "Programming"}
    (html5
     [:h2 {:align "center"} "Programming &amp; Computer Science"]
     [:p.lead
      "Learn Lisp The Hard Way" [:br]
      [:small [:a {:href "http://learnlispthehardway.org" :target "_blank"} "learnlispthehardway.org"]]]
     [:p.lead
      "Comp-Sci Cabal" [:br]
      [:small [:a {:href "http://cscabal.com" :target "_blank"} "cscabal.com"]]])))

(defn linguistics "//thephoeron.com/ linguistics page"
  [req]
  (tmpl/default-page req {:title "Linguistics"}
    (html5
     [:h2 {:align "center"} "Languages &amp; Linguistics"]
     [:p.lead "Con-Langs:" [:br]
      [:small {:style "color: #777;"}
       [:a {:href "#" :data-toggle "modal" :data-target "#phoeronitic-modal"} "Grammar of Phoeronitic"] "(Returning Soon)"
       [:br]]]
     [:p.lead "Ancient Language Resources:" [:br]
      [:small {:style "color: #777;"}
       "Sumerian" [:br]
       "Akkadian" [:br]]]
     [:div#phoeronitic-modal.modal.fade {:tabindex "-1" :role "dialog" :aria-labelledby "phoeronitic-modal-label" :aria-hidden "true"}
      [:div.modal-dialog
       [:div.modal-content
        [:div.modal-header
         [:button.close {:type "button" :data-dismiss "modal" :aria-label "Close"}
          [:span {:aria-hidden "true"} "&times;"]]
         [:h4#phoeronitic-modal-label.modal-title "Grammar of Phoeronitic"]]
        [:div.modal-body
         [:p.lead "The Phoeronitic Con-Lang is an attempt at producing a strict, lexically defined universal language with a unified syntax and semantics.  It includes three modes of speech."]
         [:p "Unlike other human languages, it has been designed from the ground up to support deductive reasoning, quantitative analysis, formal logic, pithiness, and precision, allowing it to serve equally well for conversation, literature, formal proof, and computer programming."]
         [:p "The bulk of the work on the Phoeronitic Con-Lang was completed from 2007&ndash;2009."]]
        [:div.modal-footer
         [:button.btn.btn-danger {:type "button" :data-dismiss "modal"} "Close"]]]]])))

(defn philosophy "//thephoeron.com/ philosophy page"
  [req]
  (tmpl/default-page req {:title "Philosophy"}
    (html5
     [:h2 {:align "center"} "Philosophy"]
     [:p.lead "Neuro-Occultism"]
     [:p.lead "Phoeronism"]
     [:p.lead "Existential Nihilism"]
     [:p.lead "Crypto-Anarchy"]
     [:p.lead "The Hacker Ethos"])))

(defn music "//thephoeron.com/ music page"
  [req]
  (tmpl/default-page req {:title "Music"}
    (html5
     [:h2 {:align "center"} "Music / Discography"]
     [:p.lead "Albums"]
     [:p.lead "Compilations"])))

(defn art "//thephoeron.com/ art page"
  [req]
  (tmpl/default-page req {:title "Art"}
    (html5
     [:h2 {:align "center"} "Art: Paintings &amp; Illustrations"]
     [:p.lead "Paintings"]
     [:p.lead "Illustrations"]
     [:p.lead "Calligraphy"])))

(defn sci-fi "//thephoeron.com/ sci-fi page"
  [req]
  (tmpl/default-page req {:title "Sci-Fi"}
    (html5
     [:h2 {:align "center"} "Science-Fiction"]
     [:p.lead "Novels"]
     [:p.lead "Graphic Novels"])))

(defn impressum "//thephoeron.com/ impressum page"
  [req]
  (tmpl/default-page req {:title "Impressum"}
    (html5
     [:h2 {:align "center"} "Impressum"]
     [:p.lead "\"the Phoeron\" Colin J.E. Lupton"]
     [:p "Contact: " [:a {:href "mailto:sysop@thephoeron.com"} "sysop@thephoeron.com"]]
     [:p "IRC: " [:strong "ThePhoeron"] " on freenode #lisp #clojure #haskell"]
     [:p "Social Media: "
      [:a {:href "http://github.com/thephoeron" :target "_blank"} "GitHub"] ", "
      [:a {:href "http://twitter.com/thephoeron" :target "_blank"} "Twitter"] ", "
      [:a {:href "http://facebook.com/thephoerondotcom" :target "_blank"} "Facebook"] ", "
      [:a {:href "http://thephoeron.wordpress.com" :target "_blank"} "Art &amp; Philosophy Blog"] ", "
      [:a {:href "http://cjelupton.wordpress.com" :target "_blank"} "Developer Blog"] [:br]]
     [:p "&nbsp;"])))
