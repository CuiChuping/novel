CREATE DATABASE  IF NOT EXISTS `d_novel` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `d_novel`;
-- MySQL dump 10.13  Distrib 5.5.41, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: d_novel
-- ------------------------------------------------------
-- Server version	5.5.41-0ubuntu0.14.10.1

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
-- Table structure for table `t_books`
--

DROP TABLE IF EXISTS `t_books`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_books` (
  `id` char(32) NOT NULL DEFAULT '',
  `name` varchar(32) DEFAULT '',
  `category_id` char(32) DEFAULT '',
  `author` varchar(32) DEFAULT '',
  `word_count` int(20) DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `status` int(8) DEFAULT NULL,
  `file_path` varchar(100) DEFAULT '',
  `image_path` varchar(100) DEFAULT '',
  `desc` varchar(1000) DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_books`
--

LOCK TABLES `t_books` WRITE;
/*!40000 ALTER TABLE `t_books` DISABLE KEYS */;
INSERT INTO `t_books` VALUES ('ff8081815089680f015089680fb60000','完美世界','ff808181508967650150896765d70000','microc',200,'2015-10-21 15:58:29',NULL,'/mnt/books/file/ff8081815089680f015089680fb60000','/mnt/books/image/001.jpg','这是描述...');
/*!40000 ALTER TABLE `t_books` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_category`
--

DROP TABLE IF EXISTS `t_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_category` (
  `id` char(32) NOT NULL DEFAULT '',
  `name` varchar(32) NOT NULL DEFAULT '',
  `index` int(10) DEFAULT NULL,
  `url` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_category`
--

LOCK TABLES `t_category` WRITE;
/*!40000 ALTER TABLE `t_category` DISABLE KEYS */;
INSERT INTO `t_category` VALUES ('ff808181508ecb2901508ecb29190000','玄幻魔法',0,NULL),('ff808181508ecb2901508ecb29700001','武侠修真',1,NULL),('ff808181508ecb2901508ecb29720002','都市言情',2,NULL),('ff808181508ecb2901508ecb29740003','女生穿越',3,NULL),('ff808181508ecb2901508ecb29750004','侦探推理',4,NULL),('ff808181508ecb2901508ecb29780005','网游动漫',5,NULL),('ff808181508ecb2901508ecb297a0006','科幻小说',6,NULL),('ff808181508ecb2901508ecb297c0007','恐怖灵异',7,NULL),('ff808181508ecb2901508ecb29840008','耽美同人',8,NULL),('ff808181508ecb2901508ecb29870009','历史军事',9,NULL);
/*!40000 ALTER TABLE `t_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_chapter`
--

DROP TABLE IF EXISTS `t_chapter`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_chapter` (
  `id` char(32) NOT NULL DEFAULT '',
  `name` varchar(32) DEFAULT '',
  `book_id` varchar(32) DEFAULT '',
  `position` int(15) DEFAULT NULL,
  `length` int(10) DEFAULT NULL,
  `index` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_chapter`
--

LOCK TABLES `t_chapter` WRITE;
/*!40000 ALTER TABLE `t_chapter` DISABLE KEYS */;
INSERT INTO `t_chapter` VALUES ('ff80818150896a6c0150896a6ce10000','第一章 Xxxxx','ff8081815089680f015089680fb60000',0,31,1),('ff80818150896a6c0150896a6d7f0001','第二章 Xxxxx','ff8081815089680f015089680fb60000',31,31,2),('ff80818150896a6c0150896a6d880002','第三章 Xxxxx','ff8081815089680f015089680fb60000',62,31,3),('ff80818150896c5c0150896c5c340000','第四章 Xxxxx','ff8081815089680f015089680fb60000',205,21,4),('ff80818150896c5c0150896c5cd20001','第五章 Xxxxx','ff8081815089680f015089680fb60000',102,61,5),('ff808181508970c001508970c08f0000','第四章 Xxxxx','ff8081815089680f015089680fb60000',226,9,4),('ff808181508970c001508970c1170001','第五章 Xxxxx','ff8081815089680f015089680fb60000',235,61,5);
/*!40000 ALTER TABLE `t_chapter` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;


DROP TABLE IF EXISTS `t_suggestion`;

CREATE TABLE `t_suggestion` (
  `id` varchar(32) NOT NULL DEFAULT '',
  `contact_way` text(0) ,
  `suggestion` varchar(500) DEFAULT '',
  `create_time` time DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dump completed on 2015-10-22 20:56:02
