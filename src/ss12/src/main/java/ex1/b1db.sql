create database doctor_db_Bai1;
use doctor_db_Bai1;
CREATE TABLE doctor_Bai1 (
    id INT AUTO_INCREMENT PRIMARY KEY,
    code VARCHAR(20),
    pass VARCHAR(50),
    name VARCHAR(100)
);
INSERT INTO doctor_Bai1(code, pass, name) VALUES
('D01', '123', 'Tran Van A'),
('D02', '456', 'Tran Thi B');