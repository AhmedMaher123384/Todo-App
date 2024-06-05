# ToDo Application

## Overview
This application is designed to manage a list of tasks or "todos". It provides functionality to create, update, retrieve, and delete todo items, along with the ability to list all existing todos.

## Technologies Used
- **Spring Boot**: Framework for creating stand-alone, production-grade Spring-based applications.
- **PostgreSQL**: Relational database for storing persistent data.
- **Lombok**: To reduce boilerplate code for model objects.
- **JUnit**: Framework for unit testing Java applications.

## Features

### Todo Service
- **Create Todo**: Add a new todo item.
- **Update Todo**: Modify an existing todo item.
- **Retrieve Todo**: Fetch a todo item by ID.
- **Delete Todo**: Remove a todo item by ID.
- **Get All Todos**: Retrieve a comprehensive list of all todo items.

## Setup
1. Clone the repository.
2. Configure your database credentials in "application.yml".
3. run spring app from IDE.
4. or run from CommandLine :
   ```bash
   mvn spring-boot:run
