CREATE TABLE produto (
     id INT AUTO_INCREMENT PRIMARY KEY,
     nome VARCHAR(50) NOT NULL,
     descricao VARCHAR(100) NOT NULL,
     preco REAL,
     data_validade VARCHAR(15),
     estoque INT,
     fornecedor_id INT,
     ativo INT,
     FOREIGN KEY (fornecedor_id) REFERENCES fornecedor(id)
);