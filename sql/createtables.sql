use HotelReservationDB
CREATE TABLE guest_tbl (
	id int NOT NULL,
	firstName varchar(255),
	lastName varchar(255),
	age int,
	gender int,
	PRIMARY KEY(id)
);