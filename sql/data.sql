DROP TABLE IF EXISTS users CASCADE;
DROP TABLE IF EXISTS posts CASCADE;
DROP TABLE IF EXISTS comments CASCADE;

CREATE TABLE users (
	id SERIAL PRIMARY KEY,
	name VARCHAR(60) NOT NULL,
	email VARCHAR(120) NOT NULL UNIQUE,
	password VARCHAR(120) NOT NULL,
	join_date DATE DEFAULT CURRENT_DATE
);

CREATE TABLE posts (
	id SERIAL PRIMARY KEY,
	user_id int NOT NULL,
	content TEXT NOT NULL,
	created_at TIMESTAMP DEFAULT NOW(),
	FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
);

CREATE TABLE comments (
	id SERIAL PRIMARY KEY,
	user_id int NOT NULL,
	post_id int NOT NULL,
	content TEXT NOT NULL,
	created_at TIMESTAMP DEFAULT NOW(),
	FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE, 
	FOREIGN KEY (post_id) REFERENCES posts (id) ON DELETE CASCADE
);

INSERT INTO users (name, email, password) 
	VALUES 
		('Rose Payne', 'rose@example.com', '$2a$12$hEvKAmqU0agKoq2zMT/kGua4BiRzqtKq/U3553c6nPvX2Km4laqMK'),
		('Roy Wise', 'roy@example.com', '$2a$12$hEvKAmqU0agKoq2zMT/kGua4BiRzqtKq/U3553c6nPvX2Km4laqMK'),
		('Daniel Clarke', 'daniel@example.com', '$2a$12$hEvKAmqU0agKoq2zMT/kGua4BiRzqtKq/U3553c6nPvX2Km4laqMK');

INSERT INTO posts (user_id, content)
	VALUES
		(1, 'This is a test post.'),
		(2, 'This is a test post.'),
		(3, 'This is a test post.');

INSERT INTO comments (user_id, post_Id, content)
	VALUES
		(3, 1, 'This is a test comment.'),
		(2, 2, 'This is a test comment.'),
		(1, 3, 'This is a test comment.');
