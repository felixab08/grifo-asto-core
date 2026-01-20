FROM eclipse-temurin:21-jre-alpine

COPY target/grifo-asto-0.0.1-SNAPSHOT.war app.war

ENTRYPOINT ["java","-jar","app.war"]