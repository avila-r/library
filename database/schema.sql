create table if not exists books (
    id serial primary key,
    title varchar(255) not null,
    author varchar(255) not null,
    isbn varchar(20) not null,
    publication_date date,
    publisher varchar(255),
    pages integer,
    genre varchar(100),
    summary text,
    language varchar(50),
    cover_image_url varchar(255),
    rating float,
    price decimal(10,2),
    availability varchar(20),
    tags text[],
    added_date timestamp,
    location varchar(100)
);