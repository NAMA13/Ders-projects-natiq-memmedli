CREATE TABLE computers (
  id int NOT NULL PRIMARY KEY AUTO_INCREMENT,
  model varchar(45) DEFAULT NULL,
  brand varchar(45) DEFAULT NULL,
  price int DEFAULT NULL,
  computerDate date DEFAULT NULL);
 
insert into computers(model,brand,price,computerDate)
values 
('Pavilon','HP',3899,'2020-07-06'),
('Omen :)','Lenova',4899,'2022-07-06'),
('Pavilon','HP',3899,'2018-07-06'),
('Pavilon','HP',3899,'2012-07-06');

create table users
(username varchar(50),
password varchar(100),
enabled int);

create table authorities
(username varchar(50),
authority varchar(50));

insert into users (username,password,enabled) values
('Natiq','{noop}321',1),
('Uzeyir','{noop}123',1),
('Eli','{noop}123',0),
('Mehemmed','{noop}123',0),
('Nihad','{noop}123',0),
('Huseyn','{noop}123',0);


insert into authorities (username,authority) values
('Natiq','computer:get:all'),
('Natiq','computer:delete'),
('Natiq','computer:edit'),
('Natiq','computer:search'),
('Natiq','computer:add'),
('Natiq','computer:save'),
('Uzeyir','admin'),
('Eli','admin'),
('Mehemmed','admin'),
('Nihad','admin'),
('Huseyn','admin');