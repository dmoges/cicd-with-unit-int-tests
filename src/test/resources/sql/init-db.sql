CREATE TABLE users(
    id SERIAL PRIMARY KEY, 
    user_name VARCHAR(30) NOT NULL, 
    email VARCHAR(50) NOT NULL, 
    password VARCHAR(50) NOT NULL
);