/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Tiago Teixeira
 * Created: 02/11/2021
 */


SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema db_ordemservico
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `db_ordemservico` ;

-- -----------------------------------------------------
-- Schema db_ordemservico
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `db_ordemservico` DEFAULT CHARACTER SET utf8 ;
USE `db_ordemservico` ;

-- -----------------------------------------------------
-- Table `db_ordemservico`.`cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_ordemservico`.`cliente` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(250) NULL,
  `cpf` VARCHAR(45) NULL,
  `rg` VARCHAR(45) NULL,
  `rua` VARCHAR(250) NULL,
  `bairro` VARCHAR(250) NULL,
  `numero` VARCHAR(10) NULL,
  `cidade` VARCHAR(250) NULL,
  `estado` VARCHAR(100) NULL,
  `cep` VARCHAR(15) NULL,
  `celular` VARCHAR(20) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_ordemservico`.`ordemservico`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_ordemservico`.`ordemservico` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `id_cliente` INT NOT NULL,
  `nomeVeiculo` VARCHAR(45) NULL,
  `modeloVeiculo` VARCHAR(45) NULL,
  `marcaVeiculo` VARCHAR(45) NULL,
  `corVeiculo` VARCHAR(45) NULL,
  `placaVeiculo` VARCHAR(45) NULL,
  `mecanico` VARCHAR(250) NULL,
  `defeitoreclamado` VARCHAR(5000) NULL,
  `relatomecanico` VARCHAR(5000) NULL,
  `datachegada` DATETIME NULL,
  `dataentrega` DATETIME NULL,
  `status` VARCHAR(45) NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_ordemservico_cliente1_idx` (`id_cliente` ASC) VISIBLE,
  CONSTRAINT `fk_ordemservico_cliente1`
    FOREIGN KEY (`id_cliente`)
    REFERENCES `db_ordemservico`.`cliente` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_ordemservico`.`itens_ordemservico`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_ordemservico`.`itens_ordemservico` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `id_ordem` INT NOT NULL,
  `tipo` VARCHAR(45) NULL,
  `descricao` VARCHAR(250) NULL,
  `quantidade` DOUBLE NULL,  
  `valor_un` DOUBLE NULL,
  `valor_total` DOUBLE NULL,
  PRIMARY KEY (`id`),
  INDEX `os_itemOs_idx` (`id_ordem` ASC) VISIBLE,
  CONSTRAINT `os_itemOs`
    FOREIGN KEY (`id_ordem`)
    REFERENCES `db_ordemservico`.`ordemservico` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
