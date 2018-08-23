CREATE DATABASE IF NOT EXISTS company CHARACTER SET utf8 COLLATE utf8_general_ci;
USE company;
CREATE TABLE departments
(
  dept_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  department_name VARCHAR(255) NOT NULL,
  count_emploees INT(11) NOT NULL
);
  CREATE UNIQUE INDEX department_name_uindex ON departments (department_name);

CREATE TABLE emploees
(
  id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  name VARCHAR(255) NOT NULL,
  surname VARCHAR(255) NOT NULL,
  birth DATE NOT NULL,
  salary INT NOT NULL,
  email VARCHAR(255) NOT NULL,
  department_id INT NOT NULL,

  CONSTRAINT emploees_departments_id_fk FOREIGN KEY (department_id) REFERENCES departments (dept_id) ON UPDATE CASCADE
);
CREATE UNIQUE INDEX emploees_email_uindex ON emploees (email);