CREATE DATABASE [BlueCrabCouture]
GO
USE [BlueCrabCouture]
GO
CREATE TABLE [Role](
	[id] INT IDENTITY PRIMARY KEY,
	[role_name] NVARCHAR(20) UNIQUE NOT NULL,
	[create_date] DATE DEFAULT GETDATE()
)
GO
CREATE TABLE [User](
	[id] INT IDENTITY PRIMARY KEY,
	[phone_number] NVARCHAR(13) UNIQUE NOT NULL,
	[password] NVARCHAR(50) NOT NULL,
	[id_role] INT FOREIGN KEY REFERENCES[Role](id),
	[is_locked] BIT DEFAULT 0,
	[create_date] DATE DEFAULT GETDATE()
)
GO
CREATE TABLE [Address](
	[id] INT IDENTITY PRIMARY KEY,
	[city] NVARCHAR(50),
	[district] NVARCHAR(50),
	[specific_information] NVARCHAR(255)
)
GO
CREATE TABLE [User_detail](
	[id] INT IDENTITY PRIMARY KEY,
	[name] NVARCHAR(50),
	[gender] BIT,
	[date_of_birth] DATE,
	[id_user] INT FOREIGN KEY REFERENCES[User](id),
	[id_address] INT FOREIGN KEY REFERENCES[Address](id),
	[last_edited] DATE DEFAULT GETDATE()
)
GO
CREATE TABLE [Category](
	[id] INT IDENTITY PRIMARY KEY,
	[url_logo] NVARCHAR(255),
	[name] NVARCHAR(50),
	[create_date] DATE DEFAULT GETDATE()
)
GO
CREATE TABLE [Brand](
	[id] INT IDENTITY PRIMARY KEY,
	[url_logo] NVARCHAR(255),
	[name] NVARCHAR(50),
	[create_date] DATE DEFAULT GETDATE()
)
GO
CREATE TABLE [Color](
	[id] INT IDENTITY PRIMARY KEY,
	[color_code] NVARCHAR(20),
	[name] NVARCHAR(20),
	[create_date] DATE DEFAULT GETDATE()
)
GO
CREATE TABLE [Size](
	[id] INT IDENTITY PRIMARY KEY,
	[name] NVARCHAR(20) UNIQUE,
	[create_date] DATE DEFAULT GETDATE()
)
GO
CREATE TABLE [Image](
	[id] INT IDENTITY PRIMARY KEY,
	[url] NVARCHAR(100),
	[create_date] DATE DEFAULT GETDATE()
)
GO
CREATE TABLE [Product](
	[id] INT IDENTITY PRIMARY KEY,
	[code] NVARCHAR(255),
	[name] NVARCHAR(255) NOT NULL,
	[sold] INT DEFAULT 0,
	[id_image] INT FOREIGN KEY REFERENCES[Image](id),
	[is_deleted] BIT DEFAULT 0,
	[id_user] INT FOREIGN KEY REFERENCES[User](id),
	[create_date] DATE DEFAULT GETDATE()
)
GO
CREATE TABLE [ProductDetail](
	[id] INT IDENTITY PRIMARY KEY,
	[id_category] INT FOREIGN KEY REFERENCES[Category](id),
	[id_brand] INT FOREIGN KEY REFERENCES[Brand](id),
	[id_color] INT FOREIGN KEY REFERENCES[Color](id),
	[id_size] INT FOREIGN KEY REFERENCES[Size](id),
	[id_product] INT FOREIGN KEY REFERENCES[Product](id),
	[price] BIGINT NOT NULL,
	[quantity] INT DEFAULT 0,
	[create_date] DATE DEFAULT GETDATE()
)
GO
CREATE TABLE [Cart](
	[id] INT IDENTITY PRIMARY KEY,
	[id_user] INT FOREIGN KEY REFERENCES[User](id),
	[quantity_product] INT,
	[total_money] BIGINT
)
GO
CREATE TABLE [CartDetail](
	[id] INT IDENTITY PRIMARY KEY,
	[price] BIGINT,
	[quantity] INT,
	[id_product_detail] INT FOREIGN KEY REFERENCES[ProductDetail](id),
	[add_date] DATE DEFAULT GETDATE(),
	[last_edited] DATE DEFAULT GETDATE()
)
GO
CREATE TABLE [StatusBill](
	[id] INT IDENTITY PRIMARY KEY,
	[name] NVARCHAR(50) UNIQUE NOT NULL
)
GO
CREATE TABLE [Bill](
	[id] INT IDENTITY PRIMARY KEY,
	[code_bill] NVARCHAR(50) UNIQUE NOT NULL,
	[id_user] INT FOREIGN KEY REFERENCES[User](id),
	[id_status] INT FOREIGN KEY REFERENCES[StatusBill](id),
	[total_money] BIGINT,
	[quantity_product] INT,
	[create_date] DATE DEFAULT GETDATE()
)
GO
CREATE TABLE [BillDetail](
	[id] INT IDENTITY PRIMARY KEY,
	[id_bill] INT FOREIGN KEY REFERENCES[Bill](id),
	[price] BIGINT,
	[quantity] INT,
	[id_product_detail] INT FOREIGN KEY REFERENCES[ProductDetail](id),
	[add_date] DATE DEFAULT GETDATE(),
	[last_edited] DATE DEFAULT GETDATE()
)