USE leetcode_db;

CREATE TABLE Tweets(
tweet_id 	INT PRIMARY KEY,
content VARCHAR(50)
);

INSERT INTO Tweets
VALUES	(1,"Vote for Biden"),
		("2","Let us make America great again!");
        
        
SELECT * FROM Tweets;

SELECT tweet_id 
FROM Tweets
WHERE LENGTH(content)>15;
