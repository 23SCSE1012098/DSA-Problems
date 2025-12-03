CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
  RETURN (
      # Write your MySQL query statement below.
      select salary from (select salary, Dense_Rank() over (order by salary DESC)
      AS ranking  from    Employee) AS ranked_salaries where ranking = N Limit 1);
END