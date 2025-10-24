# Hello World Spring Boot Application

A simple Spring Boot application that displays "Hello world from {environment}" where the environment is configurable.

## Project Structure

```
springapp-awa-poc/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/example/helloworld/
│   │   │       ├── HelloWorldApplication.java
│   │   │       └── controller/
│   │   │           └── HelloController.java
│   │   └── resources/
│   │       └── application.properties
│   └── test/
│       └── java/
├── pom.xml
└── README.md
```

## Configuration

The environment name can be configured in `src/main/resources/application.properties`:

```properties
app.environment=Prod
```

You can change this value to any environment name (Dev, QA, Staging, Prod, etc.)

### Alternative Configuration Methods

**1. Command Line Argument:**
```bash
mvn spring-boot:run -Dspring-boot.run.arguments=--app.environment=Dev
```

**2. Environment Variable:**
```bash
export APP_ENVIRONMENT=Staging
mvn spring-boot:run
```

**3. External Properties File:**
Create different property files for each environment (application-dev.properties, application-prod.properties) and activate them using:
```bash
mvn spring-boot:run -Dspring-boot.run.profiles=dev
```

## Running the Application

**Using Maven:**
```bash
mvn spring-boot:run
```

**Or build and run the JAR:**
```bash
mvn clean package
java -jar target/helloworld-1.0.0.jar
```

**With custom environment:**
```bash
java -jar target/helloworld-1.0.0.jar --app.environment=Production
```

## Testing the Endpoint

Once the application is running, visit:
```
http://localhost:8080/hello
```

You should see:
```
Hello world from 'Prod'
```

## Requirements

- Java 17 or higher
- Maven 3.6+
