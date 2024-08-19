-- 1: Using the Production.ProductInventory table, 
--    combine the LocationID, Shelf, and Bin values 
--    into a single column with hyphens between each.
SELECT LocationID
        , Shelf
        , Bin
        , CONCAT_WS('_', LocationID,Shelf, Bin) AS 'Combined Location'
FROM Production.ProductInventory 




-- 2: Using the HumanResources.Employee table,
--    Locate all of the people hired in February of any year.
--    Then identify the date that their 90 day new hire 
--    performance evaluation is due

SELECT * 
FROM HumanResources.Employee

SELECT 
LoginID,
JobTitle,
HireDate,
MONTH(HireDate) AS February,
DATEADD(day, 90, HireDate) AS PerformanceDue
FROM HumanResources.Employee
WHERE MONTH(HireDate) = 2

-- 3: View CreditRating information for each vendor in the 
--    Purchasing.Vendor table.  Then use a CASE statement to 
--    translate the 1 - 5 credit rating into the text ratings:
--    poor, below average, average, good, excellent
SELECT *
FROM Purchasing.Vendor

SELECT Name
    ,CreditRating
    ,CASE CreditRating
    WHEN 1 THEN 'poor'
    WHEN 2 THEN 'below average'
    WHEN 3 THEN 'average'
    WHEN 4 THEN 'good'
    WHEN 5 THEN 'excellent'
    ELSE 'Unidentified'
    END AS 'Text Rating'
FROM Purchasing.Vendor
ORDER BY CreditRating DESC

-- 4: Select three random people from Sales.SalesPerson.
--    Then use an IIF function to compare their SalesYTD 
--    to the SalesLastYear and indicate whether their 
--    performance has increased or decreased
SELECT * FROM Sales.SalesPerson

SELECT TOP 3
BusinessEntityID
,SalesLastYear
,SalesYTD
,IIF(SalesYTD>SalesLastYear, 'Increased', 'Decreased') AS Status
FROM
Sales.SalesPerson
ORDER BY NEWID()
