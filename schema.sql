drop schema public cascade;
create schema public;
Create Table users(
    id serial PRIMARY KEY,
    username varchar(16) unique not null,
    password varchar(16) not null,
    isCritic boolean not null,
    birthday date not null,
    country varchar(16) not null,
    gender varchar(16)
);
create Table admins(
    id serial PRIMARY key,
    username varchar(16) unique not null,
    password varchar(16) not null
);
create Table reviews(
    id serial PRIMARY key not null,
    review varchar(1500) not null,
    movieScore integer not null,
    dateCreated date not null,
    movieID varchar(16) not null,
    userID integer not null,
    foreign key (userID) references users(id) ON DELETE CASCADE,
    constraint userReview unique (userID, movieID)
);

