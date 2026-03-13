# GEMINI.md - KBC Appointment Service Context

## Project Overview
The **KBC Appointment Service** is a Spring Boot application (version 4.0.3) designed to manage scheduling and appointments within the KBC backend ecosystem. It provides REST APIs for creating, updating, and tracking appointments.

### Main Technologies:
- **Language:** Java 25
- **Framework:** Spring Boot 4
- **Persistence:** Spring Data JPA with PostgreSQL
- **Build System:** Gradle
- **Libraries:** Lombok (for boilerplate reduction), Hibernate/JPA.

### Architecture:
The project follows a standard layered architecture:
- **`controller`**: Handles HTTP requests for appointments.
- **`service`**: Contains business logic for scheduling and status management.
- **`repository`**: Provides data access using Spring Data JPA.
- **`entity`**: JPA entities representing the `appointment` schema.
- **`model`**: DTOs for requests and responses.
- **`constant`**: Enums for `AppointmentStatus` and security constants.

## Building and Running

### Prerequisites:
- JDK 25
- PostgreSQL (configured with `kbc` database, `appointment` schema)

### Commands:
```bash
./gradlew build
./gradlew bootRun
./gradlew test
```

## Development Conventions

### Package Structure:
- `kbc.kbc_appointment_service.entity`: JPA Entities.
- `kbc.kbc_appointment_service.model`: DTOs/Requests/Responses.
- `kbc.kbc_appointment_service.controller`: REST Controllers.
- `kbc.kbc_appointment_service.service`: Business Logic.
- `kbc.kbc_appointment_service.repository`: JPA Repositories.
- `kbc.kbc_appointment_service.constant`: Enums and Constants.

### Coding Style:
- Use **Lombok** to minimize boilerplate.
- Use **Spring Data JPA** for data persistence.
- Role-based authentication is enforced via `@PreAuthorize` using `RoleConstants`.
- Appointments are managed via the `appointment` schema in PostgreSQL.

### Configuration:
- `server.port`: 8083
- `spring.jpa.properties.hibernate.default_schema`: appointment
