INSERT INTO `roles` (`role`) VALUES ('ROLE_ADMIN');
INSERT INTO `roles` (`role`) VALUES ('ROLE_USER');

INSERT INTO `ugroups` (`group_name`) VALUES ('Группа');

INSERT INTO `users` (`first_name`, `last_name`, `username`, `password`, `group_id`) VALUES ('Admin', 'Admin', 'admin', '123', '1');
INSERT INTO `users` (`first_name`, `last_name`, `username`, `password`, `group_id`) VALUES ('User', 'User', 'user', '123', '1');
INSERT INTO `users` (`first_name`, `last_name`, `username`, `password`, `group_id`) VALUES ('ToDelete', 'User', 'delete', '123', '1');

INSERT INTO `user_roles` (`user_id`, `role_id`) VALUES ('1', '1');
INSERT INTO `user_roles` (`user_id`, `role_id`) VALUES ('1', '2');
INSERT INTO `user_roles` (`user_id`, `role_id`) VALUES ('2', '2');
INSERT INTO `user_roles` (`user_id`, `role_id`) VALUES ('3', '2');
