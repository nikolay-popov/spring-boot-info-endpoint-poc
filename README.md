Given an empty spring boot project with web layer plugged in:
1. Spring Boot Actuator added - it will by default expose a few endpoints https://docs.spring.io/spring-boot/docs/1.5.10.RELEASE/reference/htmlsingle/#production-ready
2. Actuator configured to turn off all endpoints except /info - see src/main/resources/application.properties
3. Added mvn plugin (http://www.baeldung.com/spring-git-information) to generate git.properties file with restricted list of properties. It will be automatically loaded by GitInfoContributor and properties exposed by /info endpoint - see pom.xml git-commit-id-plugin
4. Added spring security to dependencies - it will enable basic authorization on all endpoints by default. In real application and a SecurityConfig need to be checked to not expose /info endpoint unauthorized (should be checked by tests).
5. SecurityConfig class added just to add a user with defined password.
6. Tests added to check if /info requires authorization and other endpoints (like /health) are turned off.  

`mvn clean install` to build (regenerate git.properties) and run tests

`java -jar target/kommon-0.0.1-SNAPSHOT.jar` or KommonApplication->run in IDEA to run on localhost

`curl user:pwd@localhost:8080/info` to try it manually
