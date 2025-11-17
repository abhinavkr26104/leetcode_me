# Write your MySQL query statement below
SELECT 
    query_name,
    ROUND(AVG(rating / position), 2) AS quality,
    ROUND(
        100 * SUM(rating < 3) / COUNT(*),
        2
    ) AS poor_query_percentage
FROM Queries
GROUP BY query_name;
