-- company

DROP TABLE IF EXISTS company;

create table company
(
    id   int      not null auto_increment,
    name char(30) not null,
    primary key (id)
);

INSERT INTO company
VALUES (1, 'apple');

INSERT INTO company
VALUES (2, 'microsoft');

INSERT INTO company
VALUES (3, 'tesla');

-- employee

DROP TABLE IF EXISTS employee;

create table employee
(
    id   int      not null auto_increment,
    company_id int not null,
    name char(30) not null,
    age  int      not null,
    primary key (id)
);

INSERT INTO employee
VALUES (1, 1, 'kyu', 23);

INSERT INTO employee
VALUES (2, 3, 'kim', 35);

