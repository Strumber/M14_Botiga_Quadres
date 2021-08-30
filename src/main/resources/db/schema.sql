DROP table IF EXISTS QUADRE;
DROP table IF EXISTS BOTIGA;



CREATE TABLE BOTIGA (

	id integer primary key auto_increment,name varchar(25),capacity integer
	)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;;

	



CREATE TABLE QUADRE (

	id int(3) not null auto_increment,
	botiga_id int(3) default null,
	autor varchar(25) default null,
	titol varchar(25) default null,
	preu double,
	data DATE,
	PRIMARY KEY(id), KEY FK_BOTIGA_ID(botiga_id),
	constraint botiga_id
	FOREIGN KEY(botiga_id)
	references BOTIGA(id)
	)
	
	ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

	/*on delete no action on update no action)*/