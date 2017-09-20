INSERT INTO raca (descricao) VALUES('NEROLE'), ('HORLANDESA');

INSERT INTO animal (descricao, dt_cadastro, dt_nascimento, indentificador, procedencia, sexo, raca_id) VALUES('Vaca Tropicalia', '2017-01-01', '2008-01-01', '1239', 'ANIMAL_COMPRADO', 'F', 1);
INSERT INTO animal (descricao, dt_cadastro, dt_nascimento, indentificador, procedencia, sexo, raca_id) VALUES('Boi Azulao', '2017-01-01', '2008-01-01', '1233', 'ANIMAL_COMPRADO', 'M', 1);
INSERT INTO animal (descricao, dt_cadastro, dt_nascimento, indentificador, procedencia, sexo, raca_id) VALUES('Boi To', '2017-01-01', '2008-01-01', '1234', 'ANIMAL_COMPRADO', 'M', 1);
INSERT INTO animal (descricao, dt_cadastro, dt_nascimento, indentificador, procedencia, sexo, raca_id) VALUES('Vaca Amarela', '2017-01-01', '2008-01-01', '1235', 'ANIMAL_COMPRADO', 'F', 1);
INSERT INTO animal (descricao, dt_cadastro, dt_nascimento, indentificador, procedencia, sexo, raca_id) VALUES('Vaca Lenga', '2017-01-01', '2008-01-01', '1236', 'ANIMAL_COMPRADO', 'F', 1);
INSERT INTO animal (descricao, dt_cadastro, dt_nascimento, indentificador, procedencia, sexo, raca_id) VALUES('Vaca Truta', '2017-01-01', '2008-01-01', '1237', 'ANIMAL_COMPRADO', 'F', 1);
INSERT INTO animal (descricao, dt_cadastro, dt_nascimento, indentificador, procedencia, sexo, raca_id) VALUES('Vaca Twister JR', '2017-01-01', '2008-01-01', '1238', 'ANIMAL_COMPRADO', 'F', 1);
INSERT INTO animal (descricao, dt_cadastro, dt_nascimento, indentificador, procedencia, sexo, raca_id) VALUES('Vaca Macarrão', '2017-01-01', '2008-01-01', '1238', 'ANIMAL_COMPRADO', 'F', 1)
INSERT INTO animal (descricao, dt_cadastro, dt_nascimento, indentificador, procedencia, sexo, raca_id) VALUES('Vaca Rei', '2017-01-01', '2008-01-01', '1238', 'ANIMAL_COMPRADO', 'F', 1)
INSERT INTO animal (descricao, dt_cadastro, dt_nascimento, indentificador, procedencia, sexo, raca_id) VALUES('Vaca Zefa', '2017-01-01', '2008-01-01', '1238', 'ANIMAL_COMPRADO', 'F', 1)
INSERT INTO animal (descricao, dt_cadastro, dt_nascimento, indentificador, procedencia, sexo, raca_id) VALUES('Vaca Zelda', '2017-01-01', '2008-01-01', '1238', 'ANIMAL_COMPRADO', 'F', 1)
INSERT INTO animal (descricao, dt_cadastro, dt_nascimento, indentificador, procedencia, sexo, raca_id) VALUES('Boi Link', '2017-01-01', '2008-01-01', '1238', 'ANIMAL_COMPRADO', 'M', 1)
INSERT INTO animal (descricao, dt_cadastro, dt_nascimento, indentificador, procedencia, sexo, raca_id) VALUES('Vaca Bat', '2017-01-01', '2008-01-01', '1238', 'ANIMAL_COMPRADO', 'F', 1)
INSERT INTO animal (descricao, dt_cadastro, dt_nascimento, indentificador, procedencia, sexo, raca_id) VALUES('Vaca Lisa', '2017-01-01', '2008-01-01', '1238', 'ANIMAL_COMPRADO', 'F', 1)
INSERT INTO animal (descricao, dt_cadastro, dt_nascimento, indentificador, procedencia, sexo, raca_id) VALUES('Vaca Xanaina', '2017-01-01', '2008-01-01', '1238', 'ANIMAL_COMPRADO', 'F', 1)
INSERT INTO animal (descricao, dt_cadastro, dt_nascimento, indentificador, procedencia, sexo, raca_id) VALUES('Vaca Truco', '2017-01-01', '2008-01-01', '1238', 'ANIMAL_COMPRADO', 'F', 1)


INSERT INTo insumo (tipo, descricao, dt_cadastro, fornecedor) values('remedio', 'REMEDIO 01', '2017-01-01', 'FORNECEDOR 01');
INSERT INTo insumo (tipo, descricao, dt_cadastro, fornecedor) values('remedio', 'REMEDIO 02', '2017-01-01', 'FORNECEDOR 01');
INSERT INTo insumo (tipo, descricao, dt_cadastro, fornecedor) values('remedio', 'REMEDIO 03', '2017-01-04', 'FORNECEDOR 05');
INSERT INTo insumo (tipo, descricao, dt_cadastro, fornecedor) values('remedio', 'REMEDIO 04', '2017-01-04', 'FORNECEDOR 01');
INSERT INTo insumo (tipo, descricao, dt_cadastro, fornecedor) values('remedio', 'REMEDIO 05', '2017-01-06', 'FORNECEDOR 01');
INSERT INTo insumo (tipo, descricao, dt_cadastro, fornecedor) values('remedio', 'REMEDIO 06', '2017-01-07', 'FORNECEDOR 02');

INSERT INTo insumo (tipo, descricao, dt_cadastro, fornecedor, raca_id) values('semen', 'SEMEN 01', '2017-01-01', 'FORNECEDOR 01',1);
INSERT INTo insumo (tipo, descricao, dt_cadastro, fornecedor, raca_id) values('semen', 'SEMEN 02', '2017-01-01', 'FORNECEDOR 01',1);
INSERT INTo insumo (tipo, descricao, dt_cadastro, fornecedor, raca_id) values('semen', 'SEMEN 03', '2017-01-04', 'FORNECEDOR 05',1);
INSERT INTo insumo (tipo, descricao, dt_cadastro, fornecedor, raca_id) values('semen', 'SEMEN 04', '2017-01-04', 'FORNECEDOR 01',1);
INSERT INTo insumo (tipo, descricao, dt_cadastro, fornecedor, raca_id) values('semen', 'SEMEN 05', '2017-01-06', 'FORNECEDOR 01',2);
INSERT INTo insumo (tipo, descricao, dt_cadastro, fornecedor, raca_id) values('semen', 'SEMEN 06', '2017-01-07', 'FORNECEDOR 02',1);

INSERT INTO inseminacao (dtinsemincao, animal_id, semen_id, gestacao) values ('2017-01-01', 4, 7,false);
INSERT INTO inseminacao (dtinsemincao, animal_id, semen_id, gestacao) values ('2017-01-01', 4, 8,true);
INSERT INTO inseminacao (dtinsemincao, animal_id, semen_id, gestacao) values ('2017-01-01', 5, 9,false);
INSERT INTO inseminacao (dtinsemincao, animal_id, semen_id, gestacao) values ('2017-01-01', 5, 9,false);
INSERT INTO inseminacao (dtinsemincao, animal_id, semen_id, gestacao) values ('2017-01-01', 4, 7,false);
INSERT INTO inseminacao (dtinsemincao, animal_id, semen_id, gestacao) values ('2017-01-01', 4, 7,false);
