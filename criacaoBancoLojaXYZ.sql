drop database lojaOnlineXYZ;
create database lojaOnlineXYZ;
use lojaOnlineXYZ;
create table td_clientes (
	id int primary key auto_increment not null,
    cpf int not null,
    nome varchar(100),
    email varchar (100),
    senha varchar(45) DEFAULT NULL,
    foto longblob,
    fotoType varchar(300) default null
);
create table td_empregados(
	id int primary key auto_increment not null,
    cpf int not null,
    nome varchar(100),
    email varchar (100),
    senha varchar(45) DEFAULT NULL,
    foto longblob,
    fotoType varchar(300) default null,
	funcao varchar(100) not null
);
create table td_produtos(
	id int primary key auto_increment not null,
    nome varchar(100) not null,
    descricao text null
);
create table td_hist_precos(
	id int primary key auto_increment not null,
    produto int not null,
    preco double not null,
    data datetime not null,
	imagem varchar(250),
	constraint fk_produtos_hist_precos foreign key (produto) references td_produtos (id)
);

create table td_compras(
 	id int primary key auto_increment not null,
    cliente int not null,
    empregado int not null,
    data datetime not null,
	constraint fk_cliente_td_compras foreign key (cliente) references td_clientes (id),
    constraint fk_empregado_td_compras foreign key (empregado) references td_empregados (id)
);
create table td_lista_de_produtos(
	id int primary key auto_increment not null,
    compras int not null,
    produto int not null,
    quantidade int not null,
    preco int not null,
    constraint fk_compras_lista_prod foreign key (compras) references td_compras (id),
    constraint fk_produtos_lista_prod foreign key (produto) references td_produtos (id),
    constraint fk_preco_lista_prod foreign key (preco) references td_hist_precos (id)    
);
-- ------------------------------------------------------------------------------------------------------------------------
insert into td_clientes(cpf, nome, email, senha, foto, fotoType) values (1, 'Carmosito', 'carmo@teste.com', '1', '/foto1', '/foto1');
select * from td_clientes;
-- ------------------------------------------------------------------------------------------------------------------------
insert into td_empregados(cpf, nome, email, senha, foto, fotoType, funcao) values (2, 'Jose', 'jose@teste.com', '1', '/foto2', '/foto2', 'Gerente');
select * from td_empregados;
-- ------------------------------------------------------------------------------------------------------------------------
insert into td_produtos (nome, descricao) values ('xbox', 'console'),('playstation', 'console'),('controle xbox', 'acessórios'),('controle play','acessórios');
select * from td_produtos;
-- ------------------------------------------------------------------------------------------------------------------------
insert into td_hist_precos (produto, preco, data, imagem) values (1, 1700.00, now(), '\imagem1'),(2, 1700.00, now(), '\imagem2'), (3, 170.00, now(), '\imagem3'),(4, 170.00, now(), '\imagem4');
select * from td_hist_precos;
-- ------------------------------------------------------------------------------------------------------------------------
insert into td_compras(cliente, empregado, data) values (1, 1, now());
select * from td_compras;
-- ------------------------------------------------------------------------------------------------------------------------
DROP TRIGGER IF EXISTS TGR_QtdMenorQZero;
DELIMITER $
CREATE TRIGGER TGR_QtdMenorQZero BEFORE INSERT
ON td_lista_de_produtos
FOR EACH ROW
BEGIN
	if(new.quantidade <= 0)
		THEN
			SIGNAL SQLSTATE '45000'
				SET MESSAGE_TEXT = 'QUANTIDADE MENOR QUE ZERO', mysql_errno = 1001;
	END IF;
END$
DELIMITER ;
insert into td_lista_de_produtos (compras, produto, quantidade, preco) values (1, 1, 5, 1);
insert into td_lista_de_produtos (compras, produto, quantidade, preco) values (1, 3, 5, 1);
insert into td_lista_de_produtos (compras, produto, quantidade, preco) values (1, 2, 0, 1); -- IRÁ DAR ERRO, SÓ PARA TESTE
select * from td_lista_de_produtos;
-- ------------------------------------------------------------------------------------------------------------------------
DROP TRIGGER IF EXISTS TG_ProdutoIgual;
DELIMITER $
CREATE TRIGGER TG_ProdutoIgual BEFORE INSERT
ON td_lista_de_produtos
FOR EACH ROW
BEGIN
	 
     if exists(select produto from td_lista_de_produtos lp where lp.compras = new.compras and lp.produto = new.produto)
     THEN
     SIGNAL SQLSTATE '45000'
				SET MESSAGE_TEXT = 'PRODUTO JÁ INSERIDO', mysql_errno = 1001;
	end if;
END$
DELIMITER ;
insert into td_lista_de_produtos (compras, produto, quantidade, preco) values (1, 1, 25, 1); -- compra com o mesmo produto com diferente qtd


-- ---Desenvolva um Script SQL, chamado "xyz-selects.sql", que contenha as declarações SQL para:
-- -mostrar uma lista de todos os empregados. Exibir CPF e Nome.
select cpf, nome from td_empregados;
-- -mostrar uma lista de todos os produtos. Exibir Nome, Descrição e preço atual.
select pr.nome, pr.descricao, hpr.preco from td_produtos pr, td_hist_precos hpr where pr.id = hpr.id;
-- -mostrar uma lista de todos os clientes. Exibir CPF, Nome e Email.
select cpf, nome from td_cliente;
-- -mostrar uma lista de todas as compras e produtos comprados. Exibir CPF do cliente, Nome do cliente, Email do cliente, 
-- CPF do empregado, Nome do empregado, Data da compra, Nome do produto comprado, Quantidade do produto comprado e Preço do produto na compra. 
select cl.cpf, cl.nome, cl.email, e.cpf, e.nome, c.data, p.nome, lp.quantidade, hp.preco
 from td_compras c join td_cliente cl on cl.id = c.cliente 
	join td_lista_de_produtos lp on lp.compras = c.id
		join td_produtos p on lp.produto = p.id
			join td_empregados e on c.empregado = e.id
				join td_hist_precos hp on lp.preco = hp.id;
-- --Ordenar pelo nome do cliente, pela data da compra em ordem decrescente, pelo nome do produto comprado em ordem crescente
select cl.cpf, cl.nome, cl.email, e.cpf, e.nome, c.data, p.nome, lp.quantidade, hp.preco
 from td_compras c join td_cliente cl on cl.id = c.cliente 
	join td_lista_de_produtos lp on lp.compras = c.id
		join td_produtos p on lp.produto = p.id
			join td_empregados e on c.empregado = e.id
				join td_hist_precos hp on lp.preco = hp.id
                order by cl.nome, c.data desc, p.nome asc;
