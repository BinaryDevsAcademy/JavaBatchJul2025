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