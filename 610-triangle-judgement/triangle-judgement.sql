# Write your MySQL query statement below
select x,y,z,(if((x+y+z)-greatest(x,y,z)>greatest(x,y,z),"Yes","No")) as triangle from Triangle;
# select x,y,z,(CASE WHEN ((x+y+z)-greatest(x,y,z))>greatest(x,y,z) then "Yes" ELSE "No" END) as triangle from Triangle;