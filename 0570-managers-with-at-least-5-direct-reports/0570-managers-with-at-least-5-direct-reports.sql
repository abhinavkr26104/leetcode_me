# Write your MySQL query statement below
SELECT Name 
FROM Employee 
WHERE Id IN (
    SELECT ManagerId 
    FROM Employee 
    GROUP BY ManagerId 
    HAVING COUNT(DISTINCT Id) >= 5
);
