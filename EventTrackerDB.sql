-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema trackerdb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `trackerdb` ;

-- -----------------------------------------------------
-- Schema trackerdb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `trackerdb` DEFAULT CHARACTER SET utf8 ;
USE `trackerdb` ;

-- -----------------------------------------------------
-- Table `trackerdb`.`Mileage`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `trackerdb`.`Mileage` ;

CREATE TABLE IF NOT EXISTS `trackerdb`.`Mileage` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `distance` DECIMAL(5,2) NOT NULL,
  `gallons_used` DECIMAL(5,2) NOT NULL,
  `mpg` DECIMAL(5,2) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

SET SQL_MODE = '';
GRANT USAGE ON *.* TO alex@localhost;
 DROP USER alex@localhost;
SET SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';
CREATE USER 'alex'@'localhost' IDENTIFIED BY 'alex';

GRANT SELECT, INSERT, TRIGGER ON TABLE `trackerdb`.* TO 'alex'@'localhost';
GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE `trackerdb`.* TO 'alex'@'localhost';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `trackerdb`.`Mileage`
-- -----------------------------------------------------
START TRANSACTION;
USE `trackerdb`;
INSERT INTO `trackerdb`.`Mileage` (`id`, `distance`, `gallons_used`, `mpg`) VALUES (1, 315, 12.85, 24.514);
INSERT INTO `trackerdb`.`Mileage` (`id`, `distance`, `gallons_used`, `mpg`) VALUES (2, 400, 14.5, 27.586);
INSERT INTO `trackerdb`.`Mileage` (`id`, `distance`, `gallons_used`, `mpg`) VALUES (3, 386, 14.1, 27.38);

COMMIT;
