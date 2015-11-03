-- phpMyAdmin SQL Dump
-- version 4.5.0.2
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Nov 03, 2015 at 04:32 PM
-- Server version: 10.0.17-MariaDB
-- PHP Version: 5.6.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `assignment1`
--

-- --------------------------------------------------------

--
-- Table structure for table `artists`
--

CREATE TABLE `artists` (
  `id` int(11) NOT NULL,
  `fullname` varchar(100) CHARACTER SET latin1 COLLATE latin1_bin NOT NULL,
  `gender` varchar(10) CHARACTER SET latin1 COLLATE latin1_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `artists`
--

INSERT INTO `artists` (`id`, `fullname`, `gender`) VALUES
(1, 'Chadwick, Lynn', 'female'),
(2, 'Ono, Yoko', 'female'),
(3, 'Opie, Julian', 'male'),
(4, 'Etty, William', 'male'),
(5, 'Wallis, Henry', 'male'),
(6, 'Robert Delaunay', 'Male'),
(7, 'Robert Delaunay', 'Male'),
(8, 'Robert Delaunay', 'Male'),
(9, 'Robert Delaunay', 'Male'),
(992, 'Robert Delaunay', 'Male');

-- --------------------------------------------------------

--
-- Table structure for table `artist_movements`
--

CREATE TABLE `artist_movements` (
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
(5, 4),
(299, 992),
(314, 992);

-- --------------------------------------------------------

--
-- Table structure for table `artworks`
--

CREATE TABLE `artworks` (
  `artwork_id` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `artworks`
--

INSERT INTO `artworks` (`artwork_id`, `name`) VALUES
('A00067', 'Studies of a Sleeve');

-- --------------------------------------------------------

--
-- Table structure for table `artwork_artist`
--

CREATE TABLE `artwork_artist` (
  `artwork_id` varchar(255) NOT NULL,
  `artist_id` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `artwork_artist`
--

INSERT INTO `artwork_artist` (`artwork_id`, `artist_id`) VALUES
('A00067', '68');

-- --------------------------------------------------------

--
-- Table structure for table `artwork_movements`
--

CREATE TABLE `artwork_movements` (
  `artwork_id` varchar(255) NOT NULL,
  `movement_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `artwork_movements`
--

INSERT INTO `artwork_movements` (`artwork_id`, `movement_id`) VALUES
('A00067', 363);

-- --------------------------------------------------------

--
-- Table structure for table `authorities`
--

CREATE TABLE `authorities` (
  `authority_id` int(11) NOT NULL,
  `authority` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `birth`
--

CREATE TABLE `birth` (
  `birth_id` int(11) NOT NULL,
  `date` varchar(244) NOT NULL,
  `place` varchar(255) NOT NULL,
  `artist_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `birth`
--

INSERT INTO `birth` (`birth_id`, `date`, `place`, `artist_id`) VALUES
(992, '1885', 'Paris', 992);

-- --------------------------------------------------------

--
-- Table structure for table `movements`
--

CREATE TABLE `movements` (
  `id` int(11) NOT NULL,
  `name` varchar(100) CHARACTER SET latin1 COLLATE latin1_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `movements`
--

INSERT INTO `movements` (`id`, `name`) VALUES
(1, 'Geometry of Fear'),
(2, 'Kinetic Art'),
(3, 'New British Sculpture'),
(4, 'Romanticism'),
(299, 'Cubism'),
(314, 'Orphic Cubism'),
(363, 'Pre-Raphaelite Brotherhood');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `user_id` int(11) NOT NULL,
  `password` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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
-- Indexes for table `artwork_artist`
--
ALTER TABLE `artwork_artist`
  ADD PRIMARY KEY (`artwork_id`,`artist_id`);

--
-- Indexes for table `artwork_movements`
--
ALTER TABLE `artwork_movements`
  ADD PRIMARY KEY (`artwork_id`);

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
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=993;
--
-- AUTO_INCREMENT for table `authorities`
--
ALTER TABLE `authorities`
  MODIFY `authority_id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `birth`
--
ALTER TABLE `birth`
  MODIFY `birth_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=993;
--
-- AUTO_INCREMENT for table `movements`
--
ALTER TABLE `movements`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=364;
--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
