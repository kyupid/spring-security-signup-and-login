drop table if exists user_info;

-- auto-generated definition
create table user_info
(
    code     bigint auto_increment
        primary key,
    email    varchar(100) null,
    password varchar(100) null,
    auth     varchar(255) null,
    constraint user_info_email_uindex
        unique (email)
);

insert into user_info (code, email, password, auth)
VALUES (1, '1', '1', '1');


