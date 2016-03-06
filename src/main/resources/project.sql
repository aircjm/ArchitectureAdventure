show DATABASES ;


create DATABASE demo CHARSET=utf8;

USE demo;

CREATE TABLE customer (
  id BIGINT NOT NULL AUTO_INCREMENT,
  name VARCHAR(255) DEFAULT NULL,
  contact VARCHAR(255) DEFAULT  NULL,
  telephone VARCHAR(255) DEFAULT  NULL ,
  email VARCHAR(255) DEFAULT NULL ,
  remark TEXT,
  PRIMARY KEY (id)
) ENGINE =InnoDB DEFAULT  CHARSET = utf8;


INSERT INTO customer (id, name, contact, telephone, email, remark) VALUES (1, 'customer1', 'Jack', 13248784512, 'jack@gamil.com', NULL);
INSERT INTO customer (id, name, contact, telephone, email, remark) VALUES (2, 'customer2', 'Rose', 13248781234, 'rose@gamil.com', NULL);


SELECT *
FROM customer;