# Use the official Maven Docker image
FROM maven:3.8.7-eclipse-temurin-17-alpine as build

# Set the working directory
WORKDIR /app

# Copy the pom.xml file
COPY pom.xml .

# Download the dependencies
RUN mvn dependency:go-offline

# Copy the rest of the source code
COPY src /app/src

# Build the project
RUN mvn package

# Use the official OpenJDK Docker image
FROM openjdk:17-jdk-slim

# Set the working directory
WORKDIR /app

# Copy the built JAR file from the build stage
COPY --from=build /app/target/*.jar /app/app.jar

# Expose port 80
EXPOSE 80

# Run the Spring Boot backend
ENTRYPOINT ["java", "-jar", "app.jar"]
