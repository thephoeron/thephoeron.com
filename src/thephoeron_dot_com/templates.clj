(ns thephoeron-dot-com.templates
  (:use hiccup.core
        hiccup.page))

(defn header "Page header template"
  [])

(defn footer "Page footer template"
  [])

(defn menu "Page menu template"
  [])

(defmacro default-page "Page template"
  [req {:keys [title]} & body]
  `(html5
    ~(header)
    ~(menu)
    ~@body
    ~(footer)))
