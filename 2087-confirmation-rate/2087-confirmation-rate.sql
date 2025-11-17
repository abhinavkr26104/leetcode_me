# Write your MySQL query statement below
SELECT 
    Signups.user_id,
    COALESCE(ROUND(AVG(action = 'confirmed'), 2), 0) AS confirmation_rate
FROM Signups
LEFT JOIN Confirmations 
    ON Signups.user_id = Confirmations.user_id
GROUP BY Signups.user_id;
