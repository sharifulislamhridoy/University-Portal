-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.0.41-community-nt


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema university_portal
--

CREATE DATABASE IF NOT EXISTS university_portal;
USE university_portal;

--
-- Definition of table `accounthead`
--

DROP TABLE IF EXISTS `accounthead`;
CREATE TABLE `accounthead` (
  `code` int(10) unsigned NOT NULL auto_increment,
  `headName` varchar(45) NOT NULL,
  `purpose` varchar(45) NOT NULL,
  `type` varchar(45) NOT NULL,
  `baseFee` int(10) unsigned NOT NULL,
  `eLStatus` varchar(45) NOT NULL,
  PRIMARY KEY  (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `accounthead`
--

/*!40000 ALTER TABLE `accounthead` DISABLE KEYS */;
INSERT INTO `accounthead` (`code`,`headName`,`purpose`,`type`,`baseFee`,`eLStatus`) VALUES 
 (101,'Semester Fee','Education','Payment',2500,'income'),
 (102,'Course Fee GED','Education','Payment',3500,'income'),
 (103,'Course Fee CORE','Education','Payment',6000,'income');
/*!40000 ALTER TABLE `accounthead` ENABLE KEYS */;


--
-- Definition of table `assigncourses`
--

DROP TABLE IF EXISTS `assigncourses`;
CREATE TABLE `assigncourses` (
  `assignid` int(10) unsigned NOT NULL auto_increment,
  `facultyName` varchar(45) default NULL,
  `departmentName` varchar(45) default NULL,
  `batchName` varchar(45) default NULL,
  `semesterName` varchar(45) default NULL,
  `coursesName` varchar(45) default NULL,
  `courseCode` varchar(45) default NULL,
  `courseCradit` varchar(45) default NULL,
  `coursePrice` varchar(45) default NULL,
  `professorName` varchar(45) default NULL,
  `email` varchar(45) default NULL,
  `designation` varchar(45) default NULL,
  `phone` varchar(45) default NULL,
  PRIMARY KEY  (`assignid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `assigncourses`
--

/*!40000 ALTER TABLE `assigncourses` DISABLE KEYS */;
INSERT INTO `assigncourses` (`assignid`,`facultyName`,`departmentName`,`batchName`,`semesterName`,`coursesName`,`courseCode`,`courseCradit`,`coursePrice`,`professorName`,`email`,`designation`,`phone`) VALUES 
 (1,'School of Business & Economics','Marketing & International Business','33-Batch','MD.Razib','Principal Of Marketing','MKT-101','6','4500','Isaac Newton','seo@gmail.com','Professor','1675972500'),
 (2,'School of Business & Economics','Accounting & Finance','33-Batch','MD.Razib','Finance II','MKT-101','6','4500','Maruf Sir','maruf@gmail.com','Professor','01675987125'),
 (3,'School of Business & Economics','Accounting & Finance','02-Batch','Md. Rajib Hossiain ','Accounting','ACT-102','6','7500','Albert Einstein','seo@gmail.com','Professor','1675972500'),
 (4,'School of Business & Economics','Accounting & Finance','33-Batch','spring ','Finance II','MKT-101','3','4500','Albert Einstein','seo@gmail.com','Professor','1675972500');
/*!40000 ALTER TABLE `assigncourses` ENABLE KEYS */;


--
-- Definition of table `attandance`
--

DROP TABLE IF EXISTS `attandance`;
CREATE TABLE `attandance` (
  `id` int(10) unsigned NOT NULL auto_increment,
  `studentsId` varchar(45) default NULL,
  `name` varchar(45) default NULL,
  `facultyName` varchar(45) default NULL,
  `departmentName` varchar(45) default NULL,
  `batchName` varchar(45) default NULL,
  `coursesName` varchar(45) default NULL,
  `courseCode` varchar(45) default NULL,
  `professorName` varchar(45) default NULL,
  `date` date default NULL,
  `starus` varchar(45) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `attandance`
--

/*!40000 ALTER TABLE `attandance` DISABLE KEYS */;
INSERT INTO `attandance` (`id`,`studentsId`,`name`,`facultyName`,`departmentName`,`batchName`,`coursesName`,`courseCode`,`professorName`,`date`,`starus`) VALUES 
 (1,'123302236','Shanur Nahid','School of Business & Economics',NULL,'33-Batch','Principal Of Marketing','MKT-101','Isaac Newton','2020-09-01','Absent'),
 (2,'123302235','Rakib Khan','School of Business & Economics',NULL,'33-Batch','Principal Of Marketing','MKT-101','Isaac Newton','2020-09-01','Absent'),
 (3,'123302234','Sharmin Jhan','School of Business & Economics',NULL,'33-Batch','Principal Of Marketing','MKT-101','Isaac Newton','2020-09-01','Present'),
 (4,'123302233','Asiqur Rahaman','School of Business & Economics',NULL,'33-Batch','Principal Of Marketing','MKT-101','Isaac Newton','2020-09-01','Present'),
 (37,'123302236','Shanur Nahid','School of Business & Economics','Finance & Banking','33-Batch','Principal Of Marketing','MKT-101','Isaac Newton','2020-09-05','Absent'),
 (38,'123302235','Rakib Khan','School of Business & Economics','Finance & Banking','33-Batch','Principal Of Marketing','MKT-101','Isaac Newton','2020-09-05','Present'),
 (39,'123302234','Sharmin Jhan','School of Business & Economics','Finance & Banking','33-Batch','Principal Of Marketing','MKT-101','Isaac Newton','2020-09-05','Present'),
 (40,'123302233','Asiqur Rahaman','School of Business & Economics','Finance & Banking','33-Batch','Principal Of Marketing','MKT-101','Isaac Newton','2020-09-05','Present'),
 (41,'123302236','Shanur Nahid','School of Business & Economics','Finance & Banking','33-Batch','Principal Of Marketing','MKT-101','Isaac Newton','2020-09-05','Present'),
 (42,'123302235','Rakib Khan','School of Business & Economics','Finance & Banking','33-Batch','Principal Of Marketing','MKT-101','Isaac Newton','2020-09-05','Absent'),
 (43,'123302234','Sharmin Jhan','School of Business & Economics','Finance & Banking','33-Batch','Principal Of Marketing','MKT-101','Isaac Newton','2020-09-05','Absent'),
 (44,'123302233','Asiqur Rahaman','School of Business & Economics','Finance & Banking','33-Batch','Principal Of Marketing','MKT-101','Isaac Newton','2020-09-05','Present'),
 (45,'123302233','Asiqur Rahaman','School of Business & Economics','Finance & Banking','02-Batch','Accounting','ACT-102','Albert Einstein','2020-09-06','Present'),
 (46,'123302236','Shanur Nahid','School of Business & Economics','Finance & Banking','02-Batch','Accounting','ACT-102','Albert Einstein','2020-09-06','Present'),
 (47,'123302236','Shanur Nahid','School of Business & Economics','Finance & Banking','33-Batch','Principal Of Marketing','MKT-101','Isaac Newton','2020-09-06','Absent'),
 (48,'123302235','Rakib Khan','School of Business & Economics','Finance & Banking','33-Batch','Principal Of Marketing','MKT-101','Isaac Newton','2020-09-06','Present'),
 (49,'123302234','Sharmin Jhan','School of Business & Economics','Finance & Banking','33-Batch','Principal Of Marketing','MKT-101','Isaac Newton','2020-09-06','Present'),
 (50,'123302233','Asiqur Rahaman','School of Business & Economics','Finance & Banking','33-Batch','Principal Of Marketing','MKT-101','Isaac Newton','2020-09-06','Absent'),
 (51,'123302236','Shanur Nahid','School of Business & Economics','Finance & Banking','33-Batch','Finance II','MKT-101','Maruf Sir','2020-09-06','Present'),
 (52,'123302233','Asiqur Rahaman','School of Business & Economics','Finance & Banking','02-Batch','Accounting','ACT-102','Albert Einstein','2020-09-06','Present'),
 (53,'123302236','Shanur Nahid','School of Business & Economics','Finance & Banking','02-Batch','Accounting','ACT-102','Albert Einstein','2020-09-06','Present'),
 (54,'123302236','Shanur Nahid','School of Business & Economics','Finance & Banking','33-Batch','Principal Of Marketing','MKT-101','Isaac Newton','2020-09-06','Absent'),
 (55,'123302235','Rakib Khan','School of Business & Economics','Finance & Banking','33-Batch','Principal Of Marketing','MKT-101','Isaac Newton','2020-09-06','Present'),
 (56,'123302234','Sharmin Jhan','School of Business & Economics','Finance & Banking','33-Batch','Principal Of Marketing','MKT-101','Isaac Newton','2020-09-06','Present'),
 (57,'123302233','Asiqur Rahaman','School of Business & Economics','Finance & Banking','33-Batch','Principal Of Marketing','MKT-101','Isaac Newton','2020-09-06','Absent');
/*!40000 ALTER TABLE `attandance` ENABLE KEYS */;


--
-- Definition of table `audits`
--

DROP TABLE IF EXISTS `audits`;
CREATE TABLE `audits` (
  `id` int(10) unsigned NOT NULL auto_increment,
  `action` varchar(45) default NULL,
  `time` varchar(45) default NULL,
  `username` varchar(45) default NULL,
  `role` varchar(45) default NULL,
  `email` varchar(45) default NULL,
  `date` datetime default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `audits`
--

/*!40000 ALTER TABLE `audits` DISABLE KEYS */;
INSERT INTO `audits` (`id`,`action`,`time`,`username`,`role`,`email`,`date`) VALUES 
 (1,'getIndex','3:35','SharifulIslam','admin','test@gmail.com','2020-10-10 00:00:00'),
 (2,'getAllUser','4:30 pm','Rakib Hasan','User','rakib@gmail.com','2020-12-12 04:01:20'),
 (3,'index Page Loding','3:54','adminUser','admin','admin@test.com','2020-08-10 12:00:02'),
 (4,'index Page Loding','3:54','adminUser','admin','admin@test.com','2020-08-10 12:01:05'),
 (5,'index Page Loding','3:54','adminUser','admin','admin@test.com','2020-08-10 12:01:14'),
 (6,'Create','3:54','adminUser','admin','admin@test.com','2020-08-10 15:36:42'),
 (7,'Save','3:54','adminUser','admin','admin@test.com','2020-08-10 15:57:35'),
 (8,'Save','3:54','adminUser','admin','admin@test.com','2020-08-10 15:59:32'),
 (9,'Save','3:54','adminUser','admin','admin@test.com','2020-08-10 16:08:45'),
 (10,'Save','3:54','adminUser','admin','admin@test.com','2020-08-31 14:59:38'),
 (11,'Save','3:54','adminUser','admin','admin@test.com','2020-08-31 15:13:50');
/*!40000 ALTER TABLE `audits` ENABLE KEYS */;


--
-- Definition of table `batch`
--

DROP TABLE IF EXISTS `batch`;
CREATE TABLE `batch` (
  `batchId` int(10) unsigned NOT NULL auto_increment,
  `batchName` varchar(45) NOT NULL,
  `facultyName` varchar(45) NOT NULL default 'Runing',
  `departmentName` varchar(45) NOT NULL,
  `status` varchar(45) NOT NULL,
  PRIMARY KEY  (`batchId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `batch`
--

/*!40000 ALTER TABLE `batch` DISABLE KEYS */;
INSERT INTO `batch` (`batchId`,`batchName`,`facultyName`,`departmentName`,`status`) VALUES 
 (1,'42-Batch','School of Business Economics','Accounting & Finance','Runing'),
 (2,'33-Batch','School of Business Economics','Economics','Runing'),
 (3,'33-Batch','School of Business Economics','Accounting & Finance','Runing'),
 (4,'02-Batch','School of Business Economics','Accounting & Finance','Runing');
/*!40000 ALTER TABLE `batch` ENABLE KEYS */;


--
-- Definition of table `category`
--

DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `cat_id` bigint(20) unsigned NOT NULL auto_increment,
  `cat_parent` bigint(20) unsigned NOT NULL default '0',
  `cat_name` varchar(45) character set utf8 NOT NULL,
  PRIMARY KEY  (`cat_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `category`
--

/*!40000 ALTER TABLE `category` DISABLE KEYS */;
/*!40000 ALTER TABLE `category` ENABLE KEYS */;


--
-- Definition of table `classroutine`
--

DROP TABLE IF EXISTS `classroutine`;
CREATE TABLE `classroutine` (
  `routineid` int(10) unsigned NOT NULL auto_increment,
  `day` varchar(45) default NULL,
  `time` varchar(45) default NULL,
  `batchid` varchar(45) default NULL,
  `courseid` varchar(45) default NULL,
  `teacherid` varchar(45) default NULL,
  PRIMARY KEY  USING BTREE (`routineid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `classroutine`
--

/*!40000 ALTER TABLE `classroutine` DISABLE KEYS */;
INSERT INTO `classroutine` (`routineid`,`day`,`time`,`batchid`,`courseid`,`teacherid`) VALUES 
 (1,'sunday','evening-11:30','33-Batch','Principal Of Marketing','Isaac Newton'),
 (2,'Monday','evening-11:30','33-Batch','Principal Of Marketing','Galileo Galilei'),
 (3,'Wednesday','Morning 12:30 PM','42-Batch','Principal Of finance','Maruf Sir'),
 (4,'Sunday','Evening 8:30PM','42-Batch','Finance II','Albert Einstein'),
 (5,'Monday','Morning 11:30 AM','33-Batch','Accounting','Isaac Newton');
/*!40000 ALTER TABLE `classroutine` ENABLE KEYS */;


--
-- Definition of table `courses`
--

DROP TABLE IF EXISTS `courses`;
CREATE TABLE `courses` (
  `id` int(10) unsigned NOT NULL auto_increment,
  `coursesName` varchar(45) default NULL,
  `courseCode` varchar(45) default NULL,
  `courseCradit` int(10) unsigned default NULL,
  `coursePrice` int(10) unsigned default NULL,
  `semesterName` varchar(45) default NULL,
  `batchName` varchar(45) default NULL,
  `departmentName` varchar(45) default NULL,
  `facultyName` varchar(45) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `courses`
--

/*!40000 ALTER TABLE `courses` DISABLE KEYS */;
INSERT INTO `courses` (`id`,`coursesName`,`courseCode`,`courseCradit`,`coursePrice`,`semesterName`,`batchName`,`departmentName`,`facultyName`) VALUES 
 (1,'Principal Of finance','FIN-101',6,8500,'spring ','42-Batch','Marketing & International Bussiness','School of Business & Economics'),
 (2,'Principal Of Marketing','MKT-101',3,4500,'spring ','33-Batch','Marketing & International Bussiness','School of Business & Economics'),
 (3,'Finance II','MKT-101',3,4500,'spring ','33-Batch','Accounting & Finance','School of Business & Economics'),
 (19,'Accounting','ACT-102',6,7500,'spring ','02-Batch','Accounting & Finance','School of Business & Economics');
/*!40000 ALTER TABLE `courses` ENABLE KEYS */;


--
-- Definition of table `department`
--

DROP TABLE IF EXISTS `department`;
CREATE TABLE `department` (
  `dep_Id` int(10) unsigned NOT NULL auto_increment,
  `departmentName` varchar(45) default NULL,
  `facultyName` varchar(45) default NULL,
  `status` varchar(45) default NULL,
  PRIMARY KEY  USING BTREE (`dep_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `department`
--

/*!40000 ALTER TABLE `department` DISABLE KEYS */;
INSERT INTO `department` (`dep_Id`,`departmentName`,`facultyName`,`status`) VALUES 
 (1,'Accounting & Finance','Sechool of Busness & Ecnomics','Runing'),
 (2,'Economics','Sechool of Busness & Ecnomics','Runing'),
 (3,'Economics','Sechool of Busness & Ecnomics','Runing'),
 (4,'Architecture','School of Enginering & Physical Sciences','Runing');
/*!40000 ALTER TABLE `department` ENABLE KEYS */;


--
-- Definition of table `faculty`
--

DROP TABLE IF EXISTS `faculty`;
CREATE TABLE `faculty` (
  `fact_id` int(10) unsigned NOT NULL auto_increment,
  `facultyName` varchar(45) NOT NULL,
  PRIMARY KEY  (`fact_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `faculty`
--

/*!40000 ALTER TABLE `faculty` DISABLE KEYS */;
INSERT INTO `faculty` (`fact_id`,`facultyName`) VALUES 
 (1,'Sechool of Busness & Ecnomics'),
 (2,'School of Enginering & Physical Sciences'),
 (3,'School of Humanities & Scosial Sciences'),
 (4,'School of Health & Life Sciences');
/*!40000 ALTER TABLE `faculty` ENABLE KEYS */;


--
-- Definition of table `notice`
--

DROP TABLE IF EXISTS `notice`;
CREATE TABLE `notice` (
  `id` int(10) unsigned NOT NULL auto_increment,
  `title` varchar(405) default NULL,
  `notice` varchar(1000) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `notice`
--

/*!40000 ALTER TABLE `notice` DISABLE KEYS */;
INSERT INTO `notice` (`id`,`title`,`notice`) VALUES 
 (1,'Undergraduate admission test result : Fall 2020','A UGC press release (4 April, 2020) finds  holding online examinations and student assessment by private universities to be unacceptable. Our online classes will, however, continue till 28 April, 2020 as planned. We shall inform you of the time and tools  of student assessment afterwards.\r\n \r\n \r\nA UGC press release (4 April, 2020) finds  holding online examinations and student assessment by private universities to be unacceptable. Our online classes will, however, continue till 28 April, 2020 as planned. We shall inform you of the time and tools  of student assessment afterwards.'),
 (2,'Graduate Admission Notice: Fall 2020','this the massage for gggg ggg all students and all member this the massage for all students and all member this the massage for all students and all member'),
 (3,'Notice for all concerned : NSU to remain closed until 5th May 2020','this the massage for gggg ggg all students and all member this the massage for all students and all member this the massage for all students and all member'),
 (4,'Class Continuation Notice','What are the 3 methods of payment?\nThe three most basic methods of payment are cash, credit, and payment-in-kind (or bartering). These three methods are used in basic transactions; for example, one may pay for a candy bar with cash, a credit card or, theoretically, even by trading another candy bar.'),
 (5,'Attention BUS 498 Students - Exit Assessment Test Information.','What are the 3 methods of payment?\nThe three most basic methods of payment are cash, credit, and payment-in-kind (or bartering). These three methods are used in basic transactions; for example, one may pay for a candy bar with cash, a credit card or, theoretically, even by trading another candy bar.'),
 (6,'Notice for All Concerned','What are the 3 methods of payment?\nThe three most basic methods of payment are cash, credit, and payment-in-kind (or bartering). These three methods are used in basic transactions; for example, one may pay for a candy bar with cash, a credit card or, theoretically, even by trading another candy bar.'),
 (7,'Notice for All Concerned','What are the 3 methods of payment?\nThe three most basic methods of payment are cash, credit, and payment-in-kind (or bartering). These three methods are used in basic transactions; for example, one may pay for a candy bar with cash, a credit card or, theoretically, even by trading another candy bar.'),
 (8,'Payment','What are the 3 methods of payment?\nThe three most basic methods of payment are cash, credit, and payment-in-kind (or bartering). These three methods are used in basic transactions; for example, one may pay for a candy bar with cash, a credit card or, theoretically, even by trading another candy bar.');
/*!40000 ALTER TABLE `notice` ENABLE KEYS */;


--
-- Definition of table `payment`
--

DROP TABLE IF EXISTS `payment`;
CREATE TABLE `payment` (
  `id` int(10) unsigned NOT NULL auto_increment,
  `studentsId` varchar(45) default NULL,
  `name` varchar(45) default NULL,
  `facultyName` varchar(45) default NULL,
  `departmentName` varchar(45) default NULL,
  `batchName` varchar(45) default NULL,
  `semesterName` varchar(45) default NULL,
  `headName` varchar(45) default NULL,
  `purpose` varchar(45) default NULL,
  `type` varchar(45) default NULL,
  `basefee` int(10) default NULL,
  `method` varchar(45) default NULL,
  `datePayment` date default NULL,
  `acINfo` varchar(45) default NULL,
  `pass` varchar(45) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `payment`
--

/*!40000 ALTER TABLE `payment` DISABLE KEYS */;
INSERT INTO `payment` (`id`,`studentsId`,`name`,`facultyName`,`departmentName`,`batchName`,`semesterName`,`headName`,`purpose`,`type`,`basefee`,`method`,`datePayment`,`acINfo`,`pass`) VALUES 
 (2,'123302236','Marketing & International Business','33-Batch','MD.Razib','Principal Of Marketing','Spring','Semester Fee','Education','Education',5000,'Online Bank','2020-09-04','102205','12304'),
 (3,'123302236','Marketing & International Business','33-Batch','MD.Razib','Principal Of Marketing','Spring','Semester Fee','Education','Payment',2000,'Online Bank','2020-09-04','125487','1201'),
 (4,'123302236','Marketing & International Business','33-Batch','MD.Razib','Principal Of Marketing','Spring','Semester Fee','Education','Payment',7500,'Online Bank','2020-09-05','125487','123'),
 (6,'123302236','Marketing & International Business','33-Batch','MD.Razib','Principal Of Marketing','Spring','Course Fee','Education','Payment',2500,'Online Bank','2020-09-06','125487','123'),
 (8,'123302236','Marketing & International Business','33-Batch','MD.Razib','Principal Of Marketing','Spring','Course Fee','Education','Payment',2000,'Online Bank','2020-09-06','125487','123');
/*!40000 ALTER TABLE `payment` ENABLE KEYS */;


--
-- Definition of table `professors`
--

DROP TABLE IF EXISTS `professors`;
CREATE TABLE `professors` (
  `id` int(10) unsigned NOT NULL auto_increment,
  `name` varchar(45) default NULL,
  `email` varchar(45) default NULL,
  `joinDate` date default NULL,
  `password` varchar(45) default NULL,
  `designation` varchar(45) default NULL,
  `department` varchar(45) default NULL,
  `gender` varchar(45) default NULL,
  `phone` varchar(45) default NULL,
  `birthDate` date default NULL,
  `address` varchar(45) default NULL,
  `imgUrl` varchar(45) default NULL,
  `education` varchar(45) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `professors`
--

/*!40000 ALTER TABLE `professors` DISABLE KEYS */;
INSERT INTO `professors` (`id`,`name`,`email`,`joinDate`,`password`,`designation`,`department`,`gender`,`phone`,`birthDate`,`address`,`imgUrl`,`education`) VALUES 
 (1,'Mohammad Moshaidul Islam','Mohammad@g,ail.com','2020-07-31','123','Principal','CSE','Male','01657597255','2020-10-03','Dhaka Bangladesh','sir.jpg','PHD'),
 (101,'Maruf Sir','maruf@gmail.com','2020-08-01','123','Professor','CSE','Male','01675987125','2020-10-04','Dhaka Bangladesh','Screenshot (42).jpg','PHD in Java'),
 (104,'Albert Einstein','seo@gmail.com',NULL,'11123','Professor','ENG-MENG','Male','1675972500','2020-07-31','Mugda para  dhaka','avatar-1.jpg','CSE-MSE'),
 (105,'Marie Curie','seo@gmail.com',NULL,'11123','Professor','ENG-MENG','Female','1675972500','2020-07-31','Mugda para  dhaka','avatar-2.jpg','CSE-MSE'),
 (106,'Isaac Newton','seo@gmail.com','2020-08-26','11123','Professor','ENG-MENG','Female','1675972500','2020-07-20','Mugda para  dhaka','avatar-3.jpg','CSE-MSE'),
 (107,'Charles Darwin','Mohammad@g,ail.com','2020-07-31','123','Principal','CSE','Male','01657597255','2020-10-03','Dhaka Bangladesh','avatar-1.jpg','PHD'),
 (108,'Nikola Tesla','seo@gmail.com','2020-08-15','123','Professor','CSE-MSE','Male','01675972500','2020-08-19','Mugda para  dhaka','avatar-4.jpg','BBA-MBA'),
 (109,'Mohammad Moshaidul Islam','Mohammad@g,ail.com','2020-07-31','123','Principal','CSE','Male','01657597255','2020-10-03','Dhaka Bangladesh','avatar-2.jpg','PHD'),
 (110,'Shariful  Islam','Mohammad@g,ail.com','2020-07-31','123','Principal','CSE','Male','01657597255','2020-10-03','Dhaka Bangladesh','avatar-3.jpg','PHD'),
 (112,'Galileo Galilei','seo@gmail.com','2020-08-20','123','Professor','ENG-MENG','Male','01675972500','2020-08-19','Mugda para  dhaka','avatar-2.jpg','CSE-MSE'),
 (113,'Ada Lovelace','seo@gmail.com','2020-08-20','123','Professor','ENG-MENG','Male','01675972500','2020-08-19','Mugda para  dhaka','avatar-1.jpg','CSE-MSE'),
 (114,'Pythagoras','seo@gmail.com','2020-08-20','123','Professor','ENG-MENG','Male','01675972500','2020-08-19','Mugda para  dhaka','avatar-2.jpg','CSE-MSE'),
 (115,'Abdul Bari Sir','seo@gmail.com','2020-08-20','123','Professor','ENG-MENG','Male','01675972500','2020-08-19','Mugda para  dhaka','avatar-3.jpg','CSE-MSE'),
 (116,'Ada Lovelace','seo@gmail.com','2020-08-05','123','Jr. Professor','CSE-MSE','Male','01675972500','2020-08-21','Mugda para  dhaka','avatar-4.jpg','BBA-MBA');
/*!40000 ALTER TABLE `professors` ENABLE KEYS */;


--
-- Definition of table `result`
--

DROP TABLE IF EXISTS `result`;
CREATE TABLE `result` (
  `id` int(10) unsigned NOT NULL auto_increment,
  `studentsId` varchar(45) default NULL,
  `name` varchar(45) default NULL,
  `facultyName` varchar(45) default NULL,
  `departmentName` varchar(45) default NULL,
  `batchName` varchar(45) default NULL,
  `coursesName` varchar(45) default NULL,
  `courseCode` varchar(45) default NULL,
  `classTest` int(10) default NULL,
  `midTerm` int(10) default NULL,
  `finalExm` int(10) default NULL,
  `total` int(10) default NULL,
  `greatPoint` varchar(45) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `result`
--

/*!40000 ALTER TABLE `result` DISABLE KEYS */;
INSERT INTO `result` (`id`,`studentsId`,`name`,`facultyName`,`departmentName`,`batchName`,`coursesName`,`courseCode`,`classTest`,`midTerm`,`finalExm`,`total`,`greatPoint`) VALUES 
 (25,'123302233','Asiqur Rahaman','School of Business & Economics',NULL,'33-Batch','Principal Of Marketing','MKT-101',15,24,45,84,'A'),
 (26,'123302234','Sharmin Jhan','School of Business & Economics',NULL,'33-Batch','Principal Of Marketing','MKT-101',15,24,45,84,'A'),
 (27,'123302235','Rakib Khan','School of Business & Economics',NULL,'33-Batch','Principal Of Marketing','MKT-101',15,10,10,35,'F'),
 (29,'123302233','Asiqur Rahaman','School of Business & Economics',NULL,'33-Batch','Principal Of Marketing','MKT-101',15,24,45,84,'A'),
 (30,'123302234','Sharmin Jhan','School of Business & Economics',NULL,'33-Batch','Principal Of Marketing','MKT-101',15,24,45,84,'A'),
 (31,'123302235','Rakib Khan','School of Business & Economics',NULL,'33-Batch','Principal Of Marketing','MKT-101',10,10,20,40,'D'),
 (33,'123302236','Shanur Nahid','School of Business & Economics',NULL,'33-Batch','Finance II','MKT-101',20,25,45,90,'A'),
 (34,'123302233','Asiqur Rahaman','School of Business & Economics',NULL,'02-Batch','Accounting','ACT-102',15,24,45,84,'A'),
 (35,'123302236','Shanur Nahid','School of Business & Economics',NULL,'02-Batch','Accounting','ACT-102',15,20,20,55,'C'),
 (36,'123302233','Asiqur Rahaman','School of Business & Economics',NULL,'33-Batch','Principal Of Marketing','MKT-101',15,24,45,84,'A'),
 (37,'123302234','Sharmin Jhan','School of Business & Economics',NULL,'33-Batch','Principal Of Marketing','MKT-101',15,24,45,84,'A'),
 (38,'123302235','Rakib Khan','School of Business & Economics',NULL,'33-Batch','Principal Of Marketing','MKT-101',10,10,10,30,'F'),
 (39,'123302236','Shanur Nahid','School of Business & Economics',NULL,'33-Batch','Principal Of Marketing','MKT-101',15,24,35,74,'A-');
/*!40000 ALTER TABLE `result` ENABLE KEYS */;


--
-- Definition of table `semester`
--

DROP TABLE IF EXISTS `semester`;
CREATE TABLE `semester` (
  `semesterId` int(11) NOT NULL auto_increment,
  `semesterName` varchar(255) default NULL,
  `batchName` varchar(255) default NULL,
  `facultyName` varchar(45) default NULL,
  `departmentName` varchar(45) default NULL,
  PRIMARY KEY  (`semesterId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `semester`
--

/*!40000 ALTER TABLE `semester` DISABLE KEYS */;
INSERT INTO `semester` (`semesterId`,`semesterName`,`batchName`,`facultyName`,`departmentName`) VALUES 
 (1,'Spring','33-Batch','Accounting & Finance','Accounting & Finance'),
 (2,'Summer','42-Batch','Accounting & Finance','Accounting & Finance'),
 (3,'Fall','33-Batch','Accounting & Finance','Accounting & Finance'),
 (4,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `semester` ENABLE KEYS */;


--
-- Definition of table `studentaccount`
--

DROP TABLE IF EXISTS `studentaccount`;
CREATE TABLE `studentaccount` (
  `id` int(10) unsigned NOT NULL auto_increment,
  `studentsId` varchar(45) default NULL,
  `name` varchar(45) default NULL,
  `facultyName` varchar(45) default NULL,
  `departmentName` varchar(45) default NULL,
  `batchName` varchar(45) default NULL,
  `semesterName` varchar(45) default NULL,
  `coursesName` varchar(45) default NULL,
  `courseCode` varchar(45) default NULL,
  `courseCradit` int(10) unsigned default NULL,
  `coursePrice` int(10) unsigned default NULL,
  `professorName` varchar(45) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `studentaccount`
--

/*!40000 ALTER TABLE `studentaccount` DISABLE KEYS */;
INSERT INTO `studentaccount` (`id`,`studentsId`,`name`,`facultyName`,`departmentName`,`batchName`,`semesterName`,`coursesName`,`courseCode`,`courseCradit`,`coursePrice`,`professorName`) VALUES 
 (1,'123302236','Shanur Nahid','School of Business & Economics','Marketing & International Business','33-Batch','MD.Razib','Principal Of Marketing','MKT-101',6,4500,'Isaac Newton'),
 (3,'123302235','Rakib Khan','School of Business & Economics','Marketing & International Business','33-Batch','MD.Razib','Principal Of Marketing','MKT-101',6,4500,'Isaac Newton'),
 (4,'123302234','Sharmin Jhan','School of Business & Economics','Marketing & International Business','33-Batch','MD.Razib','Principal Of Marketing','MKT-101',6,4500,'Isaac Newton'),
 (5,'123302233','Asiqur Rahaman','School of Business & Economics','Marketing & International Business','33-Batch','MD.Razib','Principal Of Marketing','MKT-101',6,4500,'Isaac Newton'),
 (6,'123302233','Asiqur Rahaman','School of Business & Economics','Accounting & Finance','02-Batch','Md. Rajib Hossiain ','Accounting','ACT-102',6,7500,'Albert Einstein'),
 (7,'123302236','Shanur Nahid','School of Business & Economics','Accounting & Finance','02-Batch','Md. Rajib Hossiain ','Accounting','ACT-102',6,7500,'Albert Einstein'),
 (9,'123302236','Shanur Nahid','School of Business & Economics','Accounting & Finance','33-Batch','MD.Razib','Finance II','MKT-101',6,4500,'Maruf Sir');
/*!40000 ALTER TABLE `studentaccount` ENABLE KEYS */;


--
-- Definition of table `students`
--

DROP TABLE IF EXISTS `students`;
CREATE TABLE `students` (
  `studentsId` int(10) unsigned NOT NULL auto_increment,
  `name` varchar(45) default NULL,
  `email` varchar(45) default NULL,
  `password` varchar(45) default NULL,
  `gender` varchar(45) default NULL,
  `phone` varchar(45) default NULL,
  `birthDate` date default NULL,
  `address` varchar(45) default NULL,
  `department` varchar(45) default NULL,
  `registrationDate` date default NULL,
  `imgUrl` varchar(45) default NULL,
  PRIMARY KEY  (`studentsId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `students`
--

/*!40000 ALTER TABLE `students` DISABLE KEYS */;
INSERT INTO `students` (`studentsId`,`name`,`email`,`password`,`gender`,`phone`,`birthDate`,`address`,`department`,`registrationDate`,`imgUrl`) VALUES 
 (123302231,'Shariful Islam','shariful@gmail.com','123','Male','01675977785','2019-12-30','Dhaka Bangladesh','BBA-MBA','2020-12-06','avatar-7.jpg'),
 (123302232,'Arif Khan','seo@gmail.com','123','Male','01675972500','2020-08-21','Mugda para  dhaka','CSE-MSE','2020-08-20','avatar-6.jpg'),
 (123302233,'Sharmin Jhan','seo@gmail.com','123','Male','01675972500','2020-08-20','Mugda para  dhaka','BBA-MBA','2020-08-20','avatar-5.jpg'),
 (123302234,'Asiqur Rahaman','seo@gmail.com','123','Male','01675972500','2020-08-19','Mugda para  dhaka','BBA-MBA','2020-08-21','avatar-2.jpg'),
 (123302235,'Rakib Khan','rakib@gmail.com','123','Male','01675972500','2020-08-21','Mugda para  dhaka','BBA-MBA','2020-08-15','avatar-3.jpg'),
 (123302236,'Shanur Nahid','sharun@test,com','123','Male','01675972500','2020-08-26','Mugda para  dhaka','BBA-MBA','2020-08-16','avatar-9.jpg');
/*!40000 ALTER TABLE `students` ENABLE KEYS */;


--
-- Definition of table `university`
--

DROP TABLE IF EXISTS `university`;
CREATE TABLE `university` (
  `university_id` int(10) unsigned NOT NULL auto_increment,
  `u_name` varchar(45) NOT NULL,
  `u_address` varchar(45) NOT NULL,
  `u_phone` varchar(45) NOT NULL,
  `u_logo` varchar(45) NOT NULL,
  PRIMARY KEY  (`university_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `university`
--

/*!40000 ALTER TABLE `university` DISABLE KEYS */;
/*!40000 ALTER TABLE `university` ENABLE KEYS */;


--
-- Definition of table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `role_id` int(10) unsigned NOT NULL default '0',
  `role_name` varchar(45) default NULL,
  PRIMARY KEY  (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_role`
--

/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` (`role_id`,`role_name`) VALUES 
 (1,'admin'),
 (2,'student'),
 (3,'faculty');
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;


--
-- Definition of table `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` int(10) unsigned NOT NULL auto_increment,
  `username` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `firstName` varchar(45) NOT NULL,
  `lastName` varchar(45) NOT NULL,
  `token` varchar(45) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` (`id`,`username`,`email`,`password`,`firstName`,`lastName`,`token`) VALUES 
 (101,'shariful','shariful@gmail.com','123','shariful','islam','admin'),
 (102,'sharur','shariful@gmail.com','123','shanur','nahid','admin'),
 (103,'abir','abir@gmail.com','123','ragho','abir','user');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
