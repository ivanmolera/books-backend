/**
 * CREATE Script for init of DB
 */

-- Create 3 offline users
insert into users (user_id, date_created, deleted, online_status, password, username) values (1, now(), false, 'OFFLINE',
'$2a$10$GTui6gdITj7awrCuF.V2x.dVsN9vcw.o1P9GvQoxZEPDKszXSPGkC', 'user01@gmail.com');

insert into users (user_id, date_created, deleted, online_status, password, username) values (2, now(), false, 'OFFLINE',
'$2a$10$IrOFrHCo5ib5QryKgYPAKuns8CCYv841j9b3jLRwJK/.np5/hpac.', 'user02@gmail.com');

insert into users (user_id, date_created, deleted, online_status, password, username) values (3, now(), false, 'OFFLINE',
'$2a$10$nR8MTAfl8hbB1fUHnMd5Je65EiO.8ZaAwH5HcDqBYI8yKcF0oc08G', 'user03@gmail.com');


-- Create 3 online users
insert into users (user_id, date_created, deleted, online_status, password, username) values (4, now(), false, 'ONLINE',
'$2a$10$nIUQgkZkHL0u7IIVIxuLAuzmv0NVw9cYLOAZofLSd.KqOwu2p.1cO', 'user04@gmail.com');

insert into users (user_id, date_created, deleted, online_status, password, username) values (5, now(), false, 'ONLINE',
'$2a$10$mjMI0EmcSpd8yDc5HejkVuhCPs0bHcueehXQeS52TZEgCNqLJqtq2', 'user05@gmail.com');

insert into users (user_id, date_created, deleted, online_status, password, username) values (6, now(), false, 'ONLINE',
'$2a$10$lB6/PKg2/JC4XgdMDXyjs.dLC9jFNAuuNbFkL9udcXe/EBjxSyqxW', 'user06@gmail.com');



-- Create 5 books
insert into books (book_id, date_created, deleted, isbn10, isbn13, title, average_rating) values (1, now(), false, '8408177087', null, 'Origen', 3);

insert into books (book_id, date_created, deleted, isbn10, isbn13, title, average_rating) values (2, now(), false, '8401018250', null, 'Una columna de fuego', 2);

insert into books (book_id, date_created, deleted, isbn10, isbn13, title, average_rating) values (3, now(), false, '8408178946', '978-8408178941', 'El fuego invisible', 3);

insert into books (book_id, date_created, deleted, isbn10, isbn13, title, average_rating) values (4, now(), false, '8401018331', '978-8401018336', 'Fin de guardia', 5);

insert into books (book_id, date_created, deleted, isbn10, isbn13, title, average_rating) values (5, now(), false, '8499308724', '978-8499308722', 'Inferno', 3);