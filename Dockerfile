FROM maven:3.8.7 as build
COPY . .
RUN mvn -8 clean package - DskipTests

FROM openjdk:17
COPY --from=build /target/*.jar taskfordevop.jar

ENTRYPOINT ["Java", "-jar", "-Dserver.port8089", "taskfordevop.jar"]