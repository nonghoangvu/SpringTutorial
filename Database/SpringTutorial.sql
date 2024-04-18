CREATE DATABASE SpringTutorial
GO
USE SpringTutorial
GO
CREATE TABLE [Role](
	[id] INT IDENTITY PRIMARY KEY,
	[role_key] NVARCHAR(10) UNIQUE NOT NULL
)
GO
CREATE TABLE [Account](
	[id] INT IDENTITY PRIMARY KEY,
	[username] NVARCHAR(20) UNIQUE NOT NULL,
	[password] NVARCHAR(100) NOT NULL,
	[fullName]	NVARCHAR(50) NULL,
	[id_role] INT FOREIGN KEY REFERENCES [Role]([id])
)
GO
CREATE TABLE [Country](
	[id] INT IDENTITY PRIMARY KEY,
	[country] NVARCHAR(30) UNIQUE NOT NULL
)
GO
CREATE TABLE [Employee](
	[id] INT IDENTITY PRIMARY KEY,
	[fullname] NVARCHAR(50) NOT NULL,
	[gender] BIT NOT NULL,
	[date_of_birth] DATE NOT NULL,
	[id_country] INT FOREIGN KEY REFERENCES [Country]([id]),
	[create_date] DATE DEFAULT GETDATE()
)

GO
INSERT INTO [Role] ([role_key]) VALUES ('Admin'), ('User')
GO
INSERT INTO [Account] ([username], [password], [fullName], [id_role]) VALUES ('admin', '123', 'Nong Hoang Vu', 1)
GO
INSERT INTO [Country] ([country]) 
VALUES 
('Vietnam'),
('USA'),
('China'),
('India'),
('Brazil'),
('Mexico'),
('Japan'),
('Germany'),
('United Kingdom'),
('France'),
('Italy'),
('Canada'),
('South Korea'),
('Russia'),
('Australia'),
('Spain'),
('Indonesia'),
('Netherlands'),
('Saudi Arabia'),
('Turkey');
GO
INSERT INTO [Employee] ([fullName], [gender], [dateOfBirth], [id_country])
VALUES 
('John Doe', 1, '1990-05-15', 1),
('Jane Smith', 0, '1988-10-20', 2),
('Michael Johnson', 1, '1985-03-12', 3),
('Emily Brown', 0, '1992-07-30', 4),
('Daniel Lee', 1, '1980-11-25', 5),
('Sarah Kim', 0, '1976-09-05', 6),
('David Wang', 1, '1995-12-08', 7),
('Emma Garcia', 0, '1983-04-18', 8),
('Ryan Martinez', 1, '1998-02-22', 9),
('Olivia Lopez', 0, '1991-06-10', 10);