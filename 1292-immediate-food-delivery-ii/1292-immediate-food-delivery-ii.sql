# Write your MySQL query statement below
SELECT 
    ROUND(AVG(lookup.a) * 100, 2) AS immediate_percentage
FROM (
    SELECT 
        MIN(order_date) = MIN(customer_pref_delivery_date) AS a
    FROM Delivery
    GROUP BY customer_id
) AS lookup;
