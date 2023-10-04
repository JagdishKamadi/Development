SELECT city FROM student
GROUP BY city;


SELECT city, COUNT(name)
FROM student
GROUP BY city;

SELECT city, COUNT(name)
FROM student
GROUP BY city
ORDER BY name DESC;

SELECT grade, city, COUNT(name)
FROM student
GROUP BY grade, city;

SELECT grade, city, COUNT(name)
FROM student
WHERE marks >=80
GROUP BY grade, city;

USE  college;
