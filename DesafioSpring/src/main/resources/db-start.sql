CREATE DATABASE DESAFIO;

CREATE TABLE INICIAL
(
    ID           INTEGER PRIMARY KEY,
    NOME         VARCHAR2(100),
    EMAIL        VARCHAR2(100),
    SENHA        VARCHAR2(500),
    ID_PERMISSAO VARCHAR2(200)
);

CREATE SEQUENCE DESAFIO.SQ_INICIAL INCREMENT by 1;
