-- MySQL Script generated by MySQL Workbench
-- Thu 19 Mar 2020 11:50:31 AM -03
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema gerenciamento-ponto-eletronico-itau-estags
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `gerenciamento-ponto-eletronico-itau-estags` ;

-- -----------------------------------------------------
-- Schema gerenciamento-ponto-eletronico-itau-estags
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `gerenciamento-ponto-eletronico-itau-estags` DEFAULT CHARACTER SET latin1 ;
USE `gerenciamento-ponto-eletronico-itau-estags` ;

-- -----------------------------------------------------
-- Table `gerenciamento-ponto-eletronico-itau-estags`.`usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gerenciamento-ponto-eletronico-itau-estags`.`usuario` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NULL DEFAULT NULL,
  `email` VARCHAR(45) NULL DEFAULT NULL,
  `cpf` VARCHAR(11) NULL DEFAULT NULL,
  `data_cadastro` DATETIME NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `gerenciamento-ponto-eletronico-itau-estags`.`ponto_eletronico`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gerenciamento-ponto-eletronico-itau-estags`.`ponto_eletronico` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `data` DATETIME NOT NULL,
  `usuario_id` INT(11) NOT NULL,
  `tipo_entrada` ENUM('entrada', 'saida') NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_ponto_eletronico_1_idx` (`usuario_id` ASC),
  CONSTRAINT `fk_ponto_eletronico_1`
    FOREIGN KEY (`usuario_id`)
    REFERENCES `gerenciamento-ponto-eletronico-itau-estags`.`usuario` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = latin1;

USE `gerenciamento-ponto-eletronico-itau-estags`;

DELIMITER $$
USE `gerenciamento-ponto-eletronico-itau-estags`$$
CREATE
DEFINER=`root`@`%`
TRIGGER `gerenciamento-ponto-eletronico-itau-estags`.`usuario_BEFORE_INSERT`
BEFORE INSERT ON `gerenciamento-ponto-eletronico-itau-estags`.`usuario`
FOR EACH ROW
SET NEW.data_cadastro = NOW()$$

USE `gerenciamento-ponto-eletronico-itau-estags`$$
CREATE
DEFINER=`root`@`%`
TRIGGER `gerenciamento-ponto-eletronico-itau-estags`.`ponto_eletronico_BEFORE_INSERT`
BEFORE INSERT ON `gerenciamento-ponto-eletronico-itau-estags`.`ponto_eletronico`
FOR EACH ROW
SET NEW.data = NOW()$$


DELIMITER ;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
