SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema sample
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `sample` ;
CREATE SCHEMA IF NOT EXISTS `sample` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `sample` ;

-- -----------------------------------------------------
-- Table `sample`.`sample`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `sample`.`sample` ;

CREATE TABLE IF NOT EXISTS `sample`.`sample` (
  `idusers` MEDIUMTEXT NULL,
  `first_name` VARCHAR(45) NULL,
  `last_name` VARCHAR(45) NULL,
  `pin` VARCHAR(45) NULL,
  PRIMARY KEY (`idusers`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
