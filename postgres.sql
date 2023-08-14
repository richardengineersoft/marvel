
CREATE DATABASE "marvel";
USE "marvel";

CREATE SCHEMA "data";

CREATE TABLE "data".info (
    "character" varchar NULL,
    context varchar NULL,
    response text NULL,
    datesync timestamp NULL
);
