USE [pavlovskyim]
GO

/****** Object:  Table [dbo].[test]    Script Date: 24.03.2025 11:11:42 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO
/*
CREATE TABLE [dbo].[test](
	[id] [int] NOT NULL PRIMARY KEY
);
GO
*/
/*
DROP TABLE IF EXISTS[dbo].[test];
GO
CREATE TABLE [dbo].[test] (
[id] INT NOT NULL PRIMARY KEY);
GO
*/

ALTER TABLE [dbo].[test]
ADD 
	name NVARCHAR(100) NOT NULL,
	email NVARCHAR(255) NULL,
	created_at DATETIME DEFAULT GETDATE();
GO
