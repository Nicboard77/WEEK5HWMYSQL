create database if not exists cars;

use cars;

drop table if exists cars;

create table cars(
	id int(10) not null auto_increment,
	name varchar(50) not null,
	price int(10) not null,
	primary key(id)
);