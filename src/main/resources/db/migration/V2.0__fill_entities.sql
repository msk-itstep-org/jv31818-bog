INSERT INTO `app`.`roles` (`role`) VALUES ('ROLE_ADMIN');
INSERT INTO `app`.`roles` (`role`) VALUES ('ROLE_USER');

INSERT INTO `app`.`users` (`first_name`, `last_name`, `username`, `password`) VALUES ('Admin', 'Admin', 'admin', '123');
INSERT INTO `app`.`users` (`first_name`, `last_name`, `username`, `password`) VALUES ('User', 'User', 'user', '123');
INSERT INTO `app`.`users` (`first_name`, `last_name`, `username`, `password`) VALUES ('ToDelete', 'User', 'delete', '123');

INSERT INTO `app`.`user_roles` (`user_id`, `role_id`) VALUES ('1', '1');
INSERT INTO `app`.`user_roles` (`user_id`, `role_id`) VALUES ('1', '2');
INSERT INTO `app`.`user_roles` (`user_id`, `role_id`) VALUES ('2', '2');
INSERT INTO `app`.`user_roles` (`user_id`, `role_id`) VALUES ('3', '2');
