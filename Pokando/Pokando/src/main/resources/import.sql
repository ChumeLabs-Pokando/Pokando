
-- TABELA PAIS INSERTS
insert into pais(nome, sigla) values ('Brazil', 'BR');
insert into pais(nome, sigla) values ('Canadá', 'CN');
insert into pais(nome, sigla) values ('Argentina', 'AG');


-- tabela estado
insert into estado (nome, sigla, pais_id) values ('São Paulo', 'SP', 1);
insert into estado (nome, sigla, pais_id) values ('Rio de Janeiro', 'RJ', 1);
insert into estado (nome, sigla, pais_id) values ('Minas Gerais', 'MG', 1);
insert into estado (nome, sigla, pais_id) values ('Bahia', 'BA', 1);

-- tabela cidade
insert into cidade (nome, estado_id) values ('São Paulo', 1);
insert into cidade (nome, estado_id) values ('Campinas', 1);
insert into cidade (nome, estado_id) values ('Santos', 1);

insert into cidade (nome, estado_id) values ('Rio de Janeiro', 2);
insert into cidade (nome, estado_id) values ('Niterói', 2);
insert into cidade (nome, estado_id) values ('Petrópolis', 2);

-- tabela endereco_geografico
insert into endereco_geografico (longitude, latitude) values ('-46.633309', '-23.550520'); -- são paulo - sp

insert into endereco_geografico (longitude, latitude) values ('-43.209373', '-22.911014'); -- rio de janeiro - rj

insert into endereco_geografico (longitude, latitude) values ('-38.510830', '-12.971389'); -- salvador - ba

-- tabela endereco
-- endereço em são paulo (cidade id = 1, endereco_geografico id = 1)
insert into endereco (logradouro, cidade_id, numero, cep, bairro, complemento, endereco_geografico_id) values ('Avenida Paulista', 1, '1578', '01311000', 'Bela Vista', 'Conjunto 101', 1);

-- endereço no rio de janeiro (cidade id = 2, endereco_geografico id = 2)
insert into endereco (logradouro, cidade_id, numero, cep, bairro, complemento, endereco_geografico_id) values ('Rua Barata Ribeiro', 2, '450', '22040002', 'Copacabana', null, 2);

-- user acesso

insert into user_acesso (nome) values ('Cliente');
insert into user_acesso (nome) values ('Organizador');
insert into user_acesso (nome) values ('Proprietário');

-- usuario

insert into Usuario (nome, nickname, email, senha, user_acesso_id, dataNascimento, foto) values ('Felipe Farias', 'felipe.dev', 'felipe@email.com', '123456', 1, '1995-04-12', 'felipe.png');
insert into Usuario (nome, nickname, email, senha, user_acesso_id, dataNascimento, foto) values ('Maria Souza', 'maria.s', 'maria@email.com', 'senha123', 2, '1998-09-25', 'maria.jpg');
insert into Usuario (nome, nickname, email, senha, user_acesso_id, dataNascimento, foto) values ('João Silva', 'joaos', 'joao@email.com', 'qwerty', 1, '1990-02-10', 'joao.jpeg');


-- telefone

insert into Telefone (numero, usuario_id) values ('(31) 98877-6655', 1);
insert into Telefone (numero, usuario_id) values ('(31) 99745-3322', 1);
insert into Telefone (numero, usuario_id) values ('(21) 97654-1122', 2);
insert into Telefone (numero, usuario_id) values ('(11) 91234-5566', 3);


-- pag

insert into Pagamento (nomeCompleto, cpf, email, nomeCartao, numeroCartao, validadeCartao) values ('João Silva', '12345678901', 'joao@email.com', 'João Silva', '4111111111111111', '2027-12-31');
insert into Pagamento (nomeCompleto, cpf, email, nomeCartao, numeroCartao, validadeCartao) values ('Maria Souza', '98765432100', 'maria@email.com', 'Maria Souza', '5500000000000004', '2026-11-30');
insert into Pagamento (nomeCompleto, cpf, email, nomeCartao, numeroCartao, validadeCartao) values ('Carlos Pereira', '45678912300', null, 'Carlos Pereira', '340000000000009', '2028-02-28');


-- cat ingresso

insert into Categoria_ingresso (nome, preco, meiaEntrada) values ('VIP', 150.0, false);
insert into Categoria_ingresso (nome, preco, meiaEntrada) values ('Pista', 80.0, true);
insert into Categoria_ingresso (nome, preco, meiaEntrada) values ('Camarote', 300.0, false);


--- cargo equipe

insert into Cargo (nome) values ('Segurança');
insert into Cargo (nome) values ('DJ');
insert into Cargo (nome) values ('BarMan');
