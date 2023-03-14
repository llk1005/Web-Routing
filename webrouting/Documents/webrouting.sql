CREATE DATABASE  IF NOT EXISTS `webrouting`;
USE `webrouting`;
-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: localhost    Database: webrouting
-- ------------------------------------------------------
-- Server version	8.0.28


-- -------------------------------------------- --
-- File created by Ian Black and Logan Kirkwood --
-- -------------------------------------------- --

SET GLOBAL FOREIGN_KEY_CHECKS=0;

--
-- Table structure for table `carriers`
--

DROP TABLE IF EXISTS `carriers`;
CREATE TABLE `carriers` (
  id bigint NOT NULL,
  carrier_name varchar(255) NOT NULL,
  scac varchar(255) NOT NULL,
  ltl varchar(255) NOT NULL,
  ftl varchar(255) NOT NULL,
  pallets varchar(255) NOT NULL,
  weight varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
);

--
-- Table structure for table `contacts`
--

DROP TABLE IF EXISTS `contacts`;
CREATE TABLE `contacts` (
  `id` bigint NOT NULL,
  `city` varchar(255) DEFAULT NULL,
  `email_address` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `middle_initial` varchar(255) DEFAULT NULL,
  `primary_phone` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `street_address1` varchar(255) DEFAULT NULL,
  `street_address2` varchar(255) DEFAULT NULL,
  `work_phone` varchar(255) DEFAULT NULL,
  `zip` varchar(255) DEFAULT NULL,
  carrier_id bigint,
  CONSTRAINT CARRIER_CONTACT_FK FOREIGN KEY (carrier_id) REFERENCES carriers(id),
  PRIMARY KEY (`id`)
);

--
-- Table structure for table `locations`
--

DROP TABLE IF EXISTS `locations`;
CREATE TABLE `locations` (
  `id` bigint NOT NULL,
  `city` varchar(255) DEFAULT NULL,
  `latitude` varchar(255) DEFAULT NULL,
  `location_type` varchar(255) DEFAULT NULL,
  `longitude` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `street_address1` varchar(255) DEFAULT NULL,
  `street_address2` varchar(255) DEFAULT NULL,
  `zip` varchar(255) DEFAULT NULL,
  carrier_id bigint,
  CONSTRAINT CARRIER_LOCATIONS_FK FOREIGN KEY (carrier_id) REFERENCES carriers(id),
  PRIMARY KEY (`id`)
);

--
-- Table structure for table `vehicle_types`
--

DROP TABLE IF EXISTS `vehicle_types`;
CREATE TABLE `vehicle_types` (
  `id` bigint NOT NULL,
  `capacity` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `empty_weight` int NOT NULL,
  `height` int NOT NULL,
  `length` int NOT NULL,
  `make` varchar(255) DEFAULT NULL,
  `maximum_cubic_weight` int NOT NULL,
  `maximum_range` int NOT NULL,
  `maximum_weight` int NOT NULL,
  `minimum_cubic_weight` int NOT NULL,
  `minimum_weight` int NOT NULL,
  `model` varchar(255) DEFAULT NULL,
  `restrictions` varchar(255) DEFAULT NULL,
  `sub_type` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

--
-- Table structure for table `vehicles`
--

DROP TABLE IF EXISTS `vehicles`;
CREATE TABLE `vehicles` (
  `id` bigint NOT NULL,
  `manufactured_year` varchar(255) DEFAULT NULL,
  `plate_number` varchar(255) DEFAULT NULL,
  `vin_number` varchar(255) DEFAULT NULL,
  carrier_id bigint,
  location_id bigint,
  vehicle_type_id bigint,
  CONSTRAINT CARRIER_VEHICLES_FK FOREIGN KEY (carrier_id) REFERENCES carriers(id),
  CONSTRAINT LOCATION_VEHICLES_FK FOREIGN KEY (location_id) REFERENCES locations(id),
  CONSTRAINT VEHICLE_TYPE_VEHICLES_FK FOREIGN KEY (vehicle_type_id) REFERENCES vehicle_types(id),
  PRIMARY KEY (`id`)
);

--
-- Table structure for table `driver`
--

DROP TABLE IF EXISTS `driver`;
CREATE TABLE `driver` (
  `id` bigint NOT NULL,
  `lisence_class` varchar(255) DEFAULT NULL,
  `lisence_expiration` varchar(255) DEFAULT NULL,
  `lisence_number` varchar(255) DEFAULT NULL,
  contact_id bigint,
  carrier_id bigint,
  vehicle_id bigint,
  CONSTRAINT CONTACT_DRIVER_FK FOREIGN KEY (contact_id) REFERENCES contacts(id),
  CONSTRAINT CARRIER_DRIVER_FK FOREIGN KEY (carrier_id) REFERENCES carriers(id),
  CONSTRAINT VEHICLE_DRIVER_FK FOREIGN KEY (vehicle_id) REFERENCES vehicles(id),
  PRIMARY KEY (`id`)
);

--
-- Table structure for table `technicians`
--

DROP TABLE IF EXISTS `technicians`;
CREATE TABLE `technicians` (
  `id` bigint NOT NULL,
  `skill_grade` varchar(255) DEFAULT NULL,
  contact_id bigint,
  CONSTRAINT CONTACT_TECHNICIAN_FK FOREIGN KEY (contact_id) REFERENCES contacts(id),
  PRIMARY KEY (`id`)
);

--
-- Table structure for table `maintenance_orders`
--

DROP TABLE IF EXISTS `maintenance_orders`;
CREATE TABLE `maintenance_orders` (
  `id` bigint NOT NULL,
  `cost` varchar(255) DEFAULT NULL,
  `details` varchar(255) DEFAULT NULL,
  `maintenance_type` varchar(255) DEFAULT NULL,
  `scheduled_date` varchar(255) DEFAULT NULL,
  `service_type_key` varchar(255) DEFAULT NULL,
  `status_key` varchar(255) DEFAULT NULL,
  technician_id bigint,
  vehicle_id bigint,
  carrier_id bigint,
  CONSTRAINT TECHNICIAN_ORDER_FK FOREIGN KEY (technician_id) REFERENCES technicians(id),
  CONSTRAINT VEHICLE_ORDER_FK FOREIGN KEY (vehicle_id) REFERENCES vehicles(id),
  CONSTRAINT CARRIER_ORDER_FK FOREIGN KEY (carrier_id) REFERENCES carriers(id),
  PRIMARY KEY (`id`)
);



--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` bigint NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  role_id bigint,
  carrier_id bigint,
  CONSTRAINT ROLE_USER_FK FOREIGN KEY (role_id) REFERENCES role(id),
  CONSTRAINT CARRIER_USER_FK FOREIGN KEY (carrier_id) REFERENCES carriers(id),
  PRIMARY KEY (`id`)
);



--
-- Table structure for table `shipments`
--

DROP TABLE IF EXISTS `shipments`;
CREATE TABLE `shipments` (
  id bigint NOT NULL,
  client varchar(255) NOT NULL,
  carrier_id bigint,
  vehicle_id bigint,
  user_id bigint,
  client_mode varchar(255) NOT NULL,
  ship_date varchar(255) NOT NULL,
  freightbill_number varchar(255) NOT NULL,
  paid_amount varchar(255),
  full_freight_terms varchar(255) NOT NULL,
  commodity_class varchar(255) NOT NULL,
  commodity_pieces varchar(255) NOT NULL,
  commodity_paid_weight varchar(255) NOT NULL,
  shipper_city varchar(255) NOT NULL,
  shipper_state varchar(255) NOT NULL,
  shipper_zip varchar(255) NOT NULL,
  shipper_latitude varchar(255),
  shipper_longitude varchar(255),
  consignee_city varchar(255) NOT NULL,
  consignee_state varchar(255) NOT NULL,
  consignee_zip varchar(255) NOT NULL,
  consignee_latitude varchar(255),
  consignee_longitude varchar(255),
  CONSTRAINT CARRIER_FK FOREIGN KEY (carrier_id) REFERENCES carriers(id),
  CONSTRAINT VEHICLE_FK FOREIGN KEY (vehicle_id) REFERENCES vehicles(id),
  CONSTRAINT USER_FK FOREIGN KEY (user_id) REFERENCES user(id),
  PRIMARY KEY (`id`)
);

--
-- Table structure for table `bids`
--

DROP TABLE IF EXISTS `bids`;
CREATE TABLE `bids` (
  `id` bigint NOT NULL,
  `price` varchar(255) DEFAULT NULL,
  `date` varchar(255) DEFAULT NULL,
  `time` varchar(255) DEFAULT NULL,
  shipment_id bigint,
  carrier_id bigint,
  CONSTRAINT SHIPMENT_BID_FK FOREIGN KEY (shipment_id) REFERENCES shipments(id),
  CONSTRAINT CARRIER_BID_FK FOREIGN KEY (carrier_id) REFERENCES carriers(id),
  PRIMARY KEY (`id`)
);

--
-- Dumping data for table 'carriers'
--

LOCK TABLES `carriers` WRITE;
INSERT INTO `carriers` VALUES
(1, 'THANGIAH SHIPPING', 'GZBO', 'Yes', 'Yes', '24', '40000'),
(2, 'WONKA SHIPPING', 'COCO', 'Yes', 'Yes', '24', '40000'),
(3, 'WE SHIP 4 U', 'SH1P', 'Yes', 'Yes', '24', '40000');
UNLOCK TABLES;

--
-- Dumping data for table `contacts`
--

LOCK TABLES `contacts` WRITE;
INSERT INTO `contacts` VALUES 
(1,'kittanning','imbwwe@yahoo.com','Ian','Black','M','7248411924','PA','143 roundtop drive','','NA','16201',1),
(2,'Ford City','BobBuilder@yahoo.com','Bob','Builder','B','7248889900','PA','153 building drive','','N/A','16226',1),
(3,'Kittanning','CocoFactory@yahoo.com','Willy','Wonka','C','7571234567','PA','chocolate','','N/A','15252',1),
(4,'Butler','john@yahoo.com','John','Driver','B','5555555555','PA','724 HereILive','','N/A','345345',2),
(5,'West Kittanning','Phil@yahoo.com','Phil','Drove','C','1234567890','PA','444 drove road','','N/A','16201',2),
(6,'Latrobe','Rob@yahoo.com','Rob','Wheeler','M','9990009898','PA','678 peachtree','','N/A','12376',2),
(7,'Ford City','Rich@yahoo.com','Rich','White','','1114446677','PA','555 Thisway','','','234234',3),
(8,'Butler','Ronnie@yahoo.com','Ronnie','Brown','C','724-545-7676','PA','909 whitemoon road','','','13456',3),
(9,'Ford City','WandaTech@yahoo.com','Wanda','Dots','C','7248597676','PA','153 Window Road','','','16226',3),
(10,'Slippery Rock','sam.thangiah@sru.edu','Sam','Thangiah','','1234567890','PA','1 Morrow Way','Gazebo','','16057',1);
UNLOCK TABLES;

--
-- Dumping data for table `locations`
--

LOCK TABLES `locations` WRITE;
INSERT INTO `locations` VALUES 
(1,'Butler','','Workshop','','Factory','PA','111 Chocolate street','','12121',2),
(2,'Kittanning','','Office','','Ians House','Pennsylvania','143 roundtop drive','','16201',1),
(3,'Pittsburgh ','','warehouse','','LogHouse','PA','654 tree lane','','12345',3);
UNLOCK TABLES;

--
-- Dumping data for table `vehicle_types`
--

LOCK TABLES `vehicle_types` WRITE;
INSERT INTO `vehicle_types` VALUES 
(1,'3000','',10000,80,85,'FreightLiner',0,400,80000,0,20000,'FL-384DK','N/A','Open','Tanker'),
(2,'','',7000,90,95,'Mack',0,400,40000,0,20000,'M-DJ48DC','','Closed','Flatbed'),
(3,'','',0,70,80,'FreightLiner',0,200,30000,0,10000,'FL-20134','No Dirt Roads','Open','Flatbed'),
(4,'','',225,20,25,'Ford',0,500,1500,0,500,'F150','N/A','Super','Truck'),
(5,'','',100,10,13,'Ford',0,700,400,0,100,'Focus','','4 door','Car'),
(6,'','',10000,87,90,'Mack',0,300,65000,0,20000,'M-DD44DC','N/A','Closed','Tanker');
UNLOCK TABLES;

--
-- Dumping data for table `vehicles`
--

LOCK TABLES `vehicles` WRITE;
INSERT INTO `vehicles` VALUES 
(1,'1980','DEC-DEC1','4B7DH3LDJNEE945D',1,2,3),
(2,'1995','APR-APR1','9F2AA2LDJMYT11R',3,3,4),
(3,'2010','JAN-JAN1','8O9DH3LAVBNN343T',2,1,1),
(4,'2014','MAR-MAR2','1O1DH3LMWTRE675T',1,2,5);
UNLOCK TABLES;

--
-- Dumping data for table `driver`
--

LOCK TABLES `driver` WRITE;
INSERT INTO `driver` VALUES 
(1,'A','2022-11-16','384-374',10,1,1),
(2,'B','2022-02-08','434-555',6,2,2),
(3,'A','2022-02-26','454-090',9,3,3);
UNLOCK TABLES;

--
-- Dumping data for table `technicians`
--

LOCK TABLES `technicians` WRITE;
INSERT INTO `technicians` VALUES 
(1,'A',3),
(2,'B',5);
UNLOCK TABLES;

--
-- Dumping data for table `maintenance_orders`
--

LOCK TABLES `maintenance_orders` WRITE;
INSERT INTO `maintenance_orders` VALUES 
(1,'$5000.45','Brake Replacement','Brakes','2022-02-26','Repair','Pending',2,2,1),
(2,'$50.00','Oil Change','Oil','2022-02-23','Maintenance','Completed ',1,3,1);
UNLOCK TABLES;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
INSERT INTO role VALUES (1,'ADMIN'),(2,'SHIPPER'),(3,'CARRIER'),(4,'MASTERLIST');
UNLOCK TABLES;


--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
INSERT INTO `user` VALUES (1,'AdminTry@yahoo.com','$2a$10$1czLv.unEEJZMLTIS2sTxe6DL7CuopPOcCCEGmKwak3H4KFfUBVOm','AdminTry',1,NULL);
INSERT INTO `user` VALUES (2,'shipper@gmail.com','$2a$10$j4JWTe7EP6vPiptRf1WP1ujvRRNVPzvuQXkO7KH9Ot.YBY0znyKam','Shipper',2,NULL);
INSERT INTO `user` VALUES (3,'carrier@gmail.com','$2a$10$EVBsfb2HGqaMlI9z443kR.zM.Tn66fT.7nbvsVhDeqAw.fc4HyXOG','Carrier',3,1);
INSERT INTO `user` VALUES (4,'master@gmail.com','$2a$10$kijCY6WxZXMfsJ4NcW3SkOqeB6BDiXyR3Pmk7UExr1rJAjVmECF7i','Master',4,NULL);
INSERT INTO `user` VALUES (5,'wonka@gmail.com','$2a$10$xcIr8bwuPpCA5/dRvIOmMuVpmFZ.i18oFA5qnaQ8eiNgVKp/L.T9K','WillyWonka',3,2);
INSERT INTO `user` VALUES (6,'ship4u@gmail.com','$2a$10$0mjUJWe24cNS.XoMLb/Ybur3EK0ps.787omMxs4y3DbGB2y6StgNC','Ship4U',3,3);

UNLOCK TABLES;


--
-- Dumping data for the `shipments`
--
LOCK TABLES `shipments` WRITE;
INSERT INTO `shipments` VALUES
(1,'STBLLC',NULL,NULL,2,'FTL','2022-04-17','','','SHIPMENT AVAILABLE','15','52','1000','AVON','OH','44011','41.4517093','-82.0354225','Inwood','WV','25428','39.3578781','-78.0399994'),
(2,'STBLLC',NULL,NULL,2,'LTL','2022-12-25','','','SHIPMENT AVAILABLE','15','52','1000','PHOENIX','AZ','85043','33.4304026000','33.4304026000','CHEYENNE','WY','82007','41.0791985','-104.7987710'),
(3,'STBLLC',1,1,2,'FTL','2022-07-26','3587239','$50.00','BID ACCEPTED','15','52','1000','OKLAHOMA CITY','OK', '73131','35.5638694','-97.4705935','LANDER','WY','82520','42.8330140','-108.7306725');
UNLOCK TABLES;


--
-- Dumping data for the `bids`
--
LOCK TABLES `bids` WRITE;
INSERT INTO `bids` VALUES (1,'$50.00','2022-04-20','11:03:58',3,1);
INSERT INTO `bids` VALUES (2,'$150.00','2022-04-20','11:52:58',2,1);
INSERT INTO `bids` VALUES (3,'$700.00','2022-04-20','12:23:58',1,1);
UNLOCK TABLES;


