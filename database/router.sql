
use manager;
drop table router;
create table router 
(
id int primary key auto_increment,
name varchar(255),
neighbor varchar(255),
delay double
);

insert into router values (null, '路由器1','路由器2',0.2);
insert into router values (null, '路由器1','路由器4',0.1);
insert into router values (null, '路由器2','路由器1',0.3);
insert into router values (null, '路由器2','路由器3',0.4);
insert into router values (null, '路由器3','路由器2',0.1);
insert into router values (null, '路由器3','路由器4',0.2);
insert into router values (null, '路由器4','路由器3',0.2);
insert into router values (null, '路由器4','路由器1',0.1);
