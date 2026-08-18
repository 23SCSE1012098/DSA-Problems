# Write your MySQL query statement below
select class from courses GROUP BY CLASS HAVING COUNT(CLASS)>=5;