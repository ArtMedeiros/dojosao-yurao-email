FROM openjdk:11-alpine
## FROM amazoncorretto:11.0.12-alpine
COPY target/*.jar /usr/app/app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/usr/app/app.jar"]