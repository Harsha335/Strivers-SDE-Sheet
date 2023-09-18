# Write your MySQL query statement below
# select distinct d.id from Weather d where d.temperature>(select b.temperature from Weather b where datediff(b.recordDate,d.recordDate)=1);
select a.id from Weather a,Weather b where a.temperature>b.temperature AND datediff(a.recordDate,b.recordDate)=1;