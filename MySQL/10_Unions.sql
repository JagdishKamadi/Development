USE college;

SHOW TABLES;

SELECT * FROM teacher;
SELECT * FROM dept;
SELECT * FROM employee;

SELECT * FROM teacher
UNION
SELECT * FROM employee; 

SELECT * FROM teacher
UNION ALL
SELECT * FROM employee; 
