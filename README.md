
Hotel Reservation System (Java + MySQL)

This is a simple **Hotel Reservation System** built using **Java** and **MySQL** that allows you to:
- Create new reservations
- View all reservations
- Retrieve room number by reservation ID
- Update reservation details
- Delete reservations

---

Author

Abdul Kayum
GitHub: Abdul-Git331

---

Features

 Add a new reservation  
 View all reservations  
 Get room number by reservation ID  
 Update guest name using reservation ID  
 Delete a reservation  
 Clean and interactive CLI interface  

---

Technologies Used

- Java (JDK 8+)
- MySQL (Database)
- JDBC (Java Database Connectivity)

---

Prerequisites

Before running the application, make sure you have:

- Java JDK installed
- MySQL Server running locally
- MySQL JDBC Driver (`mysql-connector-java`) added to your project
- A MySQL database named `hotel_db` with a table named `reservation`

Sample MySQL Table

```sql
CREATE DATABASE hotel_db;

USE hotel_db;

CREATE TABLE reservation (
    reservation_id INT PRIMARY KEY,
    guest_name VARCHAR(100),
    room_number INT
);
