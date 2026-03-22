# Patient Management Microservices

A robust, event-driven microservices ecosystem for patient management, featuring gRPC communication, Kafka event streaming, and a Spring Cloud API Gateway with JWT-based security.

## 🏗️ Architecture Overview

The system consists of several specialized microservices, each responsible for a distinct part of the patient management lifecycle.

| Service | Port | Description |
| :--- | :--- | :--- |
| **API Gateway** | `4004` | Entry point for all external requests. Handles routing and JWT validation. |
| **Auth Service** | `4005` | Manages user authentication, registration, and JWT issuance. |
| **Patient Service** | `4000` | Core CRUD service for patient records. Acts as a Kafka producer (patient events) and gRPC client (billing requests). |
| **Billing Service** | `4001` | Manages patient billing accounts via gRPC server (port `9001`). |
| **Analytics Service** | - | Kafka consumer that processes patient-related events for business intelligence. |
| **Infrastructure** | - | AWS CDK-based infrastructure deployment to LocalStack. |

### 🛠️ Technology Stack

- **Java 21** & **Spring Boot 3.4.x**
- **Spring Cloud Gateway** (with custom JWT Filter)
- **Database**: PostgreSQL (Production), H2 (Development)
- **Communication**:
  - **Synchronous**: REST (Spring Web) & gRPC (using `net.devh:grpc-spring-boot-starter`)
  - **Asynchronous**: Apache Kafka (Spring Kafka)
- **Security**: JWT (JSON Web Tokens) with `io.jsonwebtoken`
- **Deployment**: Docker & Kubernetes (K8s manifests included)
- **Testing**: JUnit 5, Rest-Assured, and H2 for integration testing.

---

## 🚀 Getting Started

### Prerequisites

- Java 21 JDK
- Maven
- Docker Desktop (with Kubernetes enabled) or Minikube
- Kafka (for local messaging)
- LocalStack (for infrastructure simulation)

### Building the Project

Since this is a multi-module project (without a root POM), you should build each service individually or use a script.

```bash
# Build all services (from root)
for dir in auth-service patient-service billing-service api-gateway analytics-service; do
  cd $dir && ./mvnw clean install -DskipTests && cd ..
done
```

### Running Locally

Each service can be started via Maven:

```bash
./mvnw spring-boot:run
```

Ensure you have a Kafka broker and a PostgreSQL instance running, or update the `application.properties` in each service to use H2 for local development.

---

## 🔒 Security

The **API Gateway** acts as the security enforcer. It validates the JWT provided in the `Authorization: Bearer <token>` header before routing requests to protected services (like `patient-service`).

- **Auth Routes**: `/auth/**` (Public)
- **Patient Routes**: `/api/patients/**` (Protected via `JwtValidationGatewayFilterFactory`)

---

## 📡 API & gRPC

### gRPC Definitions

Protobuf files are located in each service's `src/main/proto/` directory:
- `billing_service.proto`: Defines billing account creation and management.
- `patient_event.proto`: Defines the schema for Kafka patient events.

### API Documentation

Swagger/OpenAPI UI is available via the Gateway:
- Patient Service Docs: `http://localhost:4004/api-docs/patients`
- Auth Service Docs: `http://localhost:4004/api-docs/auth`

---

## 🧪 Testing

### Integration Tests

Integration tests are located in the `integration-tests` module and use **Rest-Assured**.

```bash
cd integration-tests
mvn test
```

### Sample Requests

The project includes sample `.http` files for manual testing:
- `api-requests/`: HTTP requests for REST APIs.
- `grpc-requests/`: Sample requests for gRPC (can be used with tools like Postman or BloomRPC).

---

## 🏗️ Deployment (Kubernetes)

Each service contains its own `deployment.yaml` and `service.yaml`.

```bash
kubectl apply -f patient-service/deployment.yaml
kubectl apply -f patient-service/service.yaml
# Repeat for other services
```

---

## ☁️ Infrastructure (LocalStack)

The `infrastructure/` directory contains AWS CDK code to deploy resources (like Load Balancers) to a LocalStack environment.

```bash
cd infrastructure
./localstack-deploy.sh
```
