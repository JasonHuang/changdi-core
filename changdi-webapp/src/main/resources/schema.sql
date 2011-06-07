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
	id bigint not null auto_increment ,
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

/**table app_user*/
drop table if exists app_user;
create table app_user(
	id bigint not null auto_increment,
	name varchar(50) not null,
	nick varchar(50) not null,
	sex char(1),
	head varchar(50),
	birth_year varchar(4),
	birth_month varchar(2),
	birth_day varchar(2),
	email varchar(50),
	introduction varchar(200),
	last_login_time date,
	createAt date,
	updateAt date,
	primary key(id),
	unique key(name),
	unique key(nick)
)ENGINE=MyISAM;

/** table token */
drop table if exists u_token;
create table u_token(
	id bigint not null auto_increment,
	token_key varchar(50) not null,
	token_secret varchar(50) not null,
	verifier varchar(50) not null,
	u_id bigint not null,
	primary key(id),
	foreign key(u_id) references app_user(id)
)ENGINE=MyISAM;

