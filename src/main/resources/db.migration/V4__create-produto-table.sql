CREATE TABLE produto (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    descricao TEXT,
    preco_custo FLOAT NOT NULL,
    preco_venda FLOAT NOT NULL,
    qtd_estoque INT NOT NULL,
    loja_id BIGINT,
    FOREIGN KEY (loja_id) REFERENCES loja(id) ON DELETE CASCADE
);