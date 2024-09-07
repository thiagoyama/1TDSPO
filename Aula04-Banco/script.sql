create table t_carro (
    id_carro number(10) PRIMARY KEY,
    ds_modelo varchar(80) not null,
    nr_placa varchar(7),
    ds_motor number(2,1),
    ds_automatico number(1)
);

create sequence sq_t_carro INCREMENT by 1 START with 1 nocache;