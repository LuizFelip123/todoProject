# Todo Project API

## This project is a basic Todo List API built with Spring Boot, following RESTful principles. It allows users to manage todos through endpoints for creating, reading, updating, and deleting todos.

##  Maven for dependency management

- **Java**: Linguagem de programação principal.

- **Spring Boot 3.4.1**

- **Spring Web**

- **Spring Data JPA**

- **Spring Security**

- **H2 Database (in-memory database for development and testing)**

- **JSON Web Tokens (JWT) for authentication**


## Pre requisites

- **Java 17 or higher installed**

- **Maven installed**

## Running the Application

### Clone the repository:

```bash git clone https://github.com/yourusername/todoProject.git
cd todo-project
```

## Build the project:

```bash
mvn clean install
```
## Run the application:

```bash
 mvn spring-boot:run
```
## Access the application at:

```bash
http://localhost:8080
```
Endpoints

## Public Endpoints

- **POST /api/v1/auth/login - Authenticate a user and receive a JWT.**
- **POST /api/v1/usuarios - create users**
