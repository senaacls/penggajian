-- phpMyAdmin SQL Dump
-- version 4.6.6deb5
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Dec 05, 2017 at 04:55 AM
-- Server version: 5.7.20-0ubuntu0.17.10.1
-- PHP Version: 7.1.8-1ubuntu1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `penggajian`
--

-- --------------------------------------------------------

--
-- Table structure for table `gajian`
--

CREATE TABLE `gajian` (
  `notransaksi` varchar(10) NOT NULL,
  `tanggal` date NOT NULL,
  `periodebulan` varchar(2) DEFAULT NULL,
  `periodetahun` varchar(4) DEFAULT NULL,
  `nip` varchar(10) NOT NULL,
  `jmljamkerja` int(11) DEFAULT NULL,
  `potongan_pph` decimal(18,2) NOT NULL,
  `potongan_pinjaman` decimal(18,2) NOT NULL,
  `potongan_jamkerja` decimal(18,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `gajian`
--

INSERT INTO `gajian` (`notransaksi`, `tanggal`, `periodebulan`, `periodetahun`, `nip`, `jmljamkerja`, `potongan_pph`, `potongan_pinjaman`, `potongan_jamkerja`) VALUES
('N0001', '2017-12-05', '11', '2017', '10001', 0, '700000.00', '100000.00', '30000.00');

-- --------------------------------------------------------

--
-- Table structure for table `jabatan`
--

CREATE TABLE `jabatan` (
  `kodejabatan` varchar(5) NOT NULL,
  `keterangan` varchar(50) NOT NULL,
  `gapok` decimal(18,2) NOT NULL,
  `tjabatan` decimal(18,2) NOT NULL,
  `transport` decimal(18,2) NOT NULL,
  `tmakan` decimal(18,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `jabatan`
--

INSERT INTO `jabatan` (`kodejabatan`, `keterangan`, `gapok`, `tjabatan`, `transport`, `tmakan`) VALUES
('J0001', 'Senior Engineer', '8000000.00', '2000000.00', '500000.00', '200000.00'),
('J0002', 'Assistant Engineer', '6000000.00', '1500000.00', '300000.00', '150000.00'),
('J0003', 'Staff', '3500000.00', '1000000.00', '200000.00', '100000.00');

-- --------------------------------------------------------

--
-- Table structure for table `karyawan`
--

CREATE TABLE `karyawan` (
  `nip` varchar(10) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `jekel` int(11) NOT NULL,
  `tmplahir` varchar(50) NOT NULL,
  `tgl_lahir` date NOT NULL,
  `kodejabatan` varchar(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `karyawan`
--

INSERT INTO `karyawan` (`nip`, `nama`, `jekel`, `tmplahir`, `tgl_lahir`, `kodejabatan`) VALUES
('10001', 'Andi', 1, 'Jakarta', '1990-10-10', 'J0003'),
('10002', 'Rina', 0, 'Jakarta', '1985-08-08', 'J0001'),
('10003', 'Nina', 0, 'Bandung', '1993-06-06', 'J0002');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `gajian`
--
ALTER TABLE `gajian`
  ADD PRIMARY KEY (`notransaksi`),
  ADD KEY `nip` (`nip`);

--
-- Indexes for table `jabatan`
--
ALTER TABLE `jabatan`
  ADD PRIMARY KEY (`kodejabatan`);

--
-- Indexes for table `karyawan`
--
ALTER TABLE `karyawan`
  ADD PRIMARY KEY (`nip`),
  ADD KEY `kodejabatan` (`kodejabatan`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `gajian`
--
ALTER TABLE `gajian`
  ADD CONSTRAINT `gajian_ibfk_1` FOREIGN KEY (`nip`) REFERENCES `karyawan` (`nip`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `karyawan`
--
ALTER TABLE `karyawan`
  ADD CONSTRAINT `karyawan_ibfk_1` FOREIGN KEY (`kodejabatan`) REFERENCES `jabatan` (`kodejabatan`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
