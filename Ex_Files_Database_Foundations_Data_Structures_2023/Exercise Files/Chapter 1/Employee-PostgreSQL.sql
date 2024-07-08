-- -- Create new table with employee data in PostgreSQL
CREATE TABLE Employee (
    name varchar(100),
    phone_number varchar(10),
    cubical smallint,
    hire_date timestamp,
    annual_salary INTEGER
);

INSERT INTO Employee
 VALUES
        (
            'Dorean Grey', 
            '9159999999',
            '123',
            NOW(),
            '120000'
        )
;


SELECT * FROM Employee;

DROP TABLE TimeExperiment;