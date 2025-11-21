SELECT 
    m.employee_id,
    m.name,
    COUNT(e.employee_id) AS reports_count,
    round(AVG(e.age),0) AS average_age
FROM employees e
JOIN employees m 
    ON e.reports_to = m.employee_id
GROUP BY m.employee_id, m.name
order by m.employee_id