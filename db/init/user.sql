CREATE TABLE users (
                       id SERIAL PRIMARY KEY,
                       username VARCHAR(255) UNIQUE NOT NULL,
                       password VARCHAR(255) NOT NULL
);



INSERT INTO users (username, password)
VALUES ('testuser', '1234');


select * from users;