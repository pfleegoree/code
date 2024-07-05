-- Create an composite primary key in SQL Server and PostgreSQL
CREATE TABLE HotelRooms (
    CheckinDate date NOT NULL,
    RoomNumber  char(3) NOT NULL,
    GuestName   varchar(50),
CONSTRAINT PK_CheckinRooms PRIMARY KEY (CheckinDate, RoomNumber)
);

-- Verify that it will not allow two rows with the same checkin + room combination
INSERT INTO HotelRooms VALUES
('2020-10-15', '201', 'Dr. White');

INSERT INTO HotelRooms VALUES
('2020-10-15', '315', 'Ms. Green');

INSERT INTO HotelRooms VALUES
('2020-10-16', '201', 'Mr. Brown');

INSERT INTO HotelRooms VALUES
('2020-10-15', '201', 'Mrs. Blue');

SELECT * FROM HotelRooms;
DROP TABLE HotelRooms;