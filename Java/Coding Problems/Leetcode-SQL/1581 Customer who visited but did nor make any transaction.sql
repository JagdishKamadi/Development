USE leetcode_db;

CREATE TABLE transactions
(
transaction_id	INT UNIQUE,
visit_id		INT,
amount         	INT 
);

ALTER TABLE transactions
MODIFY COLUMN transaction_id INT PRIMARY KEY;

CREATE TABLE Visits
(
visit_id INT PRIMARY KEY,
customer_id INT
);

INSERT INTO transactions
VALUES	(2,5,310),
		(3,5,300),
		(9,5,200),
		(12,1,910),
		(13,2,970);
        
        
INSERT INTO Visits
VALUES	(1,23),
		(2,9),
		(4,30),
		(5,54),
		(6,96),
		(7,54),
		(8,54);
        
        
SELECT v.customer_id, COUNT(v.visit_id) AS count_no_trans
FROM visits v
LEFT JOIN transactions t 
ON v.visit_id = t.visit_id
WHERE t.transaction_id IS NULL
GROUP BY v.customer_id;
