# JDBC Project - User Management System

## 📋 Project Overview
This is a Java JDBC (Java Database Connectivity) project that demonstrates how to connect to a MySQL database and perform basic CRUD operations. The application retrieves user data from a MySQL database and displays it in the console.

## 🗂️ Project Structure

```
JDBCProject/
├── lib/
│   └── mysql-connector-j-8.3.0.jar    # MySQL JDBC Driver
├── src/
│   ├── Main.java                      # Entry point of the application
│   ├── README.md                      # This file
│   ├── db/
│   │   └── DBConnection.java          # Database connection utility class
│   ├── dao/
│   │   └── UserDAO.java               # Data Access Object for User operations
│   └── model/
│       └── User.java                  # User model/entity class
```

## 📁 File Descriptions

### 1. **Main.java**
- **Purpose**: Entry point of the application
- **Responsibilities**:
  - Creates a UserDAO instance
  - Retrieves all users from the database
  - Displays the user data in the console

### 2. **db/DBConnection.java**
- **Purpose**: Manages database connections
- **Key Details**:
  - Connection URL: `jdbc:mysql://localhost:3306/jdbc_demo`
  - Username: `root`
  - Password: `29072006`
  - Method: `getConnection()` - Returns a Connection object

### 3. **model/User.java**
- **Purpose**: Represents the User entity
- **Properties**:
  - `id`: User ID (int)
  - `name`: User's name (String)
  - `email`: User's email address (String)
- **Methods**:
  - Getters for all properties
  - `toString()`: Returns formatted user data as "id | name | email"

### 4. **dao/UserDAO.java**
- **Purpose**: Data Access Object for user-related database operations
- **Methods**:
  - `getAllUsers()`: Retrieves all users from the MySQL `users` table
  - Returns a List of User objects
  - Handles SQL exceptions gracefully

### 5. **lib/mysql-connector-j-8.3.0.jar**
- **Purpose**: MySQL JDBC Driver
- **Usage**: Required to establish connections to MySQL databases

## 🔧 Prerequisites

- **Java Development Kit (JDK)**: Java 8 or higher
- **MySQL Server**: Running locally on port 3306
- **Database**: `jdbc_demo` database with a `users` table
- **MySQL JDBC Driver**: `mysql-connector-j-8.3.0.jar` (included in lib folder)

## 📊 Database Schema

Expected `users` table structure:
```sql
CREATE TABLE users (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL
);
```

Example data:
```sql
INSERT INTO users (name, email) VALUES ('alice', 'alice@gmail.com');
```

## ▶️ How to Run

### Step 1: Compile all Java files
```powershell
cd c:\Users\vidhi\Downloads\JDBCProject
javac (Get-ChildItem -Path src -Filter *.java -Recurse).FullName
```

### Step 2: Run the application with MySQL driver in classpath
```powershell
java -cp ".;lib/mysql-connector-j-8.3.0.jar;src" Main
```

**Output Example:**
```
✅ Connected to MySQL successfully!
📋 User Data:
1 | alice | alice@gmail.com
```

## 🔑 Key Concepts Demonstrated

1. **JDBC Connectivity**: Establishing connections to MySQL databases
2. **DAO Pattern**: Separating data access logic from business logic
3. **Model/Entity Pattern**: Creating domain objects (User)
4. **Connection Management**: Using try-with-resources for proper resource cleanup
5. **SQL Queries**: Executing SELECT queries and processing ResultSets

## ⚠️ Common Issues & Solutions

### Issue: "No suitable driver found for jdbc:mysql://..."
**Solution**: Ensure the MySQL JDBC driver is in the classpath when running:
```powershell
java -cp ".;lib/mysql-connector-j-8.3.0.jar;src" Main
```

### Issue: "Access denied for user 'root'..."
**Solution**: Update the credentials in `DBConnection.java` to match your MySQL configuration

### Issue: "Unknown database 'jdbc_demo'..."
**Solution**: Create the database and users table in MySQL:
```sql
CREATE DATABASE jdbc_demo;
USE jdbc_demo;
CREATE TABLE users (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL
);
```

## 🚀 Future Enhancements

- Add CREATE, UPDATE, DELETE operations in UserDAO
- Implement connection pooling
- Add error handling and logging
- Create unit tests
- Add input validation

## 📝 Notes

- The project uses Java 8+ features (try-with-resources)
- Exceptions are caught and printed to console for debugging
- The connection is automatically closed due to try-with-resources statement
