-- Creating and using foreign key fields
SELECT * FROM QuarterlyBonus;

-- Create a table that relates to the 'customers' table
CREATE TABLE QuarterlyBonus (
    BonusID         INT IDENTITY(1,1) NOT NULL,
    BonusAmount     DECIMAL(10,2),
    Quarter         CHAR(7),
    EmployeeID      INT,
    CONSTRAINT PK_QuarterlyBonus_BonusID PRIMARY KEY (BonusID) 
);

ALTER TABLE QuarterlyBonus
ADD CONSTRAINT fk_Employee_EmployeeID FOREIGN KEY (EmployeeID)
    REFERENCES Employee (EmployeeID)
;

INSERT INTO QuarterlyBonus (QuarterEarned, AmountPaid) VALUES
    (418,'John', 1, 300),
   (419,'Elton', 2, 300.1),
   (420,'Susan', 3, 300.2),
   (421,'Josh', 4, 300.3)
;

DROP TABLE QuarterlyBonus;    

CREATE TABLE Employee (
    FirstName      varchar(50),
    LastName       varchar(100),
    PhoneNumber    char(8),
    OfficeNumber   char(3),
    HireDate       date,
    AnnualSalary   decimal (10,2),
    EmployeeID INTEGER NOT NULL,
    CONSTRAINT PK_Employee_EmployeeID PRIMARY KEY (EmployeeID) 
);

INSERT INTO Employee
 VALUES
        (
            'Dorean', 
            'Grey',
            '55-0123',
            '123',
           '2024-04-01',
            45000.00,
            100
        )
;


SELECT * FROM Employee;

DROP TABLE Employee;