DROP table IF EXISTS BOTIGUES;

CREATE TABLE BOTIGUES (

	id integer primary key auto_increment,name varchar(25),capacity integer
	);
	
DROP table IF EXISTS QUADRES;

CREATE TABLE QUADRES (

	id integer primary key auto_increment,autor varchar(25),titol varchar(25),
	preu double,data DATE,botiga_id integer
	);