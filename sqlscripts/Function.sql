drop function betygsvärde;

DELIMITER //
create function betygsvärde (productID int) returns float
READS SQL DATA
Begin
    declare medelbetyg float;
    
    select avg(betygvärde.siffervärde)
    from betyg
	inner join betygvärde 
	on betygvärde.ID = betyg.BetygvärdeID
	where betyg.produktid =productID
    group by betyg.produktid
    into medelbetyg;

RETURN medelbetyg;
END//
DELIMITER ;

select betygsvärde(2)