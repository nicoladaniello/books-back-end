create table company (
    id bigint not null,
    created date,
    modified date,
    name varchar(255),
    email varchar(255),
    password varchar(255),
    vat_number varchar(255),
    primary key (id),
    unique (name)
);
CREATE SEQUENCE companies_sequence START WITH 1 INCREMENT BY 10;