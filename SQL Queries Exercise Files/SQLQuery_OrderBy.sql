--select *
--FROM sales.SalesOrderHeader


SELECT CustomerID, 
SUM(S.subtotal) AS 'Total Sum',
MIN(S.subtotal) AS 'MIN',
MAX(S.subtotal) AS 'MAX',
AVG(S.subtotal) AS 'Overage',
Person.FirstName, 
Person.LastName
FROM Sales.SalesOrderHeader AS S
JOIN Person.Person
on S.CustomerID = Person.BusinessEntityID
GROUP BY S.CustomerID, Person.FirstName, Person.LastName
ORDER BY SUM(S.subtotal) DESC



