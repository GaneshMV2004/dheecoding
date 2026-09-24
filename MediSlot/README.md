# MediSlot — Medical Appointment Booking System

MediSlot is a beginner-friendly Java backend project for managing doctors, patients, and medical appointments.

## Technology
- Java
- JDBC
- MySQL
- Maven

## Features
- Register patients
- Add doctors
- View available doctors
- Book appointments
- View appointments
- Cancel appointments
- Store data in MySQL

## Database setup
1. Create a MySQL database using `database/schema.sql`.
2. Update the database URL, username, and password in `src/main/java/com/medislot/config/DatabaseConnection.java`.
3. Run the Maven project.

## Project structure
```
MediSlot/
├── database/schema.sql
├── pom.xml
└── src/main/java/com/medislot/
    ├── Main.java
    ├── config/DatabaseConnection.java
    ├── model/Doctor.java
    ├── model/Patient.java
    ├── model/Appointment.java
    └── dao/AppointmentDAO.java
```

This repository is a learning/project implementation and can be extended with Servlets, Spring Boot, authentication, and a web frontend.
