# Use the OpenJDK base image for the runtime environment
FROM openjdk:17-jdk-slim

# Set the working directory in the container
WORKDIR /app

COPY target/*.jar wrm.jar
# Expose the port that the application will run on
EXPOSE 8080

# Define the command to run the JAR file
ENTRYPOINT ["java", "-jar", "wrm.jar"]