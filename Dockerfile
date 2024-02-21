FROM maven:3.6-jdk-8-alpine AS build
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:18-ea-8-jdk-slim
COPY --from=build /target/InventoryManagement-0.0.1-SNAPSHOT.war InventoryManagement.war
EXPOSE 8080
ENTRYPOINT["java","-war","InventoryManagement.war"]