create table if not exists account (
    account_id serial primary key ,
    account_name varchar(100) check ( account_name in ('current_account', 'save_account')),
    account_solde float,
    account_update_date timestamp with time zone,
    account_curracy int
);

create table if not exists curracy (
    curracy_id serial primary key ,
    curracy_name varchar(50),
    curracy_code varchar(3) check ( curracy_code in ('EUR', 'MGA'))
);

create table if not exists transaction (
    transaction_id serial primary key ,
    transaction_label varchar(100),
    transaction_date timestamp with time zone,
    transaction_type varchar(10) check ( transaction_type in ('debit', 'credit'))
);