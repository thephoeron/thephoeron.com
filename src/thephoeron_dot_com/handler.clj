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
     [:script (str analytics)]]
    [:body
     [:h2 {:align "center"} "//thephoeron.com/"]]]))

(defroutes app-routes
  (GET "/" [req] (splash req))
  (route/not-found "Not Found"))

(defn -main []
  (run-server (reload/wrap-reload (handler/site #'app-routes)) {:port 8080}))
