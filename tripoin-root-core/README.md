# Run Configurations

#####Command line :
* tripoin-root-core module
(must be maven compile of tripoin-root-util : [https://github.com/Tripoin/tripoin-gateway/tree/master/tripoin-root-util](https://github.com/Tripoin/tripoin-gateway/tree/master/tripoin-root-util "tripoin-root-util")

> ``mvn clean install -DskipTests``
 
#####Run As Jetty Run :

* Click Run Configurations

![alt tag](https://raw.githubusercontent.com/Tripoin/tripoin-resources/master/tripoin-image/Setting%20Environment%205.png)

* New Jetty Webapp

![alt tag](https://raw.githubusercontent.com/Tripoin/tripoin-resources/master/tripoin-image/Setting%20Environment%206.png)

* Click Browse, select tripoin-core-integration

![alt tag](https://raw.githubusercontent.com/Tripoin/tripoin-resources/master/tripoin-image/Setting%20Environment%207.png)

* Click Run

![alt tag](https://raw.githubusercontent.com/Tripoin/tripoin-resources/master/tripoin-image/Setting%20Environment%208.png)


# Reference
+ Oauth 2.0 : [http://projects.spring.io/spring-security-oauth/docs/oauth2.html](http://projects.spring.io/spring-security-oauth/docs/oauth2.html "OAuth 2 Developers Guide")

```java
Group Id    : org.springframework.security.oauth
Artifact Id : spring-security-oauth2
Version     : 2.0.1.RELEASE
``` 

+ JAX-RS : [http://cxf.apache.org/docs/jax-rs.html](http://cxf.apache.org/docs/jax-rs.html "JAX-RS (JSR-339)")

+ Open standard for authorization : [https://en.wikipedia.org/wiki/OAuth](https://en.wikipedia.org/wiki/OAuth "Oauth")

+ JSON Web Token : [https://en.wikipedia.org/wiki/JSON_Web_Token](https://en.wikipedia.org/wiki/JSON_Web_Token "JWT")