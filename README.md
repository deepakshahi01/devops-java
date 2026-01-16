# Calculator Web API - Jenkins CI/CD Demo

A simple Java-based calculator REST API built with Spring Boot and Gradle, designed to demonstrate Jenkins declarative pipeline concepts.

## 📋 Features

- **RESTful API** with multiple calculator operations
- **Spring Boot** framework for rapid development
- **Gradle** for build and dependency management
- **Comprehensive unit tests** with JUnit 5
- **Integration tests** with MockMvc
- **Code coverage** reporting with JaCoCo
- **Jenkins declarative pipeline** for CI/CD

## 🚀 API Endpoints

All endpoints are prefixed with `/api/calculator`:

- `GET /add?a={num1}&b={num2}` - Addition
- `GET /subtract?a={num1}&b={num2}` - Subtraction
- `GET /multiply?a={num1}&b={num2}` - Multiplication
- `GET /divide?a={num1}&b={num2}` - Division
- `GET /power?base={num}&exponent={num}` - Power calculation
- `GET /sqrt?number={num}` - Square root
- `GET /health` - Health check endpoint

## 🛠️ Prerequisites

- Java 17 or higher
- Gradle 8.x (or use the included Gradle wrapper)
- Jenkins (for CI/CD pipeline)

## 📦 Building the Project

### Using Gradle Wrapper (Recommended)

```bash
# Make gradlew executable
chmod +x gradlew

# Clean and build
./gradlew clean build

# Run tests
./gradlew test

# Generate coverage report
./gradlew jacocoTestReport

# Create bootable JAR
./gradlew bootJar
```

### Using System Gradle

```bash
gradle clean build
gradle test
gradle bootJar
```

## 🏃 Running the Application

### Run with Gradle

```bash
./gradlew bootRun
```

### Run the JAR

```bash
java -jar build/libs/calculator-1.0.0.jar
```

The application will start on `http://localhost:8080`

## 🧪 Testing the API

### Using curl

```bash
# Addition
curl "http://localhost:8080/api/calculator/add?a=10&b=5"

# Subtraction
curl "http://localhost:8080/api/calculator/subtract?a=10&b=5"

# Multiplication
curl "http://localhost:8080/api/calculator/multiply?a=10&b=5"

# Division
curl "http://localhost:8080/api/calculator/divide?a=10&b=5"

# Power
curl "http://localhost:8080/api/calculator/power?base=2&exponent=3"

# Square Root
curl "http://localhost:8080/api/calculator/sqrt?number=25"

# Health Check
curl "http://localhost:8080/api/calculator/health"
```

### Example Response

```json
{
  "operand1": 10.0,
  "operand2": 5.0,
  "result": 15.0,
  "operation": "addition"
}
```

## 🔧 Jenkins Pipeline

The project includes a comprehensive `Jenkinsfile` with the following stages:

1. **Checkout** - Retrieves source code from SCM
2. **Build** - Compiles the application
3. **Test** - Runs unit and integration tests
4. **Code Quality Analysis** - Generates coverage reports
5. **Package** - Creates deployable JAR artifact
6. **Deploy** - Deploys to target environment
7. **Health Check** - Verifies deployment success

### Jenkins Setup Requirements

1. **JDK Configuration**: Configure JDK 17 in Jenkins Global Tool Configuration with name `JDK17`
2. **Plugins Required**:
   - Pipeline
   - JUnit Plugin
   - JaCoCo Plugin
   - Email Extension Plugin (for notifications)

### Pipeline Environment Variables

You can customize these in the Jenkinsfile:

- `APP_VERSION` - Application version (default: 1.0.0)
- `DEPLOY_DIR` - Deployment directory (default: /opt/applications/calculator)

### Running the Pipeline

1. Create a new Pipeline job in Jenkins
2. Point it to your Git repository
3. Jenkins will automatically detect the `Jenkinsfile`
4. Run the pipeline

## 📊 Code Coverage

After running tests, view the coverage report:

```bash
open build/reports/jacoco/test/html/index.html
```

## 📁 Project Structure

```
devops-java/
├── src/
│   ├── main/
│   │   ├── java/com/example/calculator/
│   │   │   ├── CalculatorApplication.java
│   │   │   ├── controller/
│   │   │   │   └── CalculatorController.java
│   │   │   └── service/
│   │   │       └── CalculatorService.java
│   │   └── resources/
│   │       └── application.properties
│   └── test/
│       └── java/com/example/calculator/
│           ├── service/
│           │   └── CalculatorServiceTest.java
│           └── controller/
│               └── CalculatorControllerTest.java
├── build.gradle
├── settings.gradle
├── Jenkinsfile
└── README.md
```

## 🎓 Educational Notes for Students

### Key Concepts Demonstrated

1. **Declarative Pipeline Syntax**: The Jenkinsfile uses declarative syntax, which is easier to read and maintain
2. **Stage Organization**: Logical separation of build, test, and deploy phases
3. **Artifact Management**: Proper archiving and deployment of build artifacts
4. **Test Reporting**: Integration of test results and coverage reports
5. **Error Handling**: Post-build actions for success/failure scenarios
6. **Health Checks**: Automated verification of deployment success

### Learning Exercises

1. Modify the pipeline to add a SonarQube analysis stage
2. Add Docker containerization and push to registry
3. Implement parallel test execution
4. Add approval gates for production deployment
5. Configure different deployment environments (dev, staging, prod)

## 📝 License

This project is created for educational purposes.

## 🤝 Contributing

This is a teaching example. Feel free to fork and modify for your learning needs!
