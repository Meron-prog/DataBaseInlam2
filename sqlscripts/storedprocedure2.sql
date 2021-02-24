-- drop procedure AddToCart;

Delimiter //
create procedure AddToCart(in produktID int, ordersID int,kundid int, out value VARCHAR(40))
main:Begin
 declare proid int;
 declare ordid int;
 declare kunid int;
 declare antalskorilager int;
 declare exit handler for sqlexception
 begin
  rollback;
  select('SQL exception is occurd,rollback is done' );
  end;
 declare exit handler for 1062
 begin
  rollback;
  select('Duplicate value found on unique column' );
  end;
 select antalskor into antalskorilager from produkt where produkt.id=produktID;
 if antalskorilager = 0 then
	set value= 'out of stock';
	leave main;
 end if;
 
 Select id into ordid from orders where ordersID = orders.ID;
 
 Start transaction;
 
 If ordid is null then 
	insert into orders(kundid,Datum, Status)values (kundid,now(), 'Pågående');
	insert into inehåll(produktid,ordersid) values(produktID,last_insert_id());
 else 
	insert into inehåll(produktid,ordersid) values(produktID,ordersID);
end if;
         
update produkt set antalskor = (antalskorilager-1) where produkt.id= produktID;

commit;

End; //
 
Delimiter ;
 
select*from orders;
select*from inehåll;
select*from produkt; 
 
set @out = '';
call AddToCart(2, 17 ,1, @out);
select @out;

select*from orders;
select*from inehåll;
select*from produkt;

select*from slutilager;

 
 