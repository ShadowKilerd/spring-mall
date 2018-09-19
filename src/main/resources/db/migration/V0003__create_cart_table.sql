CREATE TABLE cart
(
  id int PRIMARY KEY AUTO_INCREMENT,
  product_id int,
  quantity int
);
CREATE UNIQUE INDEX cart_id_uindex ON cart (id);