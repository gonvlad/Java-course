CREATE DATABASE accounting;

use accounting;

CREATE TABLE IF NOT EXISTS service (
	service_id INT NOT NULL AUTO_INCREMENT,
    service_name VARCHAR(256) NOT NULL,
    service_cost DOUBLE NOT NULL,
    PRIMARY KEY(service_id)
);

CREATE TABLE IF NOT EXISTS car (
	car_id INT NOT NULL AUTO_INCREMENT,
    car_brand VARCHAR(64) NOT NULL,
    car_model VARCHAR(64) NOT NULL,
    PRIMARY KEY(car_id)
);

CREATE TABLE IF NOT EXISTS ledger (
	record_id INT NOT NULL AUTO_INCREMENT,
    car_id INT NOT NULL,
    service_id INT NULL,
    due_date DATETIME NOT NULL,
    PRIMARY KEY(record_id),
    FOREIGN KEY (car_id) REFERENCES car(car_id),
    FOREIGN KEY (service_id) REFERENCES service(service_id)
);
