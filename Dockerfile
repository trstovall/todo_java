
FROM eclipse-temurin:25-jdk

WORKDIR /app

COPY target/todo-1.0.0.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","/app/app.jar"]
