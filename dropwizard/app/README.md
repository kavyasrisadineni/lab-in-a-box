# DwizExample

How to start the DwizExample application
---

1. Run `mvn clean install` to build your application
1. Start application with `java -jar target/e1-1.0-SNAPSHOT.jar server config.yml`
1. To check that your application is running enter url `http://localhost:8080`

Health Check
---

To see your applications health enter url `http://localhost:8081/healthcheck`



-- optional ---
mvn deploy:deploy-file -Durl=file://$(pwd)/repo/ -Dfile=/tmp/sigsci-module-java-1.0.2.jar \
	-DgroupId=com.signalsciences -DartifactId=sigsci-module-java \
	-Dpackaging=jar -Dversion=1.0.2


----
mvn package && java -jar target/e1-1.0-SNAPSHOT.jar server
curl  -d "name=<script>alert('foo get')</script>"  http://localhost:8080/hello-world
curl  'http://localhost:8080/hello-world?name=<script>alert('foo get')</script>''
