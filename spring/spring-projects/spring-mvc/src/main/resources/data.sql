CREATE TABLE students (
  id int NOT NULL PRIMARY KEY AUTO_INCREMENT,
  name varchar(45) DEFAULT NULL,
  surname varchar(45) DEFAULT NULL,
  birthday date DEFAULT NULL,
  sector varchar(45) DEFAULT NULL);
 
insert into students
(name,surname,birthday,sector)
values 
('Üzeyir','Məmmədov','2001-03-06','Az'),
('Natiq','Məmmədli','2001-03-06','Türk'),
('Nihad','Məhərrəmli','1999-08-06','Ingilis'),
('Hüseyn','Hüseynov','2006-03-06','Türk'),
('Əli','Əzizli','2005-03-06','Ingilis'),
('Məhəmməd','Vəliyev','2012-07-06','Az');