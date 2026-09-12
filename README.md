# Logistics Management Platform

An enterprise-style Logistics Management Platform built using **Java, Spring Boot, Spring Security, PostgreSQL, JWT, and REST APIs**.

This project demonstrates practical backend engineering concepts used in shipping, logistics, and enterprise software systems, including authentication, shipment lifecycle management, tracking, search, pagination, sorting, PDF shipping labels, and email notification infrastructure.

---

## 🚀 Project Overview

The Logistics Management Platform provides a secure REST API backend for managing shipments throughout their lifecycle.

The application follows a clean layered architecture using:

- Controllers
- Services
- Repositories
- DTOs
- Entities
- Security
- Exception Handling
- Database Persistence

JWT-based authentication protects secured APIs while allowing authenticated users to manage shipment information.

---

## ✨ Features

### 🔐 Authentication & Security

- User registration
- User login
- JWT authentication
- Password encryption using BCrypt
- Spring Security integration
- Role-based user structure
- Protected REST APIs
- Swagger/OpenAPI JWT authorization

### 👤 User Management

- Create users
- Retrieve users
- Retrieve user by ID
- Update users
- Delete users
- Search users
- Email uniqueness validation
- Secure password storage

### 📦 Shipment Management

- Create shipments
- Retrieve shipment by ID
- Retrieve shipment by tracking number
- Update shipment
- Cancel shipment
- Shipment status management
- Carrier management
- Sender and receiver information
- Origin and destination management
- Shipment weight tracking
- Automatic creation/update timestamps

### 🔎 Shipment Search & Filtering

Shipments can be searched and filtered using:

- Shipment status
- Carrier
- Origin
- Destination

### 📄 Pagination & Sorting

Shipment listing supports:

- Pagination
- Configurable page size
- Sorting
- Ascending order
- Descending order

Example:

```text
GET /api/v1/shipments?page=0&size=10&sortBy=createdAt&direction=desc
