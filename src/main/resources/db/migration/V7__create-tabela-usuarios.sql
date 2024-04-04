DROP TABLE IF EXISTS usuarios;
CREATE TABLE usuarios (
                          id SERIAL PRIMARY KEY,
                          login VARCHAR(100) NOT NULL,
                          senha VARCHAR(255) NOT NULL
);

insert into usuarios values (1,'luan.santana@voll.med', '$2a$10$Y50UaMFOxteibQEYLrwuHeehHYfcoafCopUazP12.rqB41bsolF5.');
insert into usuarios values (2,'ana.souza@voll.med', '$2a$10$Y50UaMFOxteibQEYLrwuHeehHYfcoafCopUazP12.rqB41bsolF5.');