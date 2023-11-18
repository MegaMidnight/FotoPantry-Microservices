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
2. Navigate to the project directory
3. Build the project using Gradle
4. Build the Docker image
5. (Optional) Deploy to Kubernetes
