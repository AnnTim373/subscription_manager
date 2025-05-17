FROM maven:3.9.6-eclipse-temurin-17 as build

COPY . /subman/

RUN mvn -f /subman/pom.xml clean package

FROM openjdk:17

WORKDIR /subman

COPY --from=build /subman/target/subscription_manager-1.0.jar ./subman.jar

CMD ["java", "-jar", "/subman/subman.jar"]
