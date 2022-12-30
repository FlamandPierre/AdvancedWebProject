set time_zone = "+00:00";
set @@global.time_zone = '+00:00';
set @@session.time_zone = '+00:00';

DROP TABLE IF EXISTS order_line;
DROP TABLE IF EXISTS `order`;
DROP TABLE IF EXISTS user;
DROP TABLE IF EXISTS board_game;
DROP TABLE IF EXISTS category_translation;
DROP TABLE IF EXISTS category;
DROP TABLE IF EXISTS language;

CREATE TABLE user
(
    username VARCHAR(255) UNIQUE NOT NULL,
    password VARCHAR(60) NOT NULL,
    firstname VARCHAR(255) NOT NULL,
    lastname VARCHAR(255) NOT NULL,
    loyalty_points INTEGER NOT NULL,
    address VARCHAR(255) NOT NULL,
    phone_number VARCHAR(255) NOT NULL,
    birthdate DATE NULL,
    authorities VARCHAR(60) NOT NULL,
    account_non_expired BIT NOT NULL,
    account_non_locked BIT NOT NULL,
    credentials_non_expired BIT NOT NULL,
    enabled BIT NOT NULL,
    PRIMARY KEY (username)
);

CREATE TABLE `order`(
    id INTEGER UNIQUE NOT NULL AUTO_INCREMENT,
    date DATE NOT NULL,
    is_paid BIT NOT NULL,
    reduction DOUBLE NOT NULL,
    fk_user VARCHAR(255)
        NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (fk_user) REFERENCES user (username)
);

CREATE TABLE language
(
    code VARCHAR(3) UNIQUE NOT NULL,
    PRIMARY KEY (code)
);

CREATE TABLE category
(
    label VARCHAR(60) UNIQUE NOT NULL,
    PRIMARY KEY (label)
);

CREATE TABLE category_translation(
    category_name VARCHAR(255) NOT NULL,
    fk_language VARCHAR(3) NOT NULL,
    fk_category VARCHAR(60) NOT NULL,
    PRIMARY KEY (fk_language, fk_category),
    FOREIGN KEY (fk_language) REFERENCES language (code),
    FOREIGN KEY (fk_category) REFERENCES category (label)
);

CREATE TABLE board_game
(
    id INTEGER UNIQUE NOT NULL AUTO_INCREMENT,
    name VARCHAR(255) UNIQUE NOT NULL,
    editor_name VARCHAR(255) NOT NULL,
    price DOUBLE NOT NULL,
    description VARCHAR(1022) NULL,
    fk_category VARCHAR(60) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE order_line(
    quantity INTEGER NOT NULL,
    price DOUBLE NOT NULL,
    fk_order INTEGER NOT NULL,
    fk_boardGame INTEGER NOT NULL,
    PRIMARY KEY (fk_order, fk_boardGame),
    FOREIGN KEY (fk_order) REFERENCES `order` (id),
    FOREIGN KEY (fk_boardGame) REFERENCES board_game (id)
);

INSERT INTO user(username, password, firstname, lastname, loyalty_points, address, phone_number, birthdate, authorities, account_non_expired, account_non_locked, credentials_non_expired, enabled)VALUES
('test@test.com', '$2a$10$wWXHc7YKDkvW/BkjHPXf9eRiLVngtCcJA69kQwt455Xalxk3Be9y6','test', 'test', 25, 'rue du test 42 5000 NAMUR', '0032666424242', '2000-01-01', 'ROLE_USER', 1, 1, 1, 1);

INSERT INTO `order`(date, is_paid, reduction, fk_user)VALUES
    ('2022-11-29', 1, 0.0, 'test@test.com');

INSERT INTO language(code)VALUES
('FRA');

INSERT INTO category(label)VALUES
('CONST&GEST');

INSERT INTO category_translation(fk_language, fk_category, category_name) VALUES
('FRA', 'CONST&GEST', 'jeux de construction et de gestion');

INSERT INTO board_game(name, editor_name, price, description, fk_category)VALUES
('Carcassonne', 'Filosofia', 35.20, 'Construisez une cité médiévale, et placez-y vos chevaliers dans les plus grandes villes, vos brigands sur les plus grands chemins, vos moines dans les monastères, et vos paysans sur les champs au pied des villes.','CONST&GEST');

INSERT INTO order_line(quantity, price, fk_order, fk_boardGame)VALUES
(1, 35.20, 1, 1);