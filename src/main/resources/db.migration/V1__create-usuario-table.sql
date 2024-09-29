CREATE TABLE usuario (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    senha VARCHAR(255) NOT NULL,
    nivel ENUM('admin', 'manager', 'user') NOT NULL,
    cargo VARCHAR(255) NOT NULL
);