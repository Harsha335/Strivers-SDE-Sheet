# Write your MySQL query statement below
select project_id , round(avg(experience_years),2) as average_years from  Employee e join Project p on p.employee_id=e.employee_id group by p.project_id;