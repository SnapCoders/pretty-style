create database db_pretty_style;
use db_pretty_style;

create table user (
	id					int auto_increment,
    username			varchar(50) not null,
    email				varchar(150) not null,
    email_confirmation 	varchar(150) not null,
    password_hash		varchar(300) not null,
    
    created_at			timestamp not null default now(),
    updated_at			timestamp null,
    deleted_at			timestamp null,
    
    constraint pk_id primary key (id)
);

-- select * from user;

create table provider (
	id				int auto_increment,
    cnpj			varchar(18) not null,
    fantasy_name	varchar(150) not null,
    social_reason	varchar(150) not null,
    contact			varchar(150) not null,
    id_user			int,
    
    created_at	timestamp not null default now(),
    updated_at	timestamp null,
    deleted_at	timestamp null,
    
    constraint pk_id primary key (id),
    constraint fk_provider__id_user foreign key (id_user) references user (id)
);

-- select * from provider;

create table client (
	id			int auto_increment,
    name		varchar(150) not null,
    surname		varchar(150) not null,
    genre		varchar(1) not null,
    cpf			varchar(14) not null,
    birthday	date not null,
    id_user		int,
    
    created_at	timestamp not null default now(),
    updated_at	timestamp null,
    deleted_at	timestamp null,
    
    constraint pk_id primary key (id),
    constraint fk_client__id_user foreign key (id_user) references user (id)
);

-- select * from client;

create table mark (
	id			int auto_increment,
    name		varchar(100) not null,
    id_provider int,
    
    created_at	timestamp not null default now(),
    updated_at	timestamp null,
    deleted_at	timestamp null,
    
    constraint pk_id primary key (id),
    constraint fk_mark__id_provider foreign key (id_provider) references provider (id)
);

-- select * from mark;

create table stock (
	id			int primary key auto_increment,
    quantity	int,
    
    created_at	timestamp not null default now(),
    updated_at	timestamp null,
    deleted_at	timestamp null
);

-- select stock;

create table product (
	id			int auto_increment,
    name		varchar(180) not null,
    description	varchar(300) not null,
    price		double not null,
    id_mark		int,
    id_provider int,
    
    created_at	timestamp not null default now(),
    updated_at	timestamp null,
    deleted_at	timestamp null,
    
    constraint pk_id primary key (id),
    constraint fk_product__id_mark foreign key (id_mark) references mark (id),
    constraint fk_product__id_provider foreign key (id_provider) references provider (id),
    constraint fk_product__id_stock foreign key (id_stock) references stock (id)
);

-- select * from product;

create table category (
	id			int auto_increment,
    name		varchar(180) not null,
    color		varchar(7) not null,
    id_provider int,
    
    created_at	timestamp not null default now(),
    updated_at	timestamp null,
    deleted_at	timestamp null,
    
    constraint pk_id primary key (id),
    constraint fk_category__id_provider foreign key (id_provider) references provider (id)
);

-- select * from category;

create table product_category (
    id_product	int,
    id_category	int,
    
    created_at	timestamp not null default now(),
    
    constraint fk_product_category__id_product foreign key (id_product) references product (id),
    constraint fk_product_category__id_category foreign key (id_category) references category (id)
);

-- select * from product_category;

create table product_photo (
	id			int auto_increment,
    url			varchar(300) not null,
    name		varchar(100) not null,
    id_product	int,
    
    created_at	timestamp not null default now(),
    updated_at	timestamp null,
    deleted_at	timestamp null,
    
    constraint pk_id primary key (id),
    constraint fk_product_photo__id_product foreign key (id_product) references product (id)
);

-- select * from product_photo;

create table address (
	id				int auto_increment,
    recipient		varchar(150) not null,
    place			varchar(150) not null,
    number			varchar(12) not null,
    neighborhood	varchar(100) not null,
    city			varchar(80) not null,
    country			varchar(80) not null,
    zip				varchar(8) not null,
    complement		varchar(250) not null,
    id_user			int,
    
    created_at	timestamp not null default now(),
    updated_at	timestamp null,
    deleted_at	timestamp null,
    
    constraint pk_id primary key (id),
    constraint fk_address__id_user foreign key (id_user) references user (id)
);

-- select * from address;

create table phone_number (
	id				int auto_increment,
    ddd				smallint not null,
    number			varchar(16) not null,
    id_user			int,
    
    created_at	timestamp not null default now(),
    updated_at	timestamp null,
    deleted_at	timestamp null,
    
    constraint pk_id primary key (id),
    constraint fk_phone_number__id_user foreign key (id_user) references user (id)
);

-- select * from phone_number;

create table request (
	id				int auto_increment,
    number_request	varchar(40) not null,
	total_price		double not null,
    type_payment 	varchar(50) not null,
    id_client		int,
    
    created_at		timestamp not null default now(),
    updated_at		timestamp null,
    deleted_at		timestamp null,
    
    constraint pk_id primary key (id),
    constraint fk_request__id_client foreign key (id_client) references client (id)
);

-- select * from request;


create table item (
	id			int auto_increment,
    quantity	int not null,
    id_product	int,
    id_client int,
    paid bit default false,
    
    created_at	timestamp not null default now(),
    updated_at	timestamp null,
    deleted_at	timestamp null,
    
    constraint pk_id primary key (id),
    constraint fk_item__id_product foreign key (id_product) references product (id),
    constraint fk_item__id_client foreign key (id_client) references client (id)
);

-- select * from item;

create table item_request (
	id_item		int,
    id_request	int,
    
    constraint fk_item_request__id_item foreign key (id_item) references item (id),
    constraint fk_item_request__id_request foreign key (id_request) references request (id)
);

-- select ( from item_request;

create table user_address (
	id_user		int,
    id_address	int,
    
    constraint uk_id_user unique key (id_user),
    constraint fk_user_address__id_user foreign key (id_user) references user (id),
    constraint fk_user_address__id_address foreign key (id_address) references address (id)
);

-- select * from user_address;

create table client_product_like (
	id			int auto_increment,
    id_product  int,
    id_user		int,
    action		int,

	constraint pk_id primary key (id),
    constraint fk_client_product__id_product foreign key (id_product) references product (id),
    constraint fk_client_product__id_user foreign key (id_user) references user (id)
);

-- select client_product_like;
