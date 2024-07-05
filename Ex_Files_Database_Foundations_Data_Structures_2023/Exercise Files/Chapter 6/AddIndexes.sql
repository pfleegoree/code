-- Add indexes to a table
SELECT * FROM customers;

-- Create an index on the 'state' column in the 'customers' table
CREATE INDEX IX_Customers_State  -- Typical PostgreSQL naming: customers_state_idx
ON customers (state);

-- Remove an index that is no longer needed
DROP INDEX IX_Customers_State;