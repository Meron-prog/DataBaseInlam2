insert into märke(namn)values ('Ecco');
insert into märke(namn)values ('Nike');
insert into märke(namn)values ('Puma');
insert into märke(namn)values ('Mango');
insert into märke(namn)values ('Jalas');
insert into märke(namn)values ('Hilfiger');
insert into märke(namn)values ('Timberland');

insert into katagorier(namn)values ('Sandaler');
insert into katagorier(namn)values ('Promenadskor');
insert into katagorier(namn)values ('Joggingskor');
insert into katagorier(namn)values ('Barnskor');
insert into katagorier(namn)values ('Sneakers');
insert into katagorier(namn)values ('Träningskor');
insert into katagorier(namn)values ('JoggingSkor');

insert into kunder(Förnamn, Efternamn, Ort) values ('John', 'Smith', 'Göteborg');
insert into kunder(Förnamn, Efternamn, Ort) values ('Mike', 'Robert', 'Umeå');
insert into kunder(Förnamn, Efternamn, Ort) values ('Salem', 'Yohannes', 'Stockholm');
insert into kunder(Förnamn, Efternamn, Ort) values ('Maria', 'Kaleb', 'Skellefteå');
insert into kunder(Förnamn, Efternamn, Ort) values ('Sam', 'Smith', 'Stockholm');
insert into kunder(Förnamn, Efternamn, Ort) values ('Isabela', 'Eriksson', 'Umeå');
insert into kunder(Förnamn, Efternamn, Ort) values ('John', 'Abraha', 'Stockholm');
insert into kunder(Förnamn, Efternamn, Ort) values ('Erik', 'Johansson', 'Umeå');
insert into kunder(Förnamn, Efternamn, Ort) values ('Astri', 'Niklas', 'Skellefteå');

insert into orders(Datum, kundid) values ('2020-12-24', 1);
insert into orders(Datum, kundid) values ('2020-12-30', 2);
insert into orders(Datum, kundid) values ('2021-01-04', 3);
insert into orders(Datum, kundid) values ('2021-01-07', 4);
insert into orders(Datum, kundid) values ('2021-01-15', 5);
insert into orders(Datum, kundid) values ('2021-01-16', 6);
insert into orders(Datum, kundid) values ('2021-01-29', 7);
insert into orders(Datum, kundid) values ('2021-02-02', 8);
insert into orders(Datum, kundid) values ('2021-02-07', 2);
insert into orders(Datum, kundid) values ('2021-02-10', 9);

insert into produkt(farg, storlek, pris, märkeid, antalskor)values ('svart', 38, 850.00, 1, 20);
insert into produkt(farg, storlek, pris, märkeid, antalskor)values ('svart', 42, 1500.00, 7, 5);
insert into produkt(farg, storlek, pris, märkeid, antalskor)values ('Vit', 38, 800.00, 7, 100);
insert into produkt(farg, storlek, pris, märkeid, antalskor)values ('Brun', 36, 2000.00, 6, 300);
insert into produkt(farg, storlek, pris, märkeid, antalskor)values ('Rosa', 24, 500.00, 5, 30);
insert into produkt(farg, storlek, pris, märkeid, antalskor)values ('Blå', 20, 900.00, 4, 10);
insert into produkt(farg, storlek, pris, märkeid, antalskor)values ('svart', 40, 700.00, 4, 200);
insert into produkt(farg, storlek, pris, märkeid, antalskor)values ('Vit', 35, 799.00, 3, 250);
insert into produkt(farg, storlek, pris, märkeid, antalskor)values ('Vit', 39, 990.00, 2, 400);
insert into produkt(farg, storlek, pris, märkeid, antalskor)values ('svart', 38, 699.00, 2, 500);
insert into produkt(farg, storlek, pris, märkeid, antalskor)values ('Brun', 37, 400.00, 1, 100);

insert into inehåll(produktid, Ordersid) values(5, 1);
insert into inehåll(produktid, Ordersid) values(11, 1);
insert into inehåll(produktid, Ordersid) values(2, 2);
insert into inehåll(produktid, Ordersid) values(1, 2);
insert into inehåll(produktid, Ordersid) values(4, 2);
insert into inehåll(produktid, Ordersid) values(7, 3);
insert into inehåll(produktid, Ordersid) values(4, 3);
insert into inehåll(produktid, Ordersid) values(11, 4);
insert into inehåll(produktid, Ordersid) values(6, 5);
insert into inehåll(produktid, Ordersid) values(1, 5);
insert into inehåll(produktid, Ordersid) values(8, 5);
insert into inehåll(produktid, Ordersid) values(5, 6);
insert into inehåll(produktid, Ordersid) values(11, 6);
insert into inehåll(produktid, Ordersid) values(2, 7);
insert into inehåll(produktid, Ordersid) values(3, 7);
insert into inehåll(produktid, Ordersid) values(3, 7);
insert into inehåll(produktid, Ordersid) values(8, 8);
insert into inehåll(produktid, Ordersid) values(9, 9);
insert into inehåll(produktid, Ordersid) values(1, 9);
insert into inehåll(produktid, Ordersid) values(10, 10);
insert into inehåll(produktid, Ordersid) values(4, 10);
insert into inehåll(produktid, Ordersid) values(5, 10);


insert into betygvärde(värde,siffervärde) values('Mycket nöjd',5),('Ganska nöjd',4),('nöjd',3),('Miss nöjd',2);


insert into Betyg(betygvärdeid,komment, produktid, kundid) values(4,'Var perfekt', 1,7);
insert into Betyg(betygvärdeid,komment, produktid, kundid) values(1,'Lite stor i passform', 2,5);
insert into Betyg(betygvärdeid,komment, produktid, kundid) values(2,'Hyfsat bra passform', 8,4);
insert into Betyg(betygvärdeid,komment, produktid, kundid) values(2,'Hyfsat bra passform', 2,3);

insert into tillhör(produktid, katagorieid) values(3, 2);
insert into tillhör(produktid, katagorieid) values(5, 1);
insert into tillhör(produktid, katagorieid) values(4, 3);
insert into tillhör(produktid,katagorieid) values(6, 5);
insert into tillhör(produktid, katagorieid) values(1, 2);