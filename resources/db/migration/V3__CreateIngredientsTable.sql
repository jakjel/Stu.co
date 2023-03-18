CREATE TABLE ingredients2
(
    ingredient_id         int NOT NULL AUTO_INCREMENT,
    name_of_ingredient       varchar(50),
    link        varchar(250),
    price       double,
    amount_unit       varchar(20),
    PRIMARY KEY (ingredient_id)
);