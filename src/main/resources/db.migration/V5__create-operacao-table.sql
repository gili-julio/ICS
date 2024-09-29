CREATE TABLE operacao (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    data DATE NOT NULL,
    tipo VARCHAR(50) NOT NULL,
    quantidade INT NOT NULL,
    loja_id BIGINT,
    produto_id BIGINT,
    FOREIGN KEY (loja_id) REFERENCES loja(id) ON DELETE CASCADE,
    FOREIGN KEY (produto_id) REFERENCES produto(id) ON DELETE CASCADE
);