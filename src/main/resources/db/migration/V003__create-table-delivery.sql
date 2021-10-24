create table delivery(
	id bigint not null auto_increment,
	clint_id bigint not null,
	status varchar(20) not null,
	date_order datetime not null,
	date_finished datetime,

	address_name varchar(60) not null,
	address_street varchar(255) not null,
	address_number varchar(30) not null,
	address_complement varchar(60) not null,
	address_neighboord varchar(30) not null,

	primary key (id)
);