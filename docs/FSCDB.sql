DROP DATABASE IF EXISTS `FoodStudiesConnection`;
CREATE DATABASE `FoodStudiesConnection`;
USE `FoodStudiesConnection`;
CREATE TABLE `Autores`(
`nombre` CHAR(25),
`apellido` CHAR(25),
`nombre completo` CHAR(50)
);
INSERT INTO `Autores` VALUES ('Pearl','Michel','Pearl Michel');
INSERT INTO `Autores` VALUES ('Dulce','Gonzalez','Dulce Gonzalez');
INSERT INTO `Autores` VALUES ('Noemi','Cinelli','Noemi Cinelli');

CREATE TABLE `Publicaciones`(
`titulo` CHAR(40),
`autor` CHAR(25)
);
INSERT INTO `Publicaciones` VALUES ('Comida en el S.XIX','Pearl Michel');
INSERT INTO `Publicaciones` VALUES ('El Medievo','Dulce Gonzalez');
INSERT INTO `Publicaciones` VALUES ('Pautas para un escrito gourmet','Noemi Cinelli');


