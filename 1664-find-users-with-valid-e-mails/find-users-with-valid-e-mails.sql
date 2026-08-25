# Write your MySQL query statement below
-- select user_id,name, mail from Users where mail REGEXP BINARY '^[A-Za-z][A-Za-z0-9_.-]*@leetcode[.]com$';

SELECT user_id, name, mail
FROM Users
WHERE REGEXP_LIKE(
    mail,
    '^[A-Za-z][A-Za-z0-9_.-]*@leetcode[.]com$',
    'c'
);