DELETE FROM orderedDrink;
DELETE FROM Drink;
DELETE FROM orderdb;
DELETE FROM payment;
DELETE FROM placement;
DELETE FROM tabledb;
DELETE FROM client;

INSERT INTO tabledb (id, codebar, isFree) VALUES
  (0,0,true),
  (1,1,true),
  (2,2,true),
  (3,3,true);

INSERT INTO client(id, amountDue) VALUES
  (0,0),
  (1,0),
  (2,0),
  (3,0);

INSERT INTO placement(tableId,tokenId) VALUES
  (0,1),
  (1,2),
  (2,3);

INSERT INTO drink(id,price,name,description) VALUES
  (0,2.1,'coca cola','We got only pepsi sir'),
  (1,3.0,'bier','maes'),
  (2,1.2,'water','sparkling or flat');

INSERT INTO orderdb(id, orderTime,tokenId) VALUES
  (0, CURRENT_TIMESTAMP, 1),
  (1, CURRENT_TIMESTAMP, 0);

INSERT INTO orderedDrink(orderId,drinkId,qty) VALUES
  (0, 1, 100),
  (1, 0, 1),
  (1, 2, 1);

INSERT INTO payment(id, amountPaid, tokenId) VALUES
  (0, 10, 1);


  
