# Write your MySQL query statement below
select d.name AS Department,e.name AS Employee,e.salary AS Salary
from (select id, name,salary,departmentId, Dense_Rank() over (partition by departmentId
order by salary desc) AS salary_rank from Employee) e
join department d ON e.departmentId = d.id where e.salary_rank <= 3;