-- Setting default values
SELECT * FROM customers;

-- Add a default value to an existing table column in SQL Server
ALTER TABLE customers
    ADD CONSTRAINT default_state
    DEFAULT 'CA' FOR state;

-- Add a default value to an existing table column in PostgreSQL
ALTER TABLE customers
    ALTER COLUMN state SET DEFAULT 'CA';

-- Include a default value when creating a table
CREATE TABLE customers (
    customer_id char(5) NOT NULL PRIMARY KEY,
    company varchar(100) NOT NULL,
    state char(2) DEFAULT 'CA'
);

-- Test the default value
INSERT INTO customers (customer_id, company)
VALUES ('BX305', 'Bread Express');

SELECT * FROM customers;

-- Default values can be overridden by providing an alternate value
INSERT INTO customers (customer_id, company, state)
VALUES ('BV446', 'Blue Vine', 'FL');