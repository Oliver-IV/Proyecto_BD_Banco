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
-- Table structure for table `transaccion`
--

DROP TABLE IF EXISTS `transaccion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `transaccion` (
  `id` int NOT NULL AUTO_INCREMENT,
  `monto` int NOT NULL,
  `folio` int NOT NULL,
  `fecha` date NOT NULL,
  `num_cuenta_cliente` int NOT NULL,
  `estado` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `num_cuenta_cliente_idx` (`num_cuenta_cliente`),
  CONSTRAINT `num_cuenta_cliente` FOREIGN KEY (`num_cuenta_cliente`) REFERENCES `cuenta` (`numero_cuenta`)
) ENGINE=InnoDB AUTO_INCREMENT=59 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transaccion`
--

LOCK TABLES `transaccion` WRITE;
/*!40000 ALTER TABLE `transaccion` DISABLE KEYS */;
INSERT INTO `transaccion` VALUES (4,200,700861,'2024-02-15',3,'Cobrado'),(5,200,993942,'2024-02-15',3,'Cobrado'),(6,200,737205,'2024-02-15',3,'Cobrado'),(7,200,414774,'2024-02-15',3,'Cobrado'),(8,200,768349,'2024-02-15',3,'Cobrado'),(9,200,680017,'2024-02-15',3,'Cobrado'),(10,200,42575,'2024-02-15',3,'Cobrado'),(11,200,30770,'2024-02-15',3,'Cobrado'),(12,200,809102,'2024-02-15',3,'Cobrado'),(13,200,856085,'2024-02-15',3,'Cobrado'),(14,200,124316,'2024-02-15',3,'Cobrado'),(15,200,920200,'2024-02-15',3,'Cobrado'),(16,500,22008,'2024-02-15',2,'Cobrado'),(17,1000,743036,'2024-02-15',3,'Cobrado'),(18,1000,303424,'2024-02-15',3,'Cobrado'),(19,200,135729,'2024-02-15',3,'Cobrado'),(20,200,452327,'2024-02-15',3,'Cobrado'),(21,200,997182,'2024-02-15',3,'Cobrado'),(22,500,614553,'2024-02-15',3,'Cobrado'),(23,400,889062,'2024-02-15',3,'Cobrado'),(24,1000,546321,'2024-02-15',3,'Cobrado'),(25,6565,788266,'2024-02-15',3,'Cobrado'),(26,10,776000,'2024-02-16',3,'Cobrado'),(27,233,458162,'2024-02-16',3,'Cobrado'),(28,150,885886,'2024-02-17',3,'Cobrado'),(29,0,354632,'2024-02-17',3,'Pendiente'),(30,150,435606,'2024-02-17',3,'Pendiente'),(31,150,143609,'2024-02-17',3,'Pendiente'),(32,150,612224,'2024-02-17',3,'Pendiente'),(33,150,173850,'2024-02-17',3,'Pendiente'),(34,150,973108,'2024-02-17',3,'Pendiente'),(35,150,187271,'2024-02-17',3,'Pendiente'),(36,100,59643,'2024-02-17',3,'Pendiente'),(37,500,717087,'2024-02-17',7,'Cobrado'),(38,100,439765,'2024-02-17',3,'Pendiente'),(39,500,38505,'2024-02-17',7,'Pendiente'),(40,2000,956263,'2024-02-18',3,'Pendiente'),(41,2000,549115,'2024-02-18',7,'Pendiente'),(42,2000,947051,'2024-02-18',7,'Pendiente'),(43,2000,947051,'2024-02-18',7,'Pendiente'),(44,2000,592282,'2024-02-18',3,'Pendiente'),(45,2000,203492,'2024-02-18',7,'Pendiente'),(46,2000,648746,'2024-02-18',3,'Pendiente'),(47,2000,302867,'2024-02-18',3,'Pendiente'),(48,2000,479753,'2024-02-18',3,'Pendiente'),(49,2000,361672,'2024-02-18',3,'Cobrado'),(50,500,947788,'2024-02-19',3,'Pendiente'),(51,500,78343,'2024-02-20',7,'Cobrado'),(52,400,738227,'2024-02-20',19,'Pendiente'),(53,20,48976,'2024-02-20',19,'Pendiente'),(54,200000,828255,'2024-02-20',20,'Cobrado'),(55,20000,483874,'2024-02-20',20,'Pendiente'),(56,20000,46699,'2024-02-20',20,'Cobrado'),(57,100,243946,'2024-02-20',7,'Cobrado'),(58,400,959560,'2024-02-20',7,'Cobrado');
/*!40000 ALTER TABLE `transaccion` ENABLE KEYS */;
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
