-- phpMyAdmin SQL Dump
-- version 4.2.7.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Oct 20, 2015 at 10:55 AM
-- Server version: 5.6.20
-- PHP Version: 5.5.15

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
`id` int(11) NOT NULL,
  `fullname` varchar(100) CHARACTER SET latin1 COLLATE latin1_bin NOT NULL,
  `gender` varchar(10) CHARACTER SET latin1 COLLATE latin1_bin NOT NULL
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
  `movement_Id` int(11) NOT NULL
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
`artwork_id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `artist` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `artwork_movements`
--

CREATE TABLE IF NOT EXISTS `artwork_movements` (
`atrwork_id` int(11) NOT NULL,
  `movement_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `birth`
--

CREATE TABLE IF NOT EXISTS `birth` (
`birth_id` int(11) NOT NULL,
  `date` date NOT NULL,
  `artist_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `movements`
--

CREATE TABLE IF NOT EXISTS `movements` (
`id` int(11) NOT NULL,
  `name` varchar(100) CHARACTER SET latin1 COLLATE latin1_bin NOT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Dumping data for table `movements`
--

INSERT INTO `movements` (`id`, `name`) VALUES
(1, 'Geometry of Fear'),
(2, 'Kinetic Art'),
(3, 'New British Sculpture'),
(4, 'Romanticism');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `artists`
--
ALTER TABLE `artists`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `artist_movements`
--
ALTER TABLE `artist_movements`
 ADD PRIMARY KEY (`artist_id`,`movement_Id`);

--
-- Indexes for table `artworks`
--
ALTER TABLE `artworks`
 ADD PRIMARY KEY (`artwork_id`);

--
-- Indexes for table `artwork_movements`
--
ALTER TABLE `artwork_movements`
 ADD PRIMARY KEY (`atrwork_id`);

--
-- Indexes for table `birth`
--
ALTER TABLE `birth`
 ADD PRIMARY KEY (`birth_id`);

--
-- Indexes for table `movements`
--
ALTER TABLE `movements`
 ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `artists`
--
ALTER TABLE `artists`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `artworks`
--
ALTER TABLE `artworks`
MODIFY `artwork_id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `artwork_movements`
--
ALTER TABLE `artwork_movements`
MODIFY `atrwork_id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `birth`
--
ALTER TABLE `birth`
MODIFY `birth_id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `movements`
--
ALTER TABLE `movements`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=5;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
