CREATE TABLE students (
  id int NOT NULL PRIMARY KEY AUTO_INCREMENT,
  name varchar(45) DEFAULT NULL,
  surname varchar(45) DEFAULT NULL,
  phone varchar(45) DEFAULT NULL,
  birthday date DEFAULT NULL,
  point int,
  sector varchar(45) DEFAULT NULL);
 
  
  
insert into students
(name,surname,birthday,sector,point,phone)
values 
('Üzeyir','Məmmədov','2001-03-06','Az',88,'066-565-9899'),
('Natiq','Məmmədli','2001-03-06','Türk',89,'066-565-5433'),
('Nihad','Məhərrəmli','1999-08-06','Ingilis',90,'066-565-5698'),
('Hüseyn','Hüseynov','2006-03-06','Türk',98,'066-565-5443'),
('Əli','Əzizli','2005-03-06','Ingilis',99,'066-565-7688'),
('Məhəmməd','Vəliyev','2012-07-06','Az',94,'066-565-1232');