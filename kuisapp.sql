-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 04, 2024 at 07:51 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `kuisapp`
--

-- --------------------------------------------------------

--
-- Table structure for table `guru`
--

CREATE TABLE `guru` (
  `id` int(11) NOT NULL,
  `username` varchar(255) NOT NULL,
  `nama` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `guru`
--

INSERT INTO `guru` (`id`, `username`, `nama`, `password`) VALUES
(8, 'luthfi', 'luthfi', '$2a$10$DO.gtUt50eoBS0KHl6bcWe2r8cdGyDf0UnAdMdtGgFQZsLrxGt3UK'),
(13, 'guru', 'guru', '$2a$10$WiLKau69DcLOPbUuR8MCJeLtCOXSVKMbPRuZRPEtf4htaNCB.ktsm'),
(14, 'admin', 'admin', '$2a$10$mobvWTLqB7P7MM5c66wM5e4ep3q9Dp8qR7/NZgwT.4M1Y4Dpgr4dy'),
(15, 'superuser', 'superuser', '$2a$10$1dAO9fgPRZ4DrNZP0OB9UemZONO91xk73mFLitCuEnCrkXhlz8vpK');

-- --------------------------------------------------------

--
-- Table structure for table `question`
--

CREATE TABLE `question` (
  `id` int(11) NOT NULL,
  `question_text` text NOT NULL,
  `option1` varchar(255) NOT NULL,
  `option2` varchar(255) NOT NULL,
  `option3` varchar(255) DEFAULT NULL,
  `option4` varchar(255) DEFAULT NULL,
  `correct_answer` int(11) NOT NULL,
  `guru_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `question`
--

INSERT INTO `question` (`id`, `question_text`, `option1`, `option2`, `option3`, `option4`, `correct_answer`, `guru_id`) VALUES
(4, 'Algoritma Ensemble adalah sebagai berikut', 'KNN', 'Naive Bayes', 'Random Forest', 'ANN', 3, 8),
(6, 'Contoh Algoritma Regression', 'DT', 'Logistic Regression', 'DBSCAN', 'SVM', 2, 8),
(7, 'Contoh Implementasi Sistem Paralel Kecuali', 'Threading', 'MPI', 'FTP', 'OpenCL', 3, 8),
(12, 'Contoh Implementasi Sistem Paralel Yaitu', 'OpenCL', 'SMTP', 'HTTPS', 'FTP', 1, 8),
(13, 'Contoh Implementasi Sistem Terdistribusi yaitu', 'OpenCL', 'Message Queue', 'OpenGL', 'OpenMP', 2, 8),
(14, 'Hasil dari 5 mod 4 adalah', '1', '2', '3', '0', 1, 13),
(15, 'Hasil dari 5! adalah', '1000', '5', '25', '120', 4, 13),
(16, 'Hasil dari 5C5 adalah', '1', '3', '5', '7', 1, 13),
(17, 'Salah Satu tahap Dalam SDLC kecuali', 'Design', 'Testing', 'Planning', 'Execution', 4, 14),
(18, 'Yang merupakan benua Terbesar adalah', 'Asia', 'Eropa', 'Australia', 'Amerika', 1, 14);

-- --------------------------------------------------------

--
-- Table structure for table `quiz`
--

CREATE TABLE `quiz` (
  `id` int(11) NOT NULL,
  `nama` varchar(255) NOT NULL,
  `deskripsi` text NOT NULL,
  `guru_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `quiz`
--

INSERT INTO `quiz` (`id`, `nama`, `deskripsi`, `guru_id`) VALUES
(11, 'Kuis Sister', 'Kuis UAS Sister 2023/2024', 8),
(12, 'Kuis ML', 'CLO 4 ML', 8),
(13, 'Kuis Matematika', 'Kuis UAS Matematika', 13),
(14, 'Kuis UAS Akhir', 'UAS', 8);

-- --------------------------------------------------------

--
-- Table structure for table `quiz_grade`
--

CREATE TABLE `quiz_grade` (
  `id` int(11) NOT NULL,
  `siswa_id` int(11) NOT NULL,
  `quiz_id` int(11) NOT NULL,
  `grade` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `quiz_grade`
--

INSERT INTO `quiz_grade` (`id`, `siswa_id`, `quiz_id`, `grade`) VALUES
(4, 3, 12, 100),
(5, 3, 11, 66.6667),
(7, 3, 13, 100),
(8, 4, 13, 33.3333),
(9, 4, 12, 40),
(10, 4, 14, 100);

-- --------------------------------------------------------

--
-- Table structure for table `quiz_question`
--

CREATE TABLE `quiz_question` (
  `quiz_id` int(11) NOT NULL,
  `question_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `quiz_question`
--

INSERT INTO `quiz_question` (`quiz_id`, `question_id`) VALUES
(11, 4),
(11, 6),
(11, 7),
(12, 4),
(12, 6),
(12, 7),
(12, 12),
(12, 13),
(13, 14),
(13, 15),
(13, 16),
(14, 4);

-- --------------------------------------------------------

--
-- Table structure for table `quiz_response`
--

CREATE TABLE `quiz_response` (
  `id` int(11) NOT NULL,
  `siswa_id` int(11) NOT NULL,
  `quiz_id` int(11) NOT NULL,
  `question_id` int(11) NOT NULL,
  `chosen_answer` int(11) NOT NULL,
  `is_correct` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `quiz_response`
--

INSERT INTO `quiz_response` (`id`, `siswa_id`, `quiz_id`, `question_id`, `chosen_answer`, `is_correct`) VALUES
(14, 3, 12, 4, 3, 1),
(15, 3, 12, 6, 2, 1),
(16, 3, 12, 7, 3, 1),
(17, 3, 12, 12, 1, 1),
(18, 3, 12, 13, 2, 1),
(19, 3, 11, 4, 3, 1),
(20, 3, 11, 6, 2, 1),
(21, 3, 11, 7, 4, 0),
(22, 3, 13, 14, 1, 1),
(23, 3, 13, 15, 4, 1),
(24, 3, 13, 16, 1, 1),
(25, 4, 13, 14, 4, 0),
(26, 4, 13, 15, 1, 0),
(27, 4, 13, 16, 1, 1),
(28, 4, 12, 4, 4, 0),
(29, 4, 12, 6, 2, 1),
(30, 4, 12, 7, 3, 1),
(31, 4, 12, 12, 2, 0),
(32, 4, 12, 13, 1, 0),
(33, 4, 14, 4, 3, 1);

-- --------------------------------------------------------

--
-- Table structure for table `siswa`
--

CREATE TABLE `siswa` (
  `id` int(11) NOT NULL,
  `username` varchar(255) NOT NULL,
  `nama` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `siswa`
--

INSERT INTO `siswa` (`id`, `username`, `nama`, `password`) VALUES
(3, 'luthfi', 'luthfi novra', '$2a$10$m.aoINCuNe8CarubwYxNbuM/jfcROabRtRHlUzOdiSOy4mjCn0yDK'),
(4, 'siswabaru', 'siswa baru', '$2a$10$Of1p52wRECP39RCHDWRZ4OiPI/xuX2I0NpEWNjSYdJZaDIcoAFOSm');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `guru`
--
ALTER TABLE `guru`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `username` (`username`);

--
-- Indexes for table `question`
--
ALTER TABLE `question`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_Guru` (`guru_id`);

--
-- Indexes for table `quiz`
--
ALTER TABLE `quiz`
  ADD PRIMARY KEY (`id`),
  ADD KEY `guru_id` (`guru_id`);

--
-- Indexes for table `quiz_grade`
--
ALTER TABLE `quiz_grade`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_QuizGrade` (`quiz_id`),
  ADD KEY `FK_SiswaGrade` (`siswa_id`);

--
-- Indexes for table `quiz_question`
--
ALTER TABLE `quiz_question`
  ADD PRIMARY KEY (`quiz_id`,`question_id`),
  ADD KEY `FK_Question` (`question_id`);

--
-- Indexes for table `quiz_response`
--
ALTER TABLE `quiz_response`
  ADD PRIMARY KEY (`id`),
  ADD KEY `siswa_id` (`siswa_id`),
  ADD KEY `FK_QuestionResponse` (`question_id`),
  ADD KEY `FK_QuizResponse` (`quiz_id`);

--
-- Indexes for table `siswa`
--
ALTER TABLE `siswa`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `username` (`username`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `guru`
--
ALTER TABLE `guru`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT for table `question`
--
ALTER TABLE `question`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT for table `quiz`
--
ALTER TABLE `quiz`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT for table `quiz_grade`
--
ALTER TABLE `quiz_grade`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `quiz_response`
--
ALTER TABLE `quiz_response`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=34;

--
-- AUTO_INCREMENT for table `siswa`
--
ALTER TABLE `siswa`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `question`
--
ALTER TABLE `question`
  ADD CONSTRAINT `FK_Guru` FOREIGN KEY (`guru_id`) REFERENCES `guru` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `quiz`
--
ALTER TABLE `quiz`
  ADD CONSTRAINT `FK` FOREIGN KEY (`guru_id`) REFERENCES `guru` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `quiz_grade`
--
ALTER TABLE `quiz_grade`
  ADD CONSTRAINT `FK_QuizGrade` FOREIGN KEY (`quiz_id`) REFERENCES `quiz` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_SiswaGrade` FOREIGN KEY (`siswa_id`) REFERENCES `siswa` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `quiz_question`
--
ALTER TABLE `quiz_question`
  ADD CONSTRAINT `FK_Question` FOREIGN KEY (`question_id`) REFERENCES `question` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_Quiz` FOREIGN KEY (`quiz_id`) REFERENCES `quiz` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `quiz_response`
--
ALTER TABLE `quiz_response`
  ADD CONSTRAINT `FK_QuestionResponse` FOREIGN KEY (`question_id`) REFERENCES `question` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_QuizResponse` FOREIGN KEY (`quiz_id`) REFERENCES `quiz` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_Siswa` FOREIGN KEY (`siswa_id`) REFERENCES `siswa` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
