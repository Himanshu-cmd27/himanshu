# 🎓 Student Management System

## 💡 Overview
A **Java Swing GUI-based desktop application** that allows users to manage student records. It uses **JDBC** to interact with a **MySQL** database and follows the **Model-View-Controller (MVC)** architecture for clean separation of concerns.

---

## 🧱 Project Structure

StudentManagement/
├── src/
│ ├── model/ # Student.java - Model class
│ ├── dao/ # StudentDAO.java - DB access logic
│ ├── ui/ # StudentForm.java - Swing GUI
│ ├── db/ # DBConnection.java - JDBC connection
│ └── Main.java # Main entry point
└── README.md # Project documentation

---

## ⚙️ Technologies Used

- **Java 8+**
- **Swing (Java GUI)**
- **MySQL** (Database)
- **JDBC** (Database connectivity)

---

## 🧪 Features

- Add new student records with name, email, and age
- Validates user input (empty fields, email format, numeric age)
- Prevents duplicate emails using database constraints
- Clean error handling with meaningful messages
- MVC-based structure for maintainability

---

## 🗃️ Database Setup (MySQL)

Run the following SQL commands to set up your database:

```sql
CREATE DATABASE student_db;
USE student_db;

CREATE TABLE students (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    age INT NOT NULL
);
