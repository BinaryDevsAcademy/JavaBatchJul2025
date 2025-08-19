-- used to show databases in this instance
-- show databases;
-- DDL - create - new table/ database creation, alter - updates on the table, drop, truncate
-- To create database -DDL- CREATE
-- CREATE DATABASE databasename;

CREATE DATABASE brollyacademy;

-- to create table - DDL - CREATE
-- CREATE TABLE tableName(colNae dataType constraints,...);

USE brollyacademy;

CREATE TABLE student(
	student_name VARCHAR(50),
    student_dob DATE
);

SHOW TABLES;

-- deletes the entire table
DROP TABLE student;


-- deletes the entire data inside the table
TRUNCATE TABLE student;

-- adding new column - student_phone to table student
-- query : alter table tableName add column colName dataType;

ALTER TABLE student ADD COLUMN student_phone BIGINT;

-- change student_phone datatype from Bigint to long
-- To modify any column in table we use modify keyword
-- query : ALTER TABLE tablename MODIFY COLUMN colName dataType;

ALTER TABLE student MODIFY COLUMN student_phone bigint;

-- to rename the column we use RENAME
-- alter table tablename RENAME column oldColName TO new ColName
-- change the student_phone column name to student_phone_number

ALTER TABLE student RENAME COLUMN student_phone TO student_phone_number;

-- to delete the column we use drop
-- ALTER TABLE tableName DROP COLUMN colName;
-- delete the student_phone_number column in student table

ALTER TABLE student DROP COLUMN student_phone_number;


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
(101, '2025-08-01', 2, 499.99, 'Credit Card', 'Completed'),
(102, '2025-08-01', 1, 799.00, 'UPI', 'Pending'),
(103, '2025-08-02', 3, 250.00, 'Cash', 'Completed'),
(104, '2025-08-02', 5, 120.50, 'Debit Card', 'Completed'),
(105, '2025-08-03', 2, 999.00, 'Net Banking', 'Completed'),
(106, '2025-08-03', 1, 450.75, 'Credit Card', 'Completed'),
(107, '2025-08-04', 4, 150.25, 'UPI', 'Pending'),
(108, '2025-08-04', 6, 80.00, 'Cash', 'Completed'),
(109, '2025-08-05', 3, 600.00, 'Credit Card', 'Completed'),
(110, '2025-08-05', 2, 1100.00, 'Debit Card', 'Completed'),
(111, '2025-08-06', 1, 750.50, 'Net Banking', 'Completed'),
(112, '2025-08-06', 7, 99.99, 'UPI', 'Pending'),
(113, '2025-08-07', 5, 200.00, 'Cash', 'Completed'),
(114, '2025-08-07', 2, 850.00, 'Credit Card', 'Completed'),
(115, '2025-08-08', 1, 2999.00, 'Debit Card', 'Pending'),
(116, '2025-08-08', 4, 400.00, 'Net Banking', 'Completed'),
(117, '2025-08-09', 3, 125.50, 'UPI', 'Completed'),
(118, '2025-08-09', 6, 175.75, 'Cash', 'Completed'),
(119, '2025-08-10', 2, 600.00, 'Credit Card', 'Completed'),
(120, '2025-08-10', 8, 50.00, 'UPI', 'Completed');


