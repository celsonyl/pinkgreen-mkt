# Pinkgreen-mkt

### Requirements
* Java 11
* Maven
* Docker

## How to build and run the project
* First you need to start project dependencies:
    ```bash
    docker-compose up -d
    ```
* Then you are able to run the project
    ```bash
    mvn spring-boot:run -D spring-boot.run.profiles=local
    ```

## Swagger UI documentation
* http://localhost:8181/swagger-ui.html