(ns thephoeron-dot-com.templates
  (:use hiccup.core
        hiccup.page))

(def analytics "

  var _gaq = _gaq || [];
  _gaq.push(['_setAccount', 'UA-27928725-1']);
  _gaq.push(['_trackPageview']);

  (function() {
    var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;
    ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
    var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);
  })();

")

(defn splash "//thephoeron.com/ splash page"
  [req]
  (html5
   [:html {:lang "en"}
    [:head
     [:title "//thephoeron.com/"]
     [:meta {:name "google-site-verification" :content "Mf7fBrgJF0NG9VHWGpDrtDXJntkz7HdvXjO_41AS0d8"}]
     (include-css "//maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css"
                  "//maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css"
                  "/static/main.css")
     [:script (str analytics)]]
    [:body
     [:div#splash
      [:span#helper]
      [:div#img
       [:img {:src "/static/thephoeron-logo-2015.png" :alt "//thephoeron.com/"}]
       [:p {:style "font-size: 14px;"}
        "[ "
        [:a#dialog {:href "/quantum-computing"} "Quantum Computing"] " | "
        [:a#dialog {:href "/physics"} "Physics"] " | "
        [:a#dialog {:href "/programming"} "Programming"] " | "
        [:a#dialog {:href "/linguistics"} "Linguistics"] " | "
        [:a#dialog {:href "/philosophy"} "Philosophy"] " | "
        [:a#dialog {:href "/music"} "Music"] " | "
        [:a#dialog {:href "/art"} "Art"] " | "
        [:a#dialog {:href "/sci-fi"} "Sci-Fi"] " | "
        [:a#dialog {:href "/impressum"} "Impressum"]
        " ]"]
       [:p {:style "font-size: 12px;"}
        "Copyright &copy; 2004&ndash;2015,\"the Phoeron\" Colin J.E. Lupton. All Rights Reserved. Powered by "
        [:a {:href "http://clojure.org" :target "_blank"} "Clojure"] " and "
        [:a {:href "https://www.digitalocean.com/?refcode=ef3cf1ffcbb7" :target "_blank"} "Digital Ocean"] "."]]]
     (include-js "//code.jquery.com/jquery-1.11.0.min.js"
                 "//maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"
                 "/static/main.js")]]))

(defn header "Page header template"
  [])

(defn footer "Page footer template"
  [])

(defn menu "Page menu template"
  [])

(defmacro default-page "Page template"
  [req {:keys [title]} & body]
  `(html5 {:lang "en"}
    [:body
     ~(header)
     ~(menu)
     ~@body
     ~(footer)]))
