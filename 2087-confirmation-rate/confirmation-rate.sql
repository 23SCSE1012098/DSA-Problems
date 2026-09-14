# Write your MySQL query statement below
SELECT s.user_id, IFNULL(Round(SUM(action='confirmed')/COUNT(action) , 2 ), 0.00)As confirmation_rate
from Signups s left join confirmations c on s.user_id=c.user_id group by s.user_id;