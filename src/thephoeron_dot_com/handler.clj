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

(defroutes app-routes
  (GET "/" [] "ThePhoeron.com")
  (route/not-found "Not Found"))

(defn -main []
  (run-server (reload/wrap-reload (handler/site #'app-routes)) {:port 8080}))
