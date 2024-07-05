-- Create an auto-incrementing surrogate primary key in PostgreSQL
CREATE TABLE fruit (
    fruit_id integer GENERATED ALWAYS AS IDENTITY (START WITH 100 INCREMENT BY 10) PRIMARY KEY,
    type character varying (10)
);

INSERT INTO fruit (type)
VALUES ('Apple'), ('Grape'), ('Watermelon');

SELECT * FROM fruit;

DROP TABLE fruit;