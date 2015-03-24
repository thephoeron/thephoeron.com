(defproject thephoeron_dot_com "0.1.0-SNAPSHOT"
  :description "thephoeron.com: official website of the Phoeron"
  :url "http://thephoeron.com/"
  :min-lein-version "2.0.0"
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [org.clojure/clojurescript "0.0-2322"]
                 [org.clojure/core.async "0.1.319.0-6b1aca-alpha"]
                 [org.clojure/java.jdbc "0.3.6"]
                 [org.postgresql/postgresql "9.4-1201-jdbc4"]
                 [compojure "1.3.1"]
                 [ring/ring-devel "1.3.2"]
                 [http-kit "2.1.16"]
                 [cheshire "5.4.0"]
                 [hiccup "1.0.5"]
                 [com.cemerick/friend "0.2.1"]
                 [jayq "2.5.2"]]
  :main thephoeron-dot-com.handler
  :plugins [[lein-cljsbuild "1.0.3"]]
  :profiles
  {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                        [ring-mock "0.1.5"]]}}
  :cljsbuild {:builds [{:source-paths ["src-cljs"]
                        :compiler {:output-to "resources/public/main.js"
                                   :optimizaton :simple
                                   :pretty-print true}}]})
