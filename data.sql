DROP TABLE IF EXISTS orderedDrink CASCADE;
DROP TABLE IF EXISTS drink CASCADE;
DROP TABLE IF EXISTS orderdb CASCADE;
DROP TABLE IF EXISTS payment CASCADE;
DROP TABLE IF EXISTS placement CASCADE;
DROP TABLE IF EXISTS tabledb CASCADE;
DROP TABLE IF EXISTS client CASCADE;

CREATE TABLE tabledb (
  tableId integer primary key NOT NULL
);

CREATE TABLE client (
  tokenId integer primary key NOT NULL
);

/* We modify the entity relational diagram because when a client leave he should have no table. (1,1) -> (0,1) for client to table */
CREATE TABLE placement (
  tableId integer NOT NULL UNIQUE,
  tokenId integer NOT NULL UNIQUE,
  primary key (tableId,tokenId),
  foreign key (tokenId) references client (tokenId),
  foreign key (tableId) references tabledb (tableId)
);

CREATE TABLE payment (
  paymentId integer primary key NOT NULL,
  amountPaid decimal NOT NULL,
  tokenId integer NOT NULL,
  foreign key (tokenId) references client (tokenId)
);

CREATE TABLE orderdb (
  orderId integer NOT NULL,
  orderTime timestamp NOT NULL,
  tokenId integer NOT NULL,
  primary key (orderId),
  foreign key (tokenId) references client (tokenId)
);

CREATE TABLE drink (
  drinkId integer primary key NOT NULL,
  price decimal NOT NULL,
  name varchar(30) NOT NULL,
  description varchar(150) NOT NULL
);

CREATE TABLE orderedDrink (
  qty integer NOT NULL,
  orderId integer NOT NULL,
  drinkId integer NOT NULL,
  primary key (orderId, drinkId),
  foreign key (orderId) references orderdb (orderId),
  foreign key (drinkId) references drink (drinkId)
);



