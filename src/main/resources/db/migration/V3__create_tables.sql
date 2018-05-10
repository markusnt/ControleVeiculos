CREATE TABLE veiculo (
	id	BIGINT auto_increment NOT NULL,
	tipo_veiculo	VARCHAR (250),
	marca	VARCHAR (250),
	modelo	VARCHAR (250),
	cor	VARCHAR (250),
	placa	VARCHAR (250),
	placa_cid	VARCHAR (250),
	cnh	BIGINT,
	PRIMARY KEY (id)
);

CREATE TABLE cr (
	id	BIGINT auto_increment NOT NULL,
	nome	VARCHAR (250),
	PRIMARY KEY (id)
);

CREATE TABLE localidade (
	id	BIGINT auto_increment NOT NULL,
	cidade	VARCHAR (250),
	uf VARCHAR(250),
	PRIMARY KEY (id)
);

CREATE TABLE condutor (
    cnh	BIGINT	auto_increment NOT NULL,
    venc_cnh	 VARCHAR (250),
    categ_cnh	VARCHAR (250),
    tipo_user	VARCHAR (250),
    nome	VARCHAR (250),
    local_trab	VARCHAR (250),
    matricula	BIGINT,
    email	VARCHAR (250),
    tel	VARCHAR (250),
    ramal	VARCHAR (250),
    veiculo_id	BIGINT,
    cr_id	BIGINT,
    localidade_id	BIGINT,
    PRIMARY KEY (cnh),
    FOREIGN KEY (veiculo_id) REFERENCES veiculo(id) on delete cascade,
    FOREIGN KEY (cr_id) REFERENCES cr(id) on delete cascade,
    FOREIGN KEY (localidade_id) REFERENCES localidade(id) on delete cascade
);
