--Aggregate number of orders by each company
CREATE VIEW inventory.OrdersByCompany AS
SELECT [company], COUNT(order_id) AS number_of_orders
FROM sales.[customers] 
    FULL JOIN sales.[orders]
ON customers.customer_id = orders.customer_id
GROUP BY company;


DROP VIEW inventory.OrdersByCompany;



