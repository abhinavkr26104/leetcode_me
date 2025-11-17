
select 
    substring(trans_date, 1,7)  as month, 
    country   as  country, 
    count(amount)    as trans_count,
    sum(if(state='approved',1, 0))  as approved_count,
    sum(amount)      as trans_total_amount,
    sum(case when state = 'approved' then amount else 0 end)   as approved_total_amount
from Transactions 
group by month, country

 
