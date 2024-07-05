-- Create an auto-incrementing surrogate primary key in SQL Server
CREATE TABLE Fruit (
    FruitID INT IDENTITY (100, 10) PRIMARY KEY,
    Type VARCHAR (10)
);

INSERT INTO Fruit (Type)
VALUES ('Apple'), ('Grape'), ('Watermelon');

SELECT * FROM Fruit;

DROP TABLE Fruit;