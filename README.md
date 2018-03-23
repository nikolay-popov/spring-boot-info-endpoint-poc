Given an empty spring boot project with web layer plugged in:
1. Spring Boot Actuator added - it will by default expose a few endpoints https://docs.spring.io/spring-boot/docs/1.5.10.RELEASE/reference/htmlsingle/#production-ready
2. Actuator configured to turn off all endpoints except /info - see src/main/resources/application.properties
3. Added mvn plugin (http://www.baeldung.com/spring-git-information) to generate git.properties file with restricted list of properties. It will be automatically loaded by GitInfoContributor and properties exposed by /info endpoint - see pom.xml git-commit-id-plugin
4. Added spring security to dependencies - it will enable basic authorization on all endpoints by default. In real application and a SecurityConfig need to be checked to not expose /info endpoint unauthorized (should be checked by tests).
5. SecurityConfig class added just to add a user with defined password.
6. Tests added to check if /info requires authorization and other endpoints (like /health) are turned off.  

`mvn clean install` to build (regenerate git.properties) and run tests

`java -jar target/springbootinfoendpointpoc-0.0.1-SNAPSHOT.jar` or run src/main/java/com/example/springbootinfoendpointpoc/Application.java- in IntelliJ to run server on localhost

`curl user:pwd@localhost:8080/info` to try it manually


# Spring Cloud Sleuth branch

If project have a dependency on Spring Cloud Sleuth (SCS), Spring Actuator will be there but also Spring Cloud (SC) starter will be added to dependencies which will expose a number of additional [endpoints](http://cloud.spring.io/spring-cloud-static/spring-cloud.html#_endpoints)

In SCS 1.0.4.RELEASE you cannot easily disable them all and `env` endpoint together with `env/reset` still give 200 even when explicitly disabled.

It was fixed with https://github.com/spring-cloud/spring-cloud-commons/pull/208 in [v1.2.3.RELEASE](https://github.com/spring-cloud/spring-cloud-commons/releases/tag/v1.2.3.RELEASE) of Spring Cloud Commons (SCS 1.0.4.RELEASE uses SCC 1.1.1.RELEASE). I didn't check in what version of SCS they started using it but project didn't work with 1.3.2 - the latest version of SCS in the moment of writing. 

Spring Security is disabled in this (spring-cloud-endpoints) branch to demonstrate how SC endpoints can be disabled with SCS 1.0.4 and to allow to play with versions later. Please see spring-cloud-endpoints-with-spring-security branch to see how it works with Spring Security.

Note that even disabled endpoints are still logged on application start - check SpringCloudEndpointsTests to see how they really work.

FYI: you may want to check out history of this branch - there is a commit with enabled SC endpoints together with tests to show default behaviour.
