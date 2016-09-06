# Run Configurations

#####Configuration file :
* *tripoin-web-ui\src\main\webapp\WEB-INF\properties-files\resources-web-application.properties*

#####Command line :
######Mode Debug

+ *tripoin-web-service* module

> ``mvn clean install -DskipTests``

+ *tripoin-web-ui* module | run test for development [http://localhost:8080/](http://localhost:8080/ "localhost")

> ``mvn jetty:run``

######Build War 

+ *tripoin-root-web* module

> ``mvn clean install -DskipTests``