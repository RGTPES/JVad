drop database if exists hospital_db;
create database hospital_db;
use hospital_db;

create table beds (
    bed_id int primary key auto_increment,
    status varchar(50) not null
);

create table patients (
    patient_id int primary key auto_increment,
    full_name varchar(100) not null,
    balance double not null default 0,
    bed_id int,
    status varchar(50) not null,
    foreign key (bed_id) references beds(bed_id)
);

insert into beds(status) values
('dang su dung'),
('dang su dung'),
('trong');

insert into patients(full_name, balance, bed_id, status) values
('nguyen van a', 5000000, 1, 'dang dieu tri'),
('tran thi b', 1000000, 2, 'dang dieu tri');