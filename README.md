# Submersible Probe REST API

A Spring Boot 3.3.4 REST API for controlling and monitoring a submersible probe.  
This project uses Java 17 and exposes endpoints to send commands, track positions, and manage probe operations.

## Features

- Move the probe in different directions (North, South, East, West, etc.)
- Track current position and direction
- Validate and execute commands
- OpenAPI (Swagger) documentation for easy testing
- Unit tests included using Spring Boot Test

## Technologies Used

- Java 17
- Spring Boot 3.3.4
- Spring Web
- SpringDoc OpenAPI (Swagger)
- Maven for build management

## Getting Started

### Prerequisites

- Java 17 installed
- Maven installed
- IDE (IntelliJ, Eclipse, or STS)
- Git

### Running the Project

1. Clone the repository:
```bash
git clone https://github.com/Legato-coder/probe-api.git
cd probe-api
