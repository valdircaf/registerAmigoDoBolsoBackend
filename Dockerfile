FROM maven:3.9.5-amazoncorretto-17 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean install

FROM openjdk:17-alpine
WORKDIR /app
COPY --from=build /app/target/cadastro-0.0.1-SNAPSHOT.jar ./cadastro-aws.jar
EXPOSE 8080
CMD ["java", "-jar", "cadastro-aws.jar"]