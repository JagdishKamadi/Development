USE college;

SELECT * FROM student;

UPDATE  student
SET name = "Jack"
WHERE rollno=101;

-- turn off safe mode first 
SET SQL_SAFE_UPDATES = 0;

UPDATE student
SET marks = marks+1;

-- turn on safe mode first 
SET SQL_SAFE_UPDATES = 1;
