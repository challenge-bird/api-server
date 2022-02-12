FROM openjdk:11-jre-slim

LABEL maintainer="jparangdev@gmail.com"

EXPOSE 8080

ARG JAR_FILE=/build/libs/api-server-0.0.1-SNAPSHOT.jar

ADD ${JAR_FILE} challenge-bird-api.jar

ENTRYPOINT ["java","-jar","/challenge-bird-api.jar"]