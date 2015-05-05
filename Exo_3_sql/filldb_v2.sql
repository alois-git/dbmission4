DELETE FROM orderedDrink;
DELETE FROM Drink;
DELETE FROM orderdb;
DELETE FROM payment;
DELETE FROM placement;
DELETE FROM tabledb;
DELETE FROM client;

INSERT INTO tabledb (id, codebar, isFree) VALUES
  (0,0,false),
  (1,1,false),
  (2,2,false),
  (3,3,true);

INSERT INTO drink(id,price,name,description) VALUES
  (0,2.1,'coca cola','We got only pepsi sir'),
  (1,3.0,'bier','maes'),
  (2,1.2,'water','sparkling or flat');

