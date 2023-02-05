DROP TABLE IF EXISTS type_car;
CREATE TABLE type_car (
    id INTEGER NOT NULL AUTO_INCREMENT,
    category VARCHAR NOT NULL,
    price_per_day DOUBLE NOT NULL,
    loyalty_points INTEGER NOT NULL,
    PRIMARY KEY(id)
);

DROP TABLE IF EXISTS car;
CREATE TABLE car (
    id INTEGER NOT NULL AUTO_INCREMENT,
    model VARCHAR NOT NULL,
    type_id INTEGER NOT NULL,
    PRIMARY KEY(id)
);

DROP TABLE IF EXISTS users;
CREATE TABLE users (
    id INTEGER NOT NULL AUTO_INCREMENT,
    name VARCHAR NOT NULL,
    surnames VARCHAR NOT NULL,
    PRIMARY KEY(id)
);

DROP TABLE IF EXISTS reservation;
CREATE TABLE reservation (
    id INTEGER NOT NULL AUTO_INCREMENT,
    car_id INTEGER NOT NULL,
    user_id INTEGER NOT NULL,
    pick_up_time TIMESTAMP NOT NULL,
    return_time TIMESTAMP NOT NULL,
    return_time_real TIMESTAMP,
    total_price DOUBLE NOT NULL,
    total_price_extra DOUBLE,
    loyalty_points INTEGER NOT NULL,
    status VARCHAR NOT NULL,
    PRIMARY KEY(id)
);

INSERT INTO type_car (id, category, price_per_day, loyalty_points) VALUES (1, 'PREMIUM', 300, 5);
INSERT INTO type_car (id, category, price_per_day, loyalty_points) VALUES (2, 'SUV', 150, 3);
INSERT INTO type_car (id, category, price_per_day, loyalty_points) VALUES (3, 'SMALL', 50, 1);

INSERT INTO car (id, model, type_id) VALUES (1, 'BMW 7', 1);
INSERT INTO car (id, model, type_id) VALUES (2, 'AUDI A8', 1);
INSERT INTO car (id, model, type_id) VALUES (3, 'MERCEDES CL 500', 1);
INSERT INTO car (id, model, type_id) VALUES (4, 'KIA SORENTO', 2);
INSERT INTO car (id, model, type_id) VALUES (5, 'NISSAN JUKE', 2);
INSERT INTO car (id, model, type_id) VALUES (6, 'OPEL MOKKA', 2);
INSERT INTO car (id, model, type_id) VALUES (7, 'SEAT IBIZA', 3);
INSERT INTO car (id, model, type_id) VALUES (8, 'FIAT PANDA', 3);
INSERT INTO car (id, model, type_id) VALUES (9, 'NISSAN MICRA', 3);

INSERT INTO users (id, name, surnames) VALUES (1, 'Pedro', 'Aldana Cuenca');
INSERT INTO users (id, name, surnames) VALUES (2, 'Alejandro', 'Perez Laoz');
INSERT INTO users (id, name, surnames) VALUES (3, 'Mario', 'Merino Gañan');
