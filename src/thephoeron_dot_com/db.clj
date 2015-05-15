(ns thephoeron-dot-com.db
  (:require [clojure.java.jdbc :as jdbc]
            [honeysql.core :as sql]
            [honeysql.helpers :as helpers]
            [clojure.string :as str]
            [validateur.validation :refer :all]
            [crypto.random :as crypto])
  (:import java.sql.DriverManager))

(def cred (slurp (-> (java.io.File. "cred.txt") .getAbsolutePath)))

(def db {:subprotocol "postgresql"
         :subname "//localhost/thephoeron"
         :username "thephoeron"
         :password cred})
       
;; Users, Roles, Sessions

;; Pages

(defn create-page-table []
  (jdbc/create-table-ddl
   :pages
   [:id :serial "PRIMARY KEY"]
   [:title :text]
   [:slug :text]
   [:content :text]
   [:plaintext :text]
   [:user_id :serial "references users (id)"]
   [:last_modified :timestamp "NOT NULL" "DEFAULT CURRENT_TIMESTAMP"]
   [:created_at :timestamp "NOT NULL" "DEFAULT CURRENT_TIMESTAMP"]))

;; Blog Posts

