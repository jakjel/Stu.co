CREATE TABLE `recipes2`
(
    recipe_id         int NOT NULL AUTO_INCREMENT,
    title       varchar(50),
    video       varchar(200),
    description      varchar(500),
    amount_of_people       int,
    PRIMARY KEY (recipe_id)
);