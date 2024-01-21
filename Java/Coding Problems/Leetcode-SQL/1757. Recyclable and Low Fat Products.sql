USE leetcode_db;

CREATE TABLE Products(
product_id INT PRIMARY KEY,
low_fats ENUM('Y','N'),
recyclable ENUM('Y','N')
);

INSERT INTO Products
VALUES 	(0,'Y','N'),
		(1,'Y','Y'),
        (2,'N','Y'),
        (3,'Y','Y'),
        (4,'N','N');
        
        
SELECT * FROM Products;

SELECT product_id FROM  Products
WHERE  low_fats='Y' AND recyclable='Y';