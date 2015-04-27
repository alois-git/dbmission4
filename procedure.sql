
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
    insert into orderedDrink(orderId,drinkId,qty) VALUES (newOrderId,drinks[i][1],drinks[i][2]);
  END LOOP;
  RETURN newOrderId;
  
END;
$$ LANGUAGE PLPGSQL;




