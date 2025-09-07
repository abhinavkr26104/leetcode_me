# Write your MySQL query statement below
SELECT e.unique_id, emp.name
FROM Employees emp
LEFT JOIN EmployeeUNI e
ON emp.id = e.id;
