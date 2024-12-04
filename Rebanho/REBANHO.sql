create table t_registro(
    id_cordeiro INT GENERATED AS IDENTITY PRIMARY KEY,
    mae_brinco int not null,
    data_Nascimento date not null,
    sexo varchar (1) not null check (sexo in ('M', 'F')),
    p_nascimento float not null,
    raca varchar (30) 
);

create table t_vacina(
    id_cordeiro int,
    n_brinco int primary key,
    data_vacina date not null,
    nome_vacina varchar(60) not null,
    constraint fk_t_vacina_registro
        FOREIGN KEY (id_cordeiro) REFERENCES t_registro (id_cordeiro)
);

create table t_peso(
    id_cordeiro int not null,
    n_brinco int not null,
    peso_15_dias float not null,
    peso_20_dias float not null,
    peso_30_dias float not null,
    peso_40_dias float not null,
    peso_50_dias float not null,
    peso_60_dias float not null,
    peso_90_dias float not null,
    constraint fk_t_peso_vacina
        foreign key (n_brinco) references t_vacina (n_brinco),
    constraint fk_t_peso_registro 
        FOREIGN KEY (id_cordeiro) REFERENCES t_registro (id_cordeiro)
);

create table t_manejo(
    id_cordeiro int not null,
    n_brinco int not null,
    data_manejo date not null,
    grau_do_famacha int not null,
    vermifugo_oral varchar (1) not null check (vermifugo_oral in ('S', 'N')), 
    vermifugo_muscular varchar (1) not null check 
        (vermifugo_muscular in ('S', 'N')), 
    vermifugo_venoso varchar (1) not null check (vermifugo_venoso in ('S','N')), 
    nome_vermifugo varchar(200) not null,
    medicacao varchar (500) not null,
    presenca_bicheira varchar (1) not null check 
        (presenca_bicheira in ('S', 'N')),
    constraint pk_t_manejo primary key (data_manejo, id_cordeiro),
    constraint fk_t_manejo_vacina
        foreign key (n_brinco) references t_vacina (n_brinco),
    constraint fk_t_manejo_registro 
        FOREIGN KEY (id_cordeiro) REFERENCES t_registro (id_cordeiro)  
);

select * from t_registro;
select * from t_vacina;
select * from t_peso;
select * from t_manejo;

drop table t_registro;
drop table t_vacina;
drop table t_peso;
drop table t_manejo;