drop database if exists RHMS;
create database RHMS;
use RHMS;
create table Patients (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    age INT,
    department VARCHAR(100),
    disease VARCHAR(255),
    admission_date DATE
);
INSERT INTO Patients (name, age, department, disease, admission_date) VALUES
('Hoang Minh Tuan', 28, 'Tim mach', 'Tang huyet ap', '2026-03-19'),
('Do Thi Lan', 35, 'Nhi khoa', 'Sot virus', '2026-03-17'),
('Bui Van Nam', 50, 'Than kinh', 'Dot quy nhe', '2026-03-14'),
('Nguyen Thi Hoa', 45, 'Noi tiet', 'Tieu duong', '2026-03-16'),
('Pham Quang Huy', 33, 'Ngoai khoa', 'Viem ruot thua', '2026-03-22');
DELIMITER $$
CREATE PROCEDURE CALCULATE_DISCHARGE_FEE(
    IN p_id INT,
    OUT total_fee DOUBLE
)
BEGIN
    DECLARE days INT;
    SELECT DATEDIFF(CURDATE(), admission_date)
    INTO days
    FROM Patients
    WHERE id = p_id;
    SET total_fee = days * 100;
END $$
DELIMITER ;