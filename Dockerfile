FROM openjdk:17
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} app.jar
COPY src/main/resources/firebase /app/resources/firebase

ENTRYPOINT ["java","-Dspring.profiles.active=prod","-jar","/app.jar"]