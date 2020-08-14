--DROP ALL OBJECTS;
--
drop table if exists UserAuthorities cascade;
drop table if exists users cascade;
drop table if exists Taco_Order_Tacos cascade;
drop table if exists Taco_Order cascade;
drop table if exists Taco_Ingredients cascade;
drop table if exists Taco cascade;
drop table if exists Ingredient cascade;

create table if not exists Ingredient (
 id varchar(4) not null,
 name varchar(25) not null,
 type varchar(10) not null
);
create table if not exists Taco (
 id identity,
 name varchar(50) not null,
 created_at timestamp not null
);
create table if not exists Taco_Ingredients (
 taco_id bigint not null,
 ingredient_id varchar(4) not null,
 foreign key (taco_id) references Taco(id),
 foreign key (ingredient_id) references Ingredient(id)
);
--alter table Taco_Ingredients
-- add foreign key (taco) references Taco(id);
--alter table Taco_Ingredients
-- add foreign key (ingredient) references Ingredient(id);
create table if not exists Users(
	id identity primary key,
	username varchar(50) not null,
	password varchar(50) not null,
	fullname varchar(50) not null,
     street varchar(50) not null,
     city varchar(50) not null,
     state varchar(50) not null,
     zip varchar(4),
	phoneNumber varchar(50) not null,
	enabled boolean not null
);

create table if not exists Taco_Order (
 id identity,
 name varchar(50) not null,
 street varchar(50) not null,
 city varchar(50) not null,
 state varchar(50) not null,
 zip varchar(4),
 ccNumber varchar(16) not null,
 ccExpiration varchar(5) not null,
 ccCVV varchar(3) not null,
 placedAt timestamp not null,
 users bigint not null,
 foreign key (users) references Users(id)
);
create table if not exists Taco_Order_Tacos (
 tacoOrder bigint not null,
 taco bigint not null,
 foreign key (tacoOrder) references Taco_Order(id),
 foreign key (taco) references Taco(id)
);
--alter table Taco_Order_Tacos
-- add foreign key (tacoOrder) references Taco_Order(id);
--alter table Taco_Order_Tacos
-- add foreign key (taco) references Taco(id);

create table if not exists UserAuthorities (
	username varchar_ignorecase(50) not null,
	authority varchar_ignorecase(50) not null,
	constraint fk_authorities_users foreign key(username) references users(username)
);
--create unique index ix_auth_username on UserAuthorities (username,authority);
