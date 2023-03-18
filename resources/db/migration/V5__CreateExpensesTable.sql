CREATE TABLE `expenses`
(
    expense_id         int NOT NULL AUTO_INCREMENT,
    uot_id       int NOT NULL,
    group_id       int NOT NULL,
    amount_of_money       double,
    created_at       DATE,
    user_id         int NOT NULL,
    PRIMARY KEY (expense_id)
);
ALTER TABLE expenses
    ADD CONSTRAINT fk_expense_on_user FOREIGN KEY (user_id) REFERENCES users (user_id);
