/*
SQLyog Ultimate v10.00 Beta1
MySQL - 5.5.27 : Database - employeeinformationsystem
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`employeeinformationsystem` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `employeeinformationsystem`;

/*Table structure for table `address` */

DROP TABLE IF EXISTS `address`;

CREATE TABLE `address` (
  `address_id` int(4) NOT NULL AUTO_INCREMENT,
  `houseNo` int(5) DEFAULT NULL,
  `streetName` varchar(30) NOT NULL,
  `city` varchar(20) NOT NULL,
  `state` varchar(20) NOT NULL,
  `pincode` varchar(6) NOT NULL,
  `employeedetails_id` int(4) DEFAULT NULL,
  PRIMARY KEY (`address_id`),
  KEY `employeedetails_id` (`employeedetails_id`),
  CONSTRAINT `address_ibfk_1` FOREIGN KEY (`employeedetails_id`) REFERENCES `employee` (`employeedetails_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=66 DEFAULT CHARSET=latin1;

/*Data for the table `address` */

insert  into `address`(`address_id`,`houseNo`,`streetName`,`city`,`state`,`pincode`,`employeedetails_id`) values (1,25,'4-B sainath','indore','MP','452001',5),(13,10,'vijaya','Indore','madhya pradesh','452010',32),(43,17,'tilak nagar','bhopal','MP','458001',48),(51,5,'Shiv Shakti nagar','Indore','Mp','452016',56),(52,251,'Rajwada    ','Indore','Madhya Pradesh','452007',57),(54,408,'manorama Ganj','Indore','MadhyaPradesh','452001',58),(55,23,'maheshnagar','Indore','mp','452002',59),(56,0,'airport road','indore','Madhya','452005',60),(57,64,'lig','indore','madhya pradesh','450036',61),(58,305,'Navlakha','Indore','MP','452001',62),(59,18,'khajrana','indore','mp','452018',63),(61,263,'\"hweta Nagar\"','Ujjain','Madhya Pradesh','452001',64),(62,1,'Lokmanya Nagar','Indore','MP','452009',65),(63,0,'Annapuran Nagar','Ashta','M P','466116',66),(64,101,'Paarsi Mohalla','Indore','M P','452001',67),(65,456,'villas','indore','Madhya Pradesh','458296',68);

/*Table structure for table `baselineinputdetails` */

DROP TABLE IF EXISTS `baselineinputdetails`;

CREATE TABLE `baselineinputdetails` (
  `baselineInputDetails_Id` int(4) NOT NULL AUTO_INCREMENT,
  `baselineInput` varchar(100) NOT NULL,
  `employeedetails_id` int(4) DEFAULT NULL,
  PRIMARY KEY (`baselineInputDetails_Id`),
  UNIQUE KEY `employeedetails_id` (`employeedetails_id`),
  CONSTRAINT `baselineinputdetails_ibfk_1` FOREIGN KEY (`employeedetails_id`) REFERENCES `employee` (`employeedetails_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

/*Data for the table `baselineinputdetails` */

insert  into `baselineinputdetails`(`baselineInputDetails_Id`,`baselineInput`,`employeedetails_id`) values (1,'technically strong',5),(3,'Good communication skills',32),(4,'GOOD',7),(5,'good',48),(6,'good',57),(7,'asdasda asda sdasd',64),(8,'asdasd asdasd asda sdasdasd asd asdasd as dasd as d asd a sd as d asd a sd a sd asdasd',62);

/*Table structure for table `employee` */

DROP TABLE IF EXISTS `employee`;

CREATE TABLE `employee` (
  `employeedetails_id` int(4) NOT NULL AUTO_INCREMENT,
  `yashemployeeid` int(7) NOT NULL,
  `firstname` varchar(15) NOT NULL,
  `lastname` varchar(15) NOT NULL,
  `email` varchar(40) NOT NULL,
  `mobile` varchar(10) NOT NULL,
  `alternate_mobile` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`employeedetails_id`),
  KEY `employeeId` (`yashemployeeid`)
) ENGINE=InnoDB AUTO_INCREMENT=69 DEFAULT CHARSET=latin1;

/*Data for the table `employee` */

insert  into `employee`(`employeedetails_id`,`yashemployeeid`,`firstname`,`lastname`,`email`,`mobile`,`alternate_mobile`) values (5,1004317,'Mayank','yadav','mayank.yadav@yash.com','8349039933','9584096451'),(7,1004322,'Pratik','Sethia','pratik.sethia@yash.com','9652348652','9853147441'),(32,6575768,'nikhilesh','sadhav','nikhilesh.sadhav@yash.com','9926930080',''),(48,1104325,'ram','somani','ram.somani@yash.com','9752038818','8989678487'),(56,1004329,'Shashankk','Juneja','shashank.juneja@yash.com','9874563212','9165652788'),(57,1004692,'Yashonil','Gangwal    ','yashonil.gangwal@yash.com','9584755524','5231456987'),(58,1004683,'Chandrika','Bajoria','chandrika.bajoria@yash.com','9926201968','9632871574'),(59,1004693,'Yogita','Bhati','yogita.bhati@yash.com','9039774462',''),(60,1004696,'shraddha','sharma','shraddha.sharma@yash.com','1212121212',''),(61,1004689,'shalini','yadav','shalini.yadav@yash.com','4565898721','8989898989'),(62,1004687,'Prajvi','Jain','prajvi.jain@yash.com','9617699261','9617669261'),(63,1004715,'ankita','deshpande','ankita.deshhpande@yash.com','9691080442','9691080442'),(64,7308222,'abc','abc','phalguni.vatsa@yash.com','2131231312',''),(65,1234567,'asasa dfdfdf','dfdf defdf','aditya.moghe@yash.com','8871571454',''),(66,1004312,'Deepak','Vishwakarma','deepak.vishwakarma@yash.com','7828692867','0'),(67,1004315,'kunal','Bulchandani','kunal.bulchandani@yash.com','9685568538','7828692867'),(68,1458965,'sapna','golhani','sapna.golhani@yash.com','4589671258','4595714856');

/*Table structure for table `employeeskill` */

DROP TABLE IF EXISTS `employeeskill`;

CREATE TABLE `employeeskill` (
  `employeeskill_id` int(4) NOT NULL AUTO_INCREMENT,
  `skill_id` int(4) NOT NULL,
  `employeedetails_id` int(4) NOT NULL,
  `skillefficiency_id` int(4) NOT NULL,
  PRIMARY KEY (`employeeskill_id`),
  KEY `employeeskill_ibfk_3` (`employeedetails_id`),
  KEY `employeeskill_ibfk_2` (`skill_id`),
  KEY `skillefficiency_id` (`skillefficiency_id`),
  CONSTRAINT `employeeskill_ibfk_1` FOREIGN KEY (`employeedetails_id`) REFERENCES `employee` (`employeedetails_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `employeeskill_ibfk_2` FOREIGN KEY (`skill_id`) REFERENCES `skill` (`skill_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `employeeskill_ibfk_3` FOREIGN KEY (`skillefficiency_id`) REFERENCES `skillefficiency` (`skillefficiency_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=144 DEFAULT CHARSET=latin1;

/*Data for the table `employeeskill` */

insert  into `employeeskill`(`employeeskill_id`,`skill_id`,`employeedetails_id`,`skillefficiency_id`) values (89,1,5,2),(92,1,7,3),(93,2,7,2),(94,3,7,2),(95,4,7,1),(96,1,67,3),(98,7,67,3),(99,10,67,3),(100,8,67,3),(101,1,68,2),(103,5,7,1),(118,13,66,2),(119,14,66,2),(120,15,66,2),(121,17,66,1),(122,1,66,1),(123,6,66,4),(124,9,66,4),(125,5,66,4),(126,3,66,4),(127,4,66,4),(128,10,66,4),(129,12,66,4),(130,11,66,4),(131,8,66,4),(132,18,66,4),(133,16,66,4),(134,2,66,4),(135,7,66,4),(136,6,7,1),(138,14,56,4),(139,5,56,4),(140,12,56,4),(141,1,32,1),(142,3,5,2),(143,7,5,2);

/*Table structure for table `feedbackdetails` */

DROP TABLE IF EXISTS `feedbackdetails`;

CREATE TABLE `feedbackdetails` (
  `feedbackDetails_Id` int(4) NOT NULL AUTO_INCREMENT,
  `feedback` longtext NOT NULL,
  `lastUpdatedManagerId` int(4) DEFAULT NULL,
  `employeedetails_id` int(4) DEFAULT NULL,
  PRIMARY KEY (`feedbackDetails_Id`),
  UNIQUE KEY `employeedetails_id` (`employeedetails_id`),
  KEY `fk_feedbackManagerId` (`lastUpdatedManagerId`),
  CONSTRAINT `feedbackdetails_ibfk_1` FOREIGN KEY (`employeedetails_id`) REFERENCES `employee` (`employeedetails_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_feedbackManagerId` FOREIGN KEY (`lastUpdatedManagerId`) REFERENCES `managerdetails` (`managerDetails_Id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=latin1;

/*Data for the table `feedbackdetails` */

insert  into `feedbackdetails`(`feedbackDetails_Id`,`feedback`,`lastUpdatedManagerId`,`employeedetails_id`) values (23,'very good @kushagra bhargava| nice @kushagra bhargava',18,5);

/*Table structure for table `grade` */

DROP TABLE IF EXISTS `grade`;

CREATE TABLE `grade` (
  `grade_id` int(4) NOT NULL AUTO_INCREMENT,
  `gradeValue` varchar(4) NOT NULL,
  PRIMARY KEY (`grade_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

/*Data for the table `grade` */

insert  into `grade`(`grade_id`,`gradeValue`) values (1,'A+'),(2,'A'),(3,'B+'),(4,'B'),(5,'C+'),(6,'C'),(7,'D+'),(8,'D');

/*Table structure for table `gradedetails` */

DROP TABLE IF EXISTS `gradedetails`;

CREATE TABLE `gradedetails` (
  `gradeDetails_Id` int(4) NOT NULL AUTO_INCREMENT,
  `gradeId` int(4) NOT NULL,
  `employeedetails_id` int(4) DEFAULT NULL,
  PRIMARY KEY (`gradeDetails_Id`),
  UNIQUE KEY `employeedetails_id` (`employeedetails_id`),
  KEY `gradeId` (`gradeId`),
  CONSTRAINT `gradedetails_ibfk_1` FOREIGN KEY (`gradeId`) REFERENCES `grade` (`grade_id`) ON UPDATE CASCADE,
  CONSTRAINT `gradedetails_ibfk_2` FOREIGN KEY (`employeedetails_id`) REFERENCES `employee` (`employeedetails_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=latin1;

/*Data for the table `gradedetails` */

insert  into `gradedetails`(`gradeDetails_Id`,`gradeId`,`employeedetails_id`) values (16,4,5),(17,2,66);

/*Table structure for table `managerdetails` */

DROP TABLE IF EXISTS `managerdetails`;

CREATE TABLE `managerdetails` (
  `managerDetails_Id` int(4) NOT NULL AUTO_INCREMENT,
  `managerName` varchar(20) DEFAULT NULL,
  `managerEmailId` varchar(40) NOT NULL,
  `role` int(2) DEFAULT '2',
  PRIMARY KEY (`managerDetails_Id`),
  KEY `role` (`role`),
  CONSTRAINT `managerdetails_ibfk_1` FOREIGN KEY (`role`) REFERENCES `role` (`role_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=latin1;

/*Data for the table `managerdetails` */

insert  into `managerdetails`(`managerDetails_Id`,`managerName`,`managerEmailId`,`role`) values (13,'pankaj sharma ','sharma.pankaj@yash.com',2),(14,'phalguni vatsa','phalguni.vatsa@yash.com',2),(18,'kushagra bhargava','kushagra.bhargava@yash.com',1),(19,'prakhar','prakhar.jain@yash.com',2),(29,'Pratik Sethia','pratik.sethia@yash.com',1);

/*Table structure for table `projectallocationdetails` */

DROP TABLE IF EXISTS `projectallocationdetails`;

CREATE TABLE `projectallocationdetails` (
  `projectAllocationDetails_Id` int(4) NOT NULL AUTO_INCREMENT,
  `projectDetails_Id` int(4) NOT NULL,
  `employeedetails_id` int(4) NOT NULL,
  PRIMARY KEY (`projectAllocationDetails_Id`),
  KEY `employeedetails_id` (`employeedetails_id`),
  KEY `projectDetails_Id` (`projectDetails_Id`),
  CONSTRAINT `projectallocationdetails_ibfk_1` FOREIGN KEY (`employeedetails_id`) REFERENCES `employee` (`employeedetails_id`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `projectallocationdetails_ibfk_2` FOREIGN KEY (`projectDetails_Id`) REFERENCES `projectdetails` (`projectDetails_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=107 DEFAULT CHARSET=latin1;

/*Data for the table `projectallocationdetails` */

insert  into `projectallocationdetails`(`projectAllocationDetails_Id`,`projectDetails_Id`,`employeedetails_id`) values (87,18,5),(88,18,32),(89,18,7),(90,18,48),(91,18,56),(92,16,7),(93,17,5),(94,17,48),(95,17,61),(96,17,64),(97,18,64),(98,18,66),(99,16,62),(100,20,32),(101,18,58),(102,19,62),(103,17,65),(104,33,5),(105,33,32),(106,33,7);

/*Table structure for table `projectdetails` */

DROP TABLE IF EXISTS `projectdetails`;

CREATE TABLE `projectdetails` (
  `projectDetails_Id` int(4) NOT NULL AUTO_INCREMENT,
  `projectName` varchar(20) NOT NULL,
  `projectDuration` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`projectDetails_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=latin1;

/*Data for the table `projectdetails` */

insert  into `projectdetails`(`projectDetails_Id`,`projectName`,`projectDuration`) values (16,'J.D','180 Days'),(17,'Microsoft','120 days'),(18,'Sigma','120 days'),(19,'IOT','120 days'),(20,'Google','120 days'),(21,'Sigma 1','120 days'),(25,'Monsanto','2 years'),(28,'sbi','102 DAYS'),(30,'IOT','fdgdf'),(31,'Kick','120'),(32,'Kicks','2 days'),(33,'TATA','10 years'),(34,'aasd','123');

/*Table structure for table `resume` */

DROP TABLE IF EXISTS `resume`;

CREATE TABLE `resume` (
  `resume_id` int(4) NOT NULL AUTO_INCREMENT,
  `resumeName` varchar(30) NOT NULL,
  `employeeEmail` varchar(40) NOT NULL,
  PRIMARY KEY (`resume_id`),
  UNIQUE KEY `employeedetails_id` (`employeeEmail`),
  KEY `resume_id` (`resume_id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=latin1;

/*Data for the table `resume` */

insert  into `resume`(`resume_id`,`resumeName`,`employeeEmail`) values (4,'deepak.vishwakarma','deepak.vishwakarma@yash.com'),(7,'nikhilesh.sadhav','nikhilesh.sadhav@yash.com'),(8,'sample','sample'),(10,'aditya.moghe','aditya.moghe@yash.com'),(11,'shashank.juneja','shashank.juneja@yash.com'),(13,'yashonil.gangwal','yashonil.gangwal@yash.com'),(14,'chandrika.bajoria','chandrika.bajoria@yash.com'),(15,'shalini.yadav','shalini.yadav@yash.com'),(16,'yogita.bhati','yogita.bhati@yash.com'),(17,'prajvi.jain','prajvi.jain@yash.com'),(20,'phalguni.vatsa','phalguni.vatsa@yash.com'),(21,'kunal.bulchandani','kunal.bulchandani@yash.com');

/*Table structure for table `role` */

DROP TABLE IF EXISTS `role`;

CREATE TABLE `role` (
  `role_id` int(2) NOT NULL AUTO_INCREMENT,
  `roleType` varchar(10) NOT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

/*Data for the table `role` */

insert  into `role`(`role_id`,`roleType`) values (1,'Admin'),(2,'Manager');

/*Table structure for table `skill` */

DROP TABLE IF EXISTS `skill`;

CREATE TABLE `skill` (
  `skill_id` int(4) NOT NULL AUTO_INCREMENT,
  `skillName` varchar(15) NOT NULL,
  PRIMARY KEY (`skill_id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=latin1;

/*Data for the table `skill` */

insert  into `skill`(`skill_id`,`skillName`) values (1,'Java'),(2,'Spring'),(3,'Hibernate'),(4,'Angularjs'),(5,'Bootstrap'),(6,'Jsf'),(7,'Ejb'),(8,'Html'),(9,'Css'),(10,'Jquery'),(11,'Javascript'),(12,'Restful'),(13,'NodeJs'),(14,'Android'),(15,'IOS'),(16,'PhoneGap'),(17,'ajax'),(18,'Struts');

/*Table structure for table `skillefficiency` */

DROP TABLE IF EXISTS `skillefficiency`;

CREATE TABLE `skillefficiency` (
  `skillefficiency_id` int(4) NOT NULL AUTO_INCREMENT,
  `efficiencyType` varchar(16) NOT NULL,
  PRIMARY KEY (`skillefficiency_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

/*Data for the table `skillefficiency` */

insert  into `skillefficiency`(`skillefficiency_id`,`efficiencyType`) values (1,'Below-Average'),(2,'Average'),(3,'Above-Average'),(4,'Excellent');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
