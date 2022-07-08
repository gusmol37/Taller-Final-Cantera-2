
-- -----------------------------------------------------
-- @author Gustavo Molina Batista <gusmol37@gmail.com>
-- 2022-07-03
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema VirtualBingoDB
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `VirtualBingoDB` DEFAULT CHARACTER SET utf8 ;
USE `VirtualBingoDB` ;

-- -----------------------------------------------------
-- Tabla `VirtualBingoDB`.`player`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `VirtualBingoDB`.`player` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `player_id_UNIQUE` (`id` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Tabla `VirtualBingoDB`.`game`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `VirtualBingoDB`.`game` (
  `game_id` INT NOT NULL AUTO_INCREMENT,
  `player_id` INT NOT NULL,
  PRIMARY KEY (`game_id`),
  UNIQUE INDEX `game_id_UNIQUE` (`game_id` ASC) VISIBLE,
  INDEX `fk_game_player_idx` (`player_id` ASC) VISIBLE,
  CONSTRAINT `fk_game_player`
    FOREIGN KEY (`player_id`)
    REFERENCES `VirtualBingoDB`.`player` (`id`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Tabla `VirtualBingoDB`.`card`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `VirtualBingoDB`.`card` (
  `card_id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `player_id` INT NOT NULL,
  PRIMARY KEY (`card_id`),
  INDEX `fk_card_player1_idx` (`player_id` ASC) VISIBLE,
  CONSTRAINT `fk_card_player1`
    FOREIGN KEY (`player_id`)
    REFERENCES `VirtualBingoDB`.`player` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Tabla `VirtualBingoDB`.`card_detail`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `VirtualBingoDB`.`card_detail` (
  `card_detail_id` INT NOT NULL AUTO_INCREMENT,
  `card_id` INT UNSIGNED NOT NULL,
  `line` INT NOT NULL,
  `b` INT NULL,
  `i` INT NULL,
  `n` INT NULL,
  `g` INT NULL,
  `o` INT NULL,
  `is_b` TINYINT(1) NULL DEFAULT 0,
  `is_i` TINYINT(1) NULL DEFAULT 0,
  `is_n` TINYINT(1) NULL DEFAULT 0,
  `is_g` TINYINT(1) NULL DEFAULT 0,
  `is_o` TINYINT(1) NULL DEFAULT 0,
  PRIMARY KEY (`card_detail_id`),
  INDEX `fk_card_detail_card1_idx` (`card_id` ASC) INVISIBLE,
  CONSTRAINT `fk_card_detail_card1`
    FOREIGN KEY (`card_id`)
    REFERENCES `VirtualBingoDB`.`card` (`card_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Tabla `VirtualBingoDB`.`rolled_number`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `VirtualBingoDB`.`rolled_number` (
  `rolled_number_id` INT NOT NULL AUTO_INCREMENT,
  `game_game_id` INT NOT NULL,
  `rolled_number` INT NULL,
  PRIMARY KEY (`rolled_number_id`),
  UNIQUE INDEX `rolled_number_id_UNIQUE` (`rolled_number_id` ASC) VISIBLE,
  INDEX `fk_rolled_number_game1_idx` (`game_game_id` ASC) VISIBLE,
  CONSTRAINT `fk_rolled_number_game1`
    FOREIGN KEY (`game_game_id`)
    REFERENCES `VirtualBingoDB`.`game` (`game_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Valores iniciales 
-- -----------------------------------------------------
INSERT INTO virtualbingodb.player (email)
VALUES ('don@carlos.com');
INSERT INTO virtualbingodb.game (player_id)
VALUES (1);
INSERT INTO virtualbingodb.rolled_number (game_game_id, rolled_number)
VALUES (1, 15),
       (1, 20),
       (1, 30),
       (1, 1),
       (1, 54),
       (1, 87),
       (1, 96),
       (1, 53),
       (1, 37),
       (1, 9);
INSERT INTO virtualbingodb.card (player_id)
VALUES (1);
INSERT INTO virtualbingodb.card_detail (card_id, line, b, i, n, g, o, is_b, is_i, is_n, is_g, is_o)
VALUES (1, 1, 3, 15, 30, 45, 60, DEFAULT, DEFAULT, DEFAULT, DEFAULT, DEFAULT),
       (1, 2, 7, 16, 33, 49, 63, DEFAULT, DEFAULT, DEFAULT, DEFAULT, DEFAULT),
       (1, 3, 10, 18, 36, 46, 65, DEFAULT, DEFAULT, DEFAULT, DEFAULT, DEFAULT),
       (1, 4, 14, 20, 39, 52, 69, DEFAULT, DEFAULT, DEFAULT, DEFAULT, DEFAULT),
       (1, 5, 8, 29, 42, 57, 75, DEFAULT, DEFAULT, DEFAULT, DEFAULT, DEFAULT);

