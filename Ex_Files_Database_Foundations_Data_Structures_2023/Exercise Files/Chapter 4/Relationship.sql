-- Creating a foreign key constraint
SELECT * FROM customers;
SELECT * FROM orders;

-- Insert an orphan row
INSERT INTO orders (order_date, total_price, customer_id) VALUES
('2020-10-22', 397.54, 'DF399');

SELECT * FROM customers;
SELECT * FROM orders;

DELETE FROM orders WHERE customer_id = 'DF399';


-- Add a foreign key constraint on the customer_id column
ALTER TABLE orders
ADD CONSTRAINT fk_customers_customer_id FOREIGN KEY (customer_id)
    REFERENCES customers (customer_id)
;

-- Try to add the orphan row again
INSERT INTO orders (order_date, total_price, customer_id) VALUES
('2020-10-22', 397.54, 'DF399');

-- Add the new customer data first, then enter the order
INSERT INTO customers VALUES
('DF399', 'Delish Food', '583 Roosevelt Lane', 'Evergreen Park', 'IL', '60642');

INSERT INTO orders (order_date, total_price, customer_id) VALUES
('2020-10-22', 397.54, 'DF399');

SELECT * FROM customers;
SELECT * FROM orders;