# EventClean

EventClean is a small study project built with Java, Spring Boot, PostgreSQL, and Flyway to practice Clean Architecture concepts in a simple REST API.

This repository is **not a production-ready application** and it was **not created as a real-world product**. Its main goal is to help study and apply ideas such as separation of concerns, use cases, gateways, DTO mapping, and infrastructure isolation.

## Purpose

The project exposes a basic event management API that allows you to:

- create an event
- list all events
- find an event by its identifier

The business flow is intentionally simple so the focus stays on architecture and code organization instead of product complexity.

## Clean Architecture Study Focus

The codebase is organized to highlight the responsibilities of each layer:

- `core`
  Contains the domain entity, enums, gateway contracts, and use case implementations.
- `infrastructure`
  Contains controllers, persistence, mappers, exception handling, and framework-specific code.
- `db/migration`
  Contains the Flyway SQL migration used to create the database table.

In practice, the project demonstrates:

- domain logic living outside the controller
- use cases depending on abstractions instead of concrete persistence details
- infrastructure adapting HTTP requests and database operations to the domain

## Tech Stack

- Java 17
- Spring Boot
- Spring Web MVC
- Spring Data JPA
- Flyway
- PostgreSQL
- Docker Compose
- Maven Wrapper

## Available Endpoints

Base path: `http://localhost:8080/api/v1`

### `POST /create-event`

Creates a new event.

Example request body:

```json
{
  "name": "Clean Architecture Workshop",
  "description": "Hands-on study session",
  "identify": "clean-arch-workshop",
  "startDate": "2026-06-23T19:00:00",
  "endDate": "2026-06-23T21:00:00",
  "local": "Online",
  "capacity": 100,
  "organizer": "Java10x Study Group",
  "type": "WORKSHOP"
}
```

### `GET /find-events`

Returns all registered events.

### `GET /identifyer/{identifyer}`

Returns a single event by its identifier.

Notes:

- the project uses the field name `identify`
- the route also uses the word `identifyer` because that is how it is currently implemented in the source code
- duplicate identifiers return an error

## How To Run

### 1. Start PostgreSQL with Docker Compose

```bash
docker compose up -d
```

The database will be available with these settings:

- host: `localhost`
- port: `5431`
- database: `EventClean`
- username: `postgres`
- password: `postgres`

### 2. Run the application

Using the Maven Wrapper:

```bash
bash mvnw spring-boot:run
```

The API should start on:

```text
http://localhost:8080
```

### 3. Run tests

```bash
bash mvnw test
```

Important:

- the current test and application setup expects PostgreSQL to be running on `localhost:5431`
- if the database container is not running, the application startup and the test suite will fail

## Database Migration

Flyway is enabled in the application configuration, so the `Events` table is created automatically when the application starts and connects successfully to PostgreSQL.

## Project Limitations

This is intentionally a learning project, so some things are simplified and should not be treated as production standards, for example:

- minimal test coverage
- simple error handling
- no authentication or authorization
- no advanced validation
- no production deployment setup
- naming inconsistencies kept as-is to preserve the study code

## Educational Disclaimer

This repository exists to study and practice Clean Architecture concepts.

It is **not a real product**, **not production-ready**, and **not intended to represent a complete enterprise solution**. If you want to use it as a reference, treat it as a learning example only.
