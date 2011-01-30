-- MySQL dump 10.13  Distrib 5.1.41, for apple-darwin10.2.0 (i386)
--
-- Host: localhost    Database: dairymgr
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
-- Table structure for table `account`
--

DROP TABLE IF EXISTS `account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `account` (
  `accountid` bigint(20) NOT NULL AUTO_INCREMENT,
  `dtype` varchar(255) NOT NULL,
  `e_version` int(11) NOT NULL,
  `accountnumber` varchar(60) NOT NULL,
  `established` datetime DEFAULT NULL,
  `status` varchar(255) NOT NULL,
  `type` varchar(60) DEFAULT NULL,
  `tstamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`accountid`),
  UNIQUE KEY `accountnumber` (`accountnumber`),
  KEY `accountdtype` (`dtype`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `animalhealthrequest`
--

DROP TABLE IF EXISTS `animalhealthrequest`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `animalhealthrequest` (
  `requestid` bigint(20) NOT NULL AUTO_INCREMENT,
  `dtype` varchar(255) NOT NULL,
  `e_version` int(11) NOT NULL,
  `membership_requestingmember_memberid` bigint(20) NOT NULL,
  `animalhealthrequest_dairy_companyid` bigint(20) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `reportedproblem` varchar(60) DEFAULT NULL,
  `registeredanimal_reportedanimal_registrationid` bigint(20) DEFAULT NULL,
  `dateheatdetected` datetime DEFAULT NULL,
  `firsttreatment` datetime DEFAULT NULL,
  `secondtreatment` datetime DEFAULT NULL,
  `thirdtreatment` datetime DEFAULT NULL,
  `farm_farm_farmid` bigint(20) NOT NULL,
  `supplier_referredto_companyid` bigint(20) DEFAULT NULL,
  `tstamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`requestid`),
  KEY `animalhealthrequestdtype` (`dtype`),
  KEY `FKE679DC37E86E5701` (`registeredanimal_reportedanimal_registrationid`),
  KEY `FKE679DC372148C6B4` (`membership_requestingmember_memberid`),
  KEY `FKE679DC3763342DC7` (`farm_farm_farmid`),
  KEY `FKE679DC377F899E97` (`animalhealthrequest_dairy_companyid`),
  KEY `FKE679DC37A90F4AA4` (`supplier_referredto_companyid`),
  CONSTRAINT `FKE679DC372148C6B4` FOREIGN KEY (`membership_requestingmember_memberid`) REFERENCES `membership` (`memberid`),
  CONSTRAINT `FKE679DC3763342DC7` FOREIGN KEY (`farm_farm_farmid`) REFERENCES `farm` (`farmid`),
  CONSTRAINT `FKE679DC377F899E97` FOREIGN KEY (`animalhealthrequest_dairy_companyid`) REFERENCES `dairy` (`dairyid`),
  CONSTRAINT `FKE679DC37A90F4AA4` FOREIGN KEY (`supplier_referredto_companyid`) REFERENCES `supplier` (`supplierid`),
  CONSTRAINT `FKE679DC37E86E5701` FOREIGN KEY (`registeredanimal_reportedanimal_registrationid`) REFERENCES `registeredanimal` (`registrationid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `animalidentifier`
--

DROP TABLE IF EXISTS `animalidentifier`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `animalidentifier` (
  `e_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `dtype` varchar(255) NOT NULL,
  `e_version` int(11) NOT NULL,
  `issuer` varchar(60) DEFAULT NULL,
  `value` varchar(60) DEFAULT NULL,
  `registeredanimal_identifiers_registrationid` bigint(20) DEFAULT NULL,
  `tstamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`e_id`),
  KEY `animalidentifierdtype` (`dtype`),
  KEY `FKA0A1EFA597FE78A8` (`registeredanimal_identifiers_registrationid`),
  CONSTRAINT `FKA0A1EFA597FE78A8` FOREIGN KEY (`registeredanimal_identifiers_registrationid`) REFERENCES `registeredanimal` (`registrationid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `balancepoint`
--

DROP TABLE IF EXISTS `balancepoint`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `balancepoint` (
  `accountbalanceid` bigint(20) NOT NULL AUTO_INCREMENT,
  `dtype` varchar(255) NOT NULL,
  `e_version` int(11) NOT NULL,
  `balancepoint_account_accountid` bigint(20) DEFAULT NULL,
  `asof` datetime DEFAULT NULL,
  `amount` decimal(19,2) DEFAULT NULL,
  `tstamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`accountbalanceid`),
  KEY `balancepointdtype` (`dtype`),
  KEY `FK6414D034C948E738` (`balancepoint_account_accountid`),
  CONSTRAINT `FK6414D034C948E738` FOREIGN KEY (`balancepoint_account_accountid`) REFERENCES `account` (`accountid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `collectiongroup`
--

DROP TABLE IF EXISTS `collectiongroup`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `collectiongroup` (
  `journalid` bigint(20) NOT NULL AUTO_INCREMENT,
  `dtype` varchar(255) NOT NULL,
  `e_version` int(11) NOT NULL,
  `referencenumber` varchar(60) NOT NULL,
  `journaldate` datetime NOT NULL,
  `status` varchar(255) NOT NULL,
  `employee_driver_personid` bigint(20) NOT NULL,
  `vehicle_vehicle_vehicleid` bigint(20) DEFAULT NULL,
  `drivertotal` decimal(19,2) DEFAULT NULL,
  `recordtotal` decimal(19,2) DEFAULT NULL,
  `suspended` bit(1) DEFAULT NULL,
  `entrycount` int(11) DEFAULT NULL,
  `suspendedcount` int(11) DEFAULT NULL,
  `rejectedcount` int(11) DEFAULT NULL,
  `journalnumber` varchar(60) DEFAULT NULL,
  `collectionsession_session_e_id` bigint(20) DEFAULT NULL,
  `dairylocation_collectioncenter_id` bigint(20) DEFAULT NULL,
  `type` varchar(255) NOT NULL,
  `dairy_collectionjournals_companyid` bigint(20) DEFAULT NULL,
  `tstamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`journalid`),
  KEY `collectiongroupdtype` (`dtype`),
  KEY `FK3FA5BAA1E901D8A4` (`employee_driver_personid`),
  KEY `FK3FA5BAA1C0E2B0B8` (`dairylocation_collectioncenter_id`),
  KEY `FK3FA5BAA18E0EB0AD` (`vehicle_vehicle_vehicleid`),
  KEY `FK3FA5BAA1527171B2` (`dairy_collectionjournals_companyid`),
  KEY `FK3FA5BAA166A3DBDD` (`collectionsession_session_e_id`),
  CONSTRAINT `FK3FA5BAA1527171B2` FOREIGN KEY (`dairy_collectionjournals_companyid`) REFERENCES `dairy` (`dairyid`),
  CONSTRAINT `FK3FA5BAA166A3DBDD` FOREIGN KEY (`collectionsession_session_e_id`) REFERENCES `collectionsession` (`id`),
  CONSTRAINT `FK3FA5BAA18E0EB0AD` FOREIGN KEY (`vehicle_vehicle_vehicleid`) REFERENCES `vehicle` (`vehicleid`),
  CONSTRAINT `FK3FA5BAA1C0E2B0B8` FOREIGN KEY (`dairylocation_collectioncenter_id`) REFERENCES `dairylocation` (`id`),
  CONSTRAINT `FK3FA5BAA1E901D8A4` FOREIGN KEY (`employee_driver_personid`) REFERENCES `person` (`personid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `collectionjournalline`
--

DROP TABLE IF EXISTS `collectionjournalline`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `collectionjournalline` (
  `e_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `dtype` varchar(255) NOT NULL,
  `e_version` int(11) NOT NULL,
  `linenumber` int(11) DEFAULT NULL,
  `recordedmember` varchar(60) NOT NULL,
  `quantity` decimal(19,2) NOT NULL,
  `flagged` bit(1) DEFAULT NULL,
  `unitofmeasure` varchar(255) NOT NULL,
  `notrecorded` bit(1) DEFAULT NULL,
  `membership_validatedmember_e_id` bigint(20) DEFAULT NULL,
  `offroute` bit(1) DEFAULT NULL,
  `farm_from_farmid` bigint(20) DEFAULT NULL,
  `container_farmcontainer_containerid` bigint(20) DEFAULT NULL,
  `dairycontainer_dairycontainer_containerid` bigint(20) DEFAULT NULL,
  `collectionjournalline_collectionjournal_e_id` bigint(20) DEFAULT NULL,
  `rejected` bit(1) DEFAULT NULL,
  `rejectionreason` varchar(60) DEFAULT NULL,
  `milkfatpercentage` decimal(19,2) DEFAULT NULL,
  `alcoholpercentage` decimal(19,2) DEFAULT NULL,
  `wateradded` bit(1) DEFAULT NULL,
  `scaleserial` varchar(60) DEFAULT NULL,
  `collectiontime` datetime DEFAULT NULL,
  `centernumber` varchar(60) DEFAULT NULL,
  `numcans` varchar(60) DEFAULT NULL,
  `tripnumber` varchar(60) DEFAULT NULL,
  `operatorcode` varchar(60) DEFAULT NULL,
  `validated` bit(1) DEFAULT NULL,
  `tstamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`e_id`),
  KEY `collectionjournallinedtype` (`dtype`),
  KEY `FK21648E4DBDCBB64B` (`container_farmcontainer_containerid`),
  KEY `FK21648E4DCD250D6E` (`collectionjournalline_collectionjournal_e_id`),
  KEY `FK21648E4D40348C8A` (`dairycontainer_dairycontainer_containerid`),
  KEY `FK21648E4DDF4763D3` (`farm_from_farmid`),
  KEY `FK21648E4DE57433AB` (`membership_validatedmember_e_id`),
  CONSTRAINT `FK21648E4D40348C8A` FOREIGN KEY (`dairycontainer_dairycontainer_containerid`) REFERENCES `container` (`containerid`),
  CONSTRAINT `FK21648E4DBDCBB64B` FOREIGN KEY (`container_farmcontainer_containerid`) REFERENCES `container` (`containerid`),
  CONSTRAINT `FK21648E4DCD250D6E` FOREIGN KEY (`collectionjournalline_collectionjournal_e_id`) REFERENCES `collectiongroup` (`journalid`),
  CONSTRAINT `FK21648E4DDF4763D3` FOREIGN KEY (`farm_from_farmid`) REFERENCES `farm` (`farmid`),
  CONSTRAINT `FK21648E4DE57433AB` FOREIGN KEY (`membership_validatedmember_e_id`) REFERENCES `membership` (`memberid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `collectionsession`
--

DROP TABLE IF EXISTS `collectionsession`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `collectionsession` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `dtype` varchar(255) NOT NULL,
  `e_version` int(11) NOT NULL,
  `code` varchar(60) DEFAULT NULL,
  `description` varchar(60) DEFAULT NULL,
  `timeofday` datetime DEFAULT NULL,
  `tstamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `code` (`code`),
  KEY `collectionsessiondtype` (`dtype`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `contactmethod`
--

DROP TABLE IF EXISTS `contactmethod`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `contactmethod` (
  `e_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `dtype` varchar(255) NOT NULL,
  `e_version` int(11) NOT NULL,
  `cmtype` varchar(255) DEFAULT NULL,
  `cmvalue` varchar(60) DEFAULT NULL,
  `person_contactmethods_e_id` bigint(20) DEFAULT NULL,
  `dairy_contactmethods_e_id` bigint(20) DEFAULT NULL,
  `supplier_contactmethods_e_id` bigint(20) DEFAULT NULL,
  `customer_contactmethods_e_id` bigint(20) DEFAULT NULL,
  `tstamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`e_id`),
  KEY `contactmethoddtype` (`dtype`),
  KEY `FK50595D014FD5EF4D` (`person_contactmethods_e_id`),
  KEY `FK50595D0140C891DF` (`customer_contactmethods_e_id`),
  KEY `FK50595D01937B42BB` (`supplier_contactmethods_e_id`),
  KEY `FK50595D01EE4DEF09` (`dairy_contactmethods_e_id`),
  CONSTRAINT `FK50595D0140C891DF` FOREIGN KEY (`customer_contactmethods_e_id`) REFERENCES `customer` (`customerid`),
  CONSTRAINT `FK50595D014FD5EF4D` FOREIGN KEY (`person_contactmethods_e_id`) REFERENCES `person` (`personid`),
  CONSTRAINT `FK50595D01937B42BB` FOREIGN KEY (`supplier_contactmethods_e_id`) REFERENCES `supplier` (`supplierid`),
  CONSTRAINT `FK50595D01EE4DEF09` FOREIGN KEY (`dairy_contactmethods_e_id`) REFERENCES `dairy` (`dairyid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `container`
--

DROP TABLE IF EXISTS `container`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `container` (
  `containerid` bigint(20) NOT NULL AUTO_INCREMENT,
  `dtype` varchar(255) NOT NULL,
  `e_version` int(11) NOT NULL,
  `trackingnumber` varchar(60) NOT NULL,
  `farm_owner_farmid` bigint(20) DEFAULT NULL,
  `capacity` double NOT NULL,
  `measuretype` varchar(255) DEFAULT NULL,
  `status` varchar(60) DEFAULT NULL,
  `route_zone_id` bigint(20) DEFAULT NULL,
  `tagtype` varchar(60) DEFAULT NULL,
  `tagvalue` varchar(60) DEFAULT NULL,
  `dateacquired` datetime DEFAULT NULL,
  `damagedate` datetime DEFAULT NULL,
  `damagedescription` varchar(60) DEFAULT NULL,
  `datedisposed` datetime DEFAULT NULL,
  `disposalreason` varchar(60) DEFAULT NULL,
  `disposalwitness` varchar(60) DEFAULT NULL,
  `farm_cans_farmid` bigint(20) DEFAULT NULL,
  `dairy_dairybins_companyid` bigint(20) DEFAULT NULL,
  `tstamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`containerid`),
  UNIQUE KEY `trackingnumber` (`trackingnumber`),
  KEY `containerdtype` (`dtype`),
  KEY `FKE7814C81C2BB66BA` (`farm_cans_farmid`),
  KEY `FKE7814C81E80D409C` (`farm_owner_farmid`),
  KEY `FKE7814C8153D360C1` (`route_zone_id`),
  KEY `FKE7814C8148CF2FF` (`dairy_dairybins_companyid`),
  CONSTRAINT `FKE7814C8148CF2FF` FOREIGN KEY (`dairy_dairybins_companyid`) REFERENCES `dairy` (`dairyid`),
  CONSTRAINT `FKE7814C8153D360C1` FOREIGN KEY (`route_zone_id`) REFERENCES `route` (`id`),
  CONSTRAINT `FKE7814C81C2BB66BA` FOREIGN KEY (`farm_cans_farmid`) REFERENCES `farm` (`farmid`),
  CONSTRAINT `FKE7814C81E80D409C` FOREIGN KEY (`farm_owner_farmid`) REFERENCES `farm` (`farmid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customer` (
  `customerid` bigint(20) NOT NULL AUTO_INCREMENT,
  `dtype` varchar(255) NOT NULL,
  `e_version` int(11) NOT NULL,
  `legalname` varchar(60) DEFAULT NULL,
  `customername` varchar(60) NOT NULL,
  `location_location_e_id` bigint(20) NOT NULL,
  `phonenumber` varchar(60) NOT NULL,
  `description` varchar(60) DEFAULT NULL,
  `profilephoto` varchar(60) DEFAULT NULL,
  `id` varchar(60) NOT NULL,
  `customertype` varchar(60) DEFAULT NULL,
  `status` varchar(60) DEFAULT NULL,
  `dairy_customers_companyid` bigint(20) DEFAULT NULL,
  `tstamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`customerid`),
  KEY `customerdtype` (`dtype`),
  KEY `FK24217FDE258A524A` (`location_location_e_id`),
  KEY `FK24217FDE12BEA235` (`dairy_customers_companyid`),
  CONSTRAINT `FK24217FDE12BEA235` FOREIGN KEY (`dairy_customers_companyid`) REFERENCES `dairy` (`dairyid`),
  CONSTRAINT `FK24217FDE258A524A` FOREIGN KEY (`location_location_e_id`) REFERENCES `location` (`locationid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `dairy`
--

DROP TABLE IF EXISTS `dairy`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dairy` (
  `dairyid` bigint(20) NOT NULL AUTO_INCREMENT,
  `dtype` varchar(255) NOT NULL,
  `version` bigint(20) NOT NULL,
  `legalname` varchar(60) DEFAULT NULL,
  `dairyname` varchar(60) NOT NULL,
  `location_location_e_id` bigint(20) NOT NULL,
  `phonenumber` varchar(60) NOT NULL,
  `description` varchar(60) DEFAULT NULL,
  `profilephoto` varchar(60) DEFAULT NULL,
  `registrationnumber` varchar(60) NOT NULL,
  `establisheddate` datetime DEFAULT NULL,
  `managername` varchar(60) DEFAULT NULL,
  `nssfnumber` varchar(60) DEFAULT NULL,
  `nhifnumber` varchar(60) DEFAULT NULL,
  `federalpin` varchar(60) DEFAULT NULL,
  `licenseeffectivedate` datetime DEFAULT NULL,
  `licenseexpirationdate` datetime DEFAULT NULL,
  `tstamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`dairyid`),
  KEY `dairydtype` (`dtype`),
  KEY `FK5AEDED3258A524A` (`location_location_e_id`),
  CONSTRAINT `FK5AEDED3258A524A` FOREIGN KEY (`location_location_e_id`) REFERENCES `location` (`locationid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `dairylocation`
--

DROP TABLE IF EXISTS `dairylocation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dairylocation` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `dtype` varchar(255) NOT NULL,
  `e_version` int(11) NOT NULL,
  `code` varchar(60) DEFAULT NULL,
  `name` varchar(60) NOT NULL,
  `dateopened` datetime DEFAULT NULL,
  `phone` varchar(60) DEFAULT NULL,
  `description` varchar(60) DEFAULT NULL,
  `location_location_e_id` bigint(20) NOT NULL,
  `dairycontainer_containers_containerid` bigint(20) DEFAULT NULL,
  `dairy_branchlocations_companyid` bigint(20) DEFAULT NULL,
  `tstamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `code` (`code`),
  KEY `dairylocationdtype` (`dtype`),
  KEY `FK75A7FB883F53900E` (`dairycontainer_containers_containerid`),
  KEY `FK75A7FB88258A524A` (`location_location_e_id`),
  KEY `FK75A7FB88FD6AA1C` (`dairy_branchlocations_companyid`),
  CONSTRAINT `FK75A7FB88258A524A` FOREIGN KEY (`location_location_e_id`) REFERENCES `location` (`locationid`),
  CONSTRAINT `FK75A7FB883F53900E` FOREIGN KEY (`dairycontainer_containers_containerid`) REFERENCES `container` (`containerid`),
  CONSTRAINT `FK75A7FB88FD6AA1C` FOREIGN KEY (`dairy_branchlocations_companyid`) REFERENCES `dairy` (`dairyid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `dairylocation_functions`
--

DROP TABLE IF EXISTS `dairylocation_functions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dairylocation_functions` (
  `dairylocation_functions_id` bigint(20) NOT NULL,
  `elt` varchar(255) DEFAULT NULL,
  `dairylocation_functions_idx` int(11) NOT NULL,
  `tstamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`dairylocation_functions_id`,`dairylocation_functions_idx`),
  KEY `FKC48933A4C3737B1E` (`dairylocation_functions_id`),
  CONSTRAINT `FKC48933A4C3737B1E` FOREIGN KEY (`dairylocation_functions_id`) REFERENCES `dairylocation` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `deliveryjournal`
--

DROP TABLE IF EXISTS `deliveryjournal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `deliveryjournal` (
  `e_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `dtype` varchar(255) NOT NULL,
  `e_version` int(11) NOT NULL,
  `referencenumber` varchar(60) NOT NULL,
  `date` datetime NOT NULL,
  `route_route_id` bigint(20) NOT NULL,
  `customer_customer_e_id` bigint(20) NOT NULL,
  `employee_driver_personid` bigint(20) DEFAULT NULL,
  `vehicle_vehicle_vehicleid` bigint(20) DEFAULT NULL,
  `total` decimal(19,2) NOT NULL,
  `collectionsession_session_e_id` bigint(20) DEFAULT NULL,
  `dairy_deliveryjournals_companyid` bigint(20) DEFAULT NULL,
  `tstamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`e_id`),
  KEY `deliveryjournaldtype` (`dtype`),
  KEY `FKCB09F8C3E901D8A4` (`employee_driver_personid`),
  KEY `FKCB09F8C315DAE853` (`customer_customer_e_id`),
  KEY `FKCB09F8C336E40088` (`dairy_deliveryjournals_companyid`),
  KEY `FKCB09F8C366CE7230` (`route_route_id`),
  KEY `FKCB09F8C38E0EB0AD` (`vehicle_vehicle_vehicleid`),
  KEY `FKCB09F8C366A3DBDD` (`collectionsession_session_e_id`),
  CONSTRAINT `FKCB09F8C315DAE853` FOREIGN KEY (`customer_customer_e_id`) REFERENCES `customer` (`customerid`),
  CONSTRAINT `FKCB09F8C336E40088` FOREIGN KEY (`dairy_deliveryjournals_companyid`) REFERENCES `dairy` (`dairyid`),
  CONSTRAINT `FKCB09F8C366A3DBDD` FOREIGN KEY (`collectionsession_session_e_id`) REFERENCES `collectionsession` (`id`),
  CONSTRAINT `FKCB09F8C366CE7230` FOREIGN KEY (`route_route_id`) REFERENCES `route` (`id`),
  CONSTRAINT `FKCB09F8C38E0EB0AD` FOREIGN KEY (`vehicle_vehicle_vehicleid`) REFERENCES `vehicle` (`vehicleid`),
  CONSTRAINT `FKCB09F8C3E901D8A4` FOREIGN KEY (`employee_driver_personid`) REFERENCES `person` (`personid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `farm`
--

DROP TABLE IF EXISTS `farm`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `farm` (
  `farmid` bigint(20) NOT NULL AUTO_INCREMENT,
  `dtype` varchar(255) NOT NULL,
  `e_version` int(11) NOT NULL,
  `name` varchar(60) DEFAULT NULL,
  `location_location_e_id` bigint(20) DEFAULT NULL,
  `farm_owner_e_id` bigint(20) DEFAULT NULL,
  `profilephoto` varchar(60) DEFAULT NULL,
  `tstamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`farmid`),
  KEY `farmdtype` (`dtype`),
  KEY `FK2FD836258A524A` (`location_location_e_id`),
  KEY `FK2FD836BE80D46D` (`farm_owner_e_id`),
  CONSTRAINT `FK2FD836258A524A` FOREIGN KEY (`location_location_e_id`) REFERENCES `location` (`locationid`),
  CONSTRAINT `FK2FD836BE80D46D` FOREIGN KEY (`farm_owner_e_id`) REFERENCES `person` (`personid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `imageentry`
--

DROP TABLE IF EXISTS `imageentry`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `imageentry` (
  `imageid` varchar(60) NOT NULL,
  `dtype` varchar(255) NOT NULL,
  `e_version` int(11) NOT NULL,
  `mimetype` varchar(60) NOT NULL,
  `imagedata` mediumblob,
  `tstamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`imageid`),
  KEY `imageentrydtype` (`dtype`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `location`
--

DROP TABLE IF EXISTS `location`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `location` (
  `locationid` bigint(20) NOT NULL AUTO_INCREMENT,
  `dtype` varchar(255) NOT NULL,
  `e_version` int(11) NOT NULL,
  `address` varchar(60) DEFAULT NULL,
  `section` varchar(60) DEFAULT NULL,
  `estate` varchar(60) DEFAULT NULL,
  `village` varchar(60) DEFAULT NULL,
  `sublocation` varchar(60) DEFAULT NULL,
  `location` varchar(60) DEFAULT NULL,
  `district` varchar(60) DEFAULT NULL,
  `division` varchar(60) DEFAULT NULL,
  `province` varchar(60) DEFAULT NULL,
  `postalcode` varchar(60) DEFAULT NULL,
  `longitude` double DEFAULT NULL,
  `latitude` double DEFAULT NULL,
  `landreferencenumber` varchar(60) DEFAULT NULL,
  `directions` varchar(60) DEFAULT NULL,
  `landmarks` varchar(60) DEFAULT NULL,
  `tstamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`locationid`),
  KEY `locationdtype` (`dtype`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `memberpayment`
--

DROP TABLE IF EXISTS `memberpayment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `memberpayment` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `dtype` varchar(255) NOT NULL,
  `e_version` int(11) NOT NULL,
  `year` int(11) NOT NULL,
  `month` int(11) NOT NULL,
  `paymentrate` decimal(19,2) NOT NULL,
  `paymentstotal` decimal(19,2) DEFAULT NULL,
  `paymentscount` int(11) DEFAULT NULL,
  `employee_enteredby_personid` bigint(20) NOT NULL,
  `entrydate` datetime NOT NULL,
  `dairy_pricehistory_companyid` bigint(20) DEFAULT NULL,
  `tstamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `memberpaymentdtype` (`dtype`),
  KEY `FK12BF662C6B8FE040` (`employee_enteredby_personid`),
  KEY `FK12BF662C2B7B2FE3` (`dairy_pricehistory_companyid`),
  CONSTRAINT `FK12BF662C2B7B2FE3` FOREIGN KEY (`dairy_pricehistory_companyid`) REFERENCES `dairy` (`dairyid`),
  CONSTRAINT `FK12BF662C6B8FE040` FOREIGN KEY (`employee_enteredby_personid`) REFERENCES `person` (`personid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `membership`
--

DROP TABLE IF EXISTS `membership`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `membership` (
  `memberid` bigint(20) NOT NULL AUTO_INCREMENT,
  `dtype` varchar(255) NOT NULL,
  `e_version` int(11) NOT NULL,
  `membernumber` varchar(60) NOT NULL,
  `applicationdate` datetime NOT NULL,
  `effectivedate` datetime DEFAULT NULL,
  `status` varchar(255) NOT NULL,
  `dairylocation_defaultroute_id` bigint(20) DEFAULT NULL,
  `farmer_member_personid` bigint(20) NOT NULL,
  `account` bigint(20) NOT NULL,
  `membership_dairy_companyid` bigint(20) DEFAULT NULL,
  `tstamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`memberid`),
  UNIQUE KEY `account` (`account`),
  UNIQUE KEY `membernumber` (`membernumber`),
  KEY `membershipdtype` (`dtype`),
  KEY `FKB01D87D6806384E3` (`dairylocation_defaultroute_id`),
  KEY `FKB01D87D633F82C36` (`membership_dairy_companyid`),
  KEY `FKB01D87D647A495DC` (`farmer_member_personid`),
  KEY `FKB01D87D6D6DFAC3A` (`account`),
  CONSTRAINT `FKB01D87D633F82C36` FOREIGN KEY (`membership_dairy_companyid`) REFERENCES `dairy` (`dairyid`),
  CONSTRAINT `FKB01D87D647A495DC` FOREIGN KEY (`farmer_member_personid`) REFERENCES `person` (`personid`),
  CONSTRAINT `FKB01D87D6806384E3` FOREIGN KEY (`dairylocation_defaultroute_id`) REFERENCES `dairylocation` (`id`),
  CONSTRAINT `FKB01D87D6D6DFAC3A` FOREIGN KEY (`account`) REFERENCES `account` (`accountid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `milkgrade`
--

DROP TABLE IF EXISTS `milkgrade`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `milkgrade` (
  `e_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `dtype` varchar(255) NOT NULL,
  `e_version` int(11) NOT NULL,
  `code` varchar(60) NOT NULL,
  `name` varchar(60) NOT NULL,
  `description` varchar(60) DEFAULT NULL,
  `tstamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`e_id`),
  UNIQUE KEY `code` (`code`),
  KEY `milkgradedtype` (`dtype`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `milkgradechange`
--

DROP TABLE IF EXISTS `milkgradechange`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `milkgradechange` (
  `e_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `dtype` varchar(255) NOT NULL,
  `e_version` int(11) NOT NULL,
  `date` datetime NOT NULL,
  `milkgrade_startinggrade_e_id` bigint(20) NOT NULL,
  `milkgrade_endinggrade_e_id` bigint(20) NOT NULL,
  `employee_changedby_personid` bigint(20) DEFAULT NULL,
  `reason` varchar(60) DEFAULT NULL,
  `tstamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`e_id`),
  KEY `milkgradechangedtype` (`dtype`),
  KEY `FKBD33234C1C37CBBC` (`milkgrade_startinggrade_e_id`),
  KEY `FKBD33234CCF7D18A3` (`milkgrade_endinggrade_e_id`),
  KEY `FKBD33234CB4CC82E3` (`employee_changedby_personid`),
  CONSTRAINT `FKBD33234C1C37CBBC` FOREIGN KEY (`milkgrade_startinggrade_e_id`) REFERENCES `milkgrade` (`e_id`),
  CONSTRAINT `FKBD33234CB4CC82E3` FOREIGN KEY (`employee_changedby_personid`) REFERENCES `person` (`personid`),
  CONSTRAINT `FKBD33234CCF7D18A3` FOREIGN KEY (`milkgrade_endinggrade_e_id`) REFERENCES `milkgrade` (`e_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `milksale`
--

DROP TABLE IF EXISTS `milksale`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `milksale` (
  `e_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `dtype` varchar(255) NOT NULL,
  `e_version` int(11) NOT NULL,
  `linenumber` int(11) DEFAULT NULL,
  `referencenumber` varchar(60) DEFAULT NULL,
  `saledate` datetime NOT NULL,
  `dairycontainer_bin_containerid` bigint(20) DEFAULT NULL,
  `saletype` varchar(255) NOT NULL,
  `quantity` decimal(19,2) NOT NULL,
  `price` decimal(19,2) DEFAULT NULL,
  `description` varchar(60) DEFAULT NULL,
  `rejected` bit(1) NOT NULL,
  `dairylocation_storeorroute_id` bigint(20) DEFAULT NULL,
  `customer_customer_e_id` bigint(20) DEFAULT NULL,
  `employee_soldby_personid` bigint(20) DEFAULT NULL,
  `deliveryjournal_lines_e_id` bigint(20) DEFAULT NULL,
  `tstamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`e_id`),
  KEY `milksaledtype` (`dtype`),
  KEY `FKABB35EE277DAE9F4` (`deliveryjournal_lines_e_id`),
  KEY `FKABB35EE215DAE853` (`customer_customer_e_id`),
  KEY `FKABB35EE2BBE70201` (`dairycontainer_bin_containerid`),
  KEY `FKABB35EE2B7A32801` (`employee_soldby_personid`),
  KEY `FKABB35EE24BAD0E26` (`dairylocation_storeorroute_id`),
  CONSTRAINT `FKABB35EE215DAE853` FOREIGN KEY (`customer_customer_e_id`) REFERENCES `customer` (`customerid`),
  CONSTRAINT `FKABB35EE24BAD0E26` FOREIGN KEY (`dairylocation_storeorroute_id`) REFERENCES `dairylocation` (`id`),
  CONSTRAINT `FKABB35EE277DAE9F4` FOREIGN KEY (`deliveryjournal_lines_e_id`) REFERENCES `deliveryjournal` (`e_id`),
  CONSTRAINT `FKABB35EE2B7A32801` FOREIGN KEY (`employee_soldby_personid`) REFERENCES `person` (`personid`),
  CONSTRAINT `FKABB35EE2BBE70201` FOREIGN KEY (`dairycontainer_bin_containerid`) REFERENCES `container` (`containerid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `permission`
--

DROP TABLE IF EXISTS `permission`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `permission` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `dtype` varchar(255) NOT NULL,
  `e_version` int(11) NOT NULL,
  `permissionnamespace_namespace_id` bigint(20) DEFAULT NULL,
  `name` varchar(60) DEFAULT NULL,
  `displayname` varchar(60) DEFAULT NULL,
  `tstamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `permissiondtype` (`dtype`),
  KEY `FKE125C5CF9D12BB9E` (`permissionnamespace_namespace_id`),
  CONSTRAINT `FKE125C5CF9D12BB9E` FOREIGN KEY (`permissionnamespace_namespace_id`) REFERENCES `permissionnamespace` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `permissionnamespace`
--

DROP TABLE IF EXISTS `permissionnamespace`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `permissionnamespace` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `dtype` varchar(255) NOT NULL,
  `e_version` int(11) NOT NULL,
  `name` varchar(60) DEFAULT NULL,
  `tstamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`),
  KEY `permissionnamespacedtype` (`dtype`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `person`
--

DROP TABLE IF EXISTS `person`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `person` (
  `personid` bigint(20) NOT NULL AUTO_INCREMENT,
  `dtype` varchar(255) NOT NULL,
  `e_version` int(11) NOT NULL,
  `photo` varchar(60) DEFAULT NULL,
  `honorific` varchar(60) DEFAULT NULL,
  `familyname` varchar(60) NOT NULL,
  `givenname` varchar(60) NOT NULL,
  `middlename` varchar(60) DEFAULT NULL,
  `additionalnames` varchar(60) DEFAULT NULL,
  `suffix` varchar(60) DEFAULT NULL,
  `nickname` varchar(60) DEFAULT NULL,
  `phonenumber` varchar(60) DEFAULT NULL,
  `location` bigint(20) DEFAULT NULL,
  `nssfnumber` varchar(60) DEFAULT NULL,
  `nhifnumber` varchar(60) DEFAULT NULL,
  `nationalid` varchar(60) DEFAULT NULL,
  `employeenumber` varchar(60) DEFAULT NULL,
  `operatorcode` varchar(60) DEFAULT NULL,
  `startdate` datetime DEFAULT NULL,
  `jobfunction` varchar(60) DEFAULT NULL,
  `department` varchar(60) DEFAULT NULL,
  `licenseno` varchar(60) DEFAULT NULL,
  `dairy_contacts_e_id` bigint(20) DEFAULT NULL,
  `dairy_employees_companyid` bigint(20) DEFAULT NULL,
  `supplier_contacts_e_id` bigint(20) DEFAULT NULL,
  `customer_contacts_e_id` bigint(20) DEFAULT NULL,
  `tstamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`personid`),
  UNIQUE KEY `nationalid` (`nationalid`),
  UNIQUE KEY `employeenumber` (`employeenumber`),
  KEY `persondtype` (`dtype`),
  KEY `FKC4E39B55EFE208FE` (`customer_contacts_e_id`),
  KEY `FKC4E39B5529FA1E8` (`dairy_contacts_e_id`),
  KEY `FKC4E39B55E679A38A` (`location`),
  KEY `FKC4E39B55BD57D965` (`dairy_employees_companyid`),
  KEY `FKC4E39B55530C045A` (`supplier_contacts_e_id`),
  CONSTRAINT `FKC4E39B5529FA1E8` FOREIGN KEY (`dairy_contacts_e_id`) REFERENCES `dairy` (`dairyid`),
  CONSTRAINT `FKC4E39B55530C045A` FOREIGN KEY (`supplier_contacts_e_id`) REFERENCES `supplier` (`supplierid`),
  CONSTRAINT `FKC4E39B55BD57D965` FOREIGN KEY (`dairy_employees_companyid`) REFERENCES `dairy` (`dairyid`),
  CONSTRAINT `FKC4E39B55E679A38A` FOREIGN KEY (`location`) REFERENCES `location` (`locationid`),
  CONSTRAINT `FKC4E39B55EFE208FE` FOREIGN KEY (`customer_contacts_e_id`) REFERENCES `customer` (`customerid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `preference`
--

DROP TABLE IF EXISTS `preference`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `preference` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `dtype` varchar(255) NOT NULL,
  `e_version` int(11) NOT NULL,
  `preferencekey_key_e_id` bigint(20) DEFAULT NULL,
  `value` varchar(60) DEFAULT NULL,
  `tstamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `preferencedtype` (`dtype`),
  KEY `FKA8FCBCDB4C44DAB4` (`preferencekey_key_e_id`),
  CONSTRAINT `FKA8FCBCDB4C44DAB4` FOREIGN KEY (`preferencekey_key_e_id`) REFERENCES `preferencekey` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `preferencekey`
--

DROP TABLE IF EXISTS `preferencekey`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `preferencekey` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `dtype` varchar(255) NOT NULL,
  `e_version` int(11) NOT NULL,
  `name` varchar(60) DEFAULT NULL,
  `defaultvalue` varchar(60) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `tstamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `preferencekeydtype` (`dtype`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `referenceanimaltype`
--

DROP TABLE IF EXISTS `referenceanimaltype`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `referenceanimaltype` (
  `e_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `dtype` varchar(255) NOT NULL,
  `e_version` int(11) NOT NULL,
  `species` varchar(60) DEFAULT NULL,
  `breed` varchar(60) DEFAULT NULL,
  `tstamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`e_id`),
  KEY `referenceanimaltypedtype` (`dtype`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `registeredanimal`
--

DROP TABLE IF EXISTS `registeredanimal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `registeredanimal` (
  `registrationid` bigint(20) NOT NULL AUTO_INCREMENT,
  `dtype` varchar(255) NOT NULL,
  `e_version` int(11) NOT NULL,
  `givenname` varchar(60) NOT NULL,
  `photo` varchar(60) DEFAULT NULL,
  `farm_location_farmid` bigint(20) NOT NULL,
  `gender` varchar(255) NOT NULL,
  `referenceanimaltype_animaltype_e_id` bigint(20) DEFAULT NULL,
  `referenceanimaltype_siretype_e_id` bigint(20) DEFAULT NULL,
  `purpose` varchar(255) NOT NULL,
  `dateofacquisition` datetime DEFAULT NULL,
  `acquisitiontype` varchar(255) DEFAULT NULL,
  `identifyingfeatures` varchar(60) DEFAULT NULL,
  `rearingmode` varchar(255) NOT NULL,
  `insurancenumber` varchar(60) DEFAULT NULL,
  `dateofbirth` datetime NOT NULL,
  `birthcertificatenumber` varchar(60) DEFAULT NULL,
  `veterinarycertificatenumber` varchar(60) DEFAULT NULL,
  `ministryid` varchar(60) DEFAULT NULL,
  `insurancecompany` varchar(60) DEFAULT NULL,
  `feedinghabit` varchar(60) DEFAULT NULL,
  `feedtype` varchar(60) DEFAULT NULL,
  `feedbrand` varchar(60) DEFAULT NULL,
  `supplements` varchar(60) DEFAULT NULL,
  `antibiotics` varchar(60) DEFAULT NULL,
  `veterinary` varchar(60) DEFAULT NULL,
  `awards` varchar(60) DEFAULT NULL,
  `notes` varchar(60) DEFAULT NULL,
  `farm_animals_farmid` bigint(20) DEFAULT NULL,
  `tstamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`registrationid`),
  KEY `registeredanimaldtype` (`dtype`),
  KEY `FK3FEC42FE76EF5698` (`farm_animals_farmid`),
  KEY `FK3FEC42FEB88635E8` (`farm_location_farmid`),
  KEY `FK3FEC42FE851E6C01` (`referenceanimaltype_animaltype_e_id`),
  KEY `FK3FEC42FE64723214` (`referenceanimaltype_siretype_e_id`),
  CONSTRAINT `FK3FEC42FE64723214` FOREIGN KEY (`referenceanimaltype_siretype_e_id`) REFERENCES `referenceanimaltype` (`e_id`),
  CONSTRAINT `FK3FEC42FE76EF5698` FOREIGN KEY (`farm_animals_farmid`) REFERENCES `farm` (`farmid`),
  CONSTRAINT `FK3FEC42FE851E6C01` FOREIGN KEY (`referenceanimaltype_animaltype_e_id`) REFERENCES `referenceanimaltype` (`e_id`),
  CONSTRAINT `FK3FEC42FEB88635E8` FOREIGN KEY (`farm_location_farmid`) REFERENCES `farm` (`farmid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `registeredanimal_pastowners`
--

DROP TABLE IF EXISTS `registeredanimal_pastowners`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `registeredanimal_pastowners` (
  `registeredanimal_pastowners_registrationid` bigint(20) NOT NULL,
  `elt` varchar(255) DEFAULT NULL,
  `registeredanimal_pastowners_idx` int(11) NOT NULL,
  `tstamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`registeredanimal_pastowners_registrationid`,`registeredanimal_pastowners_idx`),
  KEY `FKF90ADA935D16D9FE` (`registeredanimal_pastowners_registrationid`),
  CONSTRAINT `FKF90ADA935D16D9FE` FOREIGN KEY (`registeredanimal_pastowners_registrationid`) REFERENCES `registeredanimal` (`registrationid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `dtype` varchar(255) NOT NULL,
  `e_version` int(11) NOT NULL,
  `name` varchar(60) DEFAULT NULL,
  `description` varchar(60) DEFAULT NULL,
  `tstamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`),
  KEY `roledtype` (`dtype`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `role_permissions`
--

DROP TABLE IF EXISTS `role_permissions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role_permissions` (
  `role_permissions_id` bigint(20) NOT NULL,
  `elt` varchar(255) DEFAULT NULL,
  `role_permissions_idx` int(11) NOT NULL,
  `tstamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`role_permissions_id`,`role_permissions_idx`),
  KEY `FKEAD9D23BDA402635` (`role_permissions_id`),
  CONSTRAINT `FKEAD9D23BDA402635` FOREIGN KEY (`role_permissions_id`) REFERENCES `role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `route`
--

DROP TABLE IF EXISTS `route`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `route` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `dtype` varchar(255) NOT NULL,
  `e_version` int(11) NOT NULL,
  `name` varchar(60) DEFAULT NULL,
  `description` varchar(60) DEFAULT NULL,
  `vehicle_vehicle_vehicleid` bigint(20) DEFAULT NULL,
  `dairy_routes_companyid` bigint(20) DEFAULT NULL,
  `tstamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`),
  KEY `routedtype` (`dtype`),
  KEY `FK67AB2498E0EB0AD` (`vehicle_vehicle_vehicleid`),
  KEY `FK67AB249BB0D2E42` (`dairy_routes_companyid`),
  CONSTRAINT `FK67AB2498E0EB0AD` FOREIGN KEY (`vehicle_vehicle_vehicleid`) REFERENCES `vehicle` (`vehicleid`),
  CONSTRAINT `FK67AB249BB0D2E42` FOREIGN KEY (`dairy_routes_companyid`) REFERENCES `dairy` (`dairyid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `route_stops`
--

DROP TABLE IF EXISTS `route_stops`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `route_stops` (
  `dairylocation_id` bigint(20) NOT NULL,
  `route_id` bigint(20) DEFAULT NULL,
  `tstamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`dairylocation_id`),
  KEY `FK967B733B7072F8BA` (`dairylocation_id`),
  KEY `FK967B733B50A70FA` (`route_id`),
  CONSTRAINT `FK967B733B50A70FA` FOREIGN KEY (`route_id`) REFERENCES `route` (`id`),
  CONSTRAINT `FK967B733B7072F8BA` FOREIGN KEY (`dairylocation_id`) REFERENCES `dairylocation` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `supplier`
--

DROP TABLE IF EXISTS `supplier`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `supplier` (
  `supplierid` bigint(20) NOT NULL AUTO_INCREMENT,
  `dtype` varchar(255) NOT NULL,
  `e_version` int(11) NOT NULL,
  `legalname` varchar(60) DEFAULT NULL,
  `suppliername` varchar(60) NOT NULL,
  `location_location_e_id` bigint(20) NOT NULL,
  `phonenumber` varchar(60) NOT NULL,
  `description` varchar(60) DEFAULT NULL,
  `profilephoto` varchar(60) DEFAULT NULL,
  `id` varchar(60) NOT NULL,
  `publicdescription` varchar(60) NOT NULL,
  `status` varchar(255) NOT NULL,
  `registrationdate` datetime NOT NULL,
  `expirationdate` datetime DEFAULT NULL,
  `notes` varchar(60) DEFAULT NULL,
  `rating` int(11) DEFAULT NULL,
  `dairy_suppliers_companyid` bigint(20) DEFAULT NULL,
  `tstamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`supplierid`),
  KEY `supplierdtype` (`dtype`),
  KEY `FK9CDBF9CCE0164787` (`dairy_suppliers_companyid`),
  KEY `FK9CDBF9CC258A524A` (`location_location_e_id`),
  CONSTRAINT `FK9CDBF9CC258A524A` FOREIGN KEY (`location_location_e_id`) REFERENCES `location` (`locationid`),
  CONSTRAINT `FK9CDBF9CCE0164787` FOREIGN KEY (`dairy_suppliers_companyid`) REFERENCES `dairy` (`dairyid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `supplier_categories`
--

DROP TABLE IF EXISTS `supplier_categories`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `supplier_categories` (
  `supplier_categories_companyid` bigint(20) NOT NULL,
  `elt` varchar(255) DEFAULT NULL,
  `supplier_categories_idx` int(11) NOT NULL,
  `tstamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`supplier_categories_companyid`,`supplier_categories_idx`),
  KEY `FKD5D3CA6FE20A4274` (`supplier_categories_companyid`),
  CONSTRAINT `FKD5D3CA6FE20A4274` FOREIGN KEY (`supplier_categories_companyid`) REFERENCES `supplier` (`supplierid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `systemuser`
--

DROP TABLE IF EXISTS `systemuser`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `systemuser` (
  `e_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `dtype` varchar(255) NOT NULL,
  `e_version` int(11) NOT NULL,
  `username` varchar(60) DEFAULT NULL,
  `password` varchar(64) DEFAULT NULL,
  `relatedEmployee` bigint(20) DEFAULT NULL,
  `localenabled` bit(1) DEFAULT NULL,
  `role_role_e_id` bigint(20) DEFAULT NULL,
  `passwordhashed` bit(1) NOT NULL,
  `tstamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`e_id`),
  UNIQUE KEY `username` (`username`),
  KEY `systemuserdtype` (`dtype`),
  KEY `FK2660AE7AFF4272A7` (`relatedEmployee`),
  KEY `FK2660AE7AB828416B` (`role_role_e_id`),
  CONSTRAINT `FK2660AE7AB828416B` FOREIGN KEY (`role_role_e_id`) REFERENCES `role` (`id`),
  CONSTRAINT `FK2660AE7AFF4272A7` FOREIGN KEY (`relatedEmployee`) REFERENCES `person` (`personid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `transaction`
--

DROP TABLE IF EXISTS `transaction`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `transaction` (
  `transactionid` bigint(20) NOT NULL AUTO_INCREMENT,
  `dtype` varchar(255) NOT NULL,
  `e_version` int(11) NOT NULL,
  `transaction_account_accountid` bigint(20) DEFAULT NULL,
  `transactiondate` datetime NOT NULL,
  `transactiontype` varchar(255) NOT NULL,
  `amount` decimal(19,2) NOT NULL,
  `description` varchar(60) DEFAULT NULL,
  `referencenumber` varchar(60) DEFAULT NULL,
  `source` varchar(255) DEFAULT NULL,
  `dairylocation_relatedlocation_id` bigint(20) DEFAULT NULL,
  `checknumber` varchar(60) DEFAULT NULL,
  `signedby` varchar(60) DEFAULT NULL,
  `employee_signedoffby_personid` bigint(20) DEFAULT NULL,
  `tstamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`transactionid`),
  KEY `transactiondtype` (`dtype`),
  KEY `FK7FA0D2DE81BD5362` (`transaction_account_accountid`),
  KEY `FK7FA0D2DE1FA74279` (`dairylocation_relatedlocation_id`),
  KEY `FK7FA0D2DE4D2E0B24` (`employee_signedoffby_personid`),
  CONSTRAINT `FK7FA0D2DE1FA74279` FOREIGN KEY (`dairylocation_relatedlocation_id`) REFERENCES `dairylocation` (`id`),
  CONSTRAINT `FK7FA0D2DE4D2E0B24` FOREIGN KEY (`employee_signedoffby_personid`) REFERENCES `person` (`personid`),
  CONSTRAINT `FK7FA0D2DE81BD5362` FOREIGN KEY (`transaction_account_accountid`) REFERENCES `account` (`accountid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `trip`
--

DROP TABLE IF EXISTS `trip`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `trip` (
  `tripid` bigint(20) NOT NULL AUTO_INCREMENT,
  `dtype` varchar(255) NOT NULL,
  `e_version` int(11) NOT NULL,
  `started` datetime NOT NULL,
  `ended` datetime NOT NULL,
  `tstamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`tripid`),
  KEY `tripdtype` (`dtype`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `trip_collections`
--

DROP TABLE IF EXISTS `trip_collections`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `trip_collections` (
  `trip_tripid` bigint(20) NOT NULL,
  `collectiongroup_journalid` bigint(20) NOT NULL,
  `tstamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  KEY `FK8084E87BF0EC799F` (`trip_tripid`),
  KEY `FK8084E87B91C5ECD5` (`collectiongroup_journalid`),
  CONSTRAINT `FK8084E87B91C5ECD5` FOREIGN KEY (`collectiongroup_journalid`) REFERENCES `collectiongroup` (`journalid`),
  CONSTRAINT `FK8084E87BF0EC799F` FOREIGN KEY (`trip_tripid`) REFERENCES `trip` (`tripid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `trip_deliveries`
--

DROP TABLE IF EXISTS `trip_deliveries`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `trip_deliveries` (
  `trip_tripid` bigint(20) NOT NULL,
  `deliveryjournal_e_id` bigint(20) NOT NULL,
  `tstamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  KEY `FKFEC207ECF0EC799F` (`trip_tripid`),
  KEY `FKFEC207EC297165B4` (`deliveryjournal_e_id`),
  CONSTRAINT `FKFEC207EC297165B4` FOREIGN KEY (`deliveryjournal_e_id`) REFERENCES `deliveryjournal` (`e_id`),
  CONSTRAINT `FKFEC207ECF0EC799F` FOREIGN KEY (`trip_tripid`) REFERENCES `trip` (`tripid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `vehicle`
--

DROP TABLE IF EXISTS `vehicle`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vehicle` (
  `vehicleid` bigint(20) NOT NULL AUTO_INCREMENT,
  `dtype` varchar(255) NOT NULL,
  `e_version` int(11) NOT NULL,
  `registrationnumber` varchar(60) NOT NULL,
  `type` varchar(60) NOT NULL,
  `make` varchar(60) NOT NULL,
  `model` varchar(60) DEFAULT NULL,
  `enginenumber` varchar(60) NOT NULL,
  `chassisnumber` varchar(60) NOT NULL,
  `logbooknumber` varchar(60) DEFAULT NULL,
  `insurancepolicynumber` varchar(60) DEFAULT NULL,
  `insuranceexpirationdate` datetime DEFAULT NULL,
  `dominantcolour` varchar(60) DEFAULT NULL,
  `capacityintonnes` double DEFAULT NULL,
  `year` int(11) DEFAULT NULL,
  `employee_driver_personid` bigint(20) DEFAULT NULL,
  `tagtype` varchar(60) DEFAULT NULL,
  `tagvalue` varchar(60) DEFAULT NULL,
  `dateacquired` datetime DEFAULT NULL,
  `damagedate` datetime DEFAULT NULL,
  `damagedescription` varchar(60) DEFAULT NULL,
  `datedisposed` datetime DEFAULT NULL,
  `disposalreason` varchar(60) DEFAULT NULL,
  `disposalwitness` varchar(60) DEFAULT NULL,
  `dairy_vehicles_companyid` bigint(20) DEFAULT NULL,
  `tstamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`vehicleid`),
  UNIQUE KEY `registrationnumber` (`registrationnumber`),
  UNIQUE KEY `logbooknumber` (`logbooknumber`),
  KEY `vehicledtype` (`dtype`),
  KEY `FK14638F2C4B6F2A7F` (`dairy_vehicles_companyid`),
  KEY `FK14638F2CE901D8A4` (`employee_driver_personid`),
  CONSTRAINT `FK14638F2C4B6F2A7F` FOREIGN KEY (`dairy_vehicles_companyid`) REFERENCES `dairy` (`dairyid`),
  CONSTRAINT `FK14638F2CE901D8A4` FOREIGN KEY (`employee_driver_personid`) REFERENCES `person` (`personid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2011-01-16 16:48:09
