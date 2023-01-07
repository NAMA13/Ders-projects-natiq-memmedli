CREATE TABLE students (
  id int NOT NULL PRIMARY KEY AUTO_INCREMENT,
  name varchar(45) DEFAULT NULL,
  surname varchar(45) DEFAULT NULL,
  phone varchar(45) DEFAULT NULL,
  birthday date DEFAULT NULL,
  point int,
  email varchar(45) DEFAULT NULL,
  sector varchar(45) DEFAULT NULL);
 
  
  
insert into students
 
(name,surname,birthday,sector,point,email,phone)
values 
('Üzeyir','Məmmədov','2001-03-06','Az',88,'uzeyir@gmail.com','066-565-9899'),
('Natiq','Məmmədli','2001-03-06','Türk',89,'natiq@gmail.com','066-565-9899'),
('Nihad','Məhərrəmli','1999-08-06','Ingilis',90,'nihad@gmail.com','066-565-9899'),
('Hüseyn','Hüseynov','2006-03-06','Türk',98,'huseyn@gmail.com','066-565-9899'),
('Əli','Əzizli','2005-03-06','Ingilis',99,'eli@gmail.com','066-565-9899'),
('Məhəmməd','Vəliyev','2012-07-06','Az',94,'mehemmed@gmail.com','066-565-9899');
  
create table users
(username varchar(50),
password varchar(100),
enabled int);

create table authorities
(username varchar(50),
authority varchar(50));

insert into users (username,password,enabled) values
('adil','{bcrypt}$2a$12$Ji1Jengu.ugeOPWqy5jokOQT8H9Jy2GvNIm56Cd/5G4rlgH/Xre1O',1),
('cavid','{noop}123',0),
('hesen','{noop}123',1);

insert into authorities (username,authority) values
('adil','admin'),
('cavid','admin'),
('hesen','admin');











