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

-- Remove the existing foreign key constraint
ALTER TABLE QuarterlyBonus
DROP CONSTRAINT fk_Employee_EmployeeID;

-- Recreate the constraint with options to cascade update and cascade delete changes
ALTER TABLE QuarterlyBonus
ADD CONSTRAINT fk_Employee_EmployeeID FOREIGN KEY (EmployeeID)
      REFERENCES Employee (EmployeeID)
      ON UPDATE CASCADE
      ON DELETE CASCADE
;


INSERT INTO QuarterlyBonus (BonusAmount,  Quarter, EmployeeID) VALUES
    (419.000, 4, 102),
    (420.000, 2, 101)
;

DELETE FROM QuarterlyBonus WHERE BonusID = '4';

SELECT * FROM QuarterlyBonus;

DROP TABLE QuarterlyBonus;    

CREATE TABLE Employee (
    EmployeeID varchar(20) NOT NULL,
    FirstName      varchar(50) NOT NULL,
    LastName       varchar(100) NOT NULL,
    OfficeNumber   char(3),
    HireDate       date,
    AnnualSalary   decimal (10,2) CONSTRAINT check_minimum_salary CHECK(AnnualSalary >100.00),
    PhoneNumber    char(8)
    CONSTRAINT PK_Employee_EmployeeID PRIMARY KEY (EmployeeID) 
);

ALTER TABLE Employee
ADD CONSTRAINT DefaultPhoneNumber
DEFAULT '55-0111' FOR PhoneNumber;

INSERT INTO Employee
 VALUES
        (
            'W2348',
            'Dorean', 
            'Grey',
            '123',
            '2024-04-07',
            '100.00'
        )
;

SELECT * FROM Employee;

DROP TABLE Employee;
DROP TABLE QuarterlyBonus;