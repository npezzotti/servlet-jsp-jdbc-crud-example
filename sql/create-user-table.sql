DROP TABLE IF EXISTS users;

CREATE TABLE IF NOT EXISTS users (
	id SERIAL PRIMARY KEY,
	name VARCHAR(120) NOT NULL,
	email VARCHAR(120) NOT NULL,
	country VARCHAR(120)
);

INSERT INTO users (name, email, country) VALUES (
	'Rose Payne', 'rose@example.com', 'United States of America'
);

INSERT INTO users (name, email, country) VALUES (
	'Carl Osborne', 'carl@example.com', 'Canada'
);

INSERT INTO users (name, email, country) VALUES (
	'Wallace Hammond', 'wallace@example.com', 'Germany'
);

INSERT INTO users (name, email, country) VALUES (
	'Roy Wise', 'roy@example.com', 'Australia'
);

INSERT INTO users (name, email, country) VALUES (
	'Reginald Clarke', 'reginald@example.com', 'Mexico'
);
