drop procedure Rate;
Delimiter //
create procedure Rate(in betygID int, produktID int, komment varchar(50), kundid int)
Begin
  insert into betyg(BetygvärdeID,komment,produktid,kundid) values (betygID, komment, produktID, kundid);

End //
delimiter ;

select*from betyg;
call Rate(2,2,'liten',5);
select*from betyg;
 
 
