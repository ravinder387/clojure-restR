# clojure-restR
this is demo to call clojure from R programming by rest api <br>

### Intro <br>
This code entirely written using ring-clojure libray which handle http request mainly. It is not full http server <br>
it doesn't provide router, many things. It is kind a subset http server you can use this to build own web server <br>
web framework, internet based application. It's just like low-level http server. It provide few middleware to work <br>
In this code I wrote my own middleware. Clojure is very simple language with uniform syntax most of libraries written <br>
using mostly functions only. In clojure Ist priority given to data not anythingelse Data > Function > Macros <br> <br>

### How to use <br>
We can use this code by REPL, war, jar, aot compilation, graalvm native code, docker...etc Most easiest way to use REPL<br>
**under clojure-restR open terminal:- window os demo** <br>
C:\Users\ravi > clj <br>
C:\Users\ravi > (require '[hello]) <br>
C:\Users\ravi > (hello/run) <br>

** call in R ** <br>
```{r}
library(httr)
library(jsonlite)

url <- "http://localhost:3000"
d <- rnorm(1000000)
j <- toJSON(d)

# post request
req <- POST(url, body = j, encode = "json")

# response
res <- content(req, type = "text", encoding = "UTF-8")
res <- fromJSON(res)
res
