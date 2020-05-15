create table Usuario (
	codigo Integer not null,
	nome varchar(10) not null,
	senha varchar(10)
);

alter table Usuario
	add constraint Usuario_PK
		primary key(codigo);
		
insert into Usuario values (1, 'admin', 'nimda');

create table Pessoa (
	codigo Integer not null,
	nome varchar(30) not null,
	endereco varchar(50) not null
);

alter table Pessoa
	add constraint Pessoa_PK
		primary key(codigo);
	
insert into Pessoa values (1, 'Mateo Fischer', 'Av. Ridgewood, 321');
insert into Pessoa values (2, 'Cruz August', 'Av. Itaimwood, 2314');
insert into Pessoa values (3, 'Jakson Five', 'Rua das Rosas, 77');
insert into Pessoa values (4, 'Aline Serena', 'Estrada Pequi, 241');
insert into Pessoa values (5, 'Ana Luz', 'Rua PariSan, 54');