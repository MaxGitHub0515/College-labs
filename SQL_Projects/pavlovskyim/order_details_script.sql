USE [pavlovskyim]
GO

/****** Object:  Table [dbo].[ORDER DET]    Script Date: 24.03.2025 11:33:56 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO



ALTER TABLE [dbo].[ORDER DET]
	ADD CONSTRAINT FK_OrderDetails_Order
	FOREIGN KEY (id_order) REFERENCES dbo.[ORDER](id_order)
	ON DELETE CASCADE,


	CONSTRAINT FK_OrderDetails_Product 
	FOREIGN KEY (id_product) REFERENCES dbo.[PRODUCTS](id_product) 