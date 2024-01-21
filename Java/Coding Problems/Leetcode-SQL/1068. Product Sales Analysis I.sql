USE leetcode_db;

DROP TABLE IF EXISTS Product;

CREATE TABLE Product(
product_id INT,
product_name VARCHAR(50)
);

ALTER TABLE Product
MODIFY COLUMN product_id INT PRIMARY KEY;

CREATE TABLE Sales(
sale_id INT PRIMARY KEY,
product_id INT,
year INT,
quantity INT,
price INT,
FOREIGN KEY(product_id) REFERENCES Product(product_id) 
);

INSERT INTO product 
VALUES	(100,"Nokia"),
		(200,"Apple"),
		(300,"Samsung");



INSERT INTO sales (sale_id,product_id,year,quantity,price)
VALUES	(1,100,2008,10,5000),
		(2,100,2009,12,5000),
		(3,200,2011,15,9000);
        
        
SELECT P.product_name, S.year,S.price FROM sales S
LEFT JOIN product P
ON S.product_id = P.product_id;

