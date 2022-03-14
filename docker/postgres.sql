-- Database
CREATE DATABASE conveyordb;
\c conveyordb;

-- Scores
CREATE TABLE scores (
                           id serial NOT NULL,
                           PRIMARY KEY (id),
                           name character varying NOT NULL,
                           scores character varying NOT NULL
);

INSERT INTO scores (name, scores) VALUES ('Selin Gungor', '100');
INSERT INTO actors (name, scores) VALUES ('Lorem Ipsum', '0.5');