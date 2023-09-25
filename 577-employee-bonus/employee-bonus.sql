# Write your MySQL query statement below
select e.name,b.bonus from Employee e LEFT Join Bonus b on e.empId= b.empId where b.bonus is null or b.bonus<1000;