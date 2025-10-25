# Spring Boot Product Management API - POC

A Spring Boot REST API application for managing product inventory with full CRUD operations, integrated with Azure MySQL database.

## Overview

This POC demonstrates a production-ready Spring Boot application with:
- RESTful API endpoints for product management
- MySQL database integration (Azure MySQL)
- JPA/Hibernate for data persistence
- Complete CRUD operations
- Advanced search capabilities

## Technologies Used

- **Java 17**
- **Spring Boot 3.2.0**
- **Spring Data JPA** - Data access layer
- **Hibernate** - ORM framework
- **MySQL** - Database (Azure MySQL)
- **Maven** - Build tool
- **Jakarta Persistence API** - JPA specifications

## Project Structure

```
springapp-awa-poc/
├── src/
│   ├── main/
│   │   ├── java/com/example/helloworld/
│   │   │   ├── HelloWorldApplication.java
│   │   │   ├── controller/
│   │   │   │   └── ProductController.java
│   │   │   ├── service/
│   │   │   │   └── ProductService.java
│   │   │   ├── repository/
│   │   │   │   └── ProductRepository.java
│   │   │   └── entity/
│   │   │       └── Product.java
│   │   └── resources/
│   │       └── application.properties
│   └── test/
│       └── java/
├── pom.xml
└── README.md
```

## Database Configuration

The application connects to **Azure MySQL Database**:

- **Host**: `rs-springboot-mysql-poc.mysql.database.azure.com`
- **Port**: `3306`
- **Database**: `product_db`
- **Username**: `agiaazureuser`
- **SSL Mode**: REQUIRED (Azure MySQL requires SSL)

Configuration is located in `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:mysql://rs-springboot-mysql-poc.mysql.database.azure.com:3306/product_db?createDatabaseIfNotExist=true&ssl-mode=REQUIRED
spring.datasource.username=agiaazureuser
spring.datasource.password=Marvel$89
spring.jpa.hibernate.ddl-auto=update
```

## Product Entity

The `Product` entity includes the following fields:

| Field | Type | Description | Constraints |
|-------|------|-------------|-------------|
| `id` | Long | Primary key | Auto-generated |
| `name` | String | Product name | Not null |
| `description` | String | Product description | Max 500 chars |
| `price` | Double | Product price | Not null |
| `quantity` | Integer | Stock quantity | Not null |
| `createdAt` | LocalDateTime | Creation timestamp | Auto-set |
| `updatedAt` | LocalDateTime | Last update timestamp | Auto-updated |

## API Endpoints

Base URL: `http://localhost:8081/api/products`

### 1. Create Product
**POST** `/api/products`

**Request Body:**
```json
{
  "name": "Laptop",
  "description": "High-performance gaming laptop",
  "price": 1299.99,
  "quantity": 10
}
```

**Response:** `201 Created`
```json
{
  "id": 1,
  "name": "Laptop",
  "description": "High-performance gaming laptop",
  "price": 1299.99,
  "quantity": 10,
  "createdAt": "2025-10-25T10:30:00",
  "updatedAt": "2025-10-25T10:30:00"
}
```

### 2. Get All Products
**GET** `/api/products`

**Response:** `200 OK`
```json
[
  {
    "id": 1,
    "name": "Laptop",
    "description": "High-performance gaming laptop",
    "price": 1299.99,
    "quantity": 10,
    "createdAt": "2025-10-25T10:30:00",
    "updatedAt": "2025-10-25T10:30:00"
  }
]
```

### 3. Get Product by ID
**GET** `/api/products/{id}`

**Response:** `200 OK` or `404 Not Found`

### 4. Search Products by Name
**GET** `/api/products/search?name={searchTerm}`

**Example:** `/api/products/search?name=laptop`

### 5. Search Products by Price Range
**GET** `/api/products/search/price?minPrice={min}&maxPrice={max}`

**Example:** `/api/products/search/price?minPrice=100&maxPrice=2000`

### 6. Update Product
**PUT** `/api/products/{id}`

**Request Body:**
```json
{
  "name": "Laptop Pro",
  "description": "Updated gaming laptop",
  "price": 1499.99,
  "quantity": 8
}
```

**Response:** `200 OK` or `404 Not Found`

### 7. Delete Product
**DELETE** `/api/products/{id}`

**Response:** `204 No Content` or `404 Not Found`

### 8. Delete All Products
**DELETE** `/api/products`

**Response:** `204 No Content`

### 9. Get Total Product Count
**GET** `/api/products/count`

**Response:** `200 OK`
```json
5
```

### 10. Check if Product Exists
**GET** `/api/products/exists/{id}`

**Response:** `200 OK`
```json
true
```

## Running the Application

### Prerequisites
- Java 17 or higher
- Maven 3.6+
- Access to Azure MySQL database

### Build and Run

**Using Maven:**
```bash
mvn clean install
mvn spring-boot:run
```

**Or build and run the JAR:**
```bash
mvn clean package
java -jar target/helloworld-1.0.0.jar
```

The application will start on **http://localhost:8081**

## Testing the API

### Using cURL

**Create a Product:**
```bash
curl -X POST http://localhost:8081/api/products \
  -H "Content-Type: application/json" \
  -d '{"name":"Laptop","description":"Gaming laptop","price":1299.99,"quantity":10}'
```

**Get All Products:**
```bash
curl http://localhost:8081/api/products
```

**Get Product by ID:**
```bash
curl http://localhost:8081/api/products/1
```

**Search by Name:**
```bash
curl "http://localhost:8081/api/products/search?name=laptop"
```

**Update Product:**
```bash
curl -X PUT http://localhost:8081/api/products/1 \
  -H "Content-Type: application/json" \
  -d '{"name":"Laptop Pro","description":"Updated laptop","price":1499.99,"quantity":8}'
```

**Delete Product:**
```bash
curl -X DELETE http://localhost:8081/api/products/1
```

### Using Postman

1. Import the endpoints into Postman
2. Set the base URL to `http://localhost:8081`
3. Use the endpoint paths and request bodies documented above

## Features

- **Full CRUD Operations**: Create, Read, Update, Delete products
- **Search Functionality**: Search by name (case-insensitive) or price range
- **Auto-timestamps**: Automatic creation and update timestamps
- **Database Auto-creation**: Database and tables are created automatically
- **Error Handling**: Proper HTTP status codes and error responses
- **RESTful Design**: Following REST API best practices
- **SSL Support**: Secure connection to Azure MySQL

## Development Notes

- **DDL Auto**: Set to `update` - Hibernate will update the schema automatically
- **SQL Logging**: Enabled for development (`spring.jpa.show-sql=true`)
- **SQL Formatting**: Enabled for better readability
- **Azure MySQL**: Requires SSL connection for security

## License

This is a POC (Proof of Concept) application for demonstration purposes.
