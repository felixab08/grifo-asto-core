# =========================
# Etapa 1: Build
# =========================
FROM maven:3.9.11-eclipse-temurin-21 AS build

WORKDIR /app

COPY pom.xml .

COPY src ./src

RUN mvn clean package -DskipTests


# =========================
# Etapa 2: Runtime
# =========================
FROM eclipse-temurin:21-jre-alpine

WORKDIR /app

COPY --from=build /app/target/*.war app.war

ENTRYPOINT ["java", "-jar", "app.war"]