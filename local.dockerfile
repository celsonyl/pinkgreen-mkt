FROM openjdk:11.0.8-slim

WORKDIR /home/app

ENV JAR_FILE=target/pinkgreen-mkt-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} /home/app/application.jar

EXPOSE 8181

ENTRYPOINT ["java","-Dspring.profiles.active=local-container","-jar","/home/app/application.jar"]