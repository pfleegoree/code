-- Cascade updates and deletes
SELECT * FROM customers;
SELECT * FROM orders;

-- Try to edit a customer id
UPDATE customers
SET customer_id = 'WR521' WHERE customer_id = 'WR421';

-- Try to remove a customer
DELETE FROM customers
WHERE customer_id = 'WR421'

-- Remove the existing foreign key constraint
ALTER TABLE orders
DROP CONSTRAINT fk_customers_customer_id;

-- Recreate the constraint with options to cascade update and cascade delete changes
ALTER TABLE orders
ADD CONSTRAINT fk_customers_customer_id FOREIGN KEY (customer_id)
      REFERENCES customers (customer_id)
      ON UPDATE CASCADE
      ON DELETE CASCADE
;

-- Edit a customer id
UPDATE customers
SET customer_id = 'WR521' WHERE customer_id = 'WR421';

SELECT * FROM customers;
SELECT * FROM orders;

-- Remove a customer
DELETE FROM customers
WHERE customer_id = 'WR521'

SELECT * FROM customers;
SELECT * FROM orders;