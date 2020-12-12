-- criador de usuário para o banco da aplicacao

CREATE DATABASE aeronaves;
CREATE USER 'usr_aeronaves'@'localhost' IDENTIFIED WITH mysql_native_password BY '!3sfero@178';
GRANT ALL PRIVILEGES ON aeronaves.* TO 'usr_aeronaves'@'localhost';
FLUSH PRIVILEGES;

