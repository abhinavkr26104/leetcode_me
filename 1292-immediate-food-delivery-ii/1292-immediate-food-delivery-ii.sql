# Write your MySQL query statement below
SELECT ROUND(
           SUM(CASE WHEN order_date = customer_pref_delivery_date THEN 1 ELSE 0 END) 
           * 100.0 / COUNT(*), 
           2
       ) AS immediate_percentage
FROM (
    SELECT customer_id,
           MIN(order_date) AS first_order_date
    FROM Delivery
    GROUP BY customer_id
) f
JOIN Delivery d
  ON f.customer_id = d.customer_id
 AND f.first_order_date = d.order_date;
