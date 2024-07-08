-- Create new table with employee data
CREATE TABLE Employee (
    name varchar(100),
    phone_number varchar(10),
    cubical tinyint,
    hire_date DATETIME,
    annual_salary INTEGER

);

-- Enter first Employee
INSERT INTO Employee
    VALUES
        (
            'Dorean Grey', 
            '9159999999',
            '123',
            getdate(),
            '120000'

        )
;

SELECT * FROM Employee;

DROP TABLE Employee;