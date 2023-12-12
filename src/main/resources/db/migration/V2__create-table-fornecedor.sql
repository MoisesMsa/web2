CREATE TABLE fornecedor (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(50) NOT NULL,
    endereco VARCHAR(100),
    telefone VARCHAR(20),
    email VARCHAR(50),
    cnpj VARCHAR(25) UNIQUE NOT NULL
);