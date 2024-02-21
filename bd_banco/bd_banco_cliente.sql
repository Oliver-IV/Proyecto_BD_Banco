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
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cliente` (
  `id` int NOT NULL AUTO_INCREMENT,
  `fecha_nacimiento` date NOT NULL,
  `edad` int NOT NULL,
  `contrasenia` varchar(45) NOT NULL,
  `id_domicilio` int NOT NULL,
  `id_nombre` int NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `id_domicilio_UNIQUE` (`id_domicilio`),
  UNIQUE KEY `id_nombre_UNIQUE` (`id_nombre`),
  KEY `id_domicilio_idx` (`id_domicilio`),
  KEY `id_nombre_idx` (`id_nombre`),
  CONSTRAINT `id_domicilio` FOREIGN KEY (`id_domicilio`) REFERENCES `domicilio` (`id`),
  CONSTRAINT `id_nombre` FOREIGN KEY (`id_nombre`) REFERENCES `nombre_completo` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (5,'2004-08-02',19,'Manzana123',7,6),(6,'2004-08-02',19,'Manzana123',8,7),(7,'2004-07-06',19,'Pera123',9,8),(8,'2004-07-06',19,'Pera123',10,9),(9,'2004-07-06',19,'Pera123',11,10),(10,'2004-07-06',19,'Guasave005',12,11),(11,'2004-07-06',19,'Manzana777',13,12),(12,'1979-11-12',44,'Vientos777',14,13),(13,'2004-04-04',19,'Gaelo007',15,14),(14,'2004-02-09',20,'SoyPaquito12',16,15),(15,'2000-06-14',23,'MrCalifornia69',17,16),(16,'2004-02-27',19,'ElGaeloesunwey',18,17);
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
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
