/* Create database */
create database if not exists booksAndAuthors
;
/*Switch to  booksAndAuthors database */
use booksAndAuthors
;

/*Create table Books */
create table Books
(
	id int not null auto_increment,
    title varchar(100) not null,
    isbn varchar(13) not null,     -- unique constraint
    pubDate Date not null,
    coverImg longblob not null,
    constraint pk_Books primary key (id asc)
)
;

/*Create table Authors */
create table Authors
(
	id int not null auto_increment,
    bookId int not null,
    name varchar(50),
    constraint pk_Authors primary key (id asc)
)
;

/* Add foreign key */
alter table Authors
	add constraint fk_Authors_Books foreign key (bookId)
		references Books (id)
;


/* Add unique constraint */
-- Books table (isbn)
alter table Books
	add constraint uq_Books_isbn unique (isbn)
;