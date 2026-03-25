drop database if exists hospital_transaction;
create database hospital_transaction;
use hospital_transaction;

create table patients (
    patient_id int primary key,
    patient_name varchar(100) not null,
    status varchar(50) not null
);

create table beds (
    bed_id varchar(10) primary key,
    patient_id int,
    status varchar(50) not null,
    foreign key (patient_id) references patients(patient_id)
);

create table invoices (
    invoice_id int primary key auto_increment,
    patient_id int not null,
    amount double not null,
    created_date datetime not null default current_timestamp,
    foreign key (patient_id) references patients(patient_id)
);

insert into patients(patient_id, patient_name, status)
values (101, 'Nguyen Van A', 'Dang dieu tri');

insert into beds(bed_id, patient_id, status)
values ('G01', 101, 'Dang su dung');