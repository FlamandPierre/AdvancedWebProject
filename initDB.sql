set time_zone = "+00:00";
set @@global.time_zone = '+00:00';
set @@session.time_zone = '+00:00';

DROP TABLE IF EXISTS OrderLine;
DROP TABLE IF EXISTS `Order`;
DROP TABLE IF EXISTS User;
DROP TABLE IF EXISTS BoardGame;
DROP TABLE IF EXISTS CategoryTranslation;
DROP TABLE IF EXISTS Category;
DROP TABLE IF EXISTS Language;

CREATE TABLE User
(
    id INTEGER UNIQUE NOT NULL AUTO_INCREMENT,
    username VARCHAR(255) UNIQUE NOT NULL,
    password VARCHAR(60) NOT NULL,
    firstname VARCHAR(255) NOT NULL,
    lastname VARCHAR(255) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    loyaltyPoints INTEGER NOT NULL,
    address VARCHAR(255) NOT NULL,
    phoneNumber VARCHAR(255) NOT NULL,
    birthdate DATE NULL,
    authorities VARCHAR(60) NOT NULL,
    account_non_expired BIT NOT NULL,
    account_non_locked BIT NOT NULL,
    credentials_non_expired BIT NOT NULL,
    enabled BIT NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE `Order`(
    id INTEGER UNIQUE NOT NULL AUTO_INCREMENT,
    date DATE NOT NULL,
    isPaid BIT NOT NULL,
    reduction DOUBLE NOT NULL,
    fk_user INTEGER NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (fk_user) REFERENCES User (id)
);

CREATE TABLE Language
(
    code VARCHAR(3) UNIQUE NOT NULL,
    PRIMARY KEY (code)
);

CREATE TABLE Category
(
    label VARCHAR(60) UNIQUE NOT NULL,
    PRIMARY KEY (label)
);

CREATE TABLE CategoryTranslation(
    categoryName VARCHAR(255) NOT NULL,
    fk_language VARCHAR(3) NOT NULL,
    fk_category VARCHAR(60) NOT NULL,
    PRIMARY KEY (fk_language, fk_category),
    FOREIGN KEY (fk_language) REFERENCES Language(code),
    FOREIGN KEY (fk_category) REFERENCES Category (label)
);

CREATE TABLE BoardGame
(
    id INTEGER UNIQUE NOT NULL AUTO_INCREMENT,
    name VARCHAR(255) UNIQUE NOT NULL,
    editorName VARCHAR(255) NOT NULL,
    price DOUBLE NOT NULL,
    description VARCHAR(1022) NULL,
    fk_category VARCHAR(60) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE OrderLine(
    quantity INTEGER NOT NULL,
    price DOUBLE NOT NULL,
    fk_order INTEGER NOT NULL,
    fk_boardGame INTEGER NOT NULL,
    PRIMARY KEY (fk_order, fk_boardGame),
    FOREIGN KEY (fk_order) REFERENCES `Order` (id),
    FOREIGN KEY (fk_boardGame) REFERENCES BoardGame (id)
);

INSERT INTO User(username, password, firstname, lastname, email, loyaltyPoints, address, phoneNumber, birthdate, authorities, account_non_expired, account_non_locked, credentials_non_expired, enabled)VALUES
('test', '$2a$10$wWXHc7YKDkvW/BkjHPXf9eRiLVngtCcJA69kQwt455Xalxk3Be9y6','test', 'test', 'test@test.com', 25, 'rue du test 42 5000 NAMUR', '0032666424242', '2000-01-01', 'ROLE_USER', 1, 1, 1, 1);

INSERT INTO `Order`(date, isPaid, reduction, fk_user)VALUES
    ('2022-11-29', 1, 0.0, 1);

INSERT INTO Language(code)VALUES
('FRA');

INSERT INTO Category(label)VALUES
('CONST&GEST');

INSERT INTO CategoryTranslation(fk_language, fk_category, categoryName) VALUES
('FRA', 'CONST&GEST', 'jeux de construction et de gestion');

INSERT INTO BoardGame(name, editorName, price, description, fk_category)VALUES
('Carcassonne', 'Filosofia', 35.20, 'Construisez une cité médiévale, et placez-y vos chevaliers dans les plus grandes villes, vos brigands sur les plus grands chemins, vos moines dans les monastères, et vos paysans sur les champs au pied des villes.','CONST&GEST');

INSERT INTO OrderLine(quantity, price, fk_order, fk_boardGame) VALUES
(1, 35.20, 1, 1);