create table test
(
    id int primary key auto_increment,
    naziv varchar(50),
    opis varchar(255)
);

insert into test(naziv, opis) values('name', 'description');


create table pretraga_letova
(
    id int primary key auto_increment,
    polazni_aerodrom varchar(3),
    dolazni_aerodrom varchar(3),
    datum_polaska date,
    datum_povratka date,
    broj_putnika int,

    korisnik_kreiranja varchar(50),
    datum_kreiranja date,
    korisnik_azuriranja varchar(50),
    datum_azuriranja date
);

create table rezultati_letova(
    id int primary key auto_increment,
    cijena varchar(20),
    odlazna_aviokompanija varchar(10),
    povratna_aviokompanija varchar(10),

    pretraga_id int,

    korisnik_kreiranja varchar(50),
    datum_kreiranja date,
    korisnik_azuriranja varchar(50),
    datum_azuriranja date
);

alter table rezultati_letova add foreign key (pretraga_id) references pretraga_letova(id);