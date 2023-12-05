create table if not exists user (
    id_user int serial primary key,
    user_name varchar(150) not null
);

create table if not exists currecncy (
    type_compte varchar(20) check(type in ('Especes', 'Carte de credit')) not null
    evise_name varchar(3) check(type in ('MGA', 'EUR', 'USD', 'GBP')) not null,
    montant_de_depart float
);
