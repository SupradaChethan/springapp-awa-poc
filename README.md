# Spring Boot Product Management System - POC

A full-stack Spring Boot application for managing product inventory with RESTful API backend and modern web interface, integrated with Azure MySQL database.

## Overview

This POC demonstrates a production-ready Spring Boot application with:
- **Modern Web Interface** - Responsive HTML/CSS/JavaScript frontend for easy product management
- **RESTful API** - Complete backend API for product management
- **MySQL Integration** - Azure MySQL database for data persistence
- **JPA/Hibernate** - Object-relational mapping
- **Full CRUD Operations** - Create, Read, Update, Delete via both UI and API
- **Advanced Search** - Search by name and price range
- **Real-time Statistics** - Dashboard with inventory metrics

## Technologies Used

### Backend
- **Java 17**
- **Spring Boot 3.2.0**
- **Spring Data JPA** - Data access layer
- **Hibernate** - ORM framework
- **MySQL** - Database (Azure MySQL)
- **Maven** - Build tool
- **Jakarta Persistence API** - JPA specifications

### Frontend
- **HTML5** - Structure and content
- **CSS3** - Styling with modern gradients and animations
- **JavaScript (ES6+)** - Client-side logic and API integration
- **Fetch API** - RESTful API communication
- **Responsive Design** - Mobile-first approach

## Quick Start

```bash
# Clone the repository
git clone <repository-url>
cd springapp-awa-poc

# Build the application
mvn clean install

# Run the application
mvn spring-boot:run

# Open your browser
# Navigate to http://localhost:8081
```

That's it! The web interface will be ready to use.

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
│   │       ├── static/
│   │       │   └── index.html          (Web Interface)
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

## Web Interface

The application includes a modern, responsive web interface accessible at `http://localhost:8081` after starting the application.

### Features

- **Product Management Dashboard**
  - Add new products with a user-friendly form
  - View all products in a sortable table
  - Edit existing products with inline editing
  - Delete products with confirmation dialog

- **Search & Filter**
  - Real-time search by product name
  - Instant results without page reload
  - Clear search to view all products

- **Statistics Dashboard**
  - Total products count
  - Total inventory value calculation
  - Real-time updates as products change

- **Responsive Design**
  - Works seamlessly on desktop, tablet, and mobile devices
  - Modern UI with gradient backgrounds and smooth animations
  - Clean, intuitive interface

### Using the Web Interface

1. **Start the application** (see Running the Application section below)
2. **Open your browser** and navigate to `http://localhost:8081`
3. **Add a product**:
   - Fill in the product form (Name, Price, Quantity, Description)
   - Click "Save Product"
4. **View products**: All products are displayed in the table below
5. **Search products**: Use the search box to filter by name
6. **Edit a product**: Click the "Edit" button on any product row
7. **Delete a product**: Click the "Delete" button (confirmation required)

### Screenshots

The web interface includes:
- Purple gradient header with system title
- Clean form fields with validation
- Interactive product table with hover effects
- Success/error message notifications
- Responsive layout that adapts to screen size

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

### Accessing the Application

Once the application starts successfully:

- **Web Interface**: Open your browser and go to **http://localhost:8081**
  - Use the interactive UI to manage products visually
  - Perfect for non-technical users and quick testing

- **REST API**: Base URL is **http://localhost:8081/api/products**
  - Use for programmatic access, integrations, or testing with tools like Postman/cURL
  - Full API documentation below

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

### Application Features
- **Modern Web Interface**: Beautiful, responsive UI for easy product management
- **Full CRUD Operations**: Create, Read, Update, Delete products via both UI and API
- **Search Functionality**: Search by name (case-insensitive) or price range
- **Real-time Statistics**: Dashboard showing total products and inventory value
- **Auto-timestamps**: Automatic creation and update timestamps
- **Database Auto-creation**: Database and tables are created automatically
- **Error Handling**: Proper HTTP status codes and error responses
- **RESTful Design**: Following REST API best practices
- **CORS Enabled**: Frontend can communicate with backend seamlessly
- **SSL Support**: Secure connection to Azure MySQL

### Technical Features
- **Layered Architecture**: Separation of concerns (Controller → Service → Repository)
- **Dependency Injection**: Using Spring's @Autowired and component scanning
- **JPA/Hibernate ORM**: Object-relational mapping for database operations
- **Spring Data JPA**: Simplified data access with repository pattern
- **Responsive Design**: Mobile-first approach for web interface
- **Modern JavaScript**: ES6+ with Fetch API for async operations

## Development Notes

- **DDL Auto**: Set to `update` - Hibernate will update the schema automatically
- **SQL Logging**: Enabled for development (`spring.jpa.show-sql=true`)
- **SQL Formatting**: Enabled for better readability
- **Azure MySQL**: Requires SSL connection for security
- **Static Resources**: Web interface served from `src/main/resources/static/`
- **CORS Configuration**: Enabled with `@CrossOrigin(origins = "*")` for development
- **Frontend-Backend Integration**: Frontend uses Fetch API to communicate with REST endpoints
- **Port Configuration**: Application runs on port 8081 (configurable in `application.properties`)

## License

This is a POC (Proof of Concept) application for demonstration purposes.
