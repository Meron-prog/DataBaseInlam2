drop database inlämning2;
create database inlämning2;
use inlämning2;


create table katagorier 
( ID int not null auto_increment,
primary key(id),
  namn varchar(20) not null,
 created timestamp default current_Timestamp,
lastupdate timestamp default CURRENT_TIMESTAMP
ON UPDATE CURRENT_TIMESTAMP);


create table Kunder
(ID int not null auto_increment,
Förnamn varchar(20) not null,
Efternamn varchar(20) not null,
Ort varchar (20)not null,
primary key(ID),
Användernamn varchar(50) not null,
Lösenord varchar(200) not null,kunder
created timestamp default current_Timestamp,
lastupdate timestamp default CURRENT_TIMESTAMP
ON UPDATE CURRENT_TIMESTAMP);

CREATE TABLE märke 
(ID int NOT NULL AUTO_INCREMENT,
primary key(ID),
namn varchar(20) NOT NULL,
created timestamp default current_Timestamp,
lastupdate timestamp default CURRENT_TIMESTAMP
ON UPDATE CURRENT_TIMESTAMP);

create table Orders
(ID int not null auto_increment,
primary key(id),
kundid int not null,
FOREIGN KEY(kundid) REFERENCES kunder(ID),
Datum date not null,
created timestamp default current_Timestamp,
lastupdate timestamp default CURRENT_TIMESTAMP
ON UPDATE CURRENT_TIMESTAMP);


create table produkt
(ID int not null auto_increment,
primary key(ID),
farg varchar (20)not null,
storlek int not null,
pris decimal(10,2)not null,
märkeid int,
FOREIGN KEY(märkeid) REFERENCES märke(ID)on delete set null on update cascade,  -- om id tasbort eller uppdateras det ändras här också.
antalskor int not null,
created timestamp default current_Timestamp,
lastupdate timestamp default CURRENT_TIMESTAMP
ON UPDATE CURRENT_TIMESTAMP);

create table Inehåll
 (ID int not null auto_increment,
primary key(ID),
produktid int,
Ordersid int not null,
foreign key(produktid) references produkt(id)on delete set null,
foreign key(Ordersid) references Orders(id),
created timestamp default current_Timestamp,
lastupdate timestamp default CURRENT_TIMESTAMP
ON UPDATE CURRENT_TIMESTAMP);

create table Betygvärde
(ID int not null auto_increment,
primary key(id),
värde varchar(20) not null,
siffervärde int not null,
created timestamp default current_Timestamp,
lastupdate timestamp default CURRENT_TIMESTAMP
ON UPDATE CURRENT_TIMESTAMP);



CREATE TABLE Betyg
(ID int NOT NULL AUTO_INCREMENT,
primary key(ID),
BetygvärdeID int not null,
foreign key(BetygvärdeID) references Betygvärde(id),
komment varchar(50) NOT NULL,
produktid int not null,
foreign key(produktid) references produkt(id),
kundid int not null,
FOREIGN KEY(kundid) REFERENCES kunder(ID),
created timestamp default current_Timestamp,
lastupdate timestamp default CURRENT_TIMESTAMP
ON UPDATE CURRENT_TIMESTAMP);

create table tillhör
 (ID int not null auto_increment,
primary key(ID),
produktid int,
foreign key(produktid) references produkt(id)on delete set null,
katagorieid int,
FOREIGN KEY(katagorieid) REFERENCES katagorier(ID)on update cascade,
created timestamp default current_Timestamp,
lastupdate timestamp default CURRENT_TIMESTAMP
ON UPDATE CURRENT_TIMESTAMP);

create index IX_katagorienamn on tillhör(katagorieid);
create index IX_Märkenamn on produkt(märkeid);