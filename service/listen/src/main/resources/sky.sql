CREATE DATABASE  IF NOT EXISTS `sky_take_out` /*!40100 DEFAULT CHARACTER SET utf8 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `sky_take_out`;
-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: localhost    Database: sky_take_out
-- ------------------------------------------------------
-- Server version	8.0.28

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
-- Table structure for table `address_book`
--

DROP TABLE IF EXISTS `address_book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `address_book` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` bigint NOT NULL COMMENT '用户id',
  `consignee` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '收货人',
  `sex` varchar(2) COLLATE utf8_bin DEFAULT NULL COMMENT '性别',
  `phone` varchar(11) COLLATE utf8_bin NOT NULL COMMENT '手机号',
  `province_code` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '省级区划编号',
  `province_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '省级名称',
  `city_code` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '市级区划编号',
  `city_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '市级名称',
  `district_code` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '区级区划编号',
  `district_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '区级名称',
  `detail` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '详细地址',
  `label` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '标签',
  `is_default` tinyint(1) NOT NULL DEFAULT '0' COMMENT '默认 0 否 1是',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin COMMENT='地址簿';
/*!40101 SET character_set_client = @saved_cs_client */;

DROP TABLE IF EXISTS `station`;

CREATE TABLE `station` (
    `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
    `changeuuid` varchar(255) DEFAULT NULL COMMENT '电台变更唯一标识符',
    `stationuuid` varchar(255) DEFAULT NULL COMMENT '电台唯一标识符',
    `name` varchar(255) DEFAULT NULL COMMENT '电台名称',
    `url` varchar(255) DEFAULT NULL COMMENT '电台URL',
    `url_resolved` varchar(255) DEFAULT NULL COMMENT '解析后的电台URL',
    `homepage` varchar(255) DEFAULT NULL COMMENT '电台主页',
    `favicon` varchar(255) DEFAULT NULL COMMENT '电台图标',
    `tags` varchar(255) DEFAULT NULL COMMENT '电台标签',
    `country` varchar(255) DEFAULT NULL COMMENT '国家',
    `countrycode` varchar(255) DEFAULT NULL COMMENT '国家代码',
    `iso_3166_2` varchar(255) DEFAULT NULL COMMENT 'ISO 3166-2国家地区代码',
    `state` varchar(255) DEFAULT NULL COMMENT '州/省',
    `language` varchar(255) DEFAULT NULL COMMENT '语言',
    `languagecodes` varchar(255) DEFAULT NULL COMMENT '语言代码',
    `votes` int DEFAULT NULL COMMENT '投票数',
    `lastchangetime` datetime DEFAULT NULL COMMENT '最后变更时间',
    `lastchangetime_iso8601` datetime DEFAULT NULL COMMENT '最后变更时间(ISO8601格式)',
    `codec` varchar(255) DEFAULT NULL COMMENT '音频编码格式',
    `bitrate` int DEFAULT NULL COMMENT '比特率',
    `hls` int DEFAULT NULL COMMENT '是否支持HLS流媒体',
    `lastcheckok` int DEFAULT NULL COMMENT '最后检查是否成功',
    `lastchecktime` datetime DEFAULT NULL COMMENT '最后检查时间',
    `lastchecktime_iso8601` datetime DEFAULT NULL COMMENT '最后检查时间(ISO8601格式)',
    `lastcheckoktime` datetime DEFAULT NULL COMMENT '最后检查成功时间',
    `lastcheckoktime_iso8601` datetime DEFAULT NULL COMMENT '最后检查成功时间(ISO8601格式)',
    `lastlocalchecktime` datetime DEFAULT NULL COMMENT '最后本地检查时间',
    `lastlocalchecktime_iso8601` datetime DEFAULT NULL COMMENT '最后本地检查时间(ISO8601格式)',
    `clicktimestamp` datetime DEFAULT NULL COMMENT '点击时间戳',
    `clicktimestamp_iso8601` datetime DEFAULT NULL COMMENT '点击时间戳(ISO8601格式)',
    `clickcount` int DEFAULT NULL COMMENT '点击次数',
    `clicktrend` int DEFAULT NULL COMMENT '点击趋势',
    `ssl_error` int DEFAULT NULL COMMENT 'SSL错误',
    `geo_lat` double DEFAULT NULL COMMENT '纬度',
    `geo_long` double DEFAULT NULL COMMENT '经度',
    `geo_distance` double DEFAULT NULL COMMENT '距离',
    `has_extended_info` tinyint(1) DEFAULT NULL COMMENT '是否有扩展信息'
      PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='电台实体类';


DROP TABLE IF EXISTS `countries`;

CREATE TABLE `countries` (
    `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
    `name` varchar(255) DEFAULT NULL COMMENT '国家名称',
    `iso_3166_1` varchar(255) DEFAULT NULL COMMENT '国际编码',
    `stationcount` int DEFAULT NULL COMMENT '电台数量',
      PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='国家实体类';

DROP TABLE IF EXISTS `languages`;

CREATE TABLE `languages` (
                             `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
                             `name` varchar(255) DEFAULT NULL COMMENT '国家名称',
                             `iso_639` varchar(255) DEFAULT NULL COMMENT '国际编码',
                             `stationcount` int DEFAULT NULL COMMENT '电台数量',
                             PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='语言实体类';

DROP TABLE IF EXISTS `tags`;

CREATE TABLE `tags` (
     `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
     `name` varchar(255) DEFAULT NULL COMMENT '标签名称',
     `stationcount` int DEFAULT NULL COMMENT '电台数量',
     PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='标签实体类';

CREATE TABLE `users` (
                        `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
                        `name` varchar(255) DEFAULT NULL COMMENT '标签名称',
                        `sex` int DEFAULT NULL COMMENT '电台数量',
                        PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='标签实体类';