CREATE DATABASE IF NOT EXISTS buy4you;


CREATE USER IF NOT EXISTS 'buy4you'@'localhost'IDENTIFIED WITH caching_sha2_password BY 'buy4you';
GRANT ALL ON buy4you.* TO 'buy4you'@'localhost';