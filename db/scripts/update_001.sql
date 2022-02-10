create TABLE IF NOT EXISTS post (
    id SERIAL PRIMARY KEY,
    name TEXT,
    description TEXT
);

create TABLE IF NOT EXISTS candidate (
    id SERIAL PRIMARY KEY,
    name TEXT
);

create TABLE IF NOT EXISTS users (
   id SERIAL PRIMARY KEY,
   name TEXT,
   email TEXT,
   password TEXT
);