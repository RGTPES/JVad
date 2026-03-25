drop database if exists hospital_db;
create database hospital_db;
use hospital_db;

create table giuong_benh (
    ma_giuong int primary key auto_increment,
    ten_giuong varchar(50) not null,
    trang_thai varchar(20) not null
);

create table benh_nhan (
    ma_benh_nhan int primary key auto_increment,
    ten_benh_nhan varchar(100) not null,
    tuoi int not null,
    ma_giuong int not null,
    ngay_nhap_vien datetime not null default current_timestamp,
    foreign key (ma_giuong) references giuong_benh(ma_giuong)
);

create table tai_chinh (
    ma_phieu_thu int primary key auto_increment,
    ma_benh_nhan int not null,
    so_tien double not null,
    noi_dung varchar(255) not null,
    ngay_thu datetime not null default current_timestamp,
    foreign key (ma_benh_nhan) references benh_nhan(ma_benh_nhan)
);

insert into giuong_benh(ten_giuong, trang_thai) values
('g101', 'trong'),
('g102', 'trong'),
('g103', 'da co nguoi'),
('g104', 'trong');