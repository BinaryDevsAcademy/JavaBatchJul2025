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
SELECT MAX(total_amount) FROM sales;
-- Find the MINIMUM total Amount in the sales table
SELECT MIN(total_amount) FROM sales;

-- We can group the data inside the table
-- By using group By
-- SELECT grp_col FROM tableName GROUP BY grp_base_col

SELECT sale_date FROM sales GROUP BY sale_date;

-- show the orders count on each date;
SELECT sale_date, COUNT(sale_id) FROM sales GROUP BY sale_date;

-- find the total price for each date in sales table
SELECT sale_date, SUM(total_amount) FROM sales GROUP BY sale_date;

-- find the total number of male and female customers in customers table
SELECT gender, COUNT(gender) FROM customers GROUP BY gender;

-- find how many customers are living in an area
SELECT customer_city, COUNT(customer_city) FROM customers GROUP BY customer_city;

-- find the count of sales in a day where the quantity is greater than equal 3

-- find the average revenue generated on each day in sales table
SELECT sale_date, AVG(total_amount) FROM sales GROUP BY sale_date;

-- group the dates where there avg price is greater than or equal to 700
SELECT sale_date, AVG(total_amount) AS total_amount FROM sales HAVING total_amount >= 700;


-- find the no of orders placed by each customer
SELECT customer_id, COUNT(customer_id) FROM sales GROUP BY customer_id;

-- find the types of payment methods used by customers
SELECT payment_method FROM sales GROUP BY payment_method;


SELECT sale_id, customer_id, payment_method FROM sales GROUP BY sale_id;
SELECT sale_id, customer_id, payment_method FROM sales;

-- limit - will limit the no of records to be displayed
-- Syntax : 
-- SELECT colName FROM tableName WHERE (optional) condition LIMIT no.of Records;
-- SELECT colName FROM tableName WHERE (optional) condition LIMIT from record, no.of Records;

SELECT * FROM sales LIMIT 2;

-- find the maximum total Amount in sales table
SELECT MAX(total_amount) FROM sales;

-- sorting table
-- Ascending order and Decending order
-- syntax
-- SELECT colName FROM tableName ORDER BY colName type (ASC/ DESC);

-- arrange the table column total_amount in ascending order
SELECT * FROM sales ORDER BY total_amount ASC;

-- find the second maximum total Amount in sales table
SELECT * FROM sales ORDER BY total_amount DESC LIMIT 1,1;

-- find the type of payment methods in sales table and show them in asc order

-- find the most used payment method
SELECT payment_method, count(payment_method) AS total FROM sales GROUP BY payment_method ORDER BY total DESC LIMIT 3;

-- Subquery  : query with in another query.

-- find the total no of orders placed by customer who are having email rahul.sharma@example.com

SELECT COUNT(sale_id) FROM sales GROUP BY customer_id HAVING customer_id = 
(SELECT customer_id FROM customers WHERE customer_email = "rahul.sharma@example.com");

-- find the total amount spent by customers who are living in city 3

-- selecting customerId from cutsomer table using customer_city
-- find sales amount by customerId
SELECT SUM(total_amount) FROM sales WHERE customer_id IN (SELECT customer_id FROM customers WHERE customer_city = 3);


-- find the customer who are living in Salt Lake

SELECT customer_name FROM customers WHERE customer_city = (SELECT location_id FROM location WHERE area_name = "Salt Lake");

-- find how many orders were place from location Bandra West
SELECT COUNT(sale_id) FROM sales WHERE customer_id IN (
SELECT customer_id FROM customers WHERE customer_city = (
SELECT location_id FROM location WHERE area_name = "Bandra West"));


-- find the customer name who are having payment status pending
SELECT customer_name FROM customers WHERE customer_id IN (
SELECT customer_id FROM sales WHERE status = "pending");

-- JOINs
-- 3 types
-- inner join
-- Syntax : 
-- SELECT colNames FROM table1 JOIN table2 ON condition (reference columns);
-- outer join
-- 1. left outer join
SELECT * FROM customers c LEFT OUTER JOIN location l ON c.customer_city = l.location_id;
-- 2. right outer join
SELECT * FROM customers c RIGHT OUTER JOIN location l ON c.customer_city = l.location_id;
-- 3. full outer join

-- cross join

SELECT 
c.customer_id, 
c.customer_name, 
c.customer_email, 
c.gender, 
c.customer_phone,
l.area_name,
l.area_pincode,
l.city_name,
l.state_name 
FROM customers c LEFT OUTER JOIN location l ON c.customer_city = l.location_id;


-- views : Views : 
-- used to create virtual tables in sql.

-- Virtual Tables : 
--     These are not the physical tables but will act similar to physical one.
-- Which helps us to perform CRUD operations 

-- -> If we modify the data in views table the data will be modified in the
-- original table as well

-- syntax : 
-- CREATE VIEW viewName AS QUERY


CREATE VIEW customersDataWithLocation AS SELECT 
c.customer_id, 
c.customer_name, 
c.customer_email, 
c.gender, 
c.customer_phone,
l.area_name,
l.area_pincode,
l.city_name,
l.state_name 
FROM customers c LEFT OUTER JOIN location l ON c.customer_city = l.location_id;


SELECT * FROM customersdatawithlocation;

UPDATE customersdatawithlocation SET area_name = "Gandhi Nagar" WHERE customer_id = 1;
-- updates the entire view - virtual table
CREATE OR REPLACE VIEW customersDataWithLocation AS SELECT * FROM customers;

-- delete a view
DROP VIEW customersDataWithLocation;


-- DCL - Data Control Lang
-- root - admin
-- database - tables - access - users
-- DQL, DML, DDL
-- To find the users in database
SELECT User, host FROM mysql.user;	

-- creating user
CREATE USER "dinesh"@"localhost" IDENTIFIED BY "1234";
-- GRANT - provides the permission to the user
GRANT SELECT,INSERT ON brollyacademy.sales TO "dinesh"@"localhost";

GRANT ALL PRIVILEGES ON brollyacademy.sales TO 'dinesh'@'localhost';

-- REVOKE - Retrives the permission from the user
REVOKE ALL PRIVILEGES, GRANT OPTION FROM 'dinesh'@'localhost';
