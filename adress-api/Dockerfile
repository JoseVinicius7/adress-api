FROM maven:3.8.1-openjdk-11 AS MAVEN_BUILD

COPY pom.xml /build/
COPY src /build/src/

WORKDIR /build/
RUN mvn install


FROM openjdk:11
WORKDIR /app
COPY --from=MAVEN_BUILD /build/target/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]