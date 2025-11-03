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
-- TABELA ENDERECOGEOGRAFICO
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
-- TABELA EVENTO
-- ================================================
INSERT INTO evento (id, nome, descricao, status, datahora, autorizado, limite_inscricoes) VALUES (1, 'Festa Tech', 'Evento de tecnologia', 'DIVULGADO', '2026-01-10 18:00:00', true, 500),(2, 'Show Rock', 'Festival de rock', 'OCULTO', '2026-03-15 20:00:00', false, 800),(3, 'Startup Meeting', 'Encontro de startups', 'DIVULGADO', '2026-05-01 09:00:00', true, 300);

-- ================================================
-- TABELA CATEGORIA_INGRESSO
-- ================================================
INSERT INTO categoria_ingresso (id, nome, preco, meia_entrada) VALUES (1, 'Pista', 100.00, false);
INSERT INTO categoria_ingresso (id, nome, preco, meia_entrada) VALUES (2, 'VIP', 250.00, false);
INSERT INTO categoria_ingresso (id, nome, preco, meia_entrada) VALUES (3, 'Camarote', 400.00, true);

-- ================================================
-- TABELA PAGAMENTO
-- ================================================
insert into pagamento (nome_completo, cpf, email, nome_cartao, numero_cartao, validade_cartao) values ('João Silva', '12345678901', 'joao@email.com', 'João Silva', '4111111111111111', '2027-12-31');

insert into pagamento (nome_completo, cpf, email, nome_cartao, numero_cartao, validade_cartao) values ('Maria Souza', '98765432100', 'maria@email.com', 'Maria Souza', '5500000000000004', '2026-11-30');

insert into pagamento (nome_completo, cpf, email, nome_cartao, numero_cartao, validade_cartao) values ('Carlos Pereira', '45678912300', null, 'Carlos Pereira', '340000000000009', '2028-02-28');

-- ================================================
-- TABELA USERACESSO
-- ================================================
insert into user_acesso (nome) values ('Cliente');
insert into user_acesso (nome) values ('Organizador');
insert into user_acesso (nome) values ('Proprietário');

-- ================================================
-- TABELA INGRESSO
-- ================================================

INSERT INTO ingresso (id, quantidade, status, presenca, data_pedido, data_pagamento, gratuito, categoria_ingresso_id, pagamento_id) VALUES(1, 1, true, false, '2026-01-01', '2026-01-02', false, 1, 1),(2, 2, true, false, '2026-01-05', '2026-01-06', false, 2, 2),(3, 1, true, false, '2026-02-01', '2026-02-01', false, 3, 3);

-- ================================================
-- TABELA CLIENTE (HERANÇA: SINGLE_TABLE)
-- ================================================

-- 🔹 CLIENTES (tipo_usuario = CLIENTE)
INSERT INTO cliente (nome, nickname, email, senha, data_nascimento, foto, tipo_usuario) VALUES ('João Silva', 'joao.s', 'joao@email.com', '123', '1995-02-10', 'p1.png','CLIENTE'),('Maria Souza', 'maria.s', 'maria@email.com', '123', '1998-06-15', 'p2.png','CLIENTE'),('Pedro Lima', 'pedro.l', 'pedro@email.com', '123', '1993-11-22', 'p3.png','CLIENTE');

-- 🔸 ORGANIZADORES (tipo_usuario = ORGANIZADOR)
INSERT INTO cliente (nome, nickname, email, senha, data_nascimento, foto, cpf, cnpj, rg, tipo_usuario) VALUES ('Ana Ramos', 'ana.event', 'ana@email.com', '123', '1990-01-01', 'o1.png','12345678901','12345678000199','MG112233','ORGANIZADOR'),('Carlos Mendes', 'carlos.m', 'carlos@email.com', '123', '1988-05-22', 'o2.png','98765432100','98765432000177','SP445566','ORGANIZADOR'),( 'Fernanda Torres', 'fernanda.t', 'fernanda@email.com', '123', '1992-04-02', 'o3.png','55566677788','55443322000155','RJ889900','ORGANIZADOR');

-- 🔸 PROPRIETARIOS (tipo_usuario = PROPRIETARIO)
insert into cliente (nome, nickname, email, senha, data_nascimento, foto, cpf, cnpj, rg, tipo_usuario) values ('Mariana Souza', 'mariana.pro', 'mariana@email.com', 'proprietaria1', '1989-09-25', 'mariana.png', '32165498700', '32165498000177', 'SP321654', 'PROPRIETARIO');

insert into cliente (nome, nickname, email, senha, data_nascimento, foto, cpf, cnpj, rg, tipo_usuario) values ('Ricardo Alves', 'ricardo.alves', 'ricardo.alves@email.com', 'ricardopro', '1990-12-11', 'ricardo.jpg', '65498732100', '65498732000133', 'RJ654987', 'PROPRIETARIO');

insert into cliente (nome, nickname, email, senha, data_nascimento, foto, cpf, cnpj, rg, tipo_usuario) values ('Fernanda Costa', 'fernanda.eventos', 'fernanda@email.com', 'proeventos', '1983-02-20', 'fernanda.jpeg', '78912345600', '78912345000144', 'MG789123', 'PROPRIETARIO');

-- ================================================
-- TABELA CLIENTE_USERACESSO (TABELA INTERMEDIÁRIA MANY-TO-MANY)
-- ================================================
INSERT INTO cliente_user_acesso VALUES (1,1),(2,1),(3,1),(4,2),(5,2),(6,3),(6,2);

-- ================================================
-- TABELA CLIENTE_EVENTO
-- ================================================
insert into cliente_evento (cliente_id, evento_id) values (1, 1);
insert into cliente_evento (cliente_id, evento_id) values (1, 2);
insert into cliente_evento (cliente_id, evento_id) values (2, 3);
insert into cliente_evento (cliente_id, evento_id) values (3, 1);

-- ================================================
-- TABELA ORGANIZADOR_EVENTO
-- ================================================
INSERT INTO organizador_evento VALUES (1,1),(2,2),(3,3),(1,2);

-- ================================================
-- TABELA EVENTO_INGRESSO
-- ================================================
INSERT INTO evento_ingresso VALUES(1,1),(1,2),(2,2),(3,3);

-- ================================================
-- TABELA TELEFONE
-- ================================================
insert into telefone (numero, cliente_id) values ('(31) 98877-6655', 1);
insert into telefone (numero, cliente_id) values ('(31) 99745-3322', 1);
insert into telefone (numero, cliente_id) values ('(21) 97654-1122', 2);
insert into telefone (numero, cliente_id) values ('(11) 91234-5566', 3);
insert into telefone (numero, cliente_id) values ('(11) 98888-7777', 4);
insert into telefone (numero, cliente_id) values ('(21) 95555-6666', 5);



