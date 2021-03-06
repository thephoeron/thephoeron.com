(ns thephoeron-dot-com.handler
  (:use org.httpkit.server
        hiccup.core
        hiccup.page)
  (:require [compojure.core :refer :all]
            [compojure.handler :as handler]
            [compojure.route :as route]
            [cheshire.core :refer :all]
            [cemerick.friend :as friend]
            (cemerick.friend [workflows :as workflows]
                             [credentials :as creds])
            [thephoeron-dot-com.resources :as res]))

(defroutes app-routes
  (GET "/" [req] (res/splash req))
  (GET "/quantum-computing" [req] (res/quantum-computing req))
  (GET "/physics" [req] (res/physics req))
  (GET "/programming" [req] (res/programming req))
  (GET "/linguistics" [req] (res/linguistics req))
  (GET "/philosophy" [req] (res/philosophy req))
  (GET "/music" [req] (res/music req))
  (GET "/art" [req] (res/art req))
  (GET "/sci-fi" [req] (res/sci-fi req))
  (GET "/impressum" [req] (res/impressum req))
  (route/not-found "Not Found"))

(defn -main []
  (run-server (handler/site #'app-routes) {:port 8080})
  (println "Server started on port 8080..."))
