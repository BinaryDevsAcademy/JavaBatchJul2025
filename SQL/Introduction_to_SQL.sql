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


