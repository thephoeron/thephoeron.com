(ns thephoeron-dot-com.db
  (:require [clojure.java.jdbc :as jdbc]
            [honeysql.core :as sql]
            [honeysql.helpers :as helpers]
            [clojure.string :as str]
            [validateur.validation :refer :all]
            [crypto.random :as crypto])
  (:import java.sql.DriverManager))

