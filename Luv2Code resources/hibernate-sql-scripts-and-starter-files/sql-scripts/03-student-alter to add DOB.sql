USE `hb_student_tracker`;

--
-- Alter `student` table structure to add date_of_birth after the last_name
--

ALTER TABLE `student` (ADD COLUMN `date_of_birth` DATETIME NULL AFTER `last_name`);

