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
  
 
