
CREATE TABLE Medico (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    telefone VARCHAR(15),
    crm VARCHAR(20) NOT NULL UNIQUE,
    especialidade VARCHAR(100),
    endereco VARCHAR(255),
    ativo BOOLEAN DEFAULT TRUE
);
CREATE TABLE Paciente (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    telefone VARCHAR(15),
    cpf VARCHAR(11) NOT NULL UNIQUE,
    endereco VARCHAR(255),
    ativo BOOLEAN DEFAULT TRUE
);
CREATE TABLE Consulta (
    id SERIAL PRIMARY KEY,
    medico_id INT NOT NULL,
    paciente_id INT NOT NULL,
    data_hora TIMESTAMP NOT NULL,
    ativo BOOLEAN DEFAULT TRUE,
    FOREIGN KEY (medico_id) REFERENCES Medico(id) ON DELETE CASCADE,
    FOREIGN KEY (paciente_id) REFERENCES Paciente(id) ON DELETE CASCADE
);