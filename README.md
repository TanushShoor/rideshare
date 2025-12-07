# 🚕 RideShare Backend – Spring Boot + MongoDB + JWT

A fully functional backend for a Ride Sharing application built using **Spring Boot**, **MongoDB**, **JWT Authentication**, **Input Validation**, **Exception Handling**, and **Role-Based Access Control**.

This project was developed as part of an academic assignment to demonstrate real-world backend architecture and clean API design.

---

## 📌 Features

### 🔐 Authentication & Authorization
- User Registration (ROLE_USER, ROLE_DRIVER)
- Login with JWT token generation
- Password encryption using BCrypt
- Role-based access control using Spring Security

### 🚗 Ride Management
- Passengers (ROLE_USER) can request rides
- Drivers (ROLE_DRIVER) can view pending requests
- Drivers can accept rides
- Users/Drivers can complete rides
- Users can view all their rides

### ⚙️ Backend Architecture
- Layered architecture:
  - **Controller → Service → Repository**
- DTOs with input validation
- Global exception handling
- MongoDB integration using Spring Data
- Secure endpoints with JWT filters

---

## 🧱 Technologies Used

- **Java 22**
- **Spring Boot 3.x**
- **Spring Security + JWT (jjwt)**
- **MongoDB**
- **Maven**
- **Lombok**
- **Jakarta Validation**

---

## 📂 Folder Structure
```
src/main/java/org/example/rideshare/
├── config/ # Security & JWT configurations
├── controller/ # API controllers
├── dto/ # Request/response DTOs
├── exception/ # Custom exceptions + global handler
├── model/ # MongoDB entity models
├── repository/ # MongoDB repositories
├── service/ # Business logic layer
├── util/ # Utility classes (JWT util, etc.)
src/main/resources/
└── application.properties
```
---

## ⚙️ Installation & Setup

### 1️⃣ Clone the repository

```bash
git clone https://github.com/TanushShoor/rideshare.git
cd <your-repo-name>
```

### 2️⃣ Configure MongoDB

Make sure MongoDB is running locally on default port.

Default DB config in `application.properties`:

```properties
spring.data.mongodb.uri=mongodb://localhost:27017/rideshare
```

You can open MongoDB Compass to view data.

### 3️⃣ Run the project

Using Maven:

```bash
mvn clean install
mvn spring-boot:run
```

Or run `RideshareApplication` from IntelliJ IDEA.

---

## 🔑 Authentication (JWT)

After login, you will receive a **JWT token** like:

```
eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...
```

Use this in protected endpoints:

```
Authorization: Bearer <token>
```

---

## 🧪 API Endpoints & Testing

### 🔹 Authentication

#### Register User/Driver  
**POST** `/api/auth/register`

```json
{
  "username": "john",
  "password": "1234",
  "role": "ROLE_USER"
}
```

#### Login  
**POST** `/api/auth/login`

```json
{
  "username": "john",
  "password": "1234"
}
```

---

## 🚕 USER Endpoints (ROLE_USER)

### Request a Ride  
**POST** `/api/v1/rides`

```json
{
  "pickupLocation": "Koramangala",
  "dropLocation": "Indiranagar"
}
```

### View My Rides  
**GET** `/api/v1/user/rides`

---

## 🚗 DRIVER Endpoints (ROLE_DRIVER)

### View Pending Rides  
**GET** `/api/v1/driver/rides/requests`

### Accept a Ride  
**POST** `/api/v1/driver/rides/{rideId}/accept`

---

## ✔ Complete Ride  
(Allowed for both USER & DRIVER)

**POST** `/api/v1/rides/{rideId}/complete`

---

## ❗ Validation Rules

- Pickup & drop locations must not be blank
- Custom validation messages returned in JSON
- Bad requests return `400`
- Missing entity returns `404`

---

## 🛡 Global Exception Handling

Standard error format:

```json
{
  "error": "VALIDATION_ERROR",
  "message": "Pickup is required",
  "timestamp": "2025-01-20T12:00:00Z"
}
```

---

## 🧪 Testing Guide (Postman)

1. Register USER & DRIVER  
2. Login both → get JWT tokens  
3. USER → Create Ride  
4. DRIVER → See pending rides  
5. DRIVER → Accept Ride  
6. USER/DRIVER → Complete Ride  
7. USER → View My Rides  

All tests should return correct data & status codes.

---

## 📘 Notes

- There is **no HTML/UI page**, backend is tested using Postman.
- `/` (root URL) may show `403` due to security — this is expected.
- Only `/api/auth/**` is public; everything else requires a JWT.

---

## 📄 License

This project is for educational purposes.

---

## ✨ Author

**Tanush Shoor**  
Backend Developer | Computer Science Student





