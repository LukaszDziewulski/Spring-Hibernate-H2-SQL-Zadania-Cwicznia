--liquibase formatted sql
--changeset dziewuslkil:1
insert into post(id, title, content,created) values (100,'Test post 1', 'Content 1', '2020-07-11T14:26:43.612121200');
insert into post(id, title, content,created) values (200,'Test post 2', 'Content 1', '2020-08-11T14:26:43.612121200');
insert into post(id, title, content,created) values (300,'Test post 3', 'Content 1', '2020-09-11T14:26:43.612121200');
insert into post(id, title, content,created) values (400,'Test post 4', 'Content 1', '2020-10-11T14:26:43.612121200');

insert into comment(id, post_id, content,created) values (1,100, 'Content 1','2020-07-11T14:26:43.612121200');
insert into comment(id, post_id, content,created) values (2,100, 'Content 2','2020-08-11T14:26:43.612121200');
insert into comment(id, post_id, content,created) values (3,300, 'Content 3','2020-09-11T14:26:43.612121200');
insert into comment(id, post_id, content,created) values (4,200, 'Content 4','2020-010-11T14:26:43.612121200');