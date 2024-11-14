# Stage 1: Dependency cache
FROM maven:latest AS dependencies
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline

# Stage 2: Application build
FROM dependencies AS builder
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Stage 3: Runtime environment
FROM openjdk:17-jdk-alpine
WORKDIR /app

# Copy the built JAR file from the build stage
COPY --from=builder /app/target/*.jar wrm.jar


EXPOSE 8080
ENTRYPOINT ["java", "-Dspring.devtools.remote.secret=${SECRET_KEY}", "-jar", "wrm.jar"]