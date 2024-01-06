drop table if exists address CASCADE;
drop table if exists client CASCADE;
drop table if exists phone CASCADE;
drop sequence if exists hibernate_sequence;
create sequence hibernate_sequence start with 1 increment by 1;
create table address (id bigint not null, street varchar(255), primary key (id));
create table client (id bigint not null, name varchar(255), address_id bigint, primary key (id));
create table phone (id bigint not null, number varchar(255), client_id bigint not null, primary key (id));
alter table client add constraint fk_client_address_id foreign key (address_id) references address;
alter table phone add constraint fk_phone_client_id foreign key (client_id) references client;
select*from client;
select*from address;
insert into address(id,street) values (1,'Artema');