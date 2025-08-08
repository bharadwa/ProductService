Produce Service using spring boot application

This Dockerfile sets up a container for a Spring Boot Java application:
It starts from an Ubuntu 22.04 base image:
FROM ubuntu:22.04
Installs OpenJDK 21 for running Java applications:
RUN apt-get install -y openjdk-21-jre-headless
Sets /app as the working directory:
WORKDIR /app
Copies the built JAR file into the container:
COPY target/ProductService-0.0.1-SNAPSHOT.jar app.jar
Exposes ports 8080 and 8443 for HTTP/HTTPS traffic:
EXPOSE 8080 8443
Specifies the entrypoint to run the Spring Boot application:
ENTRYPOINT ["java", "-jar", "app.jar"]
