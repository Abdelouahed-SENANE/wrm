# Stage 1: Build environment
FROM maven:3.8.5-openjdk-17 AS builder
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline
COPY src ./src
RUN mvn clean package -DskipTests

# Stage 2: Run environment
FROM openjdk:17-jdk-alpine
WORKDIR /app
COPY --from=builder /app/target/*.jar wrm.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "wrm.jar"]
