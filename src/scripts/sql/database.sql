CREATE DATABASE  IF NOT EXISTS `renting-system` ;
USE `renting-system`;

DROP TABLE IF EXISTS `comment`;
DROP TABLE IF EXISTS `rent-item`;
DROP TABLE IF EXISTS `item`;
DROP TABLE IF EXISTS `category`;
DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` nvarchar(45) DEFAULT NULL,
  `last_name` nvarchar(45) DEFAULT NULL,
  `email` nvarchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

CREATE TABLE `category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` nvarchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;


CREATE TABLE `item` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` nvarchar(45) DEFAULT NULL,
  `category_id` int(11) not null,
  `photo_path` nvarchar(200) default null,
  `details` nvarchar(1000) DEFAULT NULL,
  `owner_id` int(11) not null,
  `cost_per_day` decimal(10,2) default null,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`owner_id`) REFERENCES `user`(`id`),
  foreign key (`category_id`) references `user`(`id`)
  
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

CREATE TABLE `rent-item` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `item_id` int(11) NOT NULL,
  `customer_id` int(11) not null,
  `rental_date` datetime,
  `return_date` datetime,
  `returned` boolean,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`item_id`) REFERENCES `item`(`id`),
  FOREIGN KEY (`customer_id`) REFERENCES `user`(`id`)
  
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

CREATE TABLE `comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `customer_id` int(11) not null,
  `owner_id` int(11) not null,
  `header` nvarchar(50) default null,
  `body` nvarchar(500) default null,
  `date` datetime default null,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`customer_id`) REFERENCES `user`(`id`),
  FOREIGN KEY (`owner_id`) REFERENCES `user`(`id`)
  
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

INSERT INTO `user` VALUES
	(1,'David','Adams','david@gmail.com'),
	(2,'John','Doe','john@gmail.com'),
	(3,'Ajay','Rao','ajay@gmail.com'),
	(4,'Mary','Public','mary@gmail.com'),
	(5,'Maxwell','Dixon','max@gmail.com');

INSERT INTO `category` VALUES 
	(1,'Książki'),
	(2,'Sprzęt sportowy'),
	(3,'Samochody'),
	(4,'Rowery'),
	(5,'Łodzie');


INSERT INTO `item` VALUES 
	(1,'Java. Podstawy',1,'../photo_1.png', 'Książka wprowadzająca do jężyka Java.', 1, 5),
	(2,'Pan Tadeusz',1,'../photo_2.png', 'Książka opowiadająca o życiu polskiej szlachty.', 1, 5),
	(3,'Kajak Super 2000',5,'../photo_3.png', 'Dwuosobowy kajak.', 2, 35),
	(4,'Fiat Punto',3,'../photo_4.png', 'Średnij wielkości samochód.', 3, 100),
	(5,'Rower Ranger',4,'../photo_5.png', 'Rower górski.', 1, 50);

INSERT INTO `rent-item` VALUES 
	(1,1,2, '2018-07-21 12:22:01', '2018-07-24 12:22:01', true),
	(2,2,2, '2018-07-21 12:22:01', '2018-07-24 12:22:01', true),
	(3,3,4, '2018-06-14 18:12:01', '2018-06-24 08:26:01', true),
	(4,3,1, '2018-08-01 11:12:51', '2018-09-15 10:21:21', false),
	(5,5,1, '2018-03-12 16:34:41', '2018-03-12 09:46:05', true);

INSERT INTO `comment` VALUES 
	(1,1,2,'Świetny wypożyczający', 'Polecam tego użytkownika!', '2018-07-24 12:22:01'),
	(2,1,3,'Świetny wypożyczający', 'Brak żadnych problemów produkt zgodny z opisem.', '2018-07-24 12:22:01'),
	(3,2,1,'Uczciwy', 'Profesjonalna i szybka obsługa!', '2018-07-24 12:22:01'),
	(4,4,1,'Dobra obsługa', 'Brak problemów', '2018-09-15 10:21:21'),
	(5,1,5,'Fatalny wypożyczający', 'Skorzystanie z jego usług to była pomyłka.', '2018-07-21 12:22:01');
