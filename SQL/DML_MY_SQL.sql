-- working on the normalized data in this file

-- creating customers table

-- contraints - rule that we apply on a column
-- 1. primary key - defines the primary key of the table
-- 2. foriegn key - creates a reference to the another table using it's primary key
-- 3. NOT NULL - make sure that the column data is not a null value 
-- 4. Unique - make sures that the data in the column is unique
-- 5. DEFAULT - will fill the cell with the default value - if passes an empty value
-- AUTO_INCREMENT - will increase the value automatically - apply on int - primary key

CREATE TABLE location(
	location_id INT PRIMARY KEY AUTO_INCREMENT,
    area_name VARCHAR(30) NOT NULL UNIQUE, 
    area_pincode INT NOT NULL UNIQUE,
    city_name VARCHAR(30) NOT NULL,
    state_name VARCHAR(40) NOT NULL
);

INSERT INTO location (area_name, area_pincode, city_name, state_name) VALUES
('Connaught Place', 110001, 'New Delhi', 'Delhi'),
('Bandra West', 400050, 'Mumbai', 'Maharashtra'),
('Whitefield', 560066, 'Bangalore', 'Karnataka'),
('Gachibowli', 500032, 'Hyderabad', 'Telangana'),
('Salt Lake', 700091, 'Kolkata', 'West Bengal'),
('Anna Nagar', 600040, 'Chennai', 'Tamil Nadu'),
('Civil Lines', 302006, 'Jaipur', 'Rajasthan'),
('Alkapuri', 390007, 'Vadodara', 'Gujarat'),
('Sector 17', 160017, 'Chandigarh', 'Chandigarh'),
('Vastrapur', 380015, 'Ahmedabad', 'Gujarat');


CREATE TABLE customers(
	customer_id INT PRIMARY KEY AUTO_INCREMENT,
    customer_name VARCHAR(80) NOT NULL,
    customer_phone BIGINT UNIQUE,
    customer_email VARCHAR(90) UNIQUE,
    customer_password VARCHAR(89) NOT NULL,
    customer_city INT,
    accountCreationTime TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (customer_city) REFERENCES location(location_id)
);

INSERT INTO customers (customer_name, customer_phone, customer_email, customer_password, customer_city) VALUES
('Rahul Sharma', 9876543210, 'rahul.sharma@example.com', 'Rahul@123', 1),
('Priya Verma', 9123456780, 'priya.verma@example.com', 'Priya@456', 2),
('Amit Kumar', 9988776655, 'amit.kumar@example.com', 'Amit@789', 3),
('Sneha Reddy', 9090909090, 'sneha.reddy@example.com', 'Sneha@111', 4),
('Vikram Singh', 9876501234, 'vikram.singh@example.com', 'Vikram@222', 2),
('Anjali Nair', 9123009876, 'anjali.nair@example.com', 'Anjali@333', 1),
('Rohan Das', 9898989898, 'rohan.das@example.com', 'Rohan@444', 5),
('Meena Iyer', 9765432109, 'meena.iyer@example.com', 'Meena@555', 3),
('Karthik Rao', 9345678901, 'karthik.rao@example.com', 'Karthik@666', 4),
('Pooja Patel', 9789456123, 'pooja.patel@example.com', 'Pooja@777', 1);


CREATE TABLE sales (
    sale_id INT PRIMARY KEY AUTO_INCREMENT,
    customer_id INT NOT NULL,
    sale_date DATE NOT NULL,
    quantity INT NOT NULL,
    price DECIMAL(10,2) NOT NULL,
    total_amount DECIMAL(10,2) GENERATED ALWAYS AS (quantity * price) STORED,
    payment_method VARCHAR(50),
    status VARCHAR(20) DEFAULT 'Completed',
    FOREIGN KEY (customer_id) REFERENCES customers(customer_id)
);


INSERT INTO sales (customer_id, sale_date, quantity, price, payment_method, status) VALUES
(1, '2025-08-01', 2, 499.99, 'Credit Card', 'Completed'),
(2, '2025-08-01', 1, 799.00, 'UPI', 'Pending'),
(3, '2025-08-02', 3, 250.00, 'Cash', 'Completed'),
(4, '2025-08-02', 5, 120.50, 'Debit Card', 'Completed'),
(5, '2025-08-03', 2, 999.00, 'Net Banking', 'Completed'),
(6, '2025-08-03', 1, 450.75, 'Credit Card', 'Completed'),
(7, '2025-08-04', 4, 150.25, 'UPI', 'Pending'),
(8, '2025-08-04', 6, 80.00, 'Cash', 'Completed'),
(9, '2025-08-05', 3, 600.00, 'Credit Card', 'Completed'),
(10, '2025-08-05', 2, 1100.00, 'Debit Card', 'Completed'),
(1, '2025-08-06', 1, 750.50, 'Net Banking', 'Completed'),
(2, '2025-08-06', 7, 99.99, 'UPI', 'Pending'),
(3, '2025-08-07', 5, 200.00, 'Cash', 'Completed'),
(4, '2025-08-07', 2, 850.00, 'Credit Card', 'Completed'),
(5, '2025-08-08', 1, 2999.00, 'Debit Card', 'Pending'),
(6, '2025-08-08', 4, 400.00, 'Net Banking', 'Completed'),
(7, '2025-08-09', 3, 125.50, 'UPI', 'Completed'),
(8, '2025-08-09', 6, 175.75, 'Cash', 'Completed'),
(9, '2025-08-10', 2, 600.00, 'Credit Card', 'Completed'),
(10, '2025-08-10', 8, 50.00, 'UPI', 'Completed');


-- DML : 
-- 1. insert
-- SYNTAX : 
-- INSERT INTO tableName VALUES(value1, value2, value3, .....);

-- insert specific column data
-- INSERT INTO tableName(colName1, colName2,...) VALUES (value1,....);
INSERT INTO customers(
	customer_name,
    customer_phone,
    customer_email,
    customer_password
) VALUES("Raj", 8907654432, "raj@gmail.com","Raj@1234");

-- inserting multiple values into the table
INSERT INTO customers(
	customer_name,
    customer_phone,
    customer_email,
    customer_password
) VALUES
("Tina", 8927654432, "tina@gmail.com","Tina@1234"),
("james", 9107654432, "james@gmail.com","James@1234"),
("Harry", 9907654432, "harry@gmail.com","Harry@1234"),
("Rom", 8456654432, "rom@gmail.com","Rom@1234");

ALTER TABLE customers
ADD gender ENUM('Male','Female','Other') AFTER customer_name;

UPDATE customers SET gender = 'Male' WHERE customer_id IN (1,3,5,7,9);
UPDATE customers SET gender = 'Female' WHERE customer_id IN (2,4,6,8,10);


INSERT INTO location(
	area_name, area_pincode, city_name, state_name
) VALUES
("KPHB", 500071, "Hyderabad", "Telangana"),
("KADAPA", 516360, "Kadapa", "Andhra"),
("KURNOOL", 510071, "Kurnool", "Andhra"),
("KARIMNAGAR", 540071, "Karimnagar", "Telangana");

-- 2. update
-- to update any records in the database table we use update command
-- UPDATE tableName SET colName = value;
UPDATE customers SET customer_city = 3;

-- to update specific records - apply condition WHERE condition
-- for an example change the customer name for cusId = 1
-- UDPATE tableName SET colName = value WHERE condition;

UPDATE customers SET customer_name = "Rajesh" WHERE customer_id = 1;

-- set customer_city = 1 for customers who are having id greater than or equal to 4
UPDATE customers SET customer_city = 1 WHERE customer_id >= 4;

-- set customer_city = 2 for customers who are having not having id as even number
UPDATE customers SET customer_city = 2 WHERE customer_id%2 != 0;

-- 3. delete
-- to delete a record form the table. 
-- 1st issue is auto increment will not reset
-- syntax : 
-- deletes all the records in the table : 
-- DELETE FROM tableName;

-- delete a certain record or records. 
DELETE FROM customers WHERE customer_id = 5;

-- showing tables;
SHOW TABLES;

-- to see the data in the table
-- DQL - SELECT
-- SELECT * FROM tableName;
SELECT * FROM customers;
SELECT * FROM location;

-- to turn off safe updates mode 
