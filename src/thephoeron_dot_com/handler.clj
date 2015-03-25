(ns thephoeron-dot-com.handler
  (:use org.httpkit.server
        hiccup.core
        hiccup.page)
  (:require [ring.middleware.reload :as reload]
            [compojure.core :refer :all]
            [compojure.handler :as handler]
            [compojure.route :as route]
            [cheshire.core :refer :all]
            [cemerick.friend :as friend]
            (cemerick.friend [workflows :as workflows]
                             [credentials :as creds])))

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
     (include-css "//maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css"
                  "//maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css"
                  "/static/main.css")
     [:script (str analytics)]]
    [:body
     [:div#splash
      [:span#helper]
      [:div#img
       [:img {:src "/static/thephoeron-logo-2015.png"}]
       [:p
        "[ "
        [:a#dialog {:href "#"} "Programming"] " | "
        [:a#dialog {:href "#"} "Music"] " | "
        [:a#dialog {:href "#"} "Art"] " | "
        [:a#dialog {:href "#"} "Writing"] " | "
        [:a#dialog {:href "#"} "Linguistics"] " | "
        [:a#dialog {:href "#"} "Papers"] " | "
        [:a#dialog {:href "#"} "Impressum"]
        " ]"]
       [:p "Copyright &copy; 2004&ndash;2015,\"the Phoeron\" Colin J.E. Lupton. All Rights Reserved."]]]
     (include-js "//code.jquery.com/jquery-1.11.0.min.js"
                 "//maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"
                 "/static/main.js")]]))

(defroutes app-routes
  (GET "/" [req] (splash req))
  (route/resources "/static")
  (route/not-found "Not Found"))

(defn -main []
  (run-server (reload/wrap-reload (handler/site #'app-routes)) {:port 8080}))
