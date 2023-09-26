# Write your MySQL query statement below
# select user_id,round((select count(*) from Confirmations where action=confirmed group by (user_id) )(select count(*) from Confirmations group by user_id),2) confirmation_rate from Signups;
# select s.user_id,round(c1.user_id*1.0/c2.user_id,2) confirmation_rate from Signups s left join Confirmations as c1 on s.user_id=c1.user_id and c1.action='confirmed' left join Confirmations as c2 on s.user_id=c2.user_id group by s.user_id;
SELECT s.user_id, 
       ROUND(ifnull(sum(action='confirmed')/count(*),0), 2) AS confirmation_rate
FROM Signups s
LEFT JOIN Confirmations c1 ON s.user_id = c1.user_id
GROUP BY s.user_id;
