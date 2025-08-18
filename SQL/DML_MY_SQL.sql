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
