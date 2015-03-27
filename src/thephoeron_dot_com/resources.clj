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
             {:quote "Magic is dangerous or it is nothing." :author "William S. Burroughs" :source "Between Spaces"}])

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
     [:p.lead "Returning Soon"])))

(defn physics "//thephoeron.com/ physics page"
  [req]
  (tmpl/default-page req {:title "Physics"}
    (html5
     [:h2 {:align "center"} "Theoretical Physics"]
     [:p.lead "Returning Soon"])))

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
     [:p.lead "Returning Soon"])))

(defn philosophy "//thephoeron.com/ philosophy page"
  [req]
  (tmpl/default-page req {:title "Philosophy"}
    (html5
     [:h2 {:align "center"} "Philosophy"]
     [:p.lead "Returning Soon"])))

(defn music "//thephoeron.com/ music page"
  [req]
  (tmpl/default-page req {:title "Music"}
    (html5
     [:h2 {:align "center"} "Music / Discography"]
     [:p.lead "Returning Soon"])))

(defn art "//thephoeron.com/ art page"
  [req]
  (tmpl/default-page req {:title "Art"}
    (html5
     [:h2 {:align "center"} "Art: Paintings &amp; Illustrations"]
     [:p.lead "Returning Soon"])))

(defn sci-fi "//thephoeron.com/ sci-fi page"
  [req]
  (tmpl/default-page req {:title "Sci-Fi"}
    (html5
     [:h2 {:align "center"} "Science-Fiction"]
     [:p.lead "Returning Soon"])))

(defn impressum "//thephoeron.com/ impressum page"
  [req]
  (tmpl/default-page req {:title "Impressum"}
    (html5
     [:h2 {:align "center"} "Impressum"]
     [:p.lead "Returning Soon"])))
