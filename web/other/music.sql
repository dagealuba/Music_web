/*
SQLyog Ultimate v11.27 (32 bit)
MySQL - 5.1.73-community : Database - music
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`music` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `music`;

/*Table structure for table `album` */

DROP TABLE IF EXISTS `album`;

CREATE TABLE `album` (
  `albumid` varchar(32) NOT NULL,
  `albumname` varchar(20) NOT NULL,
  `singer` varchar(30) NOT NULL,
  PRIMARY KEY (`albumid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `album` */

/*Table structure for table `comment` */

DROP TABLE IF EXISTS `comment`;

CREATE TABLE `comment` (
  `commentid` varchar(32) NOT NULL,
  `musicid` varchar(32) NOT NULL,
  `comment` varchar(255) NOT NULL,
  `commenttime` date NOT NULL,
  `commenttocomment` varchar(32) NOT NULL,
  `likenumber` int(9) NOT NULL,
  PRIMARY KEY (`commentid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `comment` */

/*Table structure for table `history` */

DROP TABLE IF EXISTS `history`;

CREATE TABLE `history` (
  `historyid` varchar(32) NOT NULL,
  `userid` varchar(32) NOT NULL,
  `musicid` varchar(32) NOT NULL,
  PRIMARY KEY (`historyid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `history` */

/*Table structure for table `love` */

DROP TABLE IF EXISTS `love`;

CREATE TABLE `love` (
  `loveid` varchar(32) NOT NULL,
  `lovaname` varchar(20) NOT NULL,
  `userid` varchar(32) NOT NULL,
  `musicid` varchar(32) NOT NULL,
  PRIMARY KEY (`loveid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `love` */

/*Table structure for table `music` */

DROP TABLE IF EXISTS `music`;

CREATE TABLE `music` (
  `musicid` varchar(32) NOT NULL,
  `musicname` varchar(15) NOT NULL,
  `signer` varchar(30) NOT NULL,
  `albumid` varchar(32) NOT NULL,
  `lyricsrc` varchar(50) NOT NULL,
  `musicsrc` varchar(50) NOT NULL,
  `picsrc` varchar(50) NOT NULL,
  PRIMARY KEY (`musicid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `music` */

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `userid` varchar(32) NOT NULL,
  `username` varchar(30) NOT NULL,
  `userpassword` varchar(13) NOT NULL,
  `useremail` varchar(30) NOT NULL,
  `avatarsrc` varchar(50) NOT NULL,
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `user` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
