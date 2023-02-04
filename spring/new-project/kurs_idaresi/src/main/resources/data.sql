create table authorities
(username varchar(50),
authority varchar(50));

insert into users (username,password,enabled) values
('adil','{bcrypt}$2a$12$Ji1Jengu.ugeOPWqy5jokOQT8H9Jy2GvNIm56Cd/5G4rlgH/Xre1O',1),
('cavid','{noop}123',1),
('hesen','{noop}123',1);

insert into authorities (username,authority) values
('adil','student:get:all'),
('adil','student:delete'),
('adil','student:edit'),
('adil','student:search'),
('adil','student:add'),
('adil','student:save'),

('cavid','student:get:all'),
('cavid','student:search'),

('hesen','student:get:all'),
('hesen','student:delete'),
('hesen','student:add'),
('hesen','student:save');
