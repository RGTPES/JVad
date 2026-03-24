create database doctor_db_Bai1;
use doctor_db_Bai1;
CREATE TABLE doctor_Bai1 (
    id INT AUTO_INCREMENT PRIMARY KEY,
    code VARCHAR(20),
    pass VARCHAR(50),
    name VARCHAR(100)
);
INSERT INTO doctor_Bai1(code, pass, name) VALUES
('BS101', 'abc123', 'Nguyen Van Minh'),
('BS102', 'xyz456', 'Le Thi Hoa'),
('BS103', 'pass789', 'Pham Quang Huy');