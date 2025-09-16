# Inventory Service

## Description

Inventory Service is an API for ARKA Business developed with **Spring Boot** to handle requests to create, search, update products and
allows to track updates on the product stock.

## 🚀 Technologies Used

- Java 21
- Spring Boot 3.5.5
- Spring Web
- Hibernate (JPA)
- MySQL
- Lombok

## 🚀 Aditional Concepts

- Clean architecture
- Domain Driven Design
- Rest Controller

## 📦 Installation and Configuration
### 1️⃣ Clone the Repository
```sh
git clone https://github.com/Ne052003/InventoryMicroservice.git
cd InventoryMicroservice
```

### 2️⃣ Configure the Database
Set the database connection properties:

```properties
    url: jdbc:mysql://localhost:3306/database_name
    username:
    password:
```

### 3️⃣ Run the Application
```sh
./gradlew bootRun
```

## 🔧 Future Improvements

✅ Reactive behavior to domain events in OrderService microservice to
update product stock and track stock transactions.

✅ Implementation of NotificationService to notify when a product is running out of stock.

✅ Define observable behavior to create reports of products that need to be supplied in ReportService.
