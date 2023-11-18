FROM openjdk:21-jdk-slim
COPY build/libs/FotoPantry-MediaUpload-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]