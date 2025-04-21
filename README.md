# Java Web Based Login System

A secure and modular login system built with **Java Servlets**, **JDBC**, and **Oracle Database**. It uses **BCrypt hashing** for password security and supports basic user management features through a web interface.

---

## 🔧 Features

- ✅ User Registration & Login
- 🔐 Secure Password Handling with BCrypt
- 📄 View Account Details
- ✏️ Update Email, Address, and Phone Number
- 🗑️ Delete Account
- 📡 JSON-based client-server communication
- 🔗 Database Connectivity using JDBC

---

## 🛠️ Technologies Used

- java version "23.0.1" 
- Servlets (Java EE)
- JDBC
- Oracle Database 
- BCrypt (via jBCrypt library)
- Apache Tomcat (10.1+)
- IntelliJ IDEA Ultimate

---

## 🔒  Security

All passwords are encrypted using the **BCrypt** hashing algorithm before being stored in the database. This adds a strong layer of protection against brute-force and rainbow table attacks.

Required fields are enforced through both frontend (required attribute in HTML) and backend validation to prevent bypassing via browser tools.
