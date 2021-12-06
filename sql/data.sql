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
		(1, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur aliquam lectus vel risus mollis malesuada. Maecenas iaculis nisl quis risus tincidunt dictum. Sed pretium porta felis, ac laoreet quam vulputate a. Nullam hendrerit leo nibh, at interdum felis dignissim sed. Mauris ut posuere dui. Morbi sed commodo sem. Aenean non dapibus ante. In suscipit dolor orci, sit amet aliquet ipsum aliquam tincidunt. In vitae facilisis ante. Quisque dictum felis sit amet aliquam vestibulum. Maecenas placerat lorem in purus ultrices rhoncus. Fusce nec ipsum lobortis, pharetra diam at, lacinia libero. Curabitur in sagittis ipsum. Vivamus et iaculis ante. Donec et turpis malesuada, bibendum dolor eget, facilisis neque. Morbi ligula odio, tempus vitae porta ac, iaculis sollicitudin sapien.'),
		(2, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur aliquam lectus vel risus mollis malesuada. Maecenas iaculis nisl quis risus tincidunt dictum. Sed pretium porta felis, ac laoreet quam vulputate a. Nullam hendrerit leo nibh, at interdum felis dignissim sed. Mauris ut posuere dui. Morbi sed commodo sem. Aenean non dapibus ante. In suscipit dolor orci, sit amet aliquet ipsum aliquam tincidunt. In vitae facilisis ante. Quisque dictum felis sit amet aliquam vestibulum. Maecenas placerat lorem in purus ultrices rhoncus. Fusce nec ipsum lobortis, pharetra diam at, lacinia libero. Curabitur in sagittis ipsum. Vivamus et iaculis ante. Donec et turpis malesuada, bibendum dolor eget, facilisis neque. Morbi ligula odio, tempus vitae porta ac, iaculis sollicitudin sapien.'),
		(3, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur aliquam lectus vel risus mollis malesuada. Maecenas iaculis nisl quis risus tincidunt dictum. Sed pretium porta felis, ac laoreet quam vulputate a. Nullam hendrerit leo nibh, at interdum felis dignissim sed. Mauris ut posuere dui. Morbi sed commodo sem. Aenean non dapibus ante. In suscipit dolor orci, sit amet aliquet ipsum aliquam tincidunt. In vitae facilisis ante. Quisque dictum felis sit amet aliquam vestibulum. Maecenas placerat lorem in purus ultrices rhoncus. Fusce nec ipsum lobortis, pharetra diam at, lacinia libero. Curabitur in sagittis ipsum. Vivamus et iaculis ante. Donec et turpis malesuada, bibendum dolor eget, facilisis neque. Morbi ligula odio, tempus vitae porta ac, iaculis sollicitudin sapien.');

INSERT INTO comments (user_id, post_Id, content)
	VALUES
		(3, 1, 'This is a test comment.'),
		(2, 2, 'This is a test comment.'),
		(1, 3, 'This is a test comment.');
