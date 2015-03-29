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
     [:p.lead "Quantum Hardware Designs:"]
     [:p "The VoRTeX Platform (patents pending): " [:br]
      [:span {:style "color: #777;"} "Optical Gate-Model End-User Hybrid Quantum/Classical Computer."]]
     [:p "The Philosopher's Stone (patents pending): " [:br]
      [:span {:style "color: #777;"} "Optical&ndash;Lattice experimental Quantum Computer."]]
     [:p "The Decoherence Machine (patents pending): " [:br]
      [:span {:style "color: #777;"} "Experimental Field-Distortion Lattice-Machine with Observable Quantum Effects."]]
     [:p "&nbsp;"]
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
         [:p.lead "The Phoeronitic Con-Lang is an attempt at producing a strict, lexically defined universal language with a unified syntax and semantics.  It includes three modes of speech and an agglutinative root-based morphology."]
         [:p "Unlike other human languages, it has been designed from the ground up to be concise and precise, and supports deductive reasoning, quantitative analysis, and formal logic, allowing it to serve equally well for conversation, literature, quantitative and qualitative proofs, and computer programming."]
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
     [:p "DTRASH113.3 &mdash; Subjective Variables (2012)" [:br]
      [:span {:style "color: #777;"} "Available on: "]
      [:a {:href "https://d-trashrecords.bandcamp.com/album/dtrash1133-subjective-variables" :target "_blank"} "Bandcamp"] ", "
      [:a {:href "https://itunes.apple.com/ca/album/subjective-variables/id795199434" :target "_blank"} "iTunes"] ", "
      [:a {:href "http://www.amazon.com/gp/product/B00HZNLIXI/ref=as_li_tl?ie=UTF8&camp=1789&creative=390957&creativeASIN=B00HZNLIXI&linkCode=as2&tag=thephoeroncom-20&linkId=PLBDEI4V77ACZLE3" :target "_blank"} "Amazon"] "."]
     [:p "DTRASH113.2 &mdash; BLUTGEIST: Symphony No. 2 (2008)" [:br]
      [:span {:style "color: #777;"} "Available on: "]
      [:a {:href "https://d-trashrecords.bandcamp.com/album/dtrash1132-blutgeist-symphony-no-2" :target "_blank"} "Bandcamp"] ", "
      [:a {:href "https://itunes.apple.com/ca/album/blutgeist-symphony-no.-2/id298634632" :target "_blank"} "iTunes"] ", "
      [:a {:href "http://www.amazon.com/gp/product/B001N9QDY4/ref=as_li_tl?ie=UTF8&camp=1789&creative=390957&creativeASIN=B001N9QDY4&linkCode=as2&tag=thephoeroncom-20&linkId=RR4OFMKG3V73JQA4" :target "_blank"} "Amazon"] "."]
     [:p "DTRASH113.1 &mdash; Universal Equation (2008)" [:br]
      [:span {:style "color: #777;"} "Available on: "]
      [:a {:href "https://d-trashrecords.bandcamp.com/album/dtrash1131-universal-equation" :target "_blank"} "Bandcamp"] ", "
      [:a {:href "https://itunes.apple.com/ca/album/universal-equation/id298634396" :target "_blank"} "iTunes"] ", "
      [:a {:href "http://www.amazon.com/gp/product/B001N9CP00/ref=as_li_tl?ie=UTF8&camp=1789&creative=390957&creativeASIN=B001N9CP00&linkCode=as2&tag=thephoeroncom-20&linkId=OKWZO2D5ZQKYJOLP" :target "_blank"} "Amazon"] "."]
     [:p "DTRASH082 &mdash; l'Ambiençe: Symphony No. 1 (2006)" [:br]
      [:span {:style "color: #777;"} "Available on: "]
      [:a {:href "https://d-trashrecords.bandcamp.com/album/dtrash082-lambient-ep" :target "_blank"} "Bandcamp"] ", "
      [:a {:href "https://itunes.apple.com/ca/album/lambience-symphony-no.-1/id289406045" :target "_blank"} "iTunes"] ", "
      [:a {:href "http://www.amazon.com/gp/product/B001GMK1IC/ref=as_li_tl?ie=UTF8&camp=1789&creative=390957&creativeASIN=B001GMK1IC&linkCode=as2&tag=thephoeroncom-20&linkId=JXPDP7A2XWGOEEOL" :target "_blank"} "Amazon"] "."]
     [:p "DTRASH075 &mdash; The Church of the Phoeron of Latter-day Satanists (2005)" [:br]
      [:span {:style "color: #777;"} "Available on: "]
      [:a {:href "https://d-trashrecords.bandcamp.com/album/dtrash075-the-church-of-the-phoeron-of-the-latter-day-satanists" :target "_blank"} "Bandcamp"] ", "
      [:a {:href "https://itunes.apple.com/ca/album/church-phoeron-latter-day/id289428020" :target "_blank"} "iTunes"] ", "
      [:a {:href "http://www.amazon.com/gp/product/B001GL2GEK/ref=as_li_tl?ie=UTF8&camp=1789&creative=390957&creativeASIN=B001GL2GEK&linkCode=as2&tag=thephoeroncom-20&linkId=4CBP2CCRQZRBOOES" :target "_blank"} "Amazon"] "."]
     [:p "DTRASH060 &mdash; The ABSU Meditations (2004)" [:br]
      [:span {:style "color: #777;"} "Available on: "]
      [:a {:href "https://d-trashrecords.bandcamp.com/album/dtrash060-the-absu-meditations" :target "_blank"} "Bandcamp"] ", "
      [:a {:href "https://itunes.apple.com/ca/album/the-absu-meditations/id263633477" :target "_blank"} "iTunes"] ", "
      [:a {:href "http://www.amazon.com/gp/product/B000WKWNFS/ref=as_li_tl?ie=UTF8&camp=1789&creative=390957&creativeASIN=B000WKWNFS&linkCode=as2&tag=thephoeroncom-20&linkId=ISM6YL4327X7ISS3" :target "_blank"} "Amazon"] "."]
     [:p "&nbsp;"]
     [:p.lead "Compilations"]
     [:p "DTRASH200 &mdash; Trash the World (2015)" [:br]
      [:span {:style "color: #777;"} "Available on: "]
      [:a {:href "https://d-trashrecords.bandcamp.com/album/dtrash200-trash-the-world" :target "_blank"} "Bandcamp"] ", "
      [:a {:href "http://www.amazon.com/gp/product/B00TLQLD0A/ref=as_li_tl?ie=UTF8&camp=1789&creative=390957&creativeASIN=B00TLQLD0A&linkCode=as2&tag=thephoeroncom-20&linkId=OYFA4E7LE6EV5J36" :target "_blank"} "Amazon"] "."]
     [:p "DTECH07 &mdash; The Virus Has Been Spread (2007)" [:br]
      [:span {:style "color: #777;"} "Available on: "]
      [:a {:href "https://d-trashrecords.bandcamp.com/album/dtech07-the-virus-has-been-spread" :target "_blank"} "Bandcamp"] ", "
      [:a {:href "https://itunes.apple.com/ca/album/virus-has-been-spread-tribute/id261180829" :target "_blank"} "iTunes"] ", "
      [:a {:href "http://www.amazon.com/gp/product/B000WKPH4M/ref=as_li_tl?ie=UTF8&camp=1789&creative=390957&creativeASIN=B000WKPH4M&linkCode=as2&tag=thephoeroncom-20&linkId=F2TTHUSR7JYAZOP2" :target "_blank"} "Amazon"] "."]
     [:p "&nbsp;"])))

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
