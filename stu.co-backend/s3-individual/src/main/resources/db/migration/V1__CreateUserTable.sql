CREATE TABLE `users`
(
    user_id         int NOT NULL AUTO_INCREMENT,
    username       varchar(50),
    email       varchar(50),
    password       varchar(100),
    first_name       varchar(50),
    last_name       varchar(50),
    role_name varchar(50) NOT NULL,
    PRIMARY KEY (user_id)
);