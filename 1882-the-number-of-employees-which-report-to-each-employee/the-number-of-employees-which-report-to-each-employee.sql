# Write your MySQL query statement below
SELECT e.employee_id, e.name, COUNT(p.employee_id) AS reports_count, round(AVG(p.age)) AS average_age
FROM Employees e
INNER JOIN Employees p ON e.employee_id = p.reports_to
# WHERE p.reports_to IS NOT NULL
GROUP BY e.employee_id order by e.employee_id;