# Write your MySQL query statement below
select Distinct a.num  as ConsecutiveNums from Logs a
join Logs b on b.id=a.id+1 AND b.num = a.num
join logs c on c.id=a.id+2 AND c.num = a.num;