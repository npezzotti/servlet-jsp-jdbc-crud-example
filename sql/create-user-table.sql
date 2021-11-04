DROP TABLE IF EXISTS users;

CREATE TABLE IF NOT EXISTS users (
	id SERIAL PRIMARY KEY,
	name VARCHAR(120) NOT NULL,
	email VARCHAR(120) NOT NULL UNIQUE,
	password VARCHAR(120) NOT NULL,
	country VARCHAR(120)
);

INSERT INTO users (name, email, password, country) VALUES (
	'Rose Payne', 'rose@example.com', 'password', 'United States of America'
);

INSERT INTO users (name, email, password, country) VALUES (
	'Carl Osborne', 'carl@example.com', 'password', 'Canada'
);

INSERT INTO users (name, email, password, country) VALUES (
	'Wallace Hammond', 'wallace@example.com', 'password', 'Germany'
);

INSERT INTO users (name, email, password, country) VALUES (
	'Roy Wise', 'roy@example.com', 'password', 'Australia'
);

INSERT INTO users (name, email, password, country) VALUES (
	'Reginald Clarke', 'reginald@example.com', 'password', 'Mexico'
);
