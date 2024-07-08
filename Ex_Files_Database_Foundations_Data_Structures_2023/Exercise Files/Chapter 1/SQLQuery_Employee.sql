-- -- Create new table with Employee data in PostgreSQL

CREATE TABLE Employee (
    FirstName      varchar(50),
    LastName       varchar(100),
    PhoneNumber    char(8),
    OfficeNumber   char(3),
    HireDate       date,
    AnnualSalary   decimal (10,2)
);
INSERT INTO Employee
 VALUES
        (
            'Dorean', 
            'Grey',
            '55-0123',
            '123',
           '2024-04-01',
            45000.00
        )
;


SELECT * FROM Employee;

DROP TABLE Employee;