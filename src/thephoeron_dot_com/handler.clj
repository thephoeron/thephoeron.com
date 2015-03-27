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
                             [credentials :as creds])
            [thephoeron-dot-com.resources :as res]))

(defroutes app-routes
  (GET "/" [req] (res/splash req))
  (GET "/quantum-computing" [req] (res/quantum-computing req))
  (GET "/physics" [] "Theoretical Physics")
  (GET "/programming" [] "Programming and Computer Science")
  (GET "/linguistics" [] "Linguistics and Languages")
  (GET "/philosophy" [] "Philosophy")
  (GET "/music" [] "Music")
  (GET "/art" [] "Art")
  (GET "/sci-fi" [] "Science-Fiction")
  (GET "/impressum" [] "Impressum")
  (route/resources "/static")
  (route/not-found "Not Found"))

(defn -main []
  (run-server (reload/wrap-reload (handler/site #'app-routes)) {:port 8080}))
