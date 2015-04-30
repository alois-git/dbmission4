
CREATE OR REPLACE FUNCTION sitdown(tableBarCode numeric) RETURNS integer AS $$
DECLARE
 A integer;
 newTokenId integer;
BEGIN 
 IF EXISTS (SELECT * FROM freetable WHERE tableId = tableBarCode) THEN
  select MAX(tokenId) INTO A from client;
  newTokenId := A+1;
  insert into client(tokenId) VALUES (newTokenId); 
  insert into placement(tableId,tokenId) VALUES (tableBarCode,newTokenId)
  RETURN newTokenId;
 ELSE
  RETURN -1;
 END IF;
END;
$$ LANGUAGE PLPGSQL;



CREATE OR REPLACE FUNCTION orderDrinks(tokenId integer, drinks integer[][] ) RETURNS integer AS $$
DECLARE
 newOrderId integer;
 oldOrderId integer;
BEGIN 

  select MAX(orderId) INTO oldOrderId from orderdb;
  newOrderId := oldOrderId+1; 
  insert into orderdb(orderId,orderTime,tokenId) VALUES (newOrderId,CURRENT_TIMESTAMP,tokenId);
  FOR I IN 1..array_length(drinks,1) LOOP 
    /* 1 = drinkid 2= qty*/
    insert into orderedDrink(orderId,drinkId,qty) VALUES (newOrderId,drinks[i][1],drinks[i][2]);
  END LOOP;
  RETURN newOrderId;
  
END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION issueTicket(tokenIdParam integer) RETURNS TEXT AS $$
DECLARE
 Total decimal;
 Items text;
 Item text;
 Qty text;
 curs refcursor;
BEGIN 
  SELECT COALESCE(SUM(d.qty*dr.price),0) INTO Total from client as c left join orderdb as o on o.tokenId = c.tokenId left join orderedDrink as d on d.orderId = o.orderId left join Drink as dr on d.drinkId = dr.drinkId where c.tokenId = tokenIdParam group by c.tokenId ;
  OPEN curs FOR SELECT dr.name,SUM(d.qty) as qty from client as c left join orderdb as o on o.tokenId = c.tokenId left join orderedDrink as d on d.orderId = o.orderId left join Drink as dr on d.drinkId = dr.drinkId where c.tokenId = tokenIdParam group by name;
  Items := ' Ticket : ';
  FETCH curs INTO Item, Qty; 
  WHILE Item is not NULL LOOP
   Items := Items || Item || ' : ' || Qty || ' ';
   FETCH curs INTO Item, Qty;
  END LOOP; 
  Items := Items || 'Total' || ' : ' || Total;
  RETURN Items;
END;
$$ LANGUAGE PLPGSQL;

CREATE OR REPLACE FUNCTION payTable(tokenIdParam integer, amount decimal) RETURNS TEXT AS $$
DECLARE
   amountDue decimal;
BEGIN 
  IF EXISTS (SELECT tableId FROM placement WHERE tokenId = tokenIdParam) THEN  
     select total into amountDue from clientAmount where tokenId = tokenIdParam; 
     IF amount >= amountDue then
       DELETE FROM placement as p where p.tokenId = tokenIdParam;
       RETURN 'done';
     ELSE
       RETURN 'not enough money';
     END IF;
  ELSE 
    RETURN 'client token invalid';
  END IF;
END;
$$ LANGUAGE PLPGSQL;





