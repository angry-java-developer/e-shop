FROM openjdk:17-jdk-slim
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} e-shop-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/e-shop-0.0.1-SNAPSHOT.jar","--server.port=8000"]
