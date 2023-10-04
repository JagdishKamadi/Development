USE college;

CREATE TABLE dept(
id INT PRIMARY KEY,
name VARCHAR(50)
);

DROP TABLE DEP;

DROP TABLE teacher;


CREATE TABLE teacher(
id INT PRIMARY KEY,
name VARCHAR(50),
dept_id INT,
FOREIGN KEY (dept_id) REFERENCES dept(id)
);

INSERT INTO dept
VALUES (101,"English"),
	   (102,"IT");
       
SELECT * FROM dept;
       
INSERT INTO teacher
VALUES	(1, "Jagdish",102),
		(2,	"Madhur",101);
        
SELECT * FROM teacher;


-- cascade type 
DROP TABLE teacher;
DROP TABLE dept;

CREATE TABLE dept(
id INT PRIMARY KEY,
name VARCHAR(50)
);

CREATE TABLE teacher(
id INT PRIMARY KEY,
name VARCHAR(50),
dept_id INT,
FOREIGN KEY (dept_id) REFERENCES dept(id)
ON UPDATE CASCADE
ON DELETE CASCADE
);

UPDATE dept
SET ID = 104
WHERE id = 101;





        
        