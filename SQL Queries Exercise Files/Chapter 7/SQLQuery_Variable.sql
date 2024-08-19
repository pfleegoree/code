SELECT * 
FROM Person.Person


DECLARE @ROWS INT = 5;
DECLARE @NumID INT = 255;
--set @NumID = (select MAX(Person.BusinessEntityID) from Person.Person)

SELECT TOP (@ROWS)
BusinessEntityID
, FirstName
, MiddleName
, LastName 
FROM Person.Person
WHERE BusinessEntityId >= @NumID;