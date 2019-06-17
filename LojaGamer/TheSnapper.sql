DROP SCHEMA IF EXISTS `dbsnapper`;
CREATE DATABASE `dbsnapper`;
USE `dbsnapper`;

DROP TABLE IF EXISTS `pragas`;
CREATE TABLE `pragas` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(200) NOT NULL,
  `quantidade` bigint NOT NULL,
  `fotoFileName` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
);
INSERT INTO `dbsnapper`.`pragas`(`id`,`nome`,`quantidade`) VALUES(1,"Baratas",100000000000);
INSERT INTO `dbsnapper`.`pragas`(`id`,`nome`,`quantidade`) VALUES(2,"Mosquitos",200000000000);
INSERT INTO `dbsnapper`.`pragas`(`id`,`nome`,`quantidade`) VALUES(3,"Formigas",300000000000);
INSERT INTO `dbsnapper`.`pragas`(`id`,`nome`,`quantidade`) VALUES(4,"Humanos",700000000000);

DROP TABLE IF EXISTS `usuarios`;
CREATE TABLE `usuarios` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `login` varchar(45) DEFAULT NULL,
  `senha` varchar(45) DEFAULT NULL,
  `nome` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `foto` longblob DEFAULT NULL,
  `fotoType` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

INSERT INTO usuarios VALUES (1,'root','1','MALTON WILLIAM MACHADO CUNICO','maltonx@gmail.com',NULL,'image/jpeg');
INSERT INTO usuarios VALUES (2,'guest','1','Peasant','a@a.a',NULL,'image/jpeg');
INSERT INTO usuarios VALUES (3,'root2','2','Peasant2' ,'a@a.a', NULL,'image/jpeg');
