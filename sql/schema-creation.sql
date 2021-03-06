-- 1. Design the schema for movie cruiser in MySQL Workbench
-- 2. Generate the SQL schema script in MySQL Workbench
-- 3. Paste the generated the SQL code here


SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema MovieCruiser
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema MovieCruiser
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `MovieCruiser` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `MovieCruiser` ;

-- -----------------------------------------------------
-- Table `MovieCruiser`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `MovieCruiser`.`user` (
  `us_id` INT NOT NULL AUTO_INCREMENT,
  `us_name` VARCHAR(60) NULL,
  PRIMARY KEY (`us_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `MovieCruiser`.`movie_list`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `MovieCruiser`.`movie_list` (
  `me_id` INT NOT NULL AUTO_INCREMENT,
  `me_title` VARCHAR(100) NULL,
  `me_boxOffice` DECIMAL(15,2) NULL,
  `me_active` VARCHAR(3) NULL,
  `me_date_of_launch` DATE NULL,
  `me_genre` VARCHAR(45) NULL,
  `me_hasteaser` VARCHAR(3) NULL,
  PRIMARY KEY (`me_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `MovieCruiser`.`Favorite`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `MovieCruiser`.`favorite` (
  `ft_id` INT NOT NULL AUTO_INCREMENT,
  `ft_us_id` INT NULL,
  `ft_pr_id` INT NULL,
  PRIMARY KEY (`ft_id`),
  INDEX `ft_us_fk_idx` (`ft_us_id` ASC),
  INDEX `ft_pr_fk_idx` (`ft_pr_id` ASC),
  CONSTRAINT `ft_us_fk`
    FOREIGN KEY (`ft_us_id`)
    REFERENCES `moviecruiser`.`user` (`us_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `ft_pr_fk`
    FOREIGN KEY (`ft_pr_id`)
    REFERENCES `moviecruiser`.`movie_list` (`me_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
