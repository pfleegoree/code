-- Creating tables with Primary Keys in SQL Server
-- OPTION 1
-- Create the primary key column in the column specification
CREATE TABLE customers (
    customer_id char(5) NOT NULL PRIMARY KEY,
    company     varchar(100),
    address     varchar(100),
    city        varchar(50),
    state       char(2),
    zip         char(5)
);

DROP TABLE customers;


-- OPTION 2
-- Add the primary key constraint when creating the table
CREATE TABLE customers (
    customer_id char(5) NOT NULL,
    company     varchar(100),
    address     varchar(100),
    city        varchar(50),
    state       char(2),
    zip         char(5),
    CONSTRAINT PK_Customers_CustomerID PRIMARY KEY (customer_id)
);

DROP TABLE customers;


-- OPTION 3
-- Add the primary key after the table is created
CREATE TABLE customers (
    customer_id char(5) NOT NULL,
    company     varchar(100),
    address     varchar(100),
    city        varchar(50),
    state       char(2),
    zip         char(5)
);

ALTER TABLE customers
   ADD CONSTRAINT PK_Customers_CustomerID PRIMARY KEY (customer_id);


-- Test out the Primary Key
INSERT INTO customers VALUES
('FV418', 'Flavorville', '798 Ravinia Road', 'Des Moines', 'IA', '50320');

INSERT INTO customers VALUES
('FV418', 'Wild Rose', '222 Dakota Lane', 'Kalamazoo', 'MI', '49001');
-- Change id for Wild Rose to 'WR421'

SELECT * FROM customers;