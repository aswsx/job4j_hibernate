create table cars
(
    id      serial primary key,
    model   varchar(255),
    created timestamp
);

create table IF NOT exists candidates
(
    id         serial primary key,
    name       varchar(255),
    experience timestamp,
    salary     varchar(255)
);