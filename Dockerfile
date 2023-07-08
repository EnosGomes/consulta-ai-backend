FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
COPY target/*.jar consultaai.jar
ENTRYPOINT ["java","-jar","/consultaai.jar"]
EXPOSE 8080