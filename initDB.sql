set time_zone = "+00:00";
set @@global.time_zone = '+00:00';
set @@session.time_zone = '+00:00';

DROP TABLE IF EXISTS orders;
DROP TABLE IF EXISTS orderline;
DROP TABLE IF EXISTS board_game;
DROP TABLE IF EXISTS translation;
DROP TABLE IF EXISTS category;
DROP TABLE IF EXISTS language;
DROP TABLE IF EXISTS user;

CREATE TABLE user(
    id INTEGER UNIQUE NOT NULL AUTO_INCREMENT,
    username VARCHAR(255) UNIQUE NOT NULL,
    password VARCHAR(60) NOT NULL,
    firstname VARCHAR(255) NOT NULL,
    lastname VARCHAR(255) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    loyalty_points INTEGER NOT NULL,
    creation_date DATE NOT NULL,
    address VARCHAR(255) NOT NULL,
    phone_number VARCHAR(255) NOT NULL,
    birthdate DATE NULL,
    authorities VARCHAR(60) NOT NULL,
    account_non_expired BIT NOT NULL,
    account_non_locked BIT NOT NULL,
    credentials_non_expired BIT NOT NULL,
    enabled BIT NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE language(
    code VARCHAR(3) UNIQUE NOT NULL,
    PRIMARY KEY (code)
);

CREATE TABLE category(
    label VARCHAR(60) UNIQUE NOT NULL,
    PRIMARY KEY (label)
);

CREATE TABLE translation(
    fk_language VARCHAR(3) NOT NULL,
    fk_category VARCHAR(60) NOT NULL,
    name VARCHAR(255) NOT NULL,
    PRIMARY KEY (fk_language, fk_category),
    FOREIGN KEY (fk_language) REFERENCES language(code),
    FOREIGN KEY (fk_category) REFERENCES category(label)
);

CREATE TABLE board_game(
    id INTEGER UNIQUE NOT NULL AUTO_INCREMENT,
    name VARCHAR(255) UNIQUE NOT NULL,
    editor_name VARCHAR(255) NOT NULL,
    price DOUBLE NOT NULL,
    description VARCHAR(1022) NULL,
    fk_category VARCHAR(60) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE orderline(
    id INTEGER UNIQUE NOT NULL AUTO_INCREMENT,
    quantity INTEGER NOT NULL,
    price DOUBLE NOT NULL,
    fk_board_game INTEGER NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (fk_board_game) REFERENCES board_game(id)
);

CREATE TABLE orders(
    id INTEGER UNIQUE NOT NULL AUTO_INCREMENT,
    date DATE NOT NULL,
    is_paid BIT NOT NULL,
    reduction DOUBLE NOT NULL,
    fk_user INTEGER NOT NULL,
    fk_orderline INTEGER NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (fk_user) REFERENCES user(id),
    FOREIGN KEY (fk_orderline) REFERENCES orders(id)
);

INSERT INTO user(username, password, firstname, lastname, email, loyalty_points, creation_date, address, phone_number, birthdate, authorities, account_non_expired, account_non_locked, credentials_non_expired, enabled) VALUES
('test', '$2a$10$wWXHc7YKDkvW/BkjHPXf9eRiLVngtCcJA69kQwt455Xalxk3Be9y6','test', 'test', 'test@test.com', 25, '2022-11-29', 'rue du test 42 5000 NAMUR', '0032666424242', '2000-01-01', 'ROLE_USER', 1, 1, 1, 1);

INSERT INTO language(code) VALUES
('FRA');

INSERT INTO category(label) VALUES
('CONST&GEST');

INSERT INTO translation(fk_language, fk_category, name) VALUES
('FRA', 'CONST&GEST', 'jeux de construction et de gestion');

INSERT INTO board_game(name, editor_name, price, description, fk_category) VALUES
('Carcassonne', 'Filosofia', 35.20, 'Construisez une cité médiévale, et placez-y vos chevaliers dans les plus grandes villes, vos brigands sur les plus grands chemins, vos moines dans les monastères, et vos paysans sur les champs au pied des villes.','CONST&GEST');

INSERT INTO orderline(quantity, price, fk_board_game) VALUES
(1, 35.20, 1);

INSERT INTO orders(date, is_paid, reduction, fk_orderline, fk_user) VALUES
('2022-11-29', 1, 0.0, 1, 1);