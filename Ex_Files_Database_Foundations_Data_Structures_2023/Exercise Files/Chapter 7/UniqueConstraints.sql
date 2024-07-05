-- Unique constraints
SELECT * FROM customers;

-- Add a unique constraint to an existing table column
ALTER TABLE customers
ADD CONSTRAINT unique_company UNIQUE (company);

-- Include a unique constraint when creating a table
CREATE TABLE customers (
    customer_id char(5) NOT NULL PRIMARY KEY,
    company varchar(100) NOT NULL,
    CONSTRAINT unique_company UNIQUE (company)
);

-- Remove a unique constraint from a table column
ALTER TABLE customers
DROP CONSTRAINT unique_company;

-- Try and enter a row with a duplicate company name
SELECT * FROM customers;

INSERT INTO customers (customer_id, company)
VALUES ('DF600', 'Delish Food');