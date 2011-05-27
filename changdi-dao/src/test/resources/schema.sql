--table venue
drop table venue if exists;
create table venue(
	id integer not null auto_increment ,
	name char(50) not null,
	description char(500),
	createAt date not null,
	primary key(id)
) ENGINE=MyISAM;

--table gallery
drop table venue if exists;
create table gallery(
	id integer not null auto_increment,
	name char(50) not null,
	description char(500),
	v_id integer not null,
	createAt date not null,
	primary key(id),
	foreign key(v_id) references venue(id) 
)ENGINE=MyISAM;

--table photo
drop table picture if exists;
create table picture(
	id integer not null auto_increment,
	name char(50) not null,
	description char(500),
	g_id integer not null,
	location char(50) not null,
	createAt date not null,
	primary key(id),
	foreign key(g_id) references gallery(id)
)ENGINE=InnoDB;

