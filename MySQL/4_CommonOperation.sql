SELECT * FROM student;

SELECT * FROM student
WHERE marks>85;

SELECT * FROM student
WHERE marks BETWEEN 70 AND 90;

SELECT * FROM student
WHERE city IN ("Wardha","Borgaon");

SELECT * FROM student
WHERE marks > 80 
LIMIT 2;

SELECT name, marks FROM student
ORDER BY name;

SELECT * FROM student
ORDER BY name DESC;

SELECT MAX(marks) FROM student;

SELECT MIN(marks) FROM student;

SELECT AVG(marks) FROM student;


SELECT DISTINCT(city) FROM student;
