
use manager;
drop table netflow;
create table netflow 
(
id int primary key auto_increment,
name varchar(255),
flow int
);

insert into netflow values (null, '内容网络',83);
insert into netflow values (null, '身份网络',102);
insert into netflow values (null, '地址网络',0);
insert into netflow values (null, '服务网络',0);
