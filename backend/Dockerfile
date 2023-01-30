FROM openjdk:8-jdk-alpine

CMD mvn package -DskipTests

ARG JAR_FILE=target/*.jar

COPY ${JAR_FILE} /app.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","/app.jar"]
