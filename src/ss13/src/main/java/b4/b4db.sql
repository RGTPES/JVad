drop database if exists hospital_db;
create database hospital_db;
use hospital_db;

create table BenhNhan (
    maBenhNhan int primary key auto_increment,
    tenBenhNhan varchar(100) not null,
    tuoi int,
    gioiTinh varchar(10),
    trangThai varchar(50)
);

create table DichVuSuDung (
    maDichVu int primary key auto_increment,
    tenDichVu varchar(100) not null,
    donGia double,
    maBenhNhan int,
    foreign key (maBenhNhan) references BenhNhan(maBenhNhan)
);

insert into BenhNhan(tenBenhNhan, tuoi, gioiTinh, trangThai) values
('Nguyen Van A', 30, 'Nam', 'Dang dieu tri'),
('Tran Thi B', 25, 'Nu', 'Moi nhap vien'),
('Le Van C', 40, 'Nam', 'Dang dieu tri');

insert into DichVuSuDung(tenDichVu, donGia, maBenhNhan) values
('Xet nghiem mau', 200000, 1),
('Chup X-quang', 500000, 1),
('Sieu am', 300000, 3);