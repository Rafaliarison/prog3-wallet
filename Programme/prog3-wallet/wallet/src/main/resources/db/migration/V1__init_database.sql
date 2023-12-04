create table if not exists user (
    id_user int serial primary key,
    user_name varchar(150) not null,
    type_compte varchar(20) check(type in ('Especes', 'Carte de credit')) not null
    devise varchar(3) check(type in ('MGA', 'EUR', 'USD', 'GBP')) not null,
    montant_de_depart float;
);