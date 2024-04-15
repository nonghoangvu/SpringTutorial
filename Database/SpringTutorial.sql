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
	[username] NCHAR(20) UNIQUE NOT NULL,
	[password] NVARCHAR(100) NOT NULL,
	[fullname]	NVARCHAR(50) NULL,
	[id_role] INT FOREIGN KEY REFERENCES [Role](id)
)
GO
INSERT INTO [Role] ([role_key]) VALUES ('Admin'), ('User')
GO
INSERT INTO [Account] ([username], [password], [fullname], [id_role]) VALUES ('admin', '123', 'Nong Hoang Vu', 1)
GO
SELECT * FROM [Account] INNER JOIN [Role] ON [Account].id_role = [Role].id
