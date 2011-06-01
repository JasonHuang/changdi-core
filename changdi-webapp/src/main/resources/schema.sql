/**database changdi*/
drop database if exists changdi;
create database changdi default character set utf8 COLLATE utf8_bin;

use changdi;

/**table venue*/
drop table if exists venue;
create table venue(
	id bigint not null auto_increment ,
	name VARCHAR(50) not null,
	description VARCHAR(500),
	createAt date not null,
	primary key(id)
) ENGINE=MyISAM;

/**table gallery*/
drop table if exists v_gallery;
create table v_gallery(
	id bigint not null auto_increment,
	name VARCHAR(50) not null,
	description VARCHAR(500),
	v_id bigint not null,
	createAt date not null,
	primary key(id),
	foreign key(v_id) references venue(id) 
)ENGINE=MyISAM;

/**table photo*/
drop table if exists gallery_picture;
create table v_gallery_picture(
	id bigint not null auto_increment,
	name VARCHAR(50) not null,
	description VARCHAR(500),
	is_primary_image char(1),
	g_id bigint not null,
	location VARCHAR(50) not null,
	createAt date not null,
	primary key(id),
	foreign key(g_id) references v_gallery(id)
)ENGINE=MyISAM;


