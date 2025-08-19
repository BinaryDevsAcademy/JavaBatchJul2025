-- Data Query Lang : 
-- used to display the info inside tables
-- We use 'select' query 

-- To see all the records inside the table
-- SELECT * FROM tableName; -- where * is global selector which selects the entire columns
SELECT * FROM customers;

-- to select a specific column
-- SELECT colName FROM tableName;

SELECT customer_name, customer_email FROM customers;

-- to give an alias name to the column
-- SELECT colName AS aliasName FROM tableName;

-- variation 1 : 
SELECT customer_name AS name FROM customers;
-- variation 2 : 
SELECT customer_email email FROM customers;

-- Show customer name who are having id = 1;
SELECT customer_name FROM customers WHERE customer_id = 1;

-- patterns in mysql
-- to use patterns we have to use LIKE then we have to write the pattern
-- to write the pattern we are having 2 options 
-- 1. % - matches n number of characters
-- 2. _ - matches 1 character

-- show customers whose name starting with t 
SELECT * FROM customers WHERE customer_name LIKE 't%';

-- show customers who are having 'e' in there names
SELECT * FROM customers WHERE customer_name LIKE '%e%';

-- IN and BETWEEN
-- We use them to find the records within the range or in the set.

-- Find the customers who stays in city 1 and 3
SELECT * FROM customers WHERE customer_city IN (1,3);

-- Find the customers who stays in city 1 to 3
SELECT * FROM customers WHERE customer_city BETWEEN 1 AND 3;


SELECT * FROM sales;

-- show the records of sales which is having quantity greater than 4
SELECT * FROM sales WHERE quantity > 4;

-- Agg functions : SUM, AVG, MIN, MAX, COUNT
-- will perform operations on columns
-- Syntax : 
-- SELECT AGGFUN(colName) FROM table;

-- Find the sum of total amount in sales table
SELECT SUM(total_amount) AS total_Rev FROM sales;

-- Find the Avg quantity in the sales table
SELECT AVG(quantity) FROM sales;

-- Assignment
-- Find the MAXIMUM total amount in the sales table
-- Find the MINIMUM total Amount in the sales table