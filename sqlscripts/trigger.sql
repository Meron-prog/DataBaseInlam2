drop table slutilager;
create table slutilager
(id int not null auto_increment primary key,
produktId int,
foreign key(produktid) references produkt(id)on delete set null,
DatumproduktSlut date not null);

drop trigger before_produkt_uppdate;
DELIMITER //
CREATE TRIGGER before_produkt_uppdate
    BEFORE update ON produkt
    FOR EACH ROW 
BEGIN
	IF old.antalskor > NEW.antalskor and NEW.antalskor = 0 THEN
		INSERT INTO slutilager (produktid, DatumproduktSlut) values (new.ID, now());
	END IF;
END//
DELIMITER ;