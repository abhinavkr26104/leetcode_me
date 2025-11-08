# Write your MySQL query statement below
select unique_id,name
from employees
left join EmployeeUNI on employees.id=employeeUNI.id