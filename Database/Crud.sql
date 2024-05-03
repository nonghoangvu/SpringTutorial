CREATE DATABASE CRUD_Tutorial
GO
USE CRUD_Tutorial
GO
CREATE TABLE [Student] (
	id INT IDENTITY PRIMARY KEY,
	full_name NVARCHAR(50),
	age INT,
	gender BIT
)
INSERT INTO Student(full_name, age, gender) VALUES ('Nong Hoang Vu', 19, '1')