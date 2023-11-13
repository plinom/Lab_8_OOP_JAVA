FROM maven:3.8.5-openjdk-17 AS build
COPY . .
RUN mvn package
RUN docker run -e POSTGRES_PASSWORD=postgres -d -p 5432:5432 postgres

FROM openjdk:17.0.1-jdk-slim
COPY --from=build /target/flower-0.0.1-SNAPSHOT.jar demo.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "demo.jar"]