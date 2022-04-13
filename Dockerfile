#Start with a base image containing Java runtime
FROM openjdk:11-slim as build

EXPOSE 8080

# Add the application's jar to the container
COPY target/mongo-0.0.1-SNAPSHOT.jar mongo-0.0.1-SNAPSHOT.jar

#execute the application
ENTRYPOINT ["java","-jar","/mongo-0.0.1-SNAPSHOT.jar"]