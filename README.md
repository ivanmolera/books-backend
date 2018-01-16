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
db.users.find().pretty();
db.users.find(ObjectId("5a5cae5a79ea8e3fecc223cd")).pretty();
db.users.drop();
db.users.insert({"_class" : "com.appchana.books.dao.model.User", "username" : "user01@gmail.com", "password" : "123456", "deleted" : false, "onlineStatus" : "ONLINE"});
db.users.update({_id: ObjectId("5a5e056e8c4a9df3f0249c12")}, {$set: {"password": "$2a$10$GTui6gdITj7awrCuF.V2x.dVsN9vcw.o1P9GvQoxZEPDKszXSPGkC"}});
</code>


POST Book (Using ISBN to look up into Google Books):
https://www.googleapis.com/books/v1/volumes?q=isbn:8408177087
<code>
{
  "conditionType": "NEW",
  "description": "Bla bla bla",
  "isbn10": "8408177087",
  "title": "Origin"
}
</code>

POST Author:
<code>
{
  "biography": "Bla bla bla",
  "birthDate": "1968-01-16",
  "country": "ES",
  "language": "ca",
  "name": "Ivan Molera"
}
</code>

POST User:
<code>
{
  "contact": {
    "address": "Street bla bla",
    "country": "Spain",
    "phone": "123456789",
    "postalCode": "008295",
    "region": "Catalonia"
  },
  "onlineStatus": "ONLINE",
  "password": "123456",
  "username": "user01@gmail.com"
}
</code>