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
->Login & check if table is created

**RestFul Web Services Best Practices

#Request Methods
-Get
-Post
-Put
-Delete

#Response Status
200 -Success
404 -Resource not found
400 -Bad Request
201 -Created
401 -Unauthorized
500 -Server Error

*400 corresponds to validation error
*When you create any resource and send 200 make sure you sent 201 back
 
**No secure info should be sent in uri's 
 
**Use nouns for resources
for eg:
 
