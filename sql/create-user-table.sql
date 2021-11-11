DROP TABLE IF EXISTS users;

CREATE TABLE IF NOT EXISTS users (
	id SERIAL PRIMARY KEY,
	name VARCHAR(60) NOT NULL,
	email VARCHAR(120) NOT NULL UNIQUE,
	password VARCHAR(120) NOT NULL,
	country VARCHAR(120)
);

CREATE TABLE IF NOTE EXISTS books (
	id SERIAL PRIMARY KEY,
	title VARCHAR(60)
)

INSERT INTO users (name, email, password, country) VALUES (
	'Rose Payne', 'rose@example.com', '$2a$12$hEvKAmqU0agKoq2zMT/kGua4BiRzqtKq/U3553c6nPvX2Km4laqMK', 'United States of America'
);

INSERT INTO users (name, email, password, country) VALUES (
	'Carl Osborne', 'carl@example.com', '$2a$12$hEvKAmqU0agKoq2zMT/kGua4BiRzqtKq/U3553c6nPvX2Km4laqMK', 'Canada'
);

INSERT INTO users (name, email, password, country) VALUES (
	'Wallace Hammond', 'wallace@example.com', '$2a$12$hEvKAmqU0agKoq2zMT/kGua4BiRzqtKq/U3553c6nPvX2Km4laqMK', 'Germany'
);

INSERT INTO users (name, email, password, country) VALUES (
	'Roy Wise', 'roy@example.com', '$2a$12$hEvKAmqU0agKoq2zMT/kGua4BiRzqtKq/U3553c6nPvX2Km4laqMK', 'Australia'
);

INSERT INTO users (name, email, password, country) VALUES (
	'Reginald Clarke', 'reginald@example.com', '$2a$12$hEvKAmqU0agKoq2zMT/kGua4BiRzqtKq/U3553c6nPvX2Km4laqMK', 'Mexico'
);
