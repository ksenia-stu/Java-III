use master;
go


-- rebuild database of existed
if DB_ID('ipd23flights') is not null
drop database idp23flights;
go

--create database
create database ipd23flights;
go

--switch to ipd23flights
use ipd23flights;
go

--drop schema before creating
drop schema ipd23;
go

--drop table before creating
if OBJECT_ID('ipd23.flights', 'U') is not null
drop table ipd23.Flights;
go

--create schema
create schema ipd23 authorization dbo;
go

--create table
create table Flights
(
   ID INT NOT NULL IDENTITY(1,1),  --auto generated int
   OnDay DATE NOT NULL,
   FromCode nvarchar(5) NOT NULL,
   ToCode nvarchar (5) NOT NULL,
   Type nvarchar(20) NOT NULL check(Type IN('Domestic', 'International', 'Private')),
   Passengers int NOT NULL,
   constraint pk_flights primary key clustered (Id asc)
);
go

select * from dbo.Flights
;
go