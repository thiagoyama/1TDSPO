create table t_carro (
    id_carro number(10) PRIMARY KEY,
    ds_modelo varchar(80) not null,
    nr_placa varchar(7),
    ds_motor number(2,1),
    ds_automatico number(1)
);

create table t_concessionaria(
    id_concessionaria number(10) PRIMARY KEY,
    nm_concessionaria varchar(30) not null,
    nr_cnpj varchar(14) not null,
    nr_veiculos_maximo number(5)
)

create sequence sq_t_concessionaria INCREMENT by 1 START with 1 nocache;

create sequence sq_t_carro INCREMENT by 1 START with 1 nocache;