-- Creating and using foreign key fields
SELECT * FROM customers;

-- Create a table that relates to the 'customers' table
CREATE TABLE orders (
    order_id     INT IDENTITY(100,1) NOT NULL PRIMARY KEY, --PostgreSQL: use GENERATED ALWAYS AS IDENTITY (START WITH 100 INCREMENT BY 1)
    order_date   DATE,
    total_price  DECIMAL(10,2),
    customer_id  CHAR(5)
);

INSERT INTO orders (order_date, total_price, customer_id) VALUES
    ('2020-10-15', 195.99, 'FV418'),
    ('2020-10-19', 128.76, 'FV418'),
    ('2020-10-20', 65.92, 'WR421'),
    ('2020-10-20', 1518.33, 'FV418')
;

-- View the result in both tables
SELECT * FROM customers;
SELECT * FROM orders;

-- Join data rows by matching primary and foreign key fields
SELECT  orders.order_id,
        orders.order_date,
        customers.company,
        customers.customer_id,
        customers.address,
        customers.city,
        customers.state,
        orders.total_price
FROM customers JOIN orders ON customers.customer_id = orders.customer_id;
