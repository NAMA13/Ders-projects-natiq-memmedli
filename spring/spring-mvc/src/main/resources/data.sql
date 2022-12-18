CREATE TABLE computers (
  id int NOT NULL PRIMARY KEY AUTO_INCREMENT,
  model varchar(45) DEFAULT NULL,
  brand varchar(45) DEFAULT NULL,
  price int DEFAULT NULL);
 
insert into computers(model,brand,price)
values 
('Pavilon','HP',3899),
('Omen :)','Lenova',4899),
('Pavilon','HP',3899),
('Pavilon','HP',3899);