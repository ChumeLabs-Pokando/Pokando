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
INSERT INTO evento (id, nome, descricao, status, datahora,autorizado, limite_inscricoes, local) VALUES(1, 'Tech Expo 2025', 'Feira de tecnologia e inovação.','DIVULGADO', '2025-06-10 18:00:00', TRUE, 500, 'Rua primavera 143 Jardim Primavera Itaquiraí-MS'),(2, 'Festival de Música Sunset', 'Festival de música ao ar livre.','DIVULGADO', '2025-12-01 15:00:00', TRUE, 1500, 'Avenida Salvador Dali 134A Centro São Paulo-SP'),(3, 'Encontro de Negócios Rio', 'Evento empresarial exclusivo.','OCULTO', '2025-03-20 09:00:00', FALSE, 300, 'Avenida Amélia Fukuda 1435 Centro Naviraí-MS');

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
-- TABELA CLIENTE
-- ================================================

INSERT INTO cliente (id, nome, nickname, cpf, cnpj, email, senha,data_nascimento, foto) VALUES (1, 'Felipe Andrade', 'felipe_dev', '12345678901', NULL,'felipe@gmail.com', '123456', '1998-05-22', 'foto1.png'),(2, 'Marina Costa', 'marina_c', '98765432100', NULL,'marina@gmail.com', 'senhaMarina', '1995-09-10', 'foto2.png'),(3, 'Eventos Rio LTDA', 'eventos_rio', '12312312341', '11222333000155','contato@eventosrio.com', 'admin123', '2010-01-01', 'foto_empresa.png');

-- ================================================
-- TABELA CLIENTE_USERACESSO (TABELA INTERMEDIÁRIA MANY-TO-MANY)
-- ================================================
INSERT INTO cliente_user_acesso VALUES (1,1),(2,1),(3,1),(2,2),(3,2);

------------------------------------------------------------
-- RELACIONAMENTOS EVENTO ↔ CLIENTE
-- ACESSO COMO CLIENTE (ManyToMany)
------------------------------------------------------------

-- Cliente 1 tem acesso ao Evento 1 e 2
INSERT INTO cliente_acesso_cliente_evento (cliente_id, evento_id) VALUES (1, 1);
INSERT INTO cliente_acesso_cliente_evento (cliente_id, evento_id) VALUES (1, 2);

-- Cliente 2 tem acesso ao Evento 2
INSERT INTO cliente_acesso_cliente_evento (cliente_id, evento_id) VALUES (2, 2);

------------------------------------------------------------
-- RELACIONAMENTOS ORGANIZADOR ↔ EVENTO
------------------------------------------------------------

-- Cliente 2 é organizador dos eventos 1 e 3
INSERT INTO cliente_acesso_organizador_evento (cliente_id, evento_id) VALUES (2, 1);
INSERT INTO cliente_acesso_organizador_evento (cliente_id, evento_id) VALUES (2, 3);

-- Cliente 3 organiza o Evento 2
INSERT INTO cliente_acesso_organizador_evento (cliente_id, evento_id) VALUES (3, 2);

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




