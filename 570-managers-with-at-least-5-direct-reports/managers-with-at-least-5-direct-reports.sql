# Write your MySQL query statement below
# select m.name from Employee as m having count(select * from Employee as e where e.managerId=m.id)>4;
# select m.name from employee as m where (select count(*) from Employee as e where e.managerId=m.id)>=5;
select m.name from Employee as m join Employee as e on m.id=e.managerId group by e.managerId having count(*)>=5;