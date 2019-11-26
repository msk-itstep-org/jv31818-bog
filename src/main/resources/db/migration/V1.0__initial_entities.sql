CREATE TABLE IF NOT EXISTS `roles` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `role` VARCHAR(100) UNIQUE NOT NULL,
  PRIMARY KEY (`id`));

CREATE TABLE IF NOT EXISTS `ugroups` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `group_name` VARCHAR(100) UNIQUE NOT NULL,
  PRIMARY KEY (`id`));

CREATE TABLE IF NOT EXISTS `users` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(100) NOT NULL,
  `middle_name` VARCHAR(100) NULL,
  `last_name` VARCHAR(100) NOT NULL,
  `username` VARCHAR(100) UNIQUE NOT NULL,
  `password` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id`),
  `group_id` INT UNSIGNED NOT NULL REFERENCES `ugroups`(`id`));

CREATE TABLE IF NOT EXISTS `user_roles` (
  `user_id` INT UNSIGNED NOT NULL REFERENCES `users`(`id`),
  `role_id` INT UNSIGNED NOT NULL REFERENCES `roles`(`id`),
  PRIMARY KEY (`user_id`, `role_id`));

CREATE TABLE IF NOT EXISTS `application_types` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `type` VARCHAR(100) UNIQUE NOT NULL,
  PRIMARY KEY (`id`));

CREATE TABLE IF NOT EXISTS `application_states` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `state` VARCHAR(100) UNIQUE NOT NULL,
  PRIMARY KEY (`id`));

CREATE TABLE IF NOT EXISTS `application_priorities` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `priority` VARCHAR(100) UNIQUE NOT NULL,
  PRIMARY KEY (`id`));

CREATE TABLE IF NOT EXISTS `contracts` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `contract` VARCHAR(100) UNIQUE NOT NULL,
  PRIMARY KEY (`id`));

CREATE TABLE IF NOT EXISTS `applications` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `type_id` INT UNSIGNED NOT NULL REFERENCES `application_types`(`id`),
  `create_date` DATETIME NOT NULL,
  `state_id` INT UNSIGNED NOT NULL REFERENCES `application_states`(`id`),
  `priority_id` INT UNSIGNED NOT NULL REFERENCES `application_priorities`(`id`),
  `contract_id` INT UNSIGNED NOT NULL REFERENCES `contracts`(`id`),
  `comment_id` INT UNSIGNED NULL REFERENCES `comments`(`id`),
  PRIMARY KEY (`id`));

  CREATE TABLE IF NOT EXISTS `comments` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `comment` VARCHAR(100) NOT NULL,
  `comment_user_id` INT UNSIGNED NOT NULL REFERENCES `users`(`id`),
  `create_date` DATETIME NOT NULL,
  `application_id` INT UNSIGNED NOT NULL REFERENCES `applications`(`id`),
  PRIMARY KEY (`id`));

CREATE TABLE IF NOT EXISTS `user_comments` (
  `user_id` INT UNSIGNED NOT NULL REFERENCES `users`(`id`),
  `comment_id` INT UNSIGNED NOT NULL REFERENCES `comments`(`id`),
  PRIMARY KEY (`comment_id`, `user_id`));

CREATE TABLE IF NOT EXISTS `application_groups` (
  `application_id` INT UNSIGNED NOT NULL REFERENCES `applications`(`id`),
  `group_id` INT UNSIGNED NOT NULL REFERENCES `ugroups`(`id`),
  PRIMARY KEY (`application_id`, `group_id`));
