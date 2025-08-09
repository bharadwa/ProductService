# Use Ubuntu as base image
FROM ubuntu:22.04

# Install OpenJDK 21
RUN apt-get update && \
    apt-get install -y openjdk-21-jre-headless && \
    apt-get clean && rm -rf /var/lib/apt/lists/*

# Set working directory
WORKDIR /app

# Copy the built JAR file
COPY target/ProductService-0.0.1-SNAPSHOT.jar app.jar

# Expose HTTP and HTTPS ports

EXPOSE 8080 8443

# Set environment variables for Java options
ENV JAVA_OPTS="-Xms512m -Xmx1024m"

# Run the Spring Boot application
ENTRYPOINT ["java", "-jar", "app.jar"]
