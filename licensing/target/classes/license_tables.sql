/* MySQL statements to create DB tables */

drop database if exists `frank73_f13lic`;
drop user `frank73_f13lic`@`localhost`;

create database if not exists `frank73_f13lic`;

create user 'frank73_f13lic'@'localhost' identified by 'lic2013';

grant all privileges on *.* to 'frank73_f13lic'@'localhost';

CREATE TABLE IF NOT EXISTS `frank73_f13lic`.`license` (
`id` INT NOT NULL AUTO_INCREMENT ,
`product_id` INT NOT NULL,
`customer_id` INT NOT NULL,
`license_key` VARCHAR(100) NOT NULL ,
`expiration_date` DATETIME ,
`max_activations` INT ,
PRIMARY KEY (`id`) ,
UNIQUE INDEX `id_unique` (`id` ASC) );

CREATE TABLE IF NOT EXISTS `frank73_f13lic`.`activation` (
`id` INT NOT NULL AUTO_INCREMENT ,
`license_id` INT NOT NULL,
`fingerprint` VARCHAR(200) NOT NULL ,
`activation_date` DATETIME ,
PRIMARY KEY (`id`) ,
UNIQUE INDEX `id_unique` (`id` ASC) );

CREATE TABLE IF NOT EXISTS `frank73_f13lic`.`customer` (
`id` INT NOT NULL AUTO_INCREMENT ,
`name` VARCHAR(100) NOT NULL,
`email` VARCHAR(100) NOT NULL,
PRIMARY KEY (`id`) ,
UNIQUE INDEX `id_unique` (`id` ASC) );

CREATE TABLE IF NOT EXISTS `frank73_f13lic`.`product` (
`id` INT NOT NULL AUTO_INCREMENT ,
`unique_id` VARCHAR(100) NOT NULL,
`product_name` VARCHAR(100) NOT NULL,
`product_description` VARCHAR(500) NOT NULL ,
PRIMARY KEY (`id`) ,
UNIQUE INDEX `id_unique` (`id` ASC) );

ALTER TABLE `frank73_f13lic`.`license`
ADD CONSTRAINT license_FK_product_id FOREIGN KEY (product_id)
REFERENCES product(id);

ALTER TABLE `frank73_f13lic`.`license`
ADD CONSTRAINT license_FK_customer_id FOREIGN KEY (customer_id)
REFERENCES customer(id);

ALTER TABLE `frank73_f13lic`.`activation`
ADD CONSTRAINT activation_FK_license_id FOREIGN KEY (license_id)
REFERENCES license(id);
