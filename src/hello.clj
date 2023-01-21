(ns hello 
  (:require [cheshire.core :as ch]
            [ring.adapter.jetty :as jt]))

; sum function
(defn m [x y] (+ x y))
(defn sum0 [v] (reduce m v))
 
; generate json string for socket output
(defn gg [x] (ch/generate-string (sum0 (ch/parse-string x))))

; handler
(defn handler [request]
  {:status 200
   :headers {"Content-Type" "application/json"}
   :body (:body request)})

; middleware that's include gg function on body
(defn wrap-gg [handler]
  (fn [request]
    (let [response (handler request)
          bb (:body response)
          cc (slurp bb)] ;; "[1,2,3]"
      (assoc-in response [:body] (gg cc)))))

; app
(def app 
(wrap-gg handler))

; run server
(defn run []
  (jt/run-jetty app {:port 3000
                         :join? false})
  )
