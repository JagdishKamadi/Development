USE leetcode_db;

CREATE TABLE Weather(
id 				INT PRIMARY KEY,
recordDate    	DATE,
temperature   INT
);



INSERT INTO Weather
VALUES	(2,'2015-01-02',25),
		(3,'2015-01-03',20),
		(4,'2015-01-04',30);
        
SELECT * FROM Weather;

SELECT w1.id
FROM Weather w1, Weather w2
WHERE DATEDIFF(w1.recordDate, w2.recordDate) = 1 AND w1.temperature > w2.temperature;