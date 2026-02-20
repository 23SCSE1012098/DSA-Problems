# Write your MySQL query statement below
-- WITH DailyActions AS (SELECT user_id, action_date, action FROM Activity
--     GROUP BY user_id, action_date HAVING COUNT(action) = 1
-- ), ConsecutiveStreaks AS (SELECT user_id, action, action_date, DATE_SUB(action_date, INTERVAL ROW_NUMBER() OVER(PARTITION BY user_id, action ORDER BY action_date) DAY) as grp
-- FROM DailyActions),StreakLengths AS (SELECT user_id, action, MIN(action_date) as start_date,
--     MAX(action_date) as end_date,
--      COUNT(*) as streak_length
--     FROM ConsecutiveStreaks
--     GROUP BY user_id, action, grp
-- )
-- SELECT user_id, action, streak_length, start_date, end_date FROM StreakLengths WHERE streak_length >= 5 ORDER BY user_id DESC, start_date DESC; 


WITH ConsecutiveGroups AS (
    SELECT 
        user_id,
        action,
        action_date,
        DATE_SUB(
            action_date,
            INTERVAL ROW_NUMBER() OVER (
                PARTITION BY user_id, action
                ORDER BY action_date
            ) DAY
        ) AS grp
    FROM activity
),

Streaks AS (
    SELECT
        user_id,
        action,
        MIN(action_date) AS start_date,
        MAX(action_date) AS end_date,
        COUNT(*) AS streak_length
    FROM ConsecutiveGroups
    GROUP BY user_id, action, grp
),

ValidStreaks AS (
    SELECT *
    FROM Streaks
    WHERE streak_length >= 5
),

RankedStreaks AS (
    SELECT *,
           ROW_NUMBER() OVER (
               PARTITION BY user_id
               ORDER BY streak_length DESC
           ) AS rnk
    FROM ValidStreaks
)

SELECT 
    user_id,
    action,
    streak_length,
    start_date,
    end_date
FROM RankedStreaks
WHERE rnk = 1
ORDER BY streak_length DESC, user_id ASC;