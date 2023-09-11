# Write your MySQL query statement below
SELECT eid.unique_id,e.name FROM Employees as e LEFT JOIN EmployeeUNI as eid ON e.id=eid.id;