CREATE TABLE users
(
    id       INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50)  NOT NULL,
    password VARCHAR(255) NOT NULL,
    enabled  BOOLEAN DEFAULT true
);



create table authorities
(
    username  varchar(50),
    authority varchar(50)
);
--
-- CREATE TABLE computers
-- (
--     id          INT PRIMARY KEY AUTO_INCREMENT,
--     name        VARCHAR(255)   NOT NULL,
--     image       TEXT           NOT NULL,
--     description TEXT           NOT NULL,
--     price      INT NOT NULL,
--     phone       VARCHAR(20)    NOT NULL,
--     is_new      BOOLEAN        NOT NULL,
--     ram         INT            NOT NULL,
--     cpu         VARCHAR(255)   NOT NULL,
--     drive       VARCHAR(255)   NOT NULL,
--     drive_type  VARCHAR(255)   NOT NULL,
--     os          VARCHAR(255)   NOT NULL,
--     video_card  VARCHAR(255)   NOT NULL
-- );


insert into users (username, password, enabled)
values ('admin', '{noop}aa', 1),
       ('cavid', '{noop}123', 1),
       ('hesen', '{noop}123', 1);

insert into authorities (username, authority)
values ('admin', 'account:admin'),
       ('admin', 'account:user'),

       ('cavid', 'account:user'),

       ('hesen', 'account:user');

INSERT INTO computers (name, image, description, price, phone, is_new, ram, cpu, drive, drive_type, os, video_card,
                       category, username)
VALUES ('Dell XPS 13', '/images/dell.jpg', 'Intel Core i7, 16GB RAM, 512GB SSD', 1299.99, '+1 (555) 123-4567', true, 16,
        'Intel Core i7', '512GB SSD', 'SSD', 'Windows 10', 5, 'Dell', 'admin'),
       ('Dell XPS 13', '/images/dell.jpg', 'Intel Core i7, 16GB RAM, 512GB SSD', 1299.99, '+1 (555) 123-4567', true, 16,
        'Intel Core i7', '512GB SSD', 'SSD', 'Windows 10', 5, 'Dell', 'admin'),
       ('Dell XPS 13', '/images/dell.jpg', 'Intel Core i7, 16GB RAM, 512GB SSD', 1299.99, '+1 (555) 123-4567', true, 16,
        'Intel Core i7', '512GB SSD', 'SSD', 'Windows 10', 5, 'Dell', 'admin'),
       ('Dell XPS 13', '/images/dell.jpg', 'Intel Core i7, 16GB RAM, 512GB SSD', 1299.99, '+1 (555) 123-4567', true, 16,
        'Intel Core i7', '512GB SSD', 'SSD', 'Windows 10', 5, 'Dell', 'admin'),
       ('Dell XPS 13', '/images/dell.jpg', 'Intel Core i7, 16GB RAM, 512GB SSD', 1299.99, '+1 (555) 123-4567', true, 16,
        'Intel Core i7', '512GB SSD', 'SSD', 'Windows 10', 5, 'Dell', 'admin'),
       ('Dell XPS 13', '/images/dell.jpg', 'Intel Core i7, 16GB RAM, 512GB SSD', 1299.99, '+1 (555) 123-4567', true, 16,
        'Intel Core i7', '512GB SSD', 'SSD', 'Windows 10', 5, 'Dell', 'admin'),
       ('Dell XPS 13', '/images/dell.jpg', 'Intel Core i7, 16GB RAM, 512GB SSD', 1299.99, '+1 (555) 123-4567', true, 16,
        'Intel Core i7', '512GB SSD', 'SSD', 'Windows 10', 5, 'Dell', 'admin'),
       ('Dell XPS 13', '/images/dell.jpg', 'Intel Core i7, 16GB RAM, 512GB SSD', 1299.99, '+1 (555) 123-4567', true, 16,
        'Intel Core i7', '512GB SSD', 'SSD', 'Windows 10', 5, 'Dell', 'admin'),
       ('Dell XPS 13', '/images/dell.jpg', 'Intel Core i7, 16GB RAM, 512GB SSD', 1299.99, '+1 (555) 123-4567', true, 16,
        'Intel Core i7', '512GB SSD', 'SSD', 'Windows 10', 5, 'Dell', 'admin'),
       ('Dell XPS 13', '/images/dell.jpg', 'Intel Core i7, 16GB RAM, 512GB SSD', 1299.99, '+1 (555) 123-4567', true, 16,
        'Intel Core i7', '512GB SSD', 'SSD', 'Windows 10', 5, 'Dell', 'admin'),
       ('Dell XPS 13', '/images/dell.jpg', 'Intel Core i7, 16GB RAM, 512GB SSD', 1299.99, '+1 (555) 123-4567', true, 16,
        'Intel Core i7', '512GB SSD', 'SSD', 'Windows 10', 5, 'Dell', 'admin'),
       ('Dell XPS 13', '/images/dell.jpg', 'Intel Core i7, 16GB RAM, 512GB SSD', 1299.99, '+1 (555) 123-4567', true, 16,
        'Intel Core i7', '512GB SSD', 'SSD', 'Windows 10', 5, 'Dell', 'admin'),
       ('Dell XPS 13', '/images/dell.jpg', 'Intel Core i7, 16GB RAM, 512GB SSD', 1299.99, '+1 (555) 123-4567', true, 16,
        'Intel Core i7', '512GB SSD', 'SSD', 'Windows 10', 5, 'Dell', 'admin'),
       ('Dell XPS 13', '/images/dell.jpg', 'Intel Core i7, 16GB RAM, 512GB SSD', 1299.99, '+1 (555) 123-4567', true, 16,
        'Intel Core i7', '512GB SSD', 'SSD', 'Windows 10', 5, 'Dell', 'admin'),
       ('Dell XPS 13', '/images/dell.jpg', 'Intel Core i7, 16GB RAM, 512GB SSD', 1299.99, '+1 (555) 123-4567', true, 16,
        'Intel Core i7', '512GB SSD', 'SSD', 'Windows 10', 5, 'Dell', 'admin'),
       ('Dell XPS 13', '/images/dell.jpg', 'Intel Core i7, 16GB RAM, 512GB SSD', 1299.99, '+1 (555) 123-4567', true, 16,
        'Intel Core i7', '512GB SSD', 'SSD', 'Windows 10', 5, 'Dell', 'admin'),
       ('Dell XPS 13', '/images/dell.jpg', 'Intel Core i7, 16GB RAM, 512GB SSD', 1299.99, '+1 (555) 123-4567', true, 16,
        'Intel Core i7', '512GB SSD', 'SSD', 'Windows 10', 5, 'Dell', 'admin'),
       ('Dell XPS 13', '/images/dell.jpg', 'Intel Core i7, 16GB RAM, 512GB SSD', 1299.99, '+1 (555) 123-4567', true, 16,
        'Intel Core i7', '512GB SSD', 'SSD', 'Windows 10', 5, 'Dell', 'admin'),
       ('Dell XPS 13', '/images/dell.jpg', 'Intel Core i7, 16GB RAM, 512GB SSD', 1299.99, '+1 (555) 123-4567', true, 16,
        'Intel Core i7', '512GB SSD', 'SSD', 'Windows 10', 5, 'Dell', 'admin'),
       ('Acer Nitro 5', '/images/acer.jpg',
        '15.6 inch gaming laptop with AMD Ryzen 5 processor, 8GB RAM, and NVIDIA GeForce GTX 1650 graphics card', 699,
        '123-456-7890', 1, 8, 'AMD Ryzen 5', '512 GB SSD', 'SSD', 'Windows 10 Home', 4, 'Acer', 'admin'),
       ('Acer Aspire 5', '/images/acer.jpg',
        '15.6 inch laptop with 11th Gen Intel Core i5 processor, 8GB RAM, and Intel Iris Xe graphics card', 599,
        '123-456-7890', 0, 8, 'Intel Core i5', '256 GB SSD', 'SSD', 'Windows 10 Home', 2, 'Acer', 'admin'),
       ('Acer Chromebook Spin 311', '/images/acer.jpg',
        '11.6 inch 2-in-1 Chromebook with MediaTek MT8183C processor, 4GB RAM, and integrated graphics', 279,
        '123-456-7890', 1, 4, 'MediaTek MT8183C', '32 GB eMMC', 'eMMC', 'Chrome OS', 0, 'Acer', 'admin'),
       ('Acer Predator Triton 500', '/images/acer.jpg',
        '15.6 inch thin and light gaming laptop with 10th Gen Intel Core i7 processor, 16GB RAM, and NVIDIA GeForce RTX 2080 Super graphics card',
        2299, '123-456-7890', 1, 16, 'Intel Core i7', '1 TB SSD', 'SSD', 'Windows 10 Home', 8, 'Acer', 'admin'),
       ('Acer Spin 5', '/images/acer.jpg',
        '13.5 inch 2-in-1 laptop with 11th Gen Intel Core i5 processor, 8GB RAM, and Intel Iris Xe graphics card', 999,
        '123-456-7890', 1, 8, 'Intel Core i5', '512 GB SSD', 'SSD', 'Windows 10 Home', 2, 'Acer', 'admin'),
       ('Acer Nitro 5', '/images/acer.jpg',
        '15.6 inch gaming laptop with AMD Ryzen 5 processor, 8GB RAM, and NVIDIA GeForce GTX 1650 graphics card', 699,
        '123-456-7890', 1, 8, 'AMD Ryzen 5', '512 GB SSD', 'SSD', 'Windows 10 Home', 4, 'Acer', 'admin'),
       ('Acer Aspire 5', '/images/acer.jpg',
        '15.6 inch laptop with 11th Gen Intel Core i5 processor, 8GB RAM, and Intel Iris Xe graphics card', 599,
        '123-456-7890', 0, 8, 'Intel Core i5', '256 GB SSD', 'SSD', 'Windows 10 Home', 2, 'Acer', 'admin'),
       ('Acer Chromebook Spin 311', '/images/acer.jpg',
        '11.6 inch 2-in-1 Chromebook with MediaTek MT8183C processor, 4GB RAM, and integrated graphics', 279,
        '123-456-7890', 1, 4, 'MediaTek MT8183C', '32 GB eMMC', 'eMMC', 'Chrome OS', 0, 'Acer', 'admin'),
       ('Acer Predator Triton 500', '/images/acer.jpg',
        '15.6 inch thin and light gaming laptop with 10th Gen Intel Core i7 processor, 16GB RAM, and NVIDIA GeForce RTX 2080 Super graphics card',
        2299, '123-456-7890', 1, 16, 'Intel Core i7', '1 TB SSD', 'SSD', 'Windows 10 Home', 8, 'Acer', 'admin'),
       ('Acer Spin 5', '/images/acer.jpg',
        '13.5 inch 2-in-1 laptop with 11th Gen Intel Core i5 processor, 8GB RAM, and Intel Iris Xe graphics card', 999,
        '123-456-7890', 1, 8, 'Intel Core i5', '512 GB SSD', 'SSD', 'Windows 10 Home', 2, 'Acer', 'admin'),
       ('Acer Nitro 5', '/images/acer.jpg',
        '15.6 inch gaming laptop with AMD Ryzen 5 processor, 8GB RAM, and NVIDIA GeForce GTX 1650 graphics card', 699,
        '123-456-7890', 1, 8, 'AMD Ryzen 5', '512 GB SSD', 'SSD', 'Windows 10 Home', 4, 'Acer', 'admin'),
       ('Acer Aspire 5', '/images/acer.jpg',
        '15.6 inch laptop with 11th Gen Intel Core i5 processor, 8GB RAM, and Intel Iris Xe graphics card', 599,
        '123-456-7890', 0, 8, 'Intel Core i5', '256 GB SSD', 'SSD', 'Windows 10 Home', 2, 'Acer', 'admin'),
       ('Acer Chromebook Spin 311', '/images/acer.jpg',
        '11.6 inch 2-in-1 Chromebook with MediaTek MT8183C processor, 4GB RAM, and integrated graphics', 279,
        '123-456-7890', 1, 4, 'MediaTek MT8183C', '32 GB eMMC', 'eMMC', 'Chrome OS', 0, 'Acer', 'admin'),
       ('Acer Predator Triton 500', '/images/acer.jpg',
        '15.6 inch thin and light gaming laptop with 10th Gen Intel Core i7 processor, 16GB RAM, and NVIDIA GeForce RTX 2080 Super graphics card',
        2299, '123-456-7890', 1, 16, 'Intel Core i7', '1 TB SSD', 'SSD', 'Windows 10 Home', 8, 'Acer', 'admin'),
       ( 'HP Computer', '/images/hp.jpg', 'A powerful and reliable computer from HP', 800, '555-1234', true, 16,
        'Intel Core i7', '1TB SSD', 'SSD', 'Windows 10', 4, 'Hp','admin'),
       ( 'HP Computer', '/images/hp.jpg', 'A powerful and reliable computer from HP', 800, '555-1234', true, 16,
        'Intel Core i7', '1TB SSD', 'SSD', 'Windows 10', 4, 'Hp','admin'),
       ( 'HP Computer', '/images/hp.jpg', 'A powerful and reliable computer from HP', 800, '555-1234', true, 16,
        'Intel Core i7', '1TB SSD', 'SSD', 'Windows 10', 4, 'Hp','admin'),
       ( 'HP Computer', '/images/hp.jpg', 'A powerful and reliable computer from HP', 800, '555-1234', true, 16,
        'Intel Core i7', '1TB SSD', 'SSD', 'Windows 10', 4, 'Hp','admin'),
       ( 'HP Computer', '/images/hp.jpg', 'A powerful and reliable computer from HP', 800, '555-1234', true, 16,
        'Intel Core i7', '1TB SSD', 'SSD', 'Windows 10', 4, 'Hp','admin'),
       ( 'HP Computer', '/images/hp.jpg', 'A powerful and reliable computer from HP', 800, '555-1234', true, 16,
        'Intel Core i7', '1TB SSD', 'SSD', 'Windows 10', 4, 'Hp','admin'),
       ( 'HP Computer', '/images/hp.jpg', 'A powerful and reliable computer from HP', 800, '555-1234', true, 16,
        'Intel Core i7', '1TB SSD', 'SSD', 'Windows 10', 4, 'Hp','admin'),
       ( 'HP Computer', '/images/hp.jpg', 'A powerful and reliable computer from HP', 800, '555-1234', true, 16,
        'Intel Core i7', '1TB SSD', 'SSD', 'Windows 10', 4, 'HP','admin');

insert into categories (name)
values ('Acer'),
    ('HP'),
    ('Sony'),
    ('Lenovo'),
    ('Asus'),
    ('Toshiba'),
    ('Lenovo'),
    ('Dell'),
    ('Fujitsu'),
    ('Samsung');

insert into basket (image, name, price, quantity)
values ('/images/dell.jpg', 'comp 1', 1231, 1);
