drop database if exists Hospital_Bai2;
create database doctor_db_Bai1;
use Hospital_Bai2;
create table Vitals (
    p_id INT PRIMARY KEY,
    temperature FLOAT,
    heart_rate INT
);
INSERT INTO Vitals VALUES
(1, 37.5, 75),
(2, 37.0, 80);