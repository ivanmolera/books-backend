# Books API

* Java 8
* MySQL 5.7.18
* Spring Boot 1.5.9
* Spring Data JPA
* Spring Security
* Swagger 2.3.1
* Google Guava 23.0
* JUnit 4.12
* Maven


# REST API

Tomcat server with Swagger running on localhost over port 8080.

Basic Authorization ( username / 123456 ).

All fake users they have the same password.


# DATABASE (MongoDB)

<code>
db.getCollectionNames();
db.user.find().pretty();
db.user.find(ObjectId("5a5cae5a79ea8e3fecc223cd")).pretty();
db.user.update({_id: ObjectId("5a5cae5a79ea8e3fecc223cd")}, {$set: {"password": "$2a$10$GTui6gdITj7awrCuF.V2x.dVsN9vcw.o1P9GvQoxZEPDKszXSPGkC"}});
</code>