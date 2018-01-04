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


# DATABASE

<code>
CREATE TABLE `users` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `password` varchar(100) NOT NULL,
  `online_status` boolean NOT NULL DEFAULT 0,
  `date_created` datetime NOT NULL DEFAULT NOW(),
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=latin1;
 
 
CREATE TABLE `books` (
  `book_id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(45) NOT NULL,
  `isbn10` varchar(10),
  `isbn13` varchar(13),
  `page_count` int(11),
  `average_rating` float(11),
  `deleted` boolean NOT NULL DEFAULT 0,
  `date_created` datetime NOT NULL DEFAULT NOW(),
  PRIMARY KEY (`book_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;
 
 
CREATE TABLE `users_books` (
  `user_book_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `book_id` int(11) NOT NULL,
  `deleted` boolean NOT NULL DEFAULT 0,
  `date_created` datetime NOT NULL DEFAULT NOW(),
  PRIMARY KEY (`user_book_id`),
  KEY `fk_user` (`user_id`),
  KEY `fk_book` (`book_id`),
  CONSTRAINT `fk_book` FOREIGN KEY (`book_id`) REFERENCES `books` (`book_id`),
  CONSTRAINT `fk_user` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`)
)
</code>

# Fake data

<code>
-- Create 3 offline users
insert into users (user_id, date_created, deleted, online_status, password, username) values (1, now(), false, 'OFFLINE','$2a$10$GTui6gdITj7awrCuF.V2x.dVsN9vcw.o1P9GvQoxZEPDKszXSPGkC', 'user01@gmail.com');

insert into users (user_id, date_created, deleted, online_status, password, username) values (2, now(), false, 'OFFLINE', '$2a$10$IrOFrHCo5ib5QryKgYPAKuns8CCYv841j9b3jLRwJK/.np5/hpac.', 'user02@gmail.com');

insert into users (user_id, date_created, deleted, online_status, password, username) values (3, now(), false, 'OFFLINE', '$2a$10$nR8MTAfl8hbB1fUHnMd5Je65EiO.8ZaAwH5HcDqBYI8yKcF0oc08G', 'user03@gmail.com');


-- Create 3 online users
insert into users (user_id, date_created, deleted, online_status, password, username) values (4, now(), false, 'ONLINE', '$2a$10$nIUQgkZkHL0u7IIVIxuLAuzmv0NVw9cYLOAZofLSd.KqOwu2p.1cO', 'user04@gmail.com');

insert into users (user_id, date_created, deleted, online_status, password, username) values (5, now(), false, 'ONLINE', '$2a$10$mjMI0EmcSpd8yDc5HejkVuhCPs0bHcueehXQeS52TZEgCNqLJqtq2', 'user05@gmail.com');

insert into users (user_id, date_created, deleted, online_status, password, username) values (6, now(), false, 'ONLINE', '$2a$10$lB6/PKg2/JC4XgdMDXyjs.dLC9jFNAuuNbFkL9udcXe/EBjxSyqxW', 'user06@gmail.com');



-- Create 5 books
insert into books (book_id, date_created, deleted, isbn10, isbn13, title, page_count, average_rating) values (1, now(), 0, '8408177087', '9788408177081', 'Origen', 103, 3);

insert into books (book_id, date_created, deleted, isbn10, isbn13, title, page_count, average_rating) values (2, now(), 0, '8401018250', null, 'Una columna de fuego', 210, 2);

insert into books (book_id, date_created, deleted, isbn10, isbn13, title, page_count, average_rating) values (3, now(), 0, '8408178946', '9788408178941', 'El fuego invisible', 566, 3);

insert into books (book_id, date_created, deleted, isbn10, isbn13, title, page_count, average_rating) values (4, now(), 0, '8401018331', '9788401018336', 'Fin de guardia', 201, 5);

insert into books (book_id, date_created, deleted, isbn10, isbn13, title, page_count, average_rating) values (5, now(), 0, '8499308724', '9788499308722', 'Inferno', 566, 3);


-- Create 5 userbooks for user 1
insert into users_books(date_created, deleted, user_id, book_id, condition_type) values (now(), 0, 1, 1, 'NEW');

insert into users_books(date_created, deleted, user_id, book_id, condition_type) values (now(), 0, 1, 2, 'NEW');

insert into users_books(date_created, deleted, user_id, book_id, condition_type) values (now(), 0, 1, 3, 'USED');

insert into users_books(date_created, deleted, user_id, book_id, condition_type) values (now(), 0, 1, 4, 'NEW');

insert into users_books(date_created, deleted, user_id, book_id, condition_type) values (now(), 0, 1, 5, 'USED');
</code>