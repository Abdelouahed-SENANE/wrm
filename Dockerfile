# Stage 1: Dependency cache
FROM maven:3.8.5-openjdk-17 AS dependencies
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Stage 2: Application build
FROM dependencies AS builder
COPY src ./src
RUN mvn package -DskipTests --offline

# Stage 3: Runtime environment
FROM openjdk:17-jdk-alpine
WORKDIR /app
COPY --from=builder /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]