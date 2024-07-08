-- -- Create new table with employee data in PostgreSQL

CREATE TABLE employee (
    first_name      character varying(50),
    last_name       character varying(100),
    phone_number    character(8),
    office_number   character(3),
    hire_date       date,
    annual_salary   numeric (10,2)
);
INSERT INTO employee
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


SELECT * FROM employee;

DROP TABLE employee;