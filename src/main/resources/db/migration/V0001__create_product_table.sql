CREATE TABLE product
(
  id int PRIMARY KEY AUTO_INCREMENT,
  name text,
  price int,
  unit varchar(50),
  total_amount int,
  img_url text
);
CREATE UNIQUE INDEX product_id_uindex ON product (id);