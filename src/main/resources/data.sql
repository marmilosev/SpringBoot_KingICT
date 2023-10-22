create table test
(
    id int primary key auto_increment,
    naziv varchar(50),
    opis varchar(255)
);

insert into test(naziv, opis) values('name', 'description');