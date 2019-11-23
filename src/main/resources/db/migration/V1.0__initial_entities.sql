CREATE TABLE IF NOT EXISTS `app`.`roles` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `role` VARCHAR(100) UNIQUE NOT NULL,
  PRIMARY KEY (`id`));

CREATE TABLE IF NOT EXISTS `app`.`users` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(100) NOT NULL,
  `middle_name` VARCHAR(100) NULL,
  `last_name` VARCHAR(100) NOT NULL,
  `username` VARCHAR(100) UNIQUE NOT NULL,
  `password` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id`));

CREATE TABLE IF NOT EXISTS `app`.`user_roles` (
  `user_id` INT UNSIGNED NOT NULL REFERENCES `users`(`id`),
  `role_id` INT UNSIGNED NOT NULL REFERENCES `roles`(`id`),
  PRIMARY KEY (`user_id`, `role_id`));
