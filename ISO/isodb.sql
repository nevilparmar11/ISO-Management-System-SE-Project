-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 23, 2020 at 12:46 PM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `iso`
--

-- --------------------------------------------------------

--
-- Table structure for table `department`
--

CREATE TABLE `department` (
  `i_department_id` int(11) NOT NULL,
  `c_name` varchar(45) DEFAULT NULL,
  `f_institute_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `department`
--

INSERT INTO `department` (`i_department_id`, `c_name`, `f_institute_id`) VALUES
(1, 'Computer', 1),
(2, 'IT', 1),
(3, 'Surgery', 2);

-- --------------------------------------------------------

--
-- Table structure for table `form`
--

CREATE TABLE `form` (
  `i_form_id` int(11) NOT NULL,
  `c_form_name` varchar(45) NOT NULL,
  `c_type` varchar(45) DEFAULT NULL,
  `f_subject_id` int(11) DEFAULT NULL,
  `f_institute_id` int(11) DEFAULT NULL,
  `f_department_id` int(11) DEFAULT NULL,
  `f_form_structure_id` int(11) DEFAULT NULL,
  `dt_teaching_plan_start` datetime NOT NULL,
  `dt_teaching_plan_end` datetime NOT NULL,
  `b_is_enabled` int(11) NOT NULL DEFAULT 0,
  `b_admin_accepted` int(11) NOT NULL DEFAULT 0,
  `b_hod_accepted` int(11) NOT NULL DEFAULT 0,
  `b_dept_coord_accepted` int(11) NOT NULL DEFAULT 0,
  `b_inst_coord_accepted` int(11) NOT NULL DEFAULT 0,
  `b_is_submitted` int(11) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `form`
--

INSERT INTO `form` (`i_form_id`, `c_form_name`, `c_type`, `f_subject_id`, `f_institute_id`, `f_department_id`, `f_form_structure_id`, `dt_teaching_plan_start`, `dt_teaching_plan_end`, `b_is_enabled`, `b_admin_accepted`, `b_hod_accepted`, `b_dept_coord_accepted`, `b_inst_coord_accepted`, `b_is_submitted`) VALUES
(1, 'JT LAB FORM', 'Lab', 1, 2, 1, 2, '2017-01-01 00:00:00', '2017-01-01 00:00:00', 1, 0, 0, 0, 0, 0),
(2, 'DM LAB FORM', 'Lab', 4, 1, 1, 2, '2019-12-29 00:00:00', '2019-12-29 00:00:00', 1, 0, 0, 0, 0, 0),
(5, 'OS LAB FORM', 'Lab', 1, 2, 1, 2, '2018-12-30 00:00:00', '2018-12-30 00:00:00', 1, 0, 0, 0, 0, 0),
(6, 'JT LAB FORM 3', 'Lab', 1, 2, 1, 2, '2018-12-30 00:00:00', '2018-12-30 00:00:00', 0, 0, 0, 0, 0, 0);

-- --------------------------------------------------------

--
-- Table structure for table `form_field_data`
--

CREATE TABLE `form_field_data` (
  `i_form_field_dataid` int(11) NOT NULL,
  `c_field_1` varchar(2000) DEFAULT NULL,
  `c_field_2` int(11) DEFAULT NULL,
  `f_form_id` int(11) NOT NULL,
  `sequence` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `form_field_data`
--

INSERT INTO `form_field_data` (`i_form_field_dataid`, `c_field_1`, `c_field_2`, `f_form_id`, `sequence`) VALUES
(95, 'Write Problem definition and its informal requirements', 2, 1, 1),
(96, 'Write Requirements Analysis for given application & Software Process Model', 2, 1, 2),
(97, 'write non functional requirements', 5, 1, 3);

-- --------------------------------------------------------

--
-- Table structure for table `form_review`
--

CREATE TABLE `form_review` (
  `i_form_review_id` int(11) NOT NULL,
  `f_user_id` int(11) NOT NULL,
  `f_form_id` int(11) NOT NULL,
  `c_remarks` varchar(2000) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `form_structure`
--

CREATE TABLE `form_structure` (
  `i_form_structure_id` int(11) NOT NULL,
  `c_field_1` varchar(100) NOT NULL,
  `c_field_2` varchar(100) NOT NULL,
  `c_name` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `form_structure`
--

INSERT INTO `form_structure` (`i_form_structure_id`, `c_field_1`, `c_field_2`, `c_name`) VALUES
(1, 'Major Topics', 'Number of lecture', 'Lecture'),
(2, 'Topics', 'Number of Hours', 'Lab');

-- --------------------------------------------------------

--
-- Table structure for table `institute`
--

CREATE TABLE `institute` (
  `i_institute_id` int(11) NOT NULL,
  `c_name` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `institute`
--

INSERT INTO `institute` (`i_institute_id`, `c_name`) VALUES
(2, 'Dental'),
(1, 'FOT');

-- --------------------------------------------------------

--
-- Table structure for table `subject`
--

CREATE TABLE `subject` (
  `i_subject_id` int(11) NOT NULL,
  `c_subject_name` varchar(45) DEFAULT NULL,
  `i_semester` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `subject`
--

INSERT INTO `subject` (`i_subject_id`, `c_subject_name`, `i_semester`) VALUES
(1, 'OS', 4),
(2, 'DBMS', 3),
(3, 'JT', 4),
(4, 'DM', 4);

-- --------------------------------------------------------

--
-- Table structure for table `subject_teaches`
--

CREATE TABLE `subject_teaches` (
  `i_subject_teach_id` int(11) NOT NULL,
  `f_user_id` int(11) NOT NULL,
  `f_subject_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `subject_teaches`
--

INSERT INTO `subject_teaches` (`i_subject_teach_id`, `f_user_id`, `f_subject_id`) VALUES
(1, 1, 1),
(2, 2, 1),
(3, 3, 2);

-- --------------------------------------------------------

--
-- Table structure for table `submited_form`
--

CREATE TABLE `submited_form` (
  `i_submit_form_id` int(11) NOT NULL,
  `f_user_id` int(11) NOT NULL,
  `f_form_id` int(11) DEFAULT NULL,
  `f_form_field_data` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `i_user_id` int(11) NOT NULL,
  `c_first_name` varchar(45) NOT NULL,
  `c_last_name` varchar(45) NOT NULL,
  `c_username` varchar(45) DEFAULT NULL,
  `c_password` varchar(255) NOT NULL,
  `e_email` varchar(55) NOT NULL,
  `c_role` varchar(20) NOT NULL,
  `f_institute_id` int(11) DEFAULT NULL,
  `f_department_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`i_user_id`, `c_first_name`, `c_last_name`, `c_username`, `c_password`, `e_email`, `c_role`, `f_institute_id`, `f_department_id`) VALUES
(1, 'Vanraj', 'Dangar', 'VanrajDangar', 'Vanraj123', 'vanraj@gmai.com', 'Coordinator', 1, 1),
(2, 'Niyati', 'Buch', 'NiyatiBuch', 'Niyati123', 'Niyati@gmail.com', 'Faculty', 1, 1),
(3, 'Nitant', 'Joshi', 'NitantJoshi', 'Nitant123', 'Nitant@gmail.com', 'Faculty', 2, 1),
(4, 'Ram', 'Sharma', 'RamSharma', 'Ram123', 'Ram@gmail.com', 'Admin', 1, 2);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `department`
--
ALTER TABLE `department`
  ADD PRIMARY KEY (`i_department_id`),
  ADD UNIQUE KEY `c_name_UNIQUE` (`c_name`),
  ADD KEY `f_institute_id_idx` (`f_institute_id`);

--
-- Indexes for table `form`
--
ALTER TABLE `form`
  ADD PRIMARY KEY (`i_form_id`),
  ADD UNIQUE KEY `i_form_id_UNIQUE` (`i_form_id`),
  ADD KEY `f_subject_id_form_idx` (`f_subject_id`),
  ADD KEY `f_institute_id_form_idx` (`f_institute_id`),
  ADD KEY `f_department_id_form_idx` (`f_department_id`),
  ADD KEY `f_form_structure_id_form_idx` (`f_form_structure_id`);

--
-- Indexes for table `form_field_data`
--
ALTER TABLE `form_field_data`
  ADD PRIMARY KEY (`i_form_field_dataid`),
  ADD UNIQUE KEY `i_form_field_dataid_UNIQUE` (`i_form_field_dataid`),
  ADD KEY `f_form_id_data_idx` (`f_form_id`);

--
-- Indexes for table `form_review`
--
ALTER TABLE `form_review`
  ADD PRIMARY KEY (`i_form_review_id`),
  ADD KEY `f_user_id_review_idx` (`f_user_id`),
  ADD KEY `f_form_id_review_idx` (`f_form_id`);

--
-- Indexes for table `form_structure`
--
ALTER TABLE `form_structure`
  ADD PRIMARY KEY (`i_form_structure_id`),
  ADD UNIQUE KEY `i_form_structure_id_UNIQUE` (`i_form_structure_id`),
  ADD UNIQUE KEY `c_name_UNIQUE` (`c_name`);

--
-- Indexes for table `institute`
--
ALTER TABLE `institute`
  ADD PRIMARY KEY (`i_institute_id`),
  ADD UNIQUE KEY `Name_UNIQUE` (`c_name`);

--
-- Indexes for table `subject`
--
ALTER TABLE `subject`
  ADD PRIMARY KEY (`i_subject_id`),
  ADD UNIQUE KEY `i_subject_id_UNIQUE` (`i_subject_id`),
  ADD UNIQUE KEY `c_subject_name_UNIQUE` (`c_subject_name`);

--
-- Indexes for table `subject_teaches`
--
ALTER TABLE `subject_teaches`
  ADD PRIMARY KEY (`i_subject_teach_id`),
  ADD KEY `f_user_id_teach_idx` (`f_user_id`),
  ADD KEY `f_subject_id_teach_idx` (`f_subject_id`);

--
-- Indexes for table `submited_form`
--
ALTER TABLE `submited_form`
  ADD PRIMARY KEY (`i_submit_form_id`),
  ADD KEY `f_user_id_submit_idx` (`f_user_id`),
  ADD KEY `f_form_id_submit_idx` (`f_form_id`),
  ADD KEY `f_form_field_submit_idx` (`f_form_field_data`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`i_user_id`),
  ADD UNIQUE KEY `i_user_id_UNIQUE` (`i_user_id`),
  ADD UNIQUE KEY `Email_UNIQUE` (`e_email`),
  ADD UNIQUE KEY `Username_UNIQUE` (`c_username`),
  ADD KEY `f_institute_id_idx` (`f_institute_id`),
  ADD KEY `f_department_id_idx` (`f_department_id`,`f_institute_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `department`
--
ALTER TABLE `department`
  MODIFY `i_department_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `form_field_data`
--
ALTER TABLE `form_field_data`
  MODIFY `i_form_field_dataid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=98;

--
-- AUTO_INCREMENT for table `form_review`
--
ALTER TABLE `form_review`
  MODIFY `i_form_review_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `form_structure`
--
ALTER TABLE `form_structure`
  MODIFY `i_form_structure_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `institute`
--
ALTER TABLE `institute`
  MODIFY `i_institute_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `subject`
--
ALTER TABLE `subject`
  MODIFY `i_subject_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `subject_teaches`
--
ALTER TABLE `subject_teaches`
  MODIFY `i_subject_teach_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `submited_form`
--
ALTER TABLE `submited_form`
  MODIFY `i_submit_form_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `i_user_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `department`
--
ALTER TABLE `department`
  ADD CONSTRAINT `f_institute_id` FOREIGN KEY (`f_institute_id`) REFERENCES `institute` (`i_institute_id`) ON DELETE CASCADE;

--
-- Constraints for table `form`
--
ALTER TABLE `form`
  ADD CONSTRAINT `f_department_id_form` FOREIGN KEY (`f_department_id`) REFERENCES `department` (`i_department_id`),
  ADD CONSTRAINT `f_form_structure_id_form` FOREIGN KEY (`f_form_structure_id`) REFERENCES `form_structure` (`i_form_structure_id`),
  ADD CONSTRAINT `f_institute_id_form` FOREIGN KEY (`f_institute_id`) REFERENCES `institute` (`i_institute_id`),
  ADD CONSTRAINT `f_subject_id_form` FOREIGN KEY (`f_subject_id`) REFERENCES `subject` (`i_subject_id`);

--
-- Constraints for table `form_field_data`
--
ALTER TABLE `form_field_data`
  ADD CONSTRAINT `f_form_id_data` FOREIGN KEY (`f_form_id`) REFERENCES `form` (`i_form_id`);

--
-- Constraints for table `form_review`
--
ALTER TABLE `form_review`
  ADD CONSTRAINT `f_form_id_review` FOREIGN KEY (`f_form_id`) REFERENCES `form` (`i_form_id`) ON DELETE CASCADE,
  ADD CONSTRAINT `f_user_id_review` FOREIGN KEY (`f_user_id`) REFERENCES `user` (`i_user_id`);

--
-- Constraints for table `subject_teaches`
--
ALTER TABLE `subject_teaches`
  ADD CONSTRAINT `f_subject_id_teach` FOREIGN KEY (`f_subject_id`) REFERENCES `subject` (`i_subject_id`) ON DELETE CASCADE,
  ADD CONSTRAINT `f_user_id_teach` FOREIGN KEY (`f_user_id`) REFERENCES `user` (`i_user_id`) ON DELETE CASCADE;

--
-- Constraints for table `submited_form`
--
ALTER TABLE `submited_form`
  ADD CONSTRAINT `f_form_field_submit` FOREIGN KEY (`f_form_field_data`) REFERENCES `form_field_data` (`i_form_field_dataid`),
  ADD CONSTRAINT `f_form_id_submit` FOREIGN KEY (`f_form_id`) REFERENCES `form` (`i_form_id`) ON DELETE CASCADE,
  ADD CONSTRAINT `f_user_id_submit` FOREIGN KEY (`f_user_id`) REFERENCES `user` (`i_user_id`);

--
-- Constraints for table `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `f_department_id_user` FOREIGN KEY (`f_department_id`) REFERENCES `department` (`i_department_id`),
  ADD CONSTRAINT `f_institute_id_user` FOREIGN KEY (`f_institute_id`) REFERENCES `institute` (`i_institute_id`) ON DELETE SET NULL;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
