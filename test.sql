
CREATE DATABASE tests;

create table questions(id_question SERIAL PRIMARY key, question VARCHAR(255));

create table answers(id_answer SERIAL PRIMARY key, answer VARCHAR(40), correct_answer INT);

create table tests(id_test INT PRIMARY key, test_name VARCHAR(40));

create table options(id_option INT PRIMARY key, id_question INT, id_answer INT, id_test INT);



