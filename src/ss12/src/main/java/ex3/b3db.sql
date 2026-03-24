drop database if exists Hospital_Bai3;
create database Hospital_Bai3;
use Hospital_Bai3;
create table Surgeries (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    base_cost FLOAT
);
INSERT INTO Surgeries VALUES
 ('Cataract Surgery', 1500),
 ('Hip Replacement', 7000),
 ('Gallbladder Removal', 3000);
DELIMITER $$
CREATE PROCEDURE GET_SURGERY_FEE (
    IN patiens_id INT,
    OUT patiens_fee FLOAT
)
BEGIN
    SELECT base_cost INTO patiens_fee
    FROM Surgeries
    WHERE id = patiens_id;
END $$
DELIMITER ;