-- Creates the applicaiton user. Part of the setup, and should not be included in the dbmaintain scripts
CREATE USER 'sa'@'localhost' IDENTIFIED BY 'password';
GRANT ALL PRIVILEGES ON *.* TO 'sa'@'localhost';
FLUSH PRIVILEGES;
CREATE DATABASE myproject;
