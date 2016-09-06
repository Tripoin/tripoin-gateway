# Run Configurations

#####Configuration file :
* *tripoin-web-ui\src\main\webapp\WEB-INF\properties-files\resources-web-application.properties*

#####Command line :
(must be maven compile of tripoin-root-util : [https://github.com/Tripoin/tripoin-gateway/tree/master/tripoin-root-util](https://github.com/Tripoin/tripoin-gateway/tree/master/tripoin-root-util "tripoin-root-util"))<br/>
(must be maven compile of tripoin-root-core : [https://github.com/Tripoin/tripoin-gateway/tree/master/tripoin-root-core](https://github.com/Tripoin/tripoin-gateway/tree/master/tripoin-root-core "tripoin-root-core"))

+ *tripoin-web-service* module

> ``mvn clean install -DskipTests``

+ *tripoin-web-ui* module | run test for development [http://localhost:8080/](http://localhost:8080/ "localhost")

> ``mvn jetty:run``

######Build War 

+ *tripoin-root-web* module

> ``mvn clean install -DskipTests``