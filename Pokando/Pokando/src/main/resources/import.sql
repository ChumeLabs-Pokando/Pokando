-- ================================================
-- TABELA PAIS
-- ================================================
insert into pais(nome, sigla) values ('Brazil', 'BR');
insert into pais(nome, sigla) values ('Canadá', 'CN');
insert into pais(nome, sigla) values ('Argentina', 'AG');

-- ================================================
-- TABELA ESTADO
-- ================================================
insert into estado (nome, sigla, pais_id) values ('São Paulo', 'SP', 1);
insert into estado (nome, sigla, pais_id) values ('Rio de Janeiro', 'RJ', 1);
insert into estado (nome, sigla, pais_id) values ('Minas Gerais', 'MG', 1);
insert into estado (nome, sigla, pais_id) values ('Bahia', 'BA', 1);

-- ================================================
-- TABELA CIDADE
-- ================================================
insert into cidade (nome, estado_id) values ('São Paulo', 1);
insert into cidade (nome, estado_id) values ('Campinas', 1);
insert into cidade (nome, estado_id) values ('Santos', 1);

insert into cidade (nome, estado_id) values ('Rio de Janeiro', 2);
insert into cidade (nome, estado_id) values ('Niterói', 2);
insert into cidade (nome, estado_id) values ('Petrópolis', 2);

-- ================================================
-- TABELA ENDERECO_GEOGRAFICO
-- ================================================
insert into endereco_geografico (longitude, latitude) values ('-46.633309', '-23.550520'); -- são paulo - sp
insert into endereco_geografico (longitude, latitude) values ('-43.209373', '-22.911014'); -- rio de janeiro - rj
insert into endereco_geografico (longitude, latitude) values ('-38.510830', '-12.971389'); -- salvador - ba

-- ================================================
-- TABELA ENDERECO
-- ================================================
insert into endereco (logradouro, cidade_id, numero, cep, bairro, complemento, endereco_geografico_id) values ('Avenida Paulista', 1, '1578', '01311000', 'Bela Vista', 'Conjunto 101', 1);

insert into endereco (logradouro, cidade_id, numero, cep, bairro, complemento, endereco_geografico_id) values ('Rua Barata Ribeiro', 2, '450', '22040002', 'Copacabana', null, 2);

-- ================================================
-- TABELA USER_ACESSO
-- ================================================
insert into user_acesso (nome) values ('Cliente');
insert into user_acesso (nome) values ('Organizador');
insert into user_acesso (nome) values ('Proprietário');

-- ================================================
-- TABELA CLIENTE (HERANÇA: SINGLE_TABLE)
-- ================================================
-- 🔹 CLIENTES (tipo_usuario = CLIENTE)
insert into cliente (nome, nickname, email, senha, datanascimento, foto, tipo_usuario) values ('Felipe Farias', 'felipe.dev', 'felipe@email.com', '123456', '1995-04-12', 'felipe.png', 'CLIENTE');

insert into cliente (nome, nickname, email, senha, datanascimento, foto, tipo_usuario) values ('Maria Souza', 'maria.s', 'maria@email.com', 'senha123', '1998-09-25', 'maria.jpg', 'CLIENTE');

insert into cliente (nome, nickname, email, senha, datanascimento, foto, tipo_usuario) values ('João Silva', 'joaos', 'joao@email.com', 'qwerty', '1990-02-10', 'joao.jpeg', 'CLIENTE');

-- 🔸 ORGANIZADORES (tipo_usuario = ORGANIZADOR)
insert into cliente (nome, nickname, email, senha, datanascimento, foto, cpf, cnpj, rg, tipo_usuario) values ('Lucas Pereira', 'lucas.eventos', 'lucas@email.com', 'lucas123', '1988-07-19', 'lucas.png', '12345678900', '12345678000199', 'MG123456', 'ORGANIZADOR');

insert into cliente (nome, nickname, email, senha, datanascimento, foto, cpf, cnpj, rg, tipo_usuario) values ('Ana Lima', 'ana.lima', 'ana.lima@email.com', 'anaorganiza', '1992-05-03', 'ana.jpg', '98765432100', '99887766000155', 'SP987654', 'ORGANIZADOR');

insert into cliente (nome, nickname, email, senha, datanascimento, foto, cpf, cnpj, rg, tipo_usuario) values ('Carlos Mendes', 'carlos.event', 'carlos@email.com', 'eventos2024', '1985-03-15', 'carlos.jpeg', '11223344556', '44556677000122', 'RJ112233', 'ORGANIZADOR');

-- ================================================
-- TABELA CLIENTE_USER_ACESSO (TABELA INTERMEDIÁRIA MANY-TO-MANY)
-- ================================================
insert into cliente_user_acesso (cliente_id, user_acesso_id) values (1, 1);
insert into cliente_user_acesso (cliente_id, user_acesso_id) values (2, 1);
insert into cliente_user_acesso (cliente_id, user_acesso_id) values (3, 1);
insert into cliente_user_acesso (cliente_id, user_acesso_id) values (4, 2);
insert into cliente_user_acesso (cliente_id, user_acesso_id) values (5, 2);
insert into cliente_user_acesso (cliente_id, user_acesso_id) values (6, 2);

-- ================================================
-- TABELA TELEFONE
-- ================================================
insert into telefone (numero, cliente_id) values ('(31) 98877-6655', 1);
insert into telefone (numero, cliente_id) values ('(31) 99745-3322', 1);
insert into telefone (numero, cliente_id) values ('(21) 97654-1122', 2);
insert into telefone (numero, cliente_id) values ('(11) 91234-5566', 3);
insert into telefone (numero, cliente_id) values ('(11) 98888-7777', 4);
insert into telefone (numero, cliente_id) values ('(21) 95555-6666', 5);

-- ================================================
-- TABELA PAGAMENTO
-- ================================================
insert into pagamento (nomeCompleto, cpf, email, nomeCartao, numeroCartao, validadeCartao) values ('João Silva', '12345678901', 'joao@email.com', 'João Silva', '4111111111111111', '2027-12-31');

insert into pagamento (nomeCompleto, cpf, email, nomeCartao, numeroCartao, validadeCartao) values ('Maria Souza', '98765432100', 'maria@email.com', 'Maria Souza', '5500000000000004', '2026-11-30');

insert into pagamento (nomeCompleto, cpf, email, nomeCartao, numeroCartao, validadeCartao) values ('Carlos Pereira', '45678912300', null, 'Carlos Pereira', '340000000000009', '2028-02-28');

-- ================================================
-- TABELA CATEGORIA_INGRESSO
-- ================================================
insert into categoria_ingresso (nome, preco, meiaEntrada) values ('VIP', 150.0, false);
insert into categoria_ingresso (nome, preco, meiaEntrada) values ('Pista', 80.0, true);
insert into categoria_ingresso (nome, preco, meiaEntrada) values ('Camarote', 300.0, false);

-- ================================================
-- TABELA CARGO EQUIPE
-- ================================================
insert into cargo (nome) values ('Segurança');
insert into cargo (nome) values ('DJ');
insert into cargo (nome) values ('BarMan');
