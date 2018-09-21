CREATE TABLE `order`
(
  id int PRIMARY KEY AUTO_INCREMENT,
  user_id int
);

CREATE TABLE order_item
(
  id int PRIMARY KEY AUTO_INCREMENT,
  quantity int,
  order_id int,
  product_id int,
  CONSTRAINT order_item_product_id_fk FOREIGN KEY (product_id) REFERENCES product (id),
  CONSTRAINT order_item_order_id_fk FOREIGN KEY (order_id) REFERENCES `order` (id)
);