
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