-- phpMyAdmin SQL Dump
-- version 4.0.4
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Jan 19, 2014 at 12:35 PM
-- Server version: 5.6.12-log
-- PHP Version: 5.4.12

-- DB: core5429_tomcat
-- User: core5429_tomcat
-- Pass: nNTTsq8VZnTnLh9q

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `core5429_tomcat`
--
CREATE DATABASE IF NOT EXISTS `core5429_tomcat` DEFAULT CHARACTER SET utf8 COLLATE utf8_bin;
USE `core5429_tomcat`;

-- --------------------------------------------------------

--
-- Table structure for table `dept`
--

CREATE TABLE IF NOT EXISTS `dept` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `head` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `name` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UQ__dept__000000000000000C` (`id`),
  UNIQUE KEY `UQ__dept__0000000000000011` (`name`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=3 ;

--
-- Dumping data for table `dept`
--

INSERT INTO `dept` (`id`, `head`, `name`) VALUES
(1, 'Намм Р. В.', 'Программное обеспечение ВТ и АС'),
(2, 'Ри Хосен', 'ЛИТЕЙНОЕ ПРОИЗВОДСТВО И ТЕХНОЛОГИЯ МЕТАЛЛОВ');

-- --------------------------------------------------------

--
-- Table structure for table `disc`
--

CREATE TABLE IF NOT EXISTS `disc` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UQ__disc__000000000000004E` (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=5 ;

--
-- Dumping data for table `disc`
--

INSERT INTO `disc` (`id`, `name`) VALUES
(1, 'Информатика'),
(2, 'Методология программной инженерии'),
(3, 'Экономическое обоснование проектов и исследований'),
(4, 'Обработка и защита данных');

-- --------------------------------------------------------

--
-- Table structure for table `flow`
--

CREATE TABLE IF NOT EXISTS `flow` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(128) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UQ__flow__000000000000001F` (`id`),
  UNIQUE KEY `UQ__flow__0000000000000024` (`name`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=3 ;

--
-- Dumping data for table `flow`
--

INSERT INTO `flow` (`id`, `name`) VALUES
(1, 'Дневное отделение ПО 21-22'),
(2, 'Заочное отделение ПО 21-22');

-- --------------------------------------------------------

--
-- Table structure for table `sem`
--

CREATE TABLE IF NOT EXISTS `sem` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UQ__sem__0000000000000032` (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=4 ;

--
-- Dumping data for table `sem`
--

INSERT INTO `sem` (`id`, `name`) VALUES
(1, 'Осенний семестр 2002/03 уч. года'),
(2, 'Весенний семестр 2002/03 уч. года'),
(3, 'Осенний семестр 2003/04 уч. года');

-- --------------------------------------------------------

--
-- Table structure for table `teacher`
--

CREATE TABLE IF NOT EXISTS `teacher` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UQ__teacher__0000000000000040` (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=3 ;

--
-- Dumping data for table `teacher`
--

INSERT INTO `teacher` (`id`, `name`) VALUES
(1, 'Андриенко Т. В.'),
(2, 'Федосеев А. А.');

-- --------------------------------------------------------

--
-- Table structure for table `report`
--

CREATE TABLE IF NOT EXISTS `report` (
  `id` int(11) not null AUTO_INCREMENT,
  `flow_id` int(11) not null,
  `disc_id` int(11) not null,
  `sem_id` int(11) not null,
  `dept_id` int(11) not null,
  `teacher_id` int(11) not null,
  
  PRIMARY KEY (`id`),
  UNIQUE KEY `UQ__report__0000000000001040` (`id`),
  
  foreign key(`flow_id`)
			references flow(id)
			on delete cascade,
  foreign key(`disc_id`)
			references disc(id)
			on delete cascade,
  foreign key(`sem_id`)
			references sem(id)
			on delete cascade,
  foreign key(`dept_id`)
			references dept(id)
			on delete cascade,
  foreign key(`teacher_id`)
			references teacher(id)
			on delete cascade
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dumping data for table `report`
--

INSERT INTO `report` (`flow_id`, `disc_id`, `sem_id`, `dept_id`, `teacher_id`) VALUES
(1, 1, 1, 1, 1);


-- --------------------------------------------------------

--
-- Table structure for table `report_entry`
--

CREATE TABLE IF NOT EXISTS `report_entry` (
  `id` int(11) not null AUTO_INCREMENT,
  `report_id` int(11) not null,

  `stud_count_plan` int(11) not null,
  `lection_count_plan` int(11) not null,
  `stud_count_fact` int(11) not null,
  `lection_count_fact` int(11) not null,

  PRIMARY KEY (`id`),
  UNIQUE KEY `UQ__report_entry__0000000000002040` (`id`),

  foreign key(`report_id`)
  references report(id)
    on delete cascade
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dumping data for table `report_entry`
--

INSERT INTO `report_entry` (`report_id`, `stud_count_plan`, `lection_count_plan`, `stud_count_fact`, `lection_count_fact`) VALUES
(1, 60, 0, 75, 10);


/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;


-- CREATE USER 'core5429_tomcat'@ '%' IDENTIFIED BY  'nNTTsq8VZnTnLh9q';
-- GRANT USAGE ON * . * TO  'core5429_tomcat'@ '%' IDENTIFIED BY  'nNTTsq8VZnTnLh9q' WITH MAX_QUERIES_PER_HOUR 0 MAX_CONNECTIONS_PER_HOUR 0 MAX_UPDATES_PER_HOUR 0 MAX_USER_CONNECTIONS 0 ;
-- GRANT ALL PRIVILEGES ON  `core5429\_tomcat` . * TO  'core5429_tomcat'@'%' WITH GRANT OPTION ;