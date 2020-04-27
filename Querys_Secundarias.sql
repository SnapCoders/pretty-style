use db_pretty_style;

select * from product;
select * from mark;

-- delete from product where id = 8;

SELECT * FROM product WHERE deleted_at IS NULL LIMIT 4;

-- insert into product (name, description, price) values ('iPhone XR Branco', 'IPhone XR branco com câmera 12 MP', 3999.99);

select * from user;
select * from client;
select * from request;
select * from product;
select * from item;

SELECT * FROM product WHERE deleted_at IS NULL LIMIT 8;

-- insert into user (name, surname, email) values ('Bruno', 'Futema', 'bruno.futema@outlook.com');
-- insert into user (name, surname, email) values ('Amanda', 'Cano', 'amanda.cano@outlook.com');
-- insert into client (cpf, id_user) values ('471.033.418-85', 1);
-- insert into client (cpf, id_user) values ('471.033.418-85', 2);
-- insert into request (total_price, id_client) values (1000.00, 3);
-- insert into item (quantity, id_product, id_request) values (1, 9, 3);

select
	p.name
    , p.description
    , p.price
    , r.id_client
from
	product p
    inner join item i on p.id = i.id_product
    inner join request r on i.id_request = r.id
where r.id_client = 1;

select * from provider;
select * from user;

select * from address;
select * from phone_number;

-- update user set password_hash = 'NjU0MzIx' where id = 1;

-- delete from user where id = 4;

-- insert into user (name, surname, email) value ('Admin', 'Master', 'admin.master@prettystyle.com.br');
-- insert into provider (cnpj, id_user) values ('12.345.678/1234-85', 3);

-- ALTER TABLE user ADD password_hash VARCHAR(300);

insert into request (total_price, id_client) values (1500, 1);
insert into item (quantity, id_product, id_request) values (2, 1, 4);

ALTER TABLE request ADD number_request VARCHAR(36);

insert into request (total_price, id_client, number_request) values (1500, 1, UUID());


ALTER TABLE user ADD username VARCHAR(50);
ALTER TABLE user ADD email_confirmation VARCHAR(150);

ALTER TABLE client ADD name VARCHAR(150);
ALTER TABLE client ADD surname VARCHAR(150);
ALTER TABLE client ADD birthday DATE;
ALTER TABLE client ADD sex VARCHAR(1);

ALTER TABLE phone_number MODIFY number VARCHAR(12);

ALTER TABLE user drop column birthday;
ALTER TABLE user drop column sex;

ALTER TABLE user drop column name;
ALTER TABLE user drop column surname;

select * from user;
select * from client;
select * from provider;

ALTER TABLE provider ADD fantasy_name VARCHAR(150);
ALTER TABLE provider ADD social_reason VARCHAR(150);
ALTER TABLE provider ADD contact VARCHAR(150);

create table user_address (
	id_user		int,
    id_address	int,
    
    constraint uk_id_user unique key (id_user),
    constraint fk_user_address__id_user foreign key (id_user) references user (id),
    constraint fk_user_address__id_address foreign key (id_address) references address (id)
);

-- drop table user_address;

insert into user_address (id_user, id_address) values (1, 2);

select * from user_address;

SELECT
	a.place
    , a.number
    , a.neighborhood
    , a.city
    , a.complement
    , a.zip
FROM
	address a
    INNER JOIN user_address ua on a.id = ua.id_address
    INNER JOIN user u on ua.id_user = u.id
WHERE u.id = ?;
    

select * from item;
select * from request;

SELECT
	i.quantity
    , i.quantity * p.price as total
FROM
	request r
    INNER JOIN item i on i.id_request = r.id
    INNER JOIN product p on i.id_product = p.id
WHERE r.id = 1;

select * from category;

insert into category (name, color) values ('Masculino', '#0E9AEF');
insert into category (name, color) values ('Feminino', '#0E9AEF');
insert into category (name, color) values ('Novidades', '#0E9AEF');
insert into category (name, color) values ('Pets', '#0E9AEF');


select
	p.name
    , p.description
    , p.price
    , p.id_mark
    , r.id_client
from
	product p
    inner join item i on p.id = i.id_product
    inner join product;
    
    select * from request;
    select * from item;
    select * from product_request;
    
    insert into product_request (id_product, id_request) values (1, 5);
    
    
    
    
    
    
    
    
-- ------------------------------------------------------------------------------------

use db_pretty_style;

-- ao entrar na tela de carrinho = listar todos os itens dentro do carrinho
-- adicionar no carrinho = insert
-- alterar a quantidade no carrinho = update
-- remover do carrinho = delete

-- select * from product;
-- select * from item;

-- insert into item (quantity, id_product, id_client) values (1, 1, 1);

-- alter table item drop column id_request;
-- alter table item drop foreign key fk_item__id_request;

SELECT
	i.quantity
    , p.name
    , p.description
    , p.price
FROM
	item i
    INNER JOIN product p ON i.id_product = p.id
WHERE id_client = 1;

-- update item set id_client = 3 where id > 1

-- ALTER TABLE item ADD id_client INT;
-- ALTER TABLE item ADD FOREIGN KEY (id_client) REFERENCES client (id)



-- ---------------------------------------------------------------------------------------------

use db_pretty_style;

select * from product;
select * from request;
select * from item;


ALTER TABLE provider ADD fantasy_name VARCHAR(150);
ALTER TABLE provider ADD social_reason VARCHAR(150);
ALTER TABLE provider ADD contact VARCHAR(150);

ALTER TABLE user ADD username VARCHAR(50);
ALTER TABLE user ADD email_confirmation VARCHAR(150);

ALTER TABLE client ADD name VARCHAR(150);
ALTER TABLE client ADD surname VARCHAR(150);
ALTER TABLE client ADD birthday DATE;
ALTER TABLE client ADD sex VARCHAR(1);

ALTER TABLE phone_number MODIFY number VARCHAR(11);


-- -------------------------------------------------------------------------------------


use db_pretty_style;

SELECT
	address.id
    , place
    , number
    , neighborhood
    , city
    , country
    , zip
    , complement
    , id_user
    , name
    , surname
FROM
	address
    INNER JOIN user ON user.id = id_user
WHERE address.deleted_at IS NULL and id_user = ?;


select * from address;

select * from client;

ALTER TABLE client ADD name VARCHAR(150);
ALTER TABLE client ADD surname VARCHAR(150);



-- --------------------------------------------------------------------------------------------


use db_pretty_style;

-- SELECT * FROM product;
-- SELECT * FROM product_photo;
-- SELECT * FROM mark;
-- SELECT * FROM item;

SELECT
	p.id
    , p.name
    , p.description
    , p.price
    , p.created_at
    , p.id_mark
    , m.name as 'mark'
    , pp.id as 'id_photo'
    , pp.url
    , i.id as 'id_item'
    , i.quantity
FROM
	product p
    LEFT JOIN product_photo pp ON p.id = pp.id_product
    INNER JOIN mark m ON p.id_mark = m.id
    INNER JOIN item i ON p.id = i.id_product
WHERE i.id_client = 1;

-- QUERY DE LISTAGEM DE LIKES POR CLIENTE

SELECT
	p.id
    , p.name
    , p.description
    , p.price
    , p.id_mark
    , cpl.action
FROM
	client_product_like cpl
    INNER JOIN product p ON cpl.id_product = p.id
WHERE cpl.id_client = 1;

-- UPDATE item SET id_product = 2 WHERE id = 8;




SELECT
	p.id
	, p.name
	, p.description
	, p.price
	, p.id_mark
	, cpl.id as 'id_cpl'
	, cpl.id_product
	, cpl.id_client
	, cpl.action
FROM
	client_product_like cpl
	INNER JOIN product p ON cpl.id_product = p.id
WHERE cpl.id_client = 1 AND p.deleted_at IS NULL;


SELECT
	*
FROM
    mark
WHERE id_provider = 2 AND deleted_at IS NULL;

SELECT
	c.*
FROM
	product p
    INNER JOIN product_category pc ON p.id = pc.id_product
    INNER JOIN category c ON pc.id_category = c.id
WHERE p.id_provider = 2;



-- ----------------------------------------------------------------------------

INSERT INTO product_photo (url, name, id_product) VALUES ('/Uploads/jbl.png', 'jbl.png', 1);

INSERT INTO provider (cnpj, id_user, social_reason, contact) VALUES ('12.345.678/1234-89', 11, '', '');

INSERT INTO client_product_like (id_product, id_client, action) VALUES (1, 1, 1);

INSERT INTO client_product_like (id_product, id_client, action) VALUES (2, 1, 1);

INSERT INTO client_product_like (id_product, id_client, action) VALUES (7, 1, 0);

INSERT INTO product_category (id_product, id_category) VALUES (1, 1);

INSERT INTO product_category (id_product, id_category) VALUES (2, 1);

INSERT INTO product_category (id_product, id_category) VALUES (3, 1);

INSERT INTO product_category (id_product, id_category) VALUES (7, 1);


-- ------------------------------------------------------------------------------------


SELECT * FROM mark;
SELECT * FROM product;
SELECT * FROM category;
SELECT * FROM product_category;
SELECT * FROM product_photo;
SELECT * FROM user;
SELECT * FROM provider;
SELECT * FROM client;
SELECT * FROM address;
SELECT * FROM phone_number;
SELECT * FROM request;
SELECT * FROM item;
SELECT * FROM item_request;
SELECT * FROM client_product_like;

-- ALTER TABLE product ADD id_provider INT;
-- ALTER TABLE product ADD FOREIGN KEY (id_provider) REFERENCES provider (id);
-- ALTER TABLE provider ADD fantasy_name VARCHAR(150);
-- ALTER TABLE provider DROP COLUMN cantasy_name;
-- ALTER TABLE request ADD type_payment VARCHAR(50);
-- ALTER TABLE request MODIFY COLUMN number_request VARCHAR(42);
-- ALTER TABLE mark ADD id_provider INT;
-- ALTER TABLE mark ADD FOREIGN KEY (id_provider) REFERENCES provider (id);
-- ALTER TABLE category ADD id_provider INT;
-- ALTER TABLE category ADD FOREIGN KEY (id_provider) REFERENCES provider (id);
-- ALTER TABLE client_product_like ADD id_user INT;
-- ALTER TABLE client_product_like ADD CONSTRAINT fk_client_product_like__id_user FOREIGN KEY (id_user) REFERENCES user (id);
-- ALTER TABLE client_product_like DROP COLUMN id_client;
-- ALTER TABLE client_product_like DROP FOREIGN KEY fk_client_product__id_client;
-- ALTER TABLE client_product_like DROP COLUMN id_provider;
-- ALTER TABLE client_product_like DROP FOREIGN KEY client_product_like_ibfk_1;

-- UPDATE provider SET fantasy_name = 'Pretty Style' WHERE id = 2;
-- UPDATE product SET id_provider = 2;
-- UPDATE client SET name = 'Bruno' WHERE id = 1;
-- UPDATE client SET surname = 'Futema' WHERE id = 1;
-- UPDATE mark SET id_provider = 2;
-- UPDATE category SET id_provider = 2;
-- UPDATE product SET id_provider = 2;
-- UPDATE client_product_like SET id_user = 1;



-- SELECTS

SELECT * FROM address;
SELECT * FROM category;
SELECT * FROM client;
SELECT * FROM client_product_like;
SELECT * FROM item;
SELECT * FROM item_request;
SELECT * FROM mark;
SELECT * FROM phone_number;
SELECT * FROM product;
SELECT * FROM product_category;
SELECT * FROM product_photo;
SELECT * FROM product_request;
SELECT * FROM provider;
SELECT * FROM request;
SELECT * FROM user;
SELECT * FROM user_address;





-- --------------------------------------------------------------------------------------

use db_pretty_style;

-- select * from product_photo;

-- SELECT * FROM product WHERE deleted_at IS NULL LIMIT 8;
-- \WebContent\Upload\jbl.png

-- SELECT * FROM product_photo;
-- select * from product where deleted_at is null;

-- update product set deleted_at = now() where id = 113;

-- update product set description = 'Descrição de um produto 8' where id = 116;
-- update product set id_provider = 2;

-- update product_photo set url = '\\PrettyStyle\\WebContent\\Upload\\man1.png' where id = 11;
-- update product_photo set url = '\\PrettyStyle\\WebContent\\Upload\\man2.png' where id = 12;

SELECT
	p.id
    , p.name
    , p.description
    , p.price
    , p.id_mark
    , p.id_provider
    , p.created_at
    , pp.id as 'id_photo'
    , pp.url
    , pp.name as 'photo_name'
FROM	
	product p
    INNER JOIN product_photo pp ON p.id = pp.id_product
WHERE p.deleted_at IS NULL LIMIT 16;