create database file_service_db;

use file_service_db;

create table arquivo
(
  id_arquivo   int auto_increment primary key,
  nome_arquivo varchar(255) not null,
  conteudo     longblob null
);