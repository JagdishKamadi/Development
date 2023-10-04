USE college;

-- add the new column
ALTER TABLE student
ADD COLUMN age INT CHECK( age >=0 AND age <100)  DEFAULT 18;


-- remove the column
ALTER TABLE student
DROP COLUMN AGE;

-- change the column name
ALTER TABLE student
CHANGE COLUMN NAME mark INT;


-- modify the column
ALTER TABLE student
MODIFY COLUMN city VARCHAR(25);

-- change the table name
ALTER TABLE student
RENAME TO stu;

ALTER TABLE stu
RENAME TO student;



SELECT * FROM student;

