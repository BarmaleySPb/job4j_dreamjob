create TABLE IF NOT EXISTS city (
    id SERIAL PRIMARY KEY,
    name TEXT UNIQUE
);

create TABLE IF NOT EXISTS post (
    id SERIAL PRIMARY KEY,
    name TEXT,
    description TEXT,
    created TIMESTAMP
);

create TABLE IF NOT EXISTS candidate (
    id SERIAL PRIMARY KEY,
    name TEXT,
    cityId int references city(id),
    created TIMESTAMP
);

create TABLE IF NOT EXISTS users (
    id SERIAL PRIMARY KEY,
    name TEXT,
    email TEXT UNIQUE,
    password TEXT
);

insert into city (name) values ('Moscow'), ('Saint-Petersburg'), ('Tambov'), ('Ufa');