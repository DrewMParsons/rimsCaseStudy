DROP Database rimsdb;

CREATE DATABASE rimsdb;

USE rimsdb;

CREATE TABLE `menu_item` (
	`id` BIGINT(20) NOT NULL AUTO_INCREMENT,
	`description` VARCHAR(255) NULL COLLATE 'utf8_general_ci',
	`price` DECIMAL(19,2) NULL,
	`title` VARCHAR(255) NULL COLLATE 'utf8_general_ci',
	PRIMARY KEY (`id`) USING BTREE
)
COLLATE='utf8_general_ci'
ENGINE=InnoDB
;

CREATE TABLE `user` (
	`id` BIGINT(20) NOT NULL AUTO_INCREMENT,
	`email` VARCHAR(255) NULL COLLATE 'utf8_general_ci',
	`first_name` VARCHAR(255) NULL COLLATE 'utf8_general_ci',
	`last_name` VARCHAR(255) NULL COLLATE 'utf8_general_ci',
	`password` VARCHAR(255) NULL COLLATE 'utf8_general_ci',
	`username` VARCHAR(255) NULL COLLATE 'utf8_general_ci',
	PRIMARY KEY (`id`) USING BTREE
)
COLLATE='utf8_general_ci'
ENGINE=InnoDB
AUTO_INCREMENT=15
;

CREATE TABLE `role` (
	`id` BIGINT(20) NOT NULL AUTO_INCREMENT,
	`name` VARCHAR(255) NULL COLLATE 'utf8_general_ci',
	PRIMARY KEY (`id`) USING BTREE
)
COLLATE='utf8_general_ci'
ENGINE=InnoDB
AUTO_INCREMENT=3
;

CREATE TABLE `user_roles` (
	`users_id` BIGINT(20) NOT NULL,
	`roles_id` BIGINT(20) NOT NULL,
	PRIMARY KEY (`users_id`, `roles_id`) USING BTREE,
	INDEX `FKj9553ass9uctjrmh0gkqsmv0d` (`roles_id`) USING BTREE,
	CONSTRAINT `FK7ecyobaa59vxkxckg6t355l86` FOREIGN KEY (`users_id`) REFERENCES `heroku_d30515df90454a9`.`user` (`id`) ON UPDATE CASCADE ON DELETE CASCADE,
	CONSTRAINT `FKj9553ass9uctjrmh0gkqsmv0d` FOREIGN KEY (`roles_id`) REFERENCES `heroku_d30515df90454a9`.`role` (`id`) ON UPDATE CASCADE ON DELETE CASCADE
)
COLLATE='utf8_general_ci'
ENGINE=InnoDB
;

CREATE TABLE `order_menu_item` (
	`id` BIGINT(20) NOT NULL AUTO_INCREMENT,
	`quantity` INT(11) NOT NULL,
	`menu_item_id` BIGINT(20) NULL,
	`user_id` BIGINT(20) NULL,
	PRIMARY KEY (`id`) USING BTREE,
	INDEX `FKoudm2juuy5n0gojkem824fy2k` (`menu_item_id`) USING BTREE,
	INDEX `FK6xsu02ide1awt4shjjqf97iek` (`user_id`) USING BTREE,
	CONSTRAINT `FK6xsu02ide1awt4shjjqf97iek` FOREIGN KEY (`user_id`) REFERENCES `heroku_d30515df90454a9`.`user` (`id`) ON UPDATE RESTRICT ON DELETE RESTRICT,
	CONSTRAINT `FKoudm2juuy5n0gojkem824fy2k` FOREIGN KEY (`menu_item_id`) REFERENCES `heroku_d30515df90454a9`.`menu_item` (`id`) ON UPDATE RESTRICT ON DELETE RESTRICT
)
COLLATE='utf8_general_ci'
ENGINE=InnoDB
;

INSERT INTO menu_item (`title`,`price`,`description`) VALUES
('Burger',16.00,'Double Patty with Cheese'),
('Soup du jour',9.00,'It''s the soup of the DAY'),
('Fries',5.50,'Thin Cut, organic potatoes'),
('Fried Chicken Sandwich',14.75,'Pickled Brined & deep fried');

INSERT INTO role (`name`) VALUES
('ROLE_ADMIN'),
('ROLE_USER');

INSERT INTO user (`email`,`first_name`,`last_name`,`username`,`password`,`role_id`) VALUES
('admin@gmail.com','admin','admin','admin01','password',1),
('customer@g.com','Cust','O''Mer','customer01','password',2);

INSERT INTO order_menu_item (`quantity`,`menu_item_id`,`user_id`) VALUES
(2,1,1);