--liquibase formatted sql
--changeset dziewuslkil:4
create table users
(
    id       BIGINT AUTO_INCREMENT PRIMARY KEY,
    username varchar(50) not null UNIQUE,
    password varchar(5000) not null,
    enabled  boolean     not null
)
--changeset dziewuslkil:5
create table authorities
(
    username  varchar(50) not null UNIQUE,
    authority varchar(50) not null UNIQUE,
    constraint fk_authorities_users foreign key (username) references
        users (username),
    UNIQUE KEY username_authority(username,authority)
    );
--changeset dziewuslkil:6
insert into users (id, username, password, enabled)
values (1, 'test', '{bcrypt}$2a$10$upzXFsFUOClFRR69OMKF8eajGMRs0vhcSHqvNDKy9yfW45w7o9z6O', true);
insert into authorities (username, authority) values ('test','USER');