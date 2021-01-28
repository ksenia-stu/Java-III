/* Create database */
create database if not exists dbCat
;
/*Switch to  dbCat database */
use dbCat
;

/*Create table Cats */
create table Cats
(
	id int not null auto_increment,
    name varchar(30) not null,
    age int not null,
    birthday date not null,
    constraint pk_Cats primary key (id asc)
)
;


INSERT INTO Cats(name, age, birthday)
VALUES 
('Safa', 12, '1980-09-09'),
('Akita', 16, '1986-10-15')
;