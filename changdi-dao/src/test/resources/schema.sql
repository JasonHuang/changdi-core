drop table venue if exists;
create table venue(
	id integer,
	name char(50),
	description char(500),
	createAt date
);