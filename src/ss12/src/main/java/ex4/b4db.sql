drop database  if exists  Hospital_Bai4;
create database Hospital_Bai4;
use Hospital_Bai4;
create table Results(
    id INT AUTO_INCREMENT PRIMARY KEY,
    patients_id INT,
    value FLOAT
);
INSERT INTO Results (patients_id, value) VALUES
(1, 36.5),
(2, 37.0);