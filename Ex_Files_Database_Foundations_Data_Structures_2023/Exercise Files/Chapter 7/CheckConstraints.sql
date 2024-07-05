-- Creating Check constraints
SELECT * FROM orders;

-- Add a check constraint to an existing table column
ALTER TABLE orders
   ADD CONSTRAINT check_minimum_price
   CHECK (total_price > 100);

-- Include a check constraint when creating a table
CREATE TABLE orders (
    order_id int IDENTITY(100,1) NOT NULL PRIMARY KEY,
    order_date date,
    total_price decimal(10,2) CONSTRAINT check_minimum_price CHECK (total_price > 100),
    customer_id char(5)
);

-- Test the check constraint
INSERT INTO orders (order_date, total_price, customer_id)
VALUES ('2020-10-23', '50.00', 'FV418');

INSERT INTO orders (order_date, total_price, customer_id)
VALUES ('2020-10-23', '150.00', 'FV418');

SELECT * FROM orders;