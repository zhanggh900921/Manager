
use manager;
drop table subnetflow;
create table subnetflow 
(
id int primary key auto_increment,
name varchar(255),
subnet varchar(255),
flow int
);
set names gbk;
insert into subnetflow values (null, 'ÄÚÈİÍøÂç','Âß¼­Íø250',11);
insert into subnetflow values (null, 'ÄÚÈİÍøÂç','Âß¼­Íø1',20);
insert into subnetflow values (null, 'ÄÚÈİÍøÂç','Âß¼­Íø55',31);

insert into subnetflow values (null, 'Éí·İÍøÂç','Âß¼­Íø250',2);
insert into subnetflow values (null, 'Éí·İÍøÂç','Âß¼­Íø3',12);
insert into subnetflow values (null, 'Éí·İÍøÂç','Âß¼­Íø13',21);
insert into subnetflow values (null, 'Éí·İÍøÂç','Âß¼­Íø22',15); 
