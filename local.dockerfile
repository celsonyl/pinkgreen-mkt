FROM maven:3.6.0-jdk-11-slim AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package

FROM openjdk:11.0.8-slim
WORKDIR /home/app
ENV JAR_FILE=/home/app/target/pinkgreen-mkt-0.0.1-SNAPSHOT.jar
COPY --from=build ${JAR_FILE} /home/app/application.jar
EXPOSE 8181
ENTRYPOINT ["java","-Dspring.profiles.active=local-container","-jar","/home/app/application.jar"]