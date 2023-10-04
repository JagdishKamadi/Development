USE leetcode_db;

DROP TABLE IF EXISTS employee;

CREATE TABLE employee
(
id INT PRIMARY KEY,
name VARCHAR(50)
);

CREATE TABLE employeeUNI(
id INT,
unique_id INT,
PRIMARY KEY(id,unique_id)
);

INSERT INTO employee
VALUES	(1,"Alice"),
		(7,"Bob"),
		(11,"Meir"),
		(90,"Winston"),
		(3,"Jonathan");
        
INSERT INTO employeeUNI
VALUES 	(3,1),
		(11,2),
		(90,3);





SELECT * FROM employee;
SELECT * FROM employeeUNI;

SELECT employeeUNI.unique_id, employee.name FROM employee
LEFT JOIN employeeUNI
ON employee.id = employeeUNI.id
ORDER BY employeeUNI.unique_id;


