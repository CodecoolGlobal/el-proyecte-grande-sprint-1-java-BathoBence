FROM eclipse-temurin:17-jre-alpine
WORKDIR /tmp
COPY target/*.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]