CREATE DATABASE mailbox;

use mailbox;

CREATE TABLE IF NOT EXISTS Person (
	person_id INT NOT NULL AUTO_INCREMENT,
	first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    birth_date DATE NOT NULL,
    PRIMARY KEY (person_id)
); 

CREATE TABLE IF NOT EXISTS Letter (
	letter_id INT NOT NULL AUTO_INCREMENT,
	sender INT NOT NULL,
    recipient INT NOT NULL,
    letter_subject VARCHAR(50) NOT NULL,
    letter_text VARCHAR(200) NOT NULL,
    departure_date DATE NOT NULL,
    PRIMARY KEY (letter_id),
    FOREIGN KEY (sender) REFERENCES Person(person_id),
    FOREIGN KEY (recipient) REFERENCES Person(person_id)
); 