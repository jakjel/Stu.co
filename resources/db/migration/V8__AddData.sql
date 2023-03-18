INSERT INTO `users` (`user_id`,`username`,`email`,`password`,`first_name`,`last_name`,`role_name`) VALUES (1,'jakjel','jakjel@gmail.com','$2a$10$ZLKq.sscm1oMy0zbVVyNruYGFnz19.vp5X0YEMMXTaGYYB6q9ob6y','Jakub','Jelinek','ADMIN');
INSERT INTO `users` (`user_id`,`username`,`email`,`password`,`first_name`,`last_name`,`role_name`) VALUES (2,'daniil','daniel@gmail.com','$2a$10$4pBel6kBxmyNULmbELGUIeElhUrP1DGyuAv5Yabvl0rnP5duvP4j.','Daniel','Danielito','USER');
INSERT INTO `users` (`user_id`,`username`,`email`,`password`,`first_name`,`last_name`,`role_name`) VALUES (4,'romjel','roman1@gmail.com','$2a$10$4pBel6kBxmyNULmbELGUIeElhUrP1DGyuAv5Yabvl0rnP5duvP4j.','Roman','Jelinek','USER');
INSERT INTO `users` (`user_id`,`username`,`email`,`password`,`first_name`,`last_name`,`role_name`) VALUES (5,'frank','frank@gmail.com','$2a$10$mTOpue0WeYvoFjCjREJU.OCl5cqWFY0oWwONb.AsICgCfbn8AeCf2','Frank','Coenen','USER');
INSERT INTO `users` (`user_id`,`username`,`email`,`password`,`first_name`,`last_name`,`role_name`) VALUES (6,'radek','radek@gmail.com','$2a$10$dlqU/42/hSq3P26qqxmDj.So9cur7HV0hovFrwN/kJ0r72qE3FCGS','Radek','Novy','USER');

INSERT INTO `expensesgroups` (`group_id`,`created_at`,`group_name`) VALUES (1,'2022-11-30','Trio-Mio');
INSERT INTO `expensesgroups` (`group_id`,`created_at`,`group_name`) VALUES (2,'2022-11-30','Cheffitos');
INSERT INTO `expensesgroups` (`group_id`,`created_at`,`group_name`) VALUES (3,'2023-01-10','Big-Fellas');
INSERT INTO `expensesgroups` (`group_id`,`created_at`,`group_name`) VALUES (4,'2023-01-10','Praguetos');
INSERT INTO `expensesgroups` (`group_id`,`created_at`,`group_name`) VALUES (5,'2023-01-10','Eindhoven2023');

INSERT INTO `expenses` (`expense_id`,`uot_id`,`group_id`,`amount_of_money`,`created_at`,`user_id`) VALUES (1,2,1,10,'2022-11-30',1);
INSERT INTO `expenses` (`expense_id`,`uot_id`,`group_id`,`amount_of_money`,`created_at`,`user_id`) VALUES (2,1,1,5,'2022-11-30',2);
INSERT INTO `expenses` (`expense_id`,`uot_id`,`group_id`,`amount_of_money`,`created_at`,`user_id`) VALUES (3,1,2,12,'2022-11-30',2);
INSERT INTO `expenses` (`expense_id`,`uot_id`,`group_id`,`amount_of_money`,`created_at`,`user_id`) VALUES (4,2,3,7,'2023-01-10',1);
INSERT INTO `expenses` (`expense_id`,`uot_id`,`group_id`,`amount_of_money`,`created_at`,`user_id`) VALUES (5,1,2,100,'2023-01-10',2);
INSERT INTO `expenses` (`expense_id`,`uot_id`,`group_id`,`amount_of_money`,`created_at`,`user_id`) VALUES (7,1,6,10,'2023-01-10',2);
INSERT INTO `expenses` (`expense_id`,`uot_id`,`group_id`,`amount_of_money`,`created_at`,`user_id`) VALUES (8,5,5,7,'2023-01-12',4);

INSERT INTO `group_user` (`group_id`,`user_id`) VALUES (1,1);
INSERT INTO `group_user` (`group_id`,`user_id`) VALUES (2,1);
INSERT INTO `group_user` (`group_id`,`user_id`) VALUES (3,1);
INSERT INTO `group_user` (`group_id`,`user_id`) VALUES (1,2);
INSERT INTO `group_user` (`group_id`,`user_id`) VALUES (2,2);
INSERT INTO `group_user` (`group_id`,`user_id`) VALUES (3,2);
INSERT INTO `group_user` (`group_id`,`user_id`) VALUES (5,4);
INSERT INTO `group_user` (`group_id`,`user_id`) VALUES (5,5);

INSERT INTO `recipes2` (`recipe_id`,`title`,`video`,`description`,`amount_of_people`) VALUES (1,'Paprika Chicken & Rice Bake','https://vid.tasty.co/output/20942/mp4_640x640/1484680174','Wash chicken, cut to small pieces, fry chicken on pan, add paprika and cream and let it rest on low fire for 10 minutes',1);
INSERT INTO `recipes2` (`recipe_id`,`title`,`video`,`description`,`amount_of_people`) VALUES (2,'Terijaky Beef','https://vid.tasty.co/output/10402/mp4_640x640/1474401236','Cook spaghetti seperately in boiling water add some salt, meanwhile cook meat for carbonara',3);