CREATE VIEW clientAmount AS  SELECT c.tokenId,COALESCE(SUM(d.qty*dr.price),0) as total from client as c left join orderdb as o on o.tokenId = c.tokenId left join orderedDrink as d on d.orderId = o.orderId left join Drink as dr on d.drinkId = dr.drinkId group by c.tokenId;

CREATE VIEW freeTable AS  SELECT tableId from tabledb EXCEPT select tableId from placement

