USE college;

DROP TABLE IF EXISTS student;

CREATE TABLE student(
id INT PRIMARY KEY,
name VARCHAR(50)
);

INSERT INTO student
VALUES	(101, 	"Jagdish"),
		(102,	"Madhur"),
		(103, 	"Tejas");
        
CREATE TABLE course(
id INT PRIMARY KEY,
course VARCHAR(50)
);

INSERT INTO course
VALUES 	(102,	"English"),
		(103, 	"Math"),
        (105, 	"Science"),
        (107,	"Histroy");
        
        
        
-- all types of joing is given below

-- inner join
SELECT s.id, s.name, c.course FROM student s
INNER JOIN course c
ON s.id = c.id;

-- outer join has 3 types
-- 1) left join / left outer join
-- 2) right join / right outer join
-- 3) full join / full outer join

-- left join
SELECT s.id, s.name, c.course FROM student AS s
LEFT JOIN course AS c
ON s.id = c.id;

-- right join
SELECT s.id, s.name, c.course FROM student AS s
RIGHT JOIN course AS c
ON s.id = c.id;

-- full join
-- for full join we have to take the union of left and right join
SELECT s.id, s.name, c.course FROM student s
LEFT JOIN course c
ON s.id = c.id 
UNION
SELECT s.id, s.name, c.course FROM student s
RIGHT JOIN course c
ON s.id = c.id;


-- special join
-- left exclusive join
SELECT s.id, s.name, c.course FROM student s
LEFT JOIN course c
ON s.id = c.id
WHERE c.id IS NULL;

-- right exclusive join
SELECT c.id, c.course FROM student s
RIGHT JOIN course c
ON s.id = c.id
WHERE s.id IS NULL;

-- exclusive data from the both TABLE
SELECT * FROM student s
LEFT JOIN course c
ON s.id = c.id 
WHERE c.id IS NULL
UNION
SELECT * FROM student s
RIGHT JOIN course c
ON s.id = c.id
WHERE s.id IS NULL;



-- self join example
CREATE TABLE employee(
id INT,
name VARCHAR(50),
manager_id INT
);

INSERT INTO employee
VALUES 	(101,	"adam",		103),	
		(102,	"bob",		104),	
		(103,	"casey",	null),	
		(104,	"donald",	103);	
        
SELECT * FROM employee e1
JOIN employee e2
ON e1.id = e2.manager_id;

SELECT e2.manager_id, e1.name AS manager_name, e2.name AS employee_name FROM employee e1
JOIN employee e2
ON e1.id = e2.manager_id;

