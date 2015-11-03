-- phpMyAdmin SQL Dump
-- version 4.2.7.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Nov 03, 2015 at 11:28 AM
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
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=8 ;

--
-- Dumping data for table `artists`
--

INSERT INTO `artists` (`id`, `fullname`, `gender`) VALUES
(1, 'Chadwick, Lynn', 'female'),
(2, 'Ono, Yoko', 'female'),
(3, 'Opie, Julian', 'male'),
(4, 'Etty, William', 'male'),
(5, 'Wallis, Henry', 'male'),
(6, 'Magdalena Abakanowicz', 'Female'),
(7, 'Lemuel Francis Abbott', 'Male');

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
-- Table structure for table `authorities`
--

CREATE TABLE IF NOT EXISTS `authorities` (
`authority_id` int(11) NOT NULL,
  `authority` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL
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
-- Table structure for table `comments`
--

CREATE TABLE IF NOT EXISTS `comments` (
`comment_id` int(11) NOT NULL,
  `artwork_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `comment` text NOT NULL,
  `timestamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
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

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE IF NOT EXISTS `users` (
`user_id` int(11) NOT NULL,
  `password` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

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
-- Indexes for table `authorities`
--
ALTER TABLE `authorities`
 ADD PRIMARY KEY (`authority_id`);

--
-- Indexes for table `birth`
--
ALTER TABLE `birth`
 ADD PRIMARY KEY (`birth_id`);

--
-- Indexes for table `comments`
--
ALTER TABLE `comments`
 ADD PRIMARY KEY (`comment_id`);

--
-- Indexes for table `movements`
--
ALTER TABLE `movements`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
 ADD PRIMARY KEY (`user_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `artists`
--
ALTER TABLE `artists`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=8;
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
-- AUTO_INCREMENT for table `authorities`
--
ALTER TABLE `authorities`
MODIFY `authority_id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `birth`
--
ALTER TABLE `birth`
MODIFY `birth_id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `comments`
--
ALTER TABLE `comments`
MODIFY `comment_id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `movements`
--
ALTER TABLE `movements`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
