-- phpMyAdmin SQL Dump
-- version 4.0.9
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Oct 28, 2015 at 11:40 AM
-- Server version: 5.5.34
-- PHP Version: 5.4.22

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `assignment1`
--

-- --------------------------------------------------------

--
-- Table structure for table `artists`
--

CREATE TABLE IF NOT EXISTS `artists` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fullname` varchar(100) CHARACTER SET latin1 COLLATE latin1_bin NOT NULL,
  `gender` varchar(10) CHARACTER SET latin1 COLLATE latin1_bin NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Dumping data for table `artists`
--

INSERT INTO `artists` (`id`, `fullname`, `gender`) VALUES
(1, 'Chadwick, Lynn', 'female'),
(2, 'Ono, Yoko', 'female'),
(3, 'Opie, Julian', 'male'),
(4, 'Etty, William', 'male'),
(5, 'Wallis, Henry', 'male');

-- --------------------------------------------------------

--
-- Table structure for table `artist_movements`
--

CREATE TABLE IF NOT EXISTS `artist_movements` (
  `artist_id` int(11) NOT NULL,
  `movement_Id` int(11) NOT NULL,
  PRIMARY KEY (`artist_id`,`movement_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `artist_movements`
--

INSERT INTO `artist_movements` (`artist_id`, `movement_Id`) VALUES
(1, 1),
(1, 2),
(3, 3),
(4, 4),
(5, 4);

-- --------------------------------------------------------

--
-- Table structure for table `artworks`
--

CREATE TABLE IF NOT EXISTS `artworks` (
  `artwork_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `artist` varchar(255) NOT NULL,
  PRIMARY KEY (`artwork_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `artwork_movements`
--

CREATE TABLE IF NOT EXISTS `artwork_movements` (
  `atrwork_id` int(11) NOT NULL AUTO_INCREMENT,
  `movement_id` int(11) NOT NULL,
  PRIMARY KEY (`atrwork_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `authorities`
--

CREATE TABLE IF NOT EXISTS `authorities` (
  `authority_id` int(11) NOT NULL AUTO_INCREMENT,
  `authority` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  PRIMARY KEY (`authority_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `birth`
--

CREATE TABLE IF NOT EXISTS `birth` (
  `birth_id` int(11) NOT NULL AUTO_INCREMENT,
  `date` date NOT NULL,
  `artist_id` int(11) NOT NULL,
  PRIMARY KEY (`birth_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `movements`
--

CREATE TABLE IF NOT EXISTS `movements` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) CHARACTER SET latin1 COLLATE latin1_bin NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Dumping data for table `movements`
--

INSERT INTO `movements` (`id`, `name`) VALUES
(1, 'Geometry of Fear'),
(2, 'Kinetic Art'),
(3, 'New British Sculpture'),
(4, 'Romanticism');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE IF NOT EXISTS `users` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `password` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
