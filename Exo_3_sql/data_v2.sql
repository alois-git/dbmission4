DROP TABLE IF EXISTS orderedDrink CASCADE;
DROP TABLE IF EXISTS drink CASCADE;
DROP TABLE IF EXISTS orderdb CASCADE;
DROP TABLE IF EXISTS payment CASCADE;
DROP TABLE IF EXISTS placement CASCADE;
DROP TABLE IF EXISTS tabledb CASCADE;
DROP TABLE IF EXISTS client CASCADE;

CREATE TABLE tabledb (
  id serial primary key NOT NULL,
  codebar integer NOT NULL,
  isFree boolean not NULL
);

CREATE TABLE client (
  id serial primary key NOT NULL,
  amountDue numeric NOT NULL
);

/* We modify the entity relational diagram because when a client leave he should have no table. (1,1) -> (0,1) for client to table */
CREATE TABLE placement (
  tableId integer NOT NULL UNIQUE,
  tokenId integer NOT NULL UNIQUE,
  primary key (tableId,tokenId),
  foreign key (tokenId) references client (id),
  foreign key (tableId) references tabledb (id)
);

CREATE TABLE payment (
  id serial primary key NOT NULL,
  amountPaid decimal NOT NULL,
  tokenId integer NOT NULL,
  foreign key (tokenId) references client (id)
);

CREATE TABLE orderdb (
  id serial NOT NULL,
  orderTime timestamp NOT NULL,
  tokenId integer NOT NULL,
  primary key (id),
  foreign key (tokenId) references client (id)
);

CREATE TABLE drink (
  id serial primary key NOT NULL,
  price decimal NOT NULL,
  name varchar(30) NOT NULL,
  description varchar(150) NOT NULL
);

CREATE TABLE orderedDrink (
  qty serial NOT NULL,
  orderId integer NOT NULL,
  drinkId integer NOT NULL,
  primary key (orderId, drinkId),
  foreign key (orderId) references orderdb (id),
  foreign key (drinkId) references drink (id)
);
