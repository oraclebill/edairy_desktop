-- MySQL dump 10.13  Distrib 5.1.41, for apple-darwin10.2.0 (i386)
--
-- Host: localhost    Database: dairy
-- ------------------------------------------------------
-- Server version	5.1.41

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `animalhealthrequest`
--

LOCK TABLES `animalhealthrequest` WRITE;
/*!40000 ALTER TABLE `animalhealthrequest` DISABLE KEYS */;
/*!40000 ALTER TABLE `animalhealthrequest` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `animalidentifier`
--

LOCK TABLES `animalidentifier` WRITE;
/*!40000 ALTER TABLE `animalidentifier` DISABLE KEYS */;
/*!40000 ALTER TABLE `animalidentifier` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `balancepoint`
--

LOCK TABLES `balancepoint` WRITE;
/*!40000 ALTER TABLE `balancepoint` DISABLE KEYS */;
/*!40000 ALTER TABLE `balancepoint` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `collectiongroup`
--

LOCK TABLES `collectiongroup` WRITE;
/*!40000 ALTER TABLE `collectiongroup` DISABLE KEYS */;
/*!40000 ALTER TABLE `collectiongroup` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `collectionjournalline`
--

LOCK TABLES `collectionjournalline` WRITE;
/*!40000 ALTER TABLE `collectionjournalline` DISABLE KEYS */;
/*!40000 ALTER TABLE `collectionjournalline` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `collectionsession`
--

LOCK TABLES `collectionsession` WRITE;
/*!40000 ALTER TABLE `collectionsession` DISABLE KEYS */;
INSERT INTO `collectionsession` VALUES (1,'CollectionSession',0,'AM',NULL,'1970-01-01 09:00:00','2010-10-26 20:57:04'),(2,'CollectionSession',0,'PM',NULL,'1970-01-01 09:00:00','2010-10-26 20:57:11'),(3,'CollectionSession',0,'DEFAULT',NULL,'1970-01-01 09:00:00','2010-10-26 20:57:28');
/*!40000 ALTER TABLE `collectionsession` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `contactmethod`
--

LOCK TABLES `contactmethod` WRITE;
/*!40000 ALTER TABLE `contactmethod` DISABLE KEYS */;
/*!40000 ALTER TABLE `contactmethod` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `container`
--

LOCK TABLES `container` WRITE;
/*!40000 ALTER TABLE `container` DISABLE KEYS */;
/*!40000 ALTER TABLE `container` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `dairy`
--

LOCK TABLES `dairy` WRITE;
/*!40000 ALTER TABLE `dairy` DISABLE KEYS */;
INSERT INTO `dairy` VALUES (1,'Dairy',6,'n/a','n/a',1,'+254 111 1111','n/a	',NULL,'n/a',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2010-10-26 20:58:14');
/*!40000 ALTER TABLE `dairy` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `dairylocation`
--

LOCK TABLES `dairylocation` WRITE;
/*!40000 ALTER TABLE `dairylocation` DISABLE KEYS */;
/*!40000 ALTER TABLE `dairylocation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `dairylocation_functions`
--

LOCK TABLES `dairylocation_functions` WRITE;
/*!40000 ALTER TABLE `dairylocation_functions` DISABLE KEYS */;
/*!40000 ALTER TABLE `dairylocation_functions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `deliveryjournal`
--

LOCK TABLES `deliveryjournal` WRITE;
/*!40000 ALTER TABLE `deliveryjournal` DISABLE KEYS */;
/*!40000 ALTER TABLE `deliveryjournal` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `deliveryjournalline`
--

LOCK TABLES `deliveryjournalline` WRITE;
/*!40000 ALTER TABLE `deliveryjournalline` DISABLE KEYS */;
/*!40000 ALTER TABLE `deliveryjournalline` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `farm`
--

LOCK TABLES `farm` WRITE;
/*!40000 ALTER TABLE `farm` DISABLE KEYS */;
/*!40000 ALTER TABLE `farm` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `imageentry`
--

LOCK TABLES `imageentry` WRITE;
/*!40000 ALTER TABLE `imageentry` DISABLE KEYS */;
/*!40000 ALTER TABLE `imageentry` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `location`
--

LOCK TABLES `location` WRITE;
/*!40000 ALTER TABLE `location` DISABLE KEYS */;
INSERT INTO `location` VALUES (1,'Location',4,'n/a','n/a',NULL,'n/a',NULL,NULL,NULL,NULL,'','n/a',0,0,NULL,'','','2010-10-26 20:56:30'),(2,'Location',0,'n/a','n/a',NULL,'n/a',NULL,NULL,NULL,NULL,'','n/a',0,0,NULL,'','','2010-10-26 20:58:14');
/*!40000 ALTER TABLE `location` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `memberpayment`
--

LOCK TABLES `memberpayment` WRITE;
/*!40000 ALTER TABLE `memberpayment` DISABLE KEYS */;
/*!40000 ALTER TABLE `memberpayment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `membership`
--

LOCK TABLES `membership` WRITE;
/*!40000 ALTER TABLE `membership` DISABLE KEYS */;
/*!40000 ALTER TABLE `membership` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `permission`
--

LOCK TABLES `permission` WRITE;
/*!40000 ALTER TABLE `permission` DISABLE KEYS */;
/*!40000 ALTER TABLE `permission` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `permissionnamespace`
--

LOCK TABLES `permissionnamespace` WRITE;
/*!40000 ALTER TABLE `permissionnamespace` DISABLE KEYS */;
/*!40000 ALTER TABLE `permissionnamespace` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `person`
--

LOCK TABLES `person` WRITE;
/*!40000 ALTER TABLE `person` DISABLE KEYS */;
INSERT INTO `person` VALUES (1,'Employee',2,NULL,NULL,'ADMIN','ADMIN',NULL,NULL,NULL,NULL,'254 ',2,NULL,NULL,NULL,'ADMIN',NULL,NULL,NULL,NULL,'admin','admin','',1,'\0',NULL,NULL,NULL,1,NULL,NULL,NULL,NULL,'2010-10-26 21:02:20');
/*!40000 ALTER TABLE `person` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `preference`
--

LOCK TABLES `preference` WRITE;
/*!40000 ALTER TABLE `preference` DISABLE KEYS */;
/*!40000 ALTER TABLE `preference` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `preferencekey`
--

LOCK TABLES `preferencekey` WRITE;
/*!40000 ALTER TABLE `preferencekey` DISABLE KEYS */;
/*!40000 ALTER TABLE `preferencekey` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `referenceanimaltype`
--

LOCK TABLES `referenceanimaltype` WRITE;
/*!40000 ALTER TABLE `referenceanimaltype` DISABLE KEYS */;
/*!40000 ALTER TABLE `referenceanimaltype` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `registeredanimal`
--

LOCK TABLES `registeredanimal` WRITE;
/*!40000 ALTER TABLE `registeredanimal` DISABLE KEYS */;
/*!40000 ALTER TABLE `registeredanimal` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `registeredanimal_pastowners`
--

LOCK TABLES `registeredanimal_pastowners` WRITE;
/*!40000 ALTER TABLE `registeredanimal_pastowners` DISABLE KEYS */;
/*!40000 ALTER TABLE `registeredanimal_pastowners` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'Role',0,'ADMIN',NULL,'2010-10-26 21:01:53');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `role_permissions`
--

LOCK TABLES `role_permissions` WRITE;
/*!40000 ALTER TABLE `role_permissions` DISABLE KEYS */;
INSERT INTO `role_permissions` VALUES (1,'VIEW_MILK_COLLECTIONS',0,'2010-10-26 21:01:53'),(1,'VIEW_MILK_DELIVERIES',1,'2010-10-26 21:01:53'),(1,'EDIT_DRIVER_TOTAL',2,'2010-10-26 21:01:53'),(1,'VIEW_MEMBER_LIST',3,'2010-10-26 21:01:53'),(1,'ADD_MEMBER',4,'2010-10-26 21:01:53'),(1,'DELETE_MEMBER',5,'2010-10-26 21:01:53'),(1,'VIEW_MEMBER',6,'2010-10-26 21:01:53'),(1,'EDIT_MEMBER',7,'2010-10-26 21:01:53'),(1,'VIEW_FARMS',8,'2010-10-26 21:01:53'),(1,'VIEW_LIVESTOCK',9,'2010-10-26 21:01:53'),(1,'VIEW_CONTAINERS',10,'2010-10-26 21:01:53'),(1,'VIEW_TRANSACTIONS',11,'2010-10-26 21:01:53'),(1,'VIEW_MILK_PRICES',12,'2010-10-26 21:01:53'),(1,'VIEW_ANIMAL_HEALTH_REQUESTS',13,'2010-10-26 21:01:53'),(1,'VIEW_DAIRY_PROFILE',14,'2010-10-26 21:01:53'),(1,'VIEW_EMPLOYEES',15,'2010-10-26 21:01:53'),(1,'VIEW_VEHICLES',16,'2010-10-26 21:01:53'),(1,'VIEW_DAIRY_BINS',17,'2010-10-26 21:01:53'),(1,'VIEW_DAIRY_LOCATIONS',18,'2010-10-26 21:01:53'),(1,'VIEW_ROUTES',19,'2010-10-26 21:01:53'),(1,'VIEW_EVENTS',20,'2010-10-26 21:01:53'),(1,'VIEW_CUSTOMERS',21,'2010-10-26 21:01:53'),(1,'VIEW_SUPPLIERS',22,'2010-10-26 21:01:53'),(1,'VIEW_ROLES',23,'2010-10-26 21:01:53'),(1,'EDIT_ROLE',24,'2010-10-26 21:01:53'),(1,'ADD_ROLE',25,'2010-10-26 21:01:53'),(1,'DELETE_ROLE',26,'2010-10-26 21:01:53');
/*!40000 ALTER TABLE `role_permissions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `route`
--

LOCK TABLES `route` WRITE;
/*!40000 ALTER TABLE `route` DISABLE KEYS */;
/*!40000 ALTER TABLE `route` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `route_stops`
--

LOCK TABLES `route_stops` WRITE;
/*!40000 ALTER TABLE `route_stops` DISABLE KEYS */;
/*!40000 ALTER TABLE `route_stops` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `supplier`
--

LOCK TABLES `supplier` WRITE;
/*!40000 ALTER TABLE `supplier` DISABLE KEYS */;
/*!40000 ALTER TABLE `supplier` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `supplier_categories`
--

LOCK TABLES `supplier_categories` WRITE;
/*!40000 ALTER TABLE `supplier_categories` DISABLE KEYS */;
/*!40000 ALTER TABLE `supplier_categories` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `transaction`
--

LOCK TABLES `transaction` WRITE;
/*!40000 ALTER TABLE `transaction` DISABLE KEYS */;
/*!40000 ALTER TABLE `transaction` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `trip`
--

LOCK TABLES `trip` WRITE;
/*!40000 ALTER TABLE `trip` DISABLE KEYS */;
/*!40000 ALTER TABLE `trip` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `trip_collections`
--

LOCK TABLES `trip_collections` WRITE;
/*!40000 ALTER TABLE `trip_collections` DISABLE KEYS */;
/*!40000 ALTER TABLE `trip_collections` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `trip_deliveries`
--

LOCK TABLES `trip_deliveries` WRITE;
/*!40000 ALTER TABLE `trip_deliveries` DISABLE KEYS */;
/*!40000 ALTER TABLE `trip_deliveries` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `vehicle`
--

LOCK TABLES `vehicle` WRITE;
/*!40000 ALTER TABLE `vehicle` DISABLE KEYS */;
/*!40000 ALTER TABLE `vehicle` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2010-10-26 17:03:05
