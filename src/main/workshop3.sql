CREATE DATABASE workshop3 CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

USE workshop3;


CREATE TABLE users(
                      id INT(11) NOT NULL AUTO_INCREMENT,
                      email VARCHAR(255) NOT NULL UNIQUE,
                      username VARCHAR(255) NOT NULL UNIQUE,
                      password VARCHAR(60) NOT NULL,
                      PRIMARY KEY (id)
);

INSERT INTO users(email, username, password) VALUES ('jannowak@gmail.com', 'jan_nowak', 'sssssssss');

SELECT COUNT(id) as size FROM users;

DROP TABLE users;
DELETE FROM users;

SELECT password FROM workshop3.users WHERE username='Mateusz';

SELECT username FROM workshop3.users WHERE username='ma';

SELECT email FROM workshop3.users WHERE email='ja';