USE college;

CREATE VIEW student_view as 
SELECT * FROM student LIMIT 5;

SELECT * FROM student_view;

DROP  VIEW student_view;