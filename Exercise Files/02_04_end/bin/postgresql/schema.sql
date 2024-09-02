CREATE SCHEMA LIL;

CREATE TABLE LIL.ROOMS(
  ROOM_ID BIGSERIAL PRIMARY KEY,
  NAME VARCHAR(16) NOT NULL,
  ROOM_NUMBER CHAR(2) NOT NULL UNIQUE,
  BED_INFO CHAR(2) NOT NULL
);

CREATE TABLE LIL.GUESTS(
  GUEST_ID BIGSERIAL PRIMARY KEY,
  FIRST_NAME VARCHAR(64),
  LAST_NAME VARCHAR(64),
  EMAIL_ADDRESS VARCHAR(64),
  ADDRESS VARCHAR(64),
  COUNTRY VARCHAR(32),
  STATE VARCHAR(12),
  PHONE_NUMBER VARCHAR(24)
);

CREATE TABLE LIL.RESERVATIONS(
  RESERVATION_ID BIGSERIAL PRIMARY KEY,
  ROOM_ID BIGINT NOT NULL,
  GUEST_ID BIGINT NOT NULL,
  RES_DATE DATE
);

ALTER TABLE LIL.RESERVATIONS ADD FOREIGN KEY (ROOM_ID) REFERENCES LIL.ROOMS(ROOM_ID);
ALTER TABLE LIL.RESERVATIONS ADD FOREIGN KEY (GUEST_ID) REFERENCES LIL.GUESTS(GUEST_ID);
CREATE INDEX IDX_RES_DATE_ ON LIL.RESERVATIONS(RES_DATE);
