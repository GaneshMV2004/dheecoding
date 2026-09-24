CREATE DATABASE IF NOT EXISTS medislot;
USE medislot;

CREATE TABLE IF NOT EXISTS patients (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(150) NOT NULL UNIQUE,
    phone VARCHAR(20)
);

CREATE TABLE IF NOT EXISTS doctors (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    specialization VARCHAR(100) NOT NULL
);

CREATE TABLE IF NOT EXISTS appointments (
    id INT PRIMARY KEY AUTO_INCREMENT,
    patient_id INT NOT NULL,
    doctor_id INT NOT NULL,
    appointment_date DATE NOT NULL,
    appointment_time TIME NOT NULL,
    status VARCHAR(20) NOT NULL DEFAULT 'BOOKED',
    FOREIGN KEY (patient_id) REFERENCES patients(id),
    FOREIGN KEY (doctor_id) REFERENCES doctors(id)
);

INSERT INTO doctors (name, specialization)
SELECT 'Dr. Anil Kumar', 'General Medicine'
WHERE NOT EXISTS (SELECT 1 FROM doctors WHERE name='Dr. Anil Kumar');

INSERT INTO doctors (name, specialization)
SELECT 'Dr. Priya Sharma', 'Dermatology'
WHERE NOT EXISTS (SELECT 1 FROM doctors WHERE name='Dr. Priya Sharma');
