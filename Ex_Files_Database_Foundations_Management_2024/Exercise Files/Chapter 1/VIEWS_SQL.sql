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





