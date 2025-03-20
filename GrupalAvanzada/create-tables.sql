create table authors
(
    id       integer not null,
    apellido varchar(255),
    nombre   varchar(255),
    primary key (id)
);

create table books
(
    authors_id integer,
    id         integer,
    precio     numeric(38, 2),
    isbn       varchar(255),
    titulo     varchar(255),
    primary key (id)
);

    create table authors (
        id integer,
        apellido varchar(255) not null,
        nombre varchar(255) not null,
        primary key (id)
    );

    create table books (
        authors_id integer not null,
        id integer,
        precio numeric(38,2) not null,
        isbn varchar(255),
        titulo varchar(255) not null,
        primary key (id)
    );
INSERT INTO authors (id, apellido, nombre) VALUES (1, 'Apellido 1', 'Autor 1');
INSERT INTO authors (id, apellido, nombre) VALUES (2, 'Apellido 2', 'Autor 2');
INSERT INTO authors (id, apellido, nombre) VALUES (3, 'Apellido 3', 'Autor 3');
INSERT INTO authors (id, apellido, nombre) VALUES (4, 'Apellido 4', 'Autor 4');
INSERT INTO authors (id, apellido, nombre) VALUES (5, 'Apellido 5', 'Autor 5');
INSERT INTO authors (id, apellido, nombre) VALUES (6, 'Apellido 6', 'Autor 6');
INSERT INTO authors (id, apellido, nombre) VALUES (7, 'Apellido 7', 'Autor 7');
INSERT INTO authors (id, apellido, nombre) VALUES (8, 'Apellido 8', 'Autor 8');
INSERT INTO authors (id, apellido, nombre) VALUES (9, 'Apellido 9', 'Autor 9');
INSERT INTO authors (id, apellido, nombre) VALUES (10, 'Apellido 10', 'Autor 10');
INSERT INTO authors (id, apellido, nombre) VALUES (11, 'Apellido 11', 'Autor 11');
INSERT INTO authors (id, apellido, nombre) VALUES (12, 'Apellido 12', 'Autor 12');
INSERT INTO authors (id, apellido, nombre) VALUES (13, 'Apellido 13', 'Autor 13');
INSERT INTO authors (id, apellido, nombre) VALUES (14, 'Apellido 14', 'Autor 14');
INSERT INTO authors (id, apellido, nombre) VALUES (15, 'Apellido 15', 'Autor 15');
INSERT INTO authors (id, apellido, nombre) VALUES (16, 'Apellido 16', 'Autor 16');
INSERT INTO authors (id, apellido, nombre) VALUES (17, 'Apellido 17', 'Autor 17');
INSERT INTO authors (id, apellido, nombre) VALUES (18, 'Apellido 18', 'Autor 18');
INSERT INTO authors (id, apellido, nombre) VALUES (19, 'Apellido 19', 'Autor 19');
INSERT INTO authors (id, apellido, nombre) VALUES (20, 'Apellido 20', 'Autor 20');
INSERT INTO books (id, authors_id, isbn, titulo, precio) VALUES (1, 1, 'ISBN-1', 'Libro 1', 10.00);
INSERT INTO books (id, authors_id, isbn, titulo, precio) VALUES (2, 2, 'ISBN-2', 'Libro 2', 11.00);
INSERT INTO books (id, authors_id, isbn, titulo, precio) VALUES (3, 3, 'ISBN-3', 'Libro 3', 12.00);
INSERT INTO books (id, authors_id, isbn, titulo, precio) VALUES (4, 4, 'ISBN-4', 'Libro 4', 13.00);
INSERT INTO books (id, authors_id, isbn, titulo, precio) VALUES (5, 5, 'ISBN-5', 'Libro 5', 14.00);
INSERT INTO books (id, authors_id, isbn, titulo, precio) VALUES (6, 6, 'ISBN-6', 'Libro 6', 15.00);
INSERT INTO books (id, authors_id, isbn, titulo, precio) VALUES (7, 7, 'ISBN-7', 'Libro 7', 16.00);
INSERT INTO books (id, authors_id, isbn, titulo, precio) VALUES (8, 8, 'ISBN-8', 'Libro 8', 17.00);
INSERT INTO books (id, authors_id, isbn, titulo, precio) VALUES (9, 9, 'ISBN-9', 'Libro 9', 18.00);
INSERT INTO books (id, authors_id, isbn, titulo, precio) VALUES (10, 10, 'ISBN-10', 'Libro 10', 19.00);
INSERT INTO books (id, authors_id, isbn, titulo, precio) VALUES (11, 11, 'ISBN-11', 'Libro 11', 20.00);
INSERT INTO books (id, authors_id, isbn, titulo, precio) VALUES (12, 12, 'ISBN-12', 'Libro 12', 21.00);
INSERT INTO books (id, authors_id, isbn, titulo, precio) VALUES (13, 13, 'ISBN-13', 'Libro 13', 22.00);
INSERT INTO books (id, authors_id, isbn, titulo, precio) VALUES (14, 14, 'ISBN-14', 'Libro 14', 23.00);
INSERT INTO books (id, authors_id, isbn, titulo, precio) VALUES (15, 15, 'ISBN-15', 'Libro 15', 24.00);
INSERT INTO books (id, authors_id, isbn, titulo, precio) VALUES (16, 16, 'ISBN-16', 'Libro 16', 25.00);
INSERT INTO books (id, authors_id, isbn, titulo, precio) VALUES (17, 17, 'ISBN-17', 'Libro 17', 26.00);
INSERT INTO books (id, authors_id, isbn, titulo, precio) VALUES (18, 18, 'ISBN-18', 'Libro 18', 27.00);
INSERT INTO books (id, authors_id, isbn, titulo, precio) VALUES (19, 19, 'ISBN-19', 'Libro 19', 28.00);
INSERT INTO books (id, authors_id, isbn, titulo, precio) VALUES (20, 20, 'ISBN-20', 'Libro 20', 29.00);
INSERT INTO books (id, authors_id, isbn, titulo, precio) VALUES (21, 1, 'ISBN-21', 'Libro 21', 30.00);
INSERT INTO books (id, authors_id, isbn, titulo, precio) VALUES (22, 2, 'ISBN-22', 'Libro 22', 31.00);
INSERT INTO books (id, authors_id, isbn, titulo, precio) VALUES (23, 3, 'ISBN-23', 'Libro 23', 32.00);
INSERT INTO books (id, authors_id, isbn, titulo, precio) VALUES (24, 4, 'ISBN-24', 'Libro 24', 33.00);
INSERT INTO books (id, authors_id, isbn, titulo, precio) VALUES (25, 5, 'ISBN-25', 'Libro 25', 34.00);
INSERT INTO books (id, authors_id, isbn, titulo, precio) VALUES (26, 6, 'ISBN-26', 'Libro 26', 35.00);
INSERT INTO books (id, authors_id, isbn, titulo, precio) VALUES (27, 7, 'ISBN-27', 'Libro 27', 36.00);
INSERT INTO books (id, authors_id, isbn, titulo, precio) VALUES (28, 8, 'ISBN-28', 'Libro 28', 37.00);
INSERT INTO books (id, authors_id, isbn, titulo, precio) VALUES (29, 9, 'ISBN-29', 'Libro 29', 38.00);
INSERT INTO books (id, authors_id, isbn, titulo, precio) VALUES (30, 10, 'ISBN-30', 'Libro 30', 39.00);
INSERT INTO books (id, authors_id, isbn, titulo, precio) VALUES (31, 11, 'ISBN-31', 'Libro 31', 40.00);
INSERT INTO books (id, authors_id, isbn, titulo, precio) VALUES (32, 12, 'ISBN-32', 'Libro 32', 41.00);
INSERT INTO books (id, authors_id, isbn, titulo, precio) VALUES (33, 13, 'ISBN-33', 'Libro 33', 42.00);
INSERT INTO books (id, authors_id, isbn, titulo, precio) VALUES (34, 14, 'ISBN-34', 'Libro 34', 43.00);
INSERT INTO books (id, authors_id, isbn, titulo, precio) VALUES (35, 15, 'ISBN-35', 'Libro 35', 44.00);
INSERT INTO books (id, authors_id, isbn, titulo, precio) VALUES (36, 16, 'ISBN-36', 'Libro 36', 45.00);
INSERT INTO books (id, authors_id, isbn, titulo, precio) VALUES (37, 17, 'ISBN-37', 'Libro 37', 46.00);
INSERT INTO books (id, authors_id, isbn, titulo, precio) VALUES (38, 18, 'ISBN-38', 'Libro 38', 47.00);
INSERT INTO books (id, authors_id, isbn, titulo, precio) VALUES (39, 19, 'ISBN-39', 'Libro 39', 48.00);
INSERT INTO books (id, authors_id, isbn, titulo, precio) VALUES (40, 20, 'ISBN-40', 'Libro 40', 49.00);
INSERT INTO books (id, authors_id, isbn, titulo, precio) VALUES (41, 1, 'ISBN-41', 'Libro 41', 50.00);
INSERT INTO books (id, authors_id, isbn, titulo, precio) VALUES (42, 2, 'ISBN-42', 'Libro 42', 51.00);
INSERT INTO books (id, authors_id, isbn, titulo, precio) VALUES (43, 3, 'ISBN-43', 'Libro 43', 52.00);
INSERT INTO books (id, authors_id, isbn, titulo, precio) VALUES (44, 4, 'ISBN-44', 'Libro 44', 53.00);
INSERT INTO books (id, authors_id, isbn, titulo, precio) VALUES (45, 5, 'ISBN-45', 'Libro 45', 54.00);
INSERT INTO books (id, authors_id, isbn, titulo, precio) VALUES (46, 6, 'ISBN-46', 'Libro 46', 55.00);
INSERT INTO books (id, authors_id, isbn, titulo, precio) VALUES (47, 7, 'ISBN-47', 'Libro 47', 56.00);
INSERT INTO books (id, authors_id, isbn, titulo, precio) VALUES (48, 8, 'ISBN-48', 'Libro 48', 57.00);
INSERT INTO books (id, authors_id, isbn, titulo, precio) VALUES (49, 9, 'ISBN-49', 'Libro 49', 58.00);
INSERT INTO books (id, authors_id, isbn, titulo, precio) VALUES (50, 10, 'ISBN-50', 'Libro 50', 59.00);

    create table authors (
        id integer,
        apellido varchar(255) not null,
        nombre varchar(255) not null,
        primary key (id)
    );

    create table books (
        authors_id integer not null,
        id integer,
        precio numeric(38,2) not null,
        isbn varchar(255),
        titulo varchar(255) not null,
        primary key (id)
    );
INSERT INTO authors (id, apellido, nombre) VALUES (1, 'Apellido 1', 'Autor 1');
INSERT INTO authors (id, apellido, nombre) VALUES (2, 'Apellido 2', 'Autor 2');
INSERT INTO authors (id, apellido, nombre) VALUES (3, 'Apellido 3', 'Autor 3');
INSERT INTO authors (id, apellido, nombre) VALUES (4, 'Apellido 4', 'Autor 4');
INSERT INTO authors (id, apellido, nombre) VALUES (5, 'Apellido 5', 'Autor 5');
INSERT INTO authors (id, apellido, nombre) VALUES (6, 'Apellido 6', 'Autor 6');
INSERT INTO authors (id, apellido, nombre) VALUES (7, 'Apellido 7', 'Autor 7');
INSERT INTO authors (id, apellido, nombre) VALUES (8, 'Apellido 8', 'Autor 8');
INSERT INTO authors (id, apellido, nombre) VALUES (9, 'Apellido 9', 'Autor 9');
INSERT INTO authors (id, apellido, nombre) VALUES (10, 'Apellido 10', 'Autor 10');
INSERT INTO authors (id, apellido, nombre) VALUES (11, 'Apellido 11', 'Autor 11');
INSERT INTO authors (id, apellido, nombre) VALUES (12, 'Apellido 12', 'Autor 12');
INSERT INTO authors (id, apellido, nombre) VALUES (13, 'Apellido 13', 'Autor 13');
INSERT INTO authors (id, apellido, nombre) VALUES (14, 'Apellido 14', 'Autor 14');
INSERT INTO authors (id, apellido, nombre) VALUES (15, 'Apellido 15', 'Autor 15');
INSERT INTO authors (id, apellido, nombre) VALUES (16, 'Apellido 16', 'Autor 16');
INSERT INTO authors (id, apellido, nombre) VALUES (17, 'Apellido 17', 'Autor 17');
INSERT INTO authors (id, apellido, nombre) VALUES (18, 'Apellido 18', 'Autor 18');
INSERT INTO authors (id, apellido, nombre) VALUES (19, 'Apellido 19', 'Autor 19');
INSERT INTO authors (id, apellido, nombre) VALUES (20, 'Apellido 20', 'Autor 20');
INSERT INTO books (id, authors_id, isbn, titulo, precio) VALUES (1, 1, 'ISBN-1', 'Libro 1', 10.00);
INSERT INTO books (id, authors_id, isbn, titulo, precio) VALUES (2, 2, 'ISBN-2', 'Libro 2', 11.00);
INSERT INTO books (id, authors_id, isbn, titulo, precio) VALUES (3, 3, 'ISBN-3', 'Libro 3', 12.00);
INSERT INTO books (id, authors_id, isbn, titulo, precio) VALUES (4, 4, 'ISBN-4', 'Libro 4', 13.00);
INSERT INTO books (id, authors_id, isbn, titulo, precio) VALUES (5, 5, 'ISBN-5', 'Libro 5', 14.00);
INSERT INTO books (id, authors_id, isbn, titulo, precio) VALUES (6, 6, 'ISBN-6', 'Libro 6', 15.00);
INSERT INTO books (id, authors_id, isbn, titulo, precio) VALUES (7, 7, 'ISBN-7', 'Libro 7', 16.00);
INSERT INTO books (id, authors_id, isbn, titulo, precio) VALUES (8, 8, 'ISBN-8', 'Libro 8', 17.00);
INSERT INTO books (id, authors_id, isbn, titulo, precio) VALUES (9, 9, 'ISBN-9', 'Libro 9', 18.00);
INSERT INTO books (id, authors_id, isbn, titulo, precio) VALUES (10, 10, 'ISBN-10', 'Libro 10', 19.00);
INSERT INTO books (id, authors_id, isbn, titulo, precio) VALUES (11, 11, 'ISBN-11', 'Libro 11', 20.00);
INSERT INTO books (id, authors_id, isbn, titulo, precio) VALUES (12, 12, 'ISBN-12', 'Libro 12', 21.00);
INSERT INTO books (id, authors_id, isbn, titulo, precio) VALUES (13, 13, 'ISBN-13', 'Libro 13', 22.00);
INSERT INTO books (id, authors_id, isbn, titulo, precio) VALUES (14, 14, 'ISBN-14', 'Libro 14', 23.00);
INSERT INTO books (id, authors_id, isbn, titulo, precio) VALUES (15, 15, 'ISBN-15', 'Libro 15', 24.00);
INSERT INTO books (id, authors_id, isbn, titulo, precio) VALUES (16, 16, 'ISBN-16', 'Libro 16', 25.00);
INSERT INTO books (id, authors_id, isbn, titulo, precio) VALUES (17, 17, 'ISBN-17', 'Libro 17', 26.00);
INSERT INTO books (id, authors_id, isbn, titulo, precio) VALUES (18, 18, 'ISBN-18', 'Libro 18', 27.00);
INSERT INTO books (id, authors_id, isbn, titulo, precio) VALUES (19, 19, 'ISBN-19', 'Libro 19', 28.00);
INSERT INTO books (id, authors_id, isbn, titulo, precio) VALUES (20, 20, 'ISBN-20', 'Libro 20', 29.00);
INSERT INTO books (id, authors_id, isbn, titulo, precio) VALUES (21, 1, 'ISBN-21', 'Libro 21', 30.00);
INSERT INTO books (id, authors_id, isbn, titulo, precio) VALUES (22, 2, 'ISBN-22', 'Libro 22', 31.00);
INSERT INTO books (id, authors_id, isbn, titulo, precio) VALUES (23, 3, 'ISBN-23', 'Libro 23', 32.00);
INSERT INTO books (id, authors_id, isbn, titulo, precio) VALUES (24, 4, 'ISBN-24', 'Libro 24', 33.00);
INSERT INTO books (id, authors_id, isbn, titulo, precio) VALUES (25, 5, 'ISBN-25', 'Libro 25', 34.00);
INSERT INTO books (id, authors_id, isbn, titulo, precio) VALUES (26, 6, 'ISBN-26', 'Libro 26', 35.00);
INSERT INTO books (id, authors_id, isbn, titulo, precio) VALUES (27, 7, 'ISBN-27', 'Libro 27', 36.00);
INSERT INTO books (id, authors_id, isbn, titulo, precio) VALUES (28, 8, 'ISBN-28', 'Libro 28', 37.00);
INSERT INTO books (id, authors_id, isbn, titulo, precio) VALUES (29, 9, 'ISBN-29', 'Libro 29', 38.00);
INSERT INTO books (id, authors_id, isbn, titulo, precio) VALUES (30, 10, 'ISBN-30', 'Libro 30', 39.00);
INSERT INTO books (id, authors_id, isbn, titulo, precio) VALUES (31, 11, 'ISBN-31', 'Libro 31', 40.00);
INSERT INTO books (id, authors_id, isbn, titulo, precio) VALUES (32, 12, 'ISBN-32', 'Libro 32', 41.00);
INSERT INTO books (id, authors_id, isbn, titulo, precio) VALUES (33, 13, 'ISBN-33', 'Libro 33', 42.00);
INSERT INTO books (id, authors_id, isbn, titulo, precio) VALUES (34, 14, 'ISBN-34', 'Libro 34', 43.00);
INSERT INTO books (id, authors_id, isbn, titulo, precio) VALUES (35, 15, 'ISBN-35', 'Libro 35', 44.00);
INSERT INTO books (id, authors_id, isbn, titulo, precio) VALUES (36, 16, 'ISBN-36', 'Libro 36', 45.00);
INSERT INTO books (id, authors_id, isbn, titulo, precio) VALUES (37, 17, 'ISBN-37', 'Libro 37', 46.00);
INSERT INTO books (id, authors_id, isbn, titulo, precio) VALUES (38, 18, 'ISBN-38', 'Libro 38', 47.00);
INSERT INTO books (id, authors_id, isbn, titulo, precio) VALUES (39, 19, 'ISBN-39', 'Libro 39', 48.00);
INSERT INTO books (id, authors_id, isbn, titulo, precio) VALUES (40, 20, 'ISBN-40', 'Libro 40', 49.00);
INSERT INTO books (id, authors_id, isbn, titulo, precio) VALUES (41, 1, 'ISBN-41', 'Libro 41', 50.00);
INSERT INTO books (id, authors_id, isbn, titulo, precio) VALUES (42, 2, 'ISBN-42', 'Libro 42', 51.00);
INSERT INTO books (id, authors_id, isbn, titulo, precio) VALUES (43, 3, 'ISBN-43', 'Libro 43', 52.00);
INSERT INTO books (id, authors_id, isbn, titulo, precio) VALUES (44, 4, 'ISBN-44', 'Libro 44', 53.00);
INSERT INTO books (id, authors_id, isbn, titulo, precio) VALUES (45, 5, 'ISBN-45', 'Libro 45', 54.00);
INSERT INTO books (id, authors_id, isbn, titulo, precio) VALUES (46, 6, 'ISBN-46', 'Libro 46', 55.00);
INSERT INTO books (id, authors_id, isbn, titulo, precio) VALUES (47, 7, 'ISBN-47', 'Libro 47', 56.00);
INSERT INTO books (id, authors_id, isbn, titulo, precio) VALUES (48, 8, 'ISBN-48', 'Libro 48', 57.00);
INSERT INTO books (id, authors_id, isbn, titulo, precio) VALUES (49, 9, 'ISBN-49', 'Libro 49', 58.00);
INSERT INTO books (id, authors_id, isbn, titulo, precio) VALUES (50, 10, 'ISBN-50', 'Libro 50', 59.00);
