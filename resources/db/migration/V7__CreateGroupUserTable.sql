CREATE TABLE `group_user`
(
    group_id       int,
    user_id       int,
    CONSTRAINT pk_group_user PRIMARY KEY (group_id, user_id)
);

ALTER TABLE group_user
    ADD CONSTRAINT fk_groupuser_on_group FOREIGN KEY (group_id) REFERENCES expensesgroups (group_id);

ALTER TABLE group_user
    ADD CONSTRAINT fk_groupuser_on_user FOREIGN KEY (user_id) REFERENCES users (user_id);