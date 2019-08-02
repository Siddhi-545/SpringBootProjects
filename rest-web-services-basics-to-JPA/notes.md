**Table structure for JPA with hibernate

create table user (
id integer not null, 
birth_date timestamp, 
name varchar(255), 
primary key (id)
);

**To Check table created under database
->Download & install h2
->Hit http://localhost:8082 in browser