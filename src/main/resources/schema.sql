create table book_entity (id varchar(255) not null, author varchar(255), editor varchar(255), language varchar(255), name varchar(255), release_date date, primary key (id));
create table book_entity_characters (book_entity_id varchar(255) not null, characters varchar(255));
create table book_entity_genres (book_entity_id varchar(255) not null, genres varchar(255));
alter table book_entity_characters add constraint FKkx28x07q10lwunrgjkysup2mw foreign key (book_entity_id) references book_entity;
alter table book_entity_genres add constraint FKspkxshh5vgp3sgjs3gilfl6ji foreign key (book_entity_id) references book_entity;