drop table if exists user_info;

-- auto-generated definition
create table user_info
(
    code     bigint auto_increment
        primary key,
    email    varchar(100) null,
    password varchar(100) null,
    auth     varchar(255) null,
    auth_key varchar(255) null,
    is_autologin tinyint(4) null,
    constraint user_info_email_uindex
        unique (email)
);

# autologin 활성화
insert into user_info (code, email, password, auth, is_autologin)
VALUES (1, '1', '$2a$10$pUOkbjxQXSfHWO.ZFfQcXevGIyFxm01iiWZN1rjXMLzhFsUj7YZmW', 'ROLE_USER', 1);

# autologin 비활성화
insert into user_info (code, email, password, auth, is_autologin)
VALUES (2, '2', '$2a$10$pUOkbjxQXSfHWO.ZFfQcXevGIyFxm01iiWZN1rjXMLzhFsUj7YZmW', 'ROLE_USER', 0);

