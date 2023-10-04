-- there are 3 ways to write the sub queries
-- 1) select
-- 1) from 
-- 1) where


USE colllege;

SELECT * FROM student;

--  with where clause
SELECT name, mark FROM student
WHERE mark > (SELECT  AVG(mark) FROM student);

SELECT * FROM student
WHERE mark IN (SELECT min(mark) FROM student);

-- from clause
SELECT MAX(mark) FROM (SELECT mark FROM student WHERE city = "Wardha") AS temp;

SELECT AVG(mark) FROM (SELECT mark FROM student WHERE city = "Wardha") AS temp;

