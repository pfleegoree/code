--Aggregate number of orders by each company
CREATE VIEW inventory.OrdersByCompany AS
SELECT [company], COUNT(order_id) AS number_of_orders
FROM sales.[customers] 
    FULL JOIN sales.[orders]
ON customers.customer_id = orders.customer_id
GROUP BY company;

DROP VIEW inventory.OrdersByCompany;

SELECT * FROM sales.order_lines
SELECT * FROM inventory.products

SELECT order_lines.line_id,order_lines.quantity, price, order_lines.quantity * products.price as order_total_price
from sales.order_lines 
LEFT JOIN inventory.products
ON order_lines.sku = products.sku;



CREATE PROCEDURE sales.addCustomer
(
       -- Add the parameters for the stored procedure here
    @customer_id char(5) = NULL,
    @company nvarchar(100) = NULL
) 
AS

BEGIN
    -- SET NOCOUNT ON added to prevent extra result sets from
    -- interfering with SELECT statements.
    SET NOCOUNT ON

    -- Insert statements for procedure here
    INSERT 
       INTO sales.customers 
       (customer_id, 
       company)
       VALUES
        (@customer_id,
            @company
        ) 
        
END
GO

EXEC sales.addCustomer
@customer_id = 'MM123',
@company = 'Green Day'

