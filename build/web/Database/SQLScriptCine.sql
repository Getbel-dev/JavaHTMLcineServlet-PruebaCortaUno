CREATE DATABASE Cine;
USE Cine;

CREATE TABLE peliculas (
  id int auto_increment KEY,
  title varchar(255) NOT NULL,
  director varchar(255) NOT NULL,
  year  int NOT NULL,
  imageUrl TEXT NOT NULL
);

INSERT INTO peliculas (title, director, year, imageUrl )
Values ('The Incredibles','Brad Bird', 2004 , 'https://m.media-amazon.com/images/M/MV5BMTY5OTU0OTc2NV5BMl5BanBnXkFtZTcwMzU4MDcyMQ@@._V1_SX300.jpg');

INSERT INTO peliculas (title, director, year, imageUrl )
Values ('The Beauty and the Beast','Gary Trousdale', 1991, 'https://m.media-amazon.com/images/M/MV5BMzE5MDM1NDktY2I0OC00YWI5LTk2NzUtYjczNDczOWQxYjM0XkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_SX300.jpg');

INSERT INTO peliculas (title, director, year, imageUrl )
Values ('The Lego Batman Movie','Chris McKay', 2017,'https://m.media-amazon.com/images/M/MV5BMTcyNTEyOTY0M15BMl5BanBnXkFtZTgwOTAyNzU3MDI@._V1_SX300.jpg');

INSERT INTO peliculas (title, director, year, imageUrl )
Values ('The Lion King','Roger Allers', 1994,'https://m.media-amazon.com/images/M/MV5BYTYxNGMyZTYtMjE3MS00MzNjLWFjNmYtMDk3N2FmM2JiM2M1XkEyXkFqcGdeQXVyNjY5NDU4NzI@._V1_SX300.jpg');

UPDATE peliculas SET title= 'The Lion King 3', director='Roger Espinoza', year=1994, imageUrl='https://m.media-amazon.com/images/M/MV5BYTYxNGMyZTYtMjE3MS00MzNjLWFjNmYtMDk3N2FmM2JiM2M1XkEyXkFqcGdeQXVyNjY5NDU4NzI@._V1_SX300.jpg' WHERE id = 4;

Select * FROM peliculas;

Delete from peliculas where Id =4