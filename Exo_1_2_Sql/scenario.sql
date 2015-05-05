DO $$

DECLARE 
token int;
ticket text;
BEGIN
select sitdown(3) into token;
IF (token = -1) then
    RAISE NOTICE 'table is already taken';
ELSE
perform orderDrinks(token,array[[2,1]]);
select issueTicket(token) into ticket;
RAISE NOTICE '%', ticket;
perform orderDrinks(token,array[[2,1]]);
perform payTable(token, 20);
END IF;

END $$;
