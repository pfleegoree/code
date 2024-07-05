-- Null constraints
SELECT * FROM customers;

-- Add a null constraint to an existing table column
ALTER TABLE customers
ALTER COLUMN company varchar(100) NOT NULL;

-- Include a null constraint when creating a table
CREATE TABLE customers (
    customer_id char(5) NOT NULL PRIMARY KEY,
    company varchar(100) NOT NULL,
    -- and so on...
)

-- Try and enter a row with no company name
INSERT INTO customers (customer_id)
VALUES ('GR208');

-- Enter a row with just a company id and name
INSERT INTO customers (customer_id, company)
VALUES ('GR208', 'Green Gardens');

SELECT * FROM customers;

-- View detailed information about each column's design in SQL Server
EXEC sp_columns @table_name = 'customers';

-- View detailed information about each column's design in PostgreSQL
SELECT * FROM information_schema.columns
WHERE table_name = 'employees';