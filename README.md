# Media Upload Kotlin Microservice

This is a Kotlin-based microservice that uses RabbitMQ for message queuing. The service is designed to be deployed on a Kubernetes (k8s) cluster. It also uses a MySQL server for data persistence.

## Project Status

This project is currently under development and is just in a stage to test the env on k8s. The basic structure is in place, and it includes a Dockerfile for containerization and deployment to a Kubernetes cluster for testing the environment.

## Technologies

- Kotlin: The main programming language used for development.
- RabbitMQ: Used for asynchronous message queuing.
- MySQL: Used for data persistence.
- Docker: Used for creating a container of the application, ensuring that it runs the same way in every environment.
- Kubernetes (k8s): Used for automating deployment, scaling, and management of the application.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

- JDK 21
- Docker
- Kubernetes (optional)

### Installing

A step by step series of examples that tell you how to get a development environment running.

1. Clone the repository
```git clone https://github.com/MegaMidnight/FotoPantry-Microservices.git```
2. Navigate to the project directory
```cd FotoPantry-Microservices/media-upload```
3. Build the project using Gradle
```./gradlew build```
4. Build the Docker image
```docker build -t fotopantry-microservices .```
5. (Optional) Deploy to Kubernetes via docker container
```docker push fotopantry-microservices```
6. (Optional) Deploy to Kubernetes
```yaml 
apiVersion: apps/v1
kind: Deployment
metadata:
  name: fotopantry-microservices
spec:
  replicas: 1
  selector:
    matchLabels:
      app: fotopantry-microservices
  template:
    metadata:
      labels:
        app: fotopantry-microservices
    spec:
      containers:
      - name: fotopantry-microservices
        image: your-dockerhub-username/fotopantry-microservices:latest
        ports:
        - containerPort: 8080
---
apiVersion: v1
kind: Service
metadata:
  name: fotopantry-microservices
spec:
  selector:
    app: fotopantry-microservices
  ports:
    - protocol: TCP
      port: 80
      targetPort: 8080
  type: ClusterIP
  ```
Then apply the yaml file to your k8s cluster
```kubectl apply -f media-upload.yaml```
