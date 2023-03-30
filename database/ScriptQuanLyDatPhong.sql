CREATE DATABASE  IF NOT EXISTS `quanlydatphong` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `quanlydatphong`;
-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: localhost    Database: quanlydatphong
-- ------------------------------------------------------
-- Server version	8.0.32

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
-- Table structure for table `chi_tiet_su_dung_dich_vu`
--

DROP TABLE IF EXISTS `chi_tiet_su_dung_dich_vu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `chi_tiet_su_dung_dich_vu` (
  `MaDatPhong` int NOT NULL,
  `MaDichVu` int NOT NULL,
  `SoLuong` int DEFAULT NULL,
  PRIMARY KEY (`MaDatPhong`,`MaDichVu`),
  KEY `MaDichVu_idx` (`MaDichVu`),
  CONSTRAINT `MaDatPhong` FOREIGN KEY (`MaDatPhong`) REFERENCES `dat_phong` (`MaDatPhong`),
  CONSTRAINT `MaDichVu` FOREIGN KEY (`MaDichVu`) REFERENCES `dich_vu_di_kem` (`MaDichVu`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chi_tiet_su_dung_dich_vu`
--

LOCK TABLES `chi_tiet_su_dung_dich_vu` WRITE;
/*!40000 ALTER TABLE `chi_tiet_su_dung_dich_vu` DISABLE KEYS */;
INSERT INTO `chi_tiet_su_dung_dich_vu` VALUES (2,1,20),(2,2,10),(3,4,10),(4,5,9),(5,6,11);
/*!40000 ALTER TABLE `chi_tiet_su_dung_dich_vu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dat_phong`
--

DROP TABLE IF EXISTS `dat_phong`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dat_phong` (
  `MaDatPhong` int NOT NULL,
  `MaPhong` int NOT NULL,
  `MaKhachHang` int NOT NULL,
  `NgayDat` date DEFAULT NULL,
  `GioBatDau` time DEFAULT NULL,
  `GioKetThuc` time DEFAULT NULL,
  `TienDatCoc` double DEFAULT NULL,
  `GhiChu` varchar(45) DEFAULT NULL,
  `TrangThaiDat` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`MaDatPhong`),
  KEY `MaKhachHang_idx` (`MaKhachHang`),
  KEY `MaPhong_idx` (`MaPhong`),
  CONSTRAINT `MaKhachHang` FOREIGN KEY (`MaKhachHang`) REFERENCES `khach_hang` (`MaKhachHang`),
  CONSTRAINT `MaPhong` FOREIGN KEY (`MaPhong`) REFERENCES `phong` (`MaPhong`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dat_phong`
--

LOCK TABLES `dat_phong` WRITE;
/*!40000 ALTER TABLE `dat_phong` DISABLE KEYS */;
INSERT INTO `dat_phong` VALUES (1,1,1,'2017-10-10','09:21:00','09:30:00',54000,'DaHuy','DaDat'),(2,2,1,'2016-09-09','09:26:00','10:00:00',2000,'DaDat','DaDat'),(3,4,2,'2023-10-10','09:30:00','09:45:00',52000,'DaDat','DaDat'),(4,4,2,'2027-10-10','09:20:00','09:30:00',2300,'DaDat','DaDat'),(5,4,3,'2022-09-09','09:30:00','10:00:00',1000,'DaHuy','DaDat'),(6,6,3,'2021-10-10','10:10:00','11:00:00',2000,'DaDat','DaDat');
/*!40000 ALTER TABLE `dat_phong` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dich_vu_di_kem`
--

DROP TABLE IF EXISTS `dich_vu_di_kem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dich_vu_di_kem` (
  `MaDichVu` int NOT NULL,
  `TenDichVu` varchar(45) DEFAULT NULL,
  `DonViTinh` varchar(45) DEFAULT NULL,
  `DonGia` double DEFAULT NULL,
  PRIMARY KEY (`MaDichVu`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dich_vu_di_kem`
--

LOCK TABLES `dich_vu_di_kem` WRITE;
/*!40000 ALTER TABLE `dich_vu_di_kem` DISABLE KEYS */;
INSERT INTO `dich_vu_di_kem` VALUES (1,'Room service','cai',110000),(2,'Spa','lon',40000),(3,'Hồ bơi','1',4000),(4,'Gym','1',5000),(5,'Dv đưa đón','1',6000),(6,'Dv ăn uống','1',2000);
/*!40000 ALTER TABLE `dich_vu_di_kem` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `khach_hang`
--

DROP TABLE IF EXISTS `khach_hang`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `khach_hang` (
  `MaKhachHang` int NOT NULL,
  `TenKhachHang` varchar(45) DEFAULT NULL,
  `DiaChi` varchar(45) DEFAULT NULL,
  `SoDT` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`MaKhachHang`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `khach_hang`
--

LOCK TABLES `khach_hang` WRITE;
/*!40000 ALTER TABLE `khach_hang` DISABLE KEYS */;
INSERT INTO `khach_hang` VALUES (1,'Duong Dung','Hoa Xuan','025566995'),(2,'Nguyen Bao','Hue','25566688'),(3,'Truong Quoc','DakNong','585555566'),(4,'Nguyen Tan Gia Bao','Hue','5656655');
/*!40000 ALTER TABLE `khach_hang` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `phong`
--

DROP TABLE IF EXISTS `phong`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `phong` (
  `MaPhong` int NOT NULL,
  `LoaiPhong` varchar(45) DEFAULT NULL,
  `SoKhachToiDa` varchar(45) DEFAULT NULL,
  `GiaPhong` double DEFAULT NULL,
  `MoTa` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`MaPhong`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `phong`
--

LOCK TABLES `phong` WRITE;
/*!40000 ALTER TABLE `phong` DISABLE KEYS */;
INSERT INTO `phong` VALUES (1,'Phòng đơn','1',12000,'phòng đơn'),(2,'Phòng đôi','2',12000,'Phòng đôi'),(3,'Phòng gia đình','5',13000,'phòng gia đình'),(4,'deluxe','3',2000,'deluxe'),(5,'phòng tổng thống','5',52000,'phòng tổng thống'),(6,'luxury','11',140000,'luxury');
/*!40000 ALTER TABLE `phong` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-03-30 11:01:33
