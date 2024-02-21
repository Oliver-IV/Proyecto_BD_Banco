-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: bd_banco
-- ------------------------------------------------------
-- Server version	8.0.35

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `retiro_sin_cuenta`
--

DROP TABLE IF EXISTS `retiro_sin_cuenta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `retiro_sin_cuenta` (
  `id_transaccion_ret` int NOT NULL,
  `contrasenia` varchar(8) NOT NULL,
  PRIMARY KEY (`id_transaccion_ret`),
  UNIQUE KEY `id_transaccion_UNIQUE` (`id_transaccion_ret`),
  CONSTRAINT `id_transaccion_ret` FOREIGN KEY (`id_transaccion_ret`) REFERENCES `transaccion` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `retiro_sin_cuenta`
--

LOCK TABLES `retiro_sin_cuenta` WRITE;
/*!40000 ALTER TABLE `retiro_sin_cuenta` DISABLE KEYS */;
INSERT INTO `retiro_sin_cuenta` VALUES (12,'42731807'),(13,'94550546'),(14,'22559770'),(15,'37358004'),(16,'64674841'),(17,'90619867'),(18,'21546496'),(19,'86240636'),(20,'50125110'),(21,'58485227'),(22,'18762634'),(23,'38858203'),(24,'32252449'),(25,'43204703'),(26,'24212441'),(27,'32722190'),(28,'91997387'),(29,'32504408'),(30,'80809150'),(31,'17867685'),(32,'13717498'),(33,'73515505'),(34,'10774784'),(35,'48733050'),(36,'47829440'),(37,'34531580'),(38,'77392200'),(39,'91438255'),(50,'62774042'),(52,'22591079'),(53,'59070521'),(55,'24564200');
/*!40000 ALTER TABLE `retiro_sin_cuenta` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-02-20 18:40:17
