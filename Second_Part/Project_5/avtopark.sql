-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Хост: 127.0.0.1
-- Время создания: Май 19 2022 г., 05:27
-- Версия сервера: 10.4.24-MariaDB
-- Версия PHP: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT = @@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS = @@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION = @@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Data Base: `avtopark`
--
CREATE DATABASE IF NOT EXISTS `avtopark` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `avtopark`;

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`
(
    `ID`    int(11)                                NOT NULL,
    `login` varchar(13) COLLATE utf8mb4_unicode_ci NOT NULL,
    `pass`  varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`ID`, `login`, `pass`)
VALUES (1, 'Kek', '12345'),
       (55, 'Lol', '1234');

-- --------------------------------------------------------

--
-- Table structure for table `breaking`
--

DROP TABLE IF EXISTS `breaking`;
CREATE TABLE `breaking`
(
    `Date`      date       NOT NULL,
    `bus_id`    int(11)    NOT NULL,
    `id`        bigint(20) NOT NULL,
    `repair_id` bigint(11) NOT NULL
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci;

--
-- Dumping data for table `breaking`
--

INSERT INTO `breaking` (`Date`, `bus_id`, `id`, `repair_id`)
VALUES ('2021-07-22', 20, 27, 45),
       ('2021-07-23', 85, 28, 30),
       ('2021-07-22', 20, 29, 12),
       ('2022-07-22', 20, 30, 12);

-- --------------------------------------------------------

--
-- Table structure for table `bus`
--

DROP TABLE IF EXISTS `bus`;
CREATE TABLE `bus`
(
    `ID`   int(11)                                NOT NULL,
    `name` varchar(10) COLLATE utf8mb4_unicode_ci NOT NULL,
    `cost` int(10) UNSIGNED                       NOT NULL
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci;

--
-- Dumping data for table `bus`
--

INSERT INTO `bus` (`ID`, `name`, `cost`)
VALUES (20, 'small', 457),
       (45, 'medium', 852),
       (85, 'big', 984);

-- --------------------------------------------------------

--
-- Table structure for table `driver`
--

DROP TABLE IF EXISTS `driver`;
CREATE TABLE `driver`
(
    `ID`   int(11)                                NOT NULL,
    `name` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci;

--
-- Dumping data for table `driver`
--

INSERT INTO `driver` (`ID`, `name`)
VALUES (5, 'O`Donell'),
       (7, 'Hess'),
       (8, 'Doronin'),
       (12, 'Smith'),
       (55, 'Browning');

-- --------------------------------------------------------

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
CREATE TABLE `hibernate_sequence`
(
    `next_val` bigint(20) DEFAULT NULL
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci;

--
-- Dumping data for table `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`)
VALUES (81);

-- --------------------------------------------------------

--
-- Table structure for table `profit`
--

DROP TABLE IF EXISTS `profit`;
CREATE TABLE `profit`
(
    `Date`     date             NOT NULL,
    `bus_id`   int(11)          NOT NULL,
    `route_id` int(11)          NOT NULL,
    `profit`   int(10) UNSIGNED NOT NULL,
    `id`       bigint(20)       NOT NULL
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci;

--
-- Dumping data for table `profit`
--

INSERT INTO `profit` (`Date`, `bus_id`, `route_id`, `profit`, `id`)
VALUES ('2022-05-19', 45, 62, 2500, 2),
       ('2022-05-12', 20, 166, 1000, 9),
       ('2022-05-05', 20, 63, 1350, 10),
       ('2022-05-14', 85, 166, 2500, 11),
       ('2022-05-15', 85, 166, 1800, 13);

-- --------------------------------------------------------

--
-- Table structure for table `repai`
--

DROP TABLE IF EXISTS `repai`;
CREATE TABLE `repai`
(
    `ID`          bigint(20)                             NOT NULL,
    `name`        varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
    `consumption` int(11) UNSIGNED                       NOT NULL
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci;

--
-- Dumping data for table `repai`
--

INSERT INTO `repai` (`ID`, `name`, `consumption`)
VALUES (12, 'motor', 8500),
       (30, 'wheel', 3000),
       (45, 'brake', 1750);

-- --------------------------------------------------------

--
-- Table structure for table `route`
--

DROP TABLE IF EXISTS `route`;
CREATE TABLE `route`
(
    `ID`   int(11)                                NOT NULL,
    `name` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci;

--
-- Dumping data for table `route`
--

INSERT INTO `route` (`ID`, `name`)
VALUES (62, 'Century City - Downt'),
       (63, 'Chatsworth - Canoga '),
       (166, 'Canoga Av - Sun Vall');

-- --------------------------------------------------------

--
-- Table structure for table `work`
--

DROP TABLE IF EXISTS `work`;
CREATE TABLE `work`
(
    `Date`      date       NOT NULL,
    `bus_id`    int(11)    NOT NULL,
    `driver_id` int(11)    NOT NULL,
    `route_id`  int(11)    NOT NULL,
    `id`        bigint(20) NOT NULL
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci;

--
-- Dumping data for table `work`
--

INSERT INTO `work` (`Date`, `bus_id`, `driver_id`, `route_id`, `id`)
VALUES ('2021-07-23', 85, 12, 62, 9),
       ('2021-07-23', 20, 8, 63, 10),
       ('2021-07-30', 45, 8, 166, 11),
       ('2021-07-22', 85, 8, 62, 13);

--
-- Saved table indexes
--

--
-- Table indexes `admin`
--
ALTER TABLE `admin`
    ADD PRIMARY KEY (`ID`);

--
-- Table indexes `breaking`
--
ALTER TABLE `breaking`
    ADD PRIMARY KEY (`id`),
    ADD KEY `breaking_ibfk_1` (`bus_id`),
    ADD KEY `repair_id` (`repair_id`);

--
-- Table indexes `bus`
--
ALTER TABLE `bus`
    ADD PRIMARY KEY (`ID`);

--
-- Table indexes `driver`
--
ALTER TABLE `driver`
    ADD PRIMARY KEY (`ID`);

--
-- Table indexes `profit`
--
ALTER TABLE `profit`
    ADD PRIMARY KEY (`id`),
    ADD KEY `profit_ibfk_1` (`bus_id`),
    ADD KEY `profit_ibfk_2` (`route_id`);

--
-- Table indexes `repai`
--
ALTER TABLE `repai`
    ADD PRIMARY KEY (`ID`);

--
-- Table indexes `route`
--
ALTER TABLE `route`
    ADD PRIMARY KEY (`ID`);

--
-- Table indexes `work`
--
ALTER TABLE `work`
    ADD PRIMARY KEY (`id`),
    ADD KEY `work_ibfk_1` (`bus_id`),
    ADD KEY `work_ibfk_2` (`driver_id`),
    ADD KEY `work_ibfk_3` (`route_id`);

--
-- AUTO_INCREMENT for saved tables
--

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
    MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT,
    AUTO_INCREMENT = 81;

--
-- AUTO_INCREMENT for table `breaking`
--
ALTER TABLE `breaking`
    MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT,
    AUTO_INCREMENT = 31;

--
-- AUTO_INCREMENT for table `bus`
--
ALTER TABLE `bus`
    MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT,
    AUTO_INCREMENT = 86;

--
-- AUTO_INCREMENT for table `driver`
--
ALTER TABLE `driver`
    MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT,
    AUTO_INCREMENT = 80;

--
-- AUTO_INCREMENT for table `profit`
--
ALTER TABLE `profit`
    MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT,
    AUTO_INCREMENT = 14;

--
-- AUTO_INCREMENT for table `repai`
--
ALTER TABLE `repai`
    MODIFY `ID` bigint(20) NOT NULL AUTO_INCREMENT,
    AUTO_INCREMENT = 75;

--
-- AUTO_INCREMENT for table `route`
--
ALTER TABLE `route`
    MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT,
    AUTO_INCREMENT = 167;

--
-- AUTO_INCREMENT for table `work`
--
ALTER TABLE `work`
    MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT,
    AUTO_INCREMENT = 14;

--
-- Limitations of the external key of the saved tables
--

--
-- External key limits for table `breaking`
--
ALTER TABLE `breaking`
    ADD CONSTRAINT `breaking_ibfk_1` FOREIGN KEY (`bus_id`) REFERENCES `bus` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
    ADD CONSTRAINT `breaking_ibfk_2` FOREIGN KEY (`repair_id`) REFERENCES `repai` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- External key limits for table `profit`
--
ALTER TABLE `profit`
    ADD CONSTRAINT `profit_ibfk_1` FOREIGN KEY (`bus_id`) REFERENCES `bus` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
    ADD CONSTRAINT `profit_ibfk_2` FOREIGN KEY (`route_id`) REFERENCES `route` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- External key limits for table `work`
--
ALTER TABLE `work`
    ADD CONSTRAINT `work_ibfk_1` FOREIGN KEY (`bus_id`) REFERENCES `bus` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
    ADD CONSTRAINT `work_ibfk_2` FOREIGN KEY (`driver_id`) REFERENCES `driver` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
    ADD CONSTRAINT `work_ibfk_3` FOREIGN KEY (`route_id`) REFERENCES `route` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT = @OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS = @OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION = @OLD_COLLATION_CONNECTION */;
