drop procedure Rate;
Delimiter //
create procedure Rate(in betygID int, produktID int, komment varchar(50), kundid int)
Begin
  insert into betyg(BetygvärdeID,komment,produktid,kundid) values (betygID, komment, produktID, kundid);

End //
delimiter ;

select*from betyg;
call Rate(1,4,'test',2);
select*from betyg;
 
 
