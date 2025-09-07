# Write your MySQL query statement below
SELECT r.contest_id,
       ROUND(COUNT(r.user_id) * 100.0 / (SELECT COUNT(*) FROM Users), 2) AS percentage
FROM Register r
GROUP BY r.contest_id
order by 
percentage DESC, -- Order the results by percentage in descending order
  contest_id;