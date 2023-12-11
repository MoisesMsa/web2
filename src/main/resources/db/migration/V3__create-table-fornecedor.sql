CREATE TABLE Fornecedor (
    id_fornecedor INT PRIMARY KEY,
    nome VARCHAR(50) NOT NULL,
    endereco VARCHAR(100),
    telefone VARCHAR(20),
    email VARCHAR(50),
    cnpj VARCHAR(25) UNIQUE NOT NULL
);