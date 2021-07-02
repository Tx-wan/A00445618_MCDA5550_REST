use HotelReservationDB
DROP TABLE IF EXISTS guest_tbl

CREATE TABLE guest_tbl (
	id bigint NOT NULL,
	first_name varchar(255),
	last_name varchar(255),
	age int,
	gender int,
	PRIMARY KEY(id)
);

DROP TABLE IF EXISTS hotel_tbl

CREATE TABLE hotel_tbl (
	id bigint NOT NULL,
	hotel_name varchar(255),
	price float,
	available char,
	PRIMARY KEY(id)
);

DROP TABLE IF EXISTS reservation_tbl

CREATE TABLE reservation_tbl (
	id bigint NOT NULL,
	check_in_date date,
	check_out_date date,
	hotelId bigint NOT NULL,
	PRIMARY KEY(id),
	FOREIGN KEY(hotelId) REFERENCES hotel_tbl(id)
);