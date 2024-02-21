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
-- Table structure for table `cuenta`
--

DROP TABLE IF EXISTS `cuenta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cuenta` (
  `numero_cuenta` int NOT NULL AUTO_INCREMENT,
  `fecha_apertura` date NOT NULL,
  `saldo` decimal(10,0) NOT NULL,
  `id_cliente` int NOT NULL,
  `estado` varchar(45) NOT NULL,
  PRIMARY KEY (`numero_cuenta`),
  UNIQUE KEY `numero_cuenta_UNIQUE` (`numero_cuenta`),
  KEY `id_cliente_idx` (`id_cliente`),
  CONSTRAINT `id_cliente` FOREIGN KEY (`id_cliente`) REFERENCES `cliente` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cuenta`
--

LOCK TABLES `cuenta` WRITE;
/*!40000 ALTER TABLE `cuenta` DISABLE KEYS */;
INSERT INTO `cuenta` VALUES (1,'2024-02-14',1000,8,'Activa'),(2,'2024-02-14',49500,9,'Activa'),(3,'2024-02-14',0,10,'Cancelada'),(7,'2024-02-17',24600,10,'Activa'),(8,'2024-02-17',4000,11,'Activa'),(9,'2024-02-17',80000,12,'Activa'),(10,'2024-02-17',367,13,'Activa'),(11,'2024-02-17',20,14,'Activa'),(12,'2024-02-17',202500,15,'Activa'),(13,'2024-02-19',700,10,'Activa'),(14,'2024-02-19',5000,10,'Activa'),(15,'2024-02-19',7000,10,'Activa'),(16,'2024-02-19',700,10,'Activa'),(17,'2024-02-19',600,10,'Activa'),(18,'2024-02-20',690,10,'Activa'),(19,'2024-02-20',0,10,'Cancelada'),(20,'2024-02-20',460400,10,'Activa'),(21,'2024-02-20',0,16,'Cancelada'),(22,'2024-02-20',1000000,16,'Activa');
/*!40000 ALTER TABLE `cuenta` ENABLE KEYS */;
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
