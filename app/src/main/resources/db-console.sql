create database libreria;
use libreria;
CREATE TABLE user
(
    user VARCHAR(100) NOT NULL,
    pass VARCHAR(100) NULL,
    CONSTRAINT pk_user PRIMARY KEY (user)
);

CREATE TABLE book
(
    isbn          VARCHAR(100)  NOT NULL,
    title         VARCHAR(100)  NULL,
    author        VARCHAR(100)  NULL,
    image         VARCHAR(100)  NULL,
    `description` VARCHAR(1000) NULL,
    category      VARCHAR(100)  NULL,
    CONSTRAINT pk_book PRIMARY KEY (isbn)
);
CREATE TABLE review
(
    id      INT AUTO_INCREMENT NOT NULL,
    user    VARCHAR(100)       NULL,
    book    VARCHAR(100)       NULL,
    message VARCHAR(100)       NULL,
    date    date               NULL,
    CONSTRAINT pk_review PRIMARY KEY (id)
);

ALTER TABLE review
    ADD CONSTRAINT FK_REVIEW_ON_BOOK FOREIGN KEY (book) REFERENCES book (isbn);

ALTER TABLE review
    ADD CONSTRAINT FK_REVIEW_ON_USER FOREIGN KEY (user) REFERENCES user (user);


insert into user
values ('sebas2409', 'root');
insert into book
values ('123456789A',
        'Domain-Driven Design with Java - A Practitioner’s Guide',
        'Karthik Krishnan', 'https://static.packt-cdn.com/products/9781800560734/cover/smaller',
        'Domain-Driven Design (DDD) makes available a set of techniques and patterns that enable domain experts, architects, and developers to work together to decompose complex business problems into a set of well-factored, collaborating, and loosely coupled subsystems.',
        'Java');

insert into book
values ('123456789B',
        'Go for Devops',
        'David Justice',
        'https://static.packt-cdn.com/products/9781801818896/cover/smaller',
        'Go is the go-to language for DevOps libraries and services, and without it, achieving fast and safe automation is a challenge. With the help of Go for DevOps, you''ll learn how to deliver services with ease and safety, becoming a better DevOps engineer in the process.',
        'Go');

insert into book
values ('123456789C',
        'Mastering React Test-Driven Development - Second Edition',
        ' Daniel Irvine',
        'https://static.packt-cdn.com/products/9781803247120/cover/smaller',
        'Test-driven development (TDD) is a programming workflow that helps you build your apps by specifying behavior as automated tests. The TDD workflow future-proofs apps so that they can be modified without fear of breaking existing functionality.',
        'React');

insert into review(user, book, message, date) values ('sebas2409','123456789A','Excelente!!','2022-11-28');
insert into review(user, book, message, date) values ('sebas2409','123456789B','Poco contenido','2022-10-28');
insert into review(user, book, message, date) values ('sebas2409','123456789C','Me ha ayudado bastante','2022-09-28');