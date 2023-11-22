select distinct p.product_id,ifnull(x.price,10) as price from Products p left join (select product_id,new_price as price from Products where (product_id,change_date) in (SELECT product_id ,max(change_date) from Products where change_date<="2019-08-16" group by product_id)) as x on x.product_id=p.product_id;