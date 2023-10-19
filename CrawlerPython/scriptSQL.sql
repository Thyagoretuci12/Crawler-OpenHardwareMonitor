DROP USER 'ScrapUser'@'localhost';

CREATE USER 'ScrapUser'@'%' IDENTIFIED BY 'Scrap2023';
GRANT ALL PRIVILEGES ON Crawler.* TO 'ScrapUser'@'%';
FLUSH PRIVILEGES;

CREATE DATABASE Crawler;
USE Crawler;

CREATE TABLE Registros(
id INT PRIMARY KEY AUTO_INCREMENT,
dataHora DATETIME,
temp_value FLOAT,
ram_value FLOAT,
disk_value FLOAT
);

SELECT * FROM Registros;
DESC Registros;
TRUNCATE TABLE Registros;
