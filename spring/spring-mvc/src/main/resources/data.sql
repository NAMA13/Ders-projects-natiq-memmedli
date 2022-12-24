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