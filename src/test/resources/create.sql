CREATE DATABASE test ;
use test;
CREATE TABLE `test`.`fans` (
                                 `id` INT NOT NULL AUTO_INCREMENT,
                                 `model_name` VARCHAR(45) NOT NULL,
                                 `producer_name` VARCHAR(45) NOT NULL,
                                 `quantity_in_stock` INT NOT NULL,
                                 piece_volume DOUBLE NOT NULL,
                                 piece_weight DOUBLE NOT NULL,
                                 `in_order` INT NOT NULL,
                                 free_stock INT AS (`quantity_in_stock` - `in_order`),
                                 location VARCHAR(45) NOT NULL,
                                 description VARCHAR(45) DEFAULT NULL,
                                 PRIMARY KEY (`id`))
    DEFAULT CHARACTER SET = utf8;