# clojure-restR
this is demo to call clojure from R programming by rest api <br>

### Intro <br>
This code entirely written using ring-clojure libray which handle http request mainly. It is not full http server <br>
it doesn't provide router, and many things. It is kind a subset http server you can use this to build own web server, <br>
web framework, internet based application. It's just like low-level http server. It provide few middleware to work <br>
In this code I wrote my own middleware. Clojure is language with lisp syntax and great thing about lisp syntax(prefix notation only) <br>
that it doesn't need associativity and precedence rules in syntax structure like other lang c,c++,python,java languages need <br>
and this feature make code easier to understand code for programmer as well as cpu also.In clojure's Ist priority is given to Data > Function > Macros <br> <br>

### How to use <br>
We can use this code by REPL, war, jar, aot compilation, graalvm native code, docker...etc Most easiest way to use REPL<br>
----------- DEMO IN WINDOWS MACHINE ----------------------- <br>
**first go to clojure-restR folder then open terminal** <br>
C:\Users\ravi\clojure-restR > clj <br>
C:\Users\ravi\clojure-restR > (require '[hello]) <br>
C:\Users\ravi\clojure-restR > (hello/run) <br>

**call in R** <br>
```{r}
library(httr)
library(jsonlite)

url <- "http://localhost:3000"
d <- c(1,2,3)
j <- toJSON(d)

# post request
req <- POST(url, body = j, encode = "json")

# response
res <- content(req, type = "text", encoding = "UTF-8")
res <- fromJSON(res)
res
```
