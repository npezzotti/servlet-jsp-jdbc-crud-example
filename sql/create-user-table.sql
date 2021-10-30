DROP database IF EXISTS demo;
CREATE database demo;
USE demo;

CREATE TABLE users (
	id int(3) NOT NULL AUTO_INCREMENT,
	name varchar(120) NOT NULL,
	email varchar(120) NOT NULL,
	country varchar(120),
	PRIMARY KEY (id)
);
