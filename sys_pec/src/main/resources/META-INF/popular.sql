INSERT INTO raca (descricao) VALUES('NEROLE'), ('HORLANDESA');

INSERT INTO animal (descricao, dt_cadastro, indentificador, sexo, raca_id) VALUES('Vaca Tropicalia', '2008-01-01', '1239', 'F', 1);
INSERT INTO animal (descricao, dt_cadastro, indentificador, sexo, raca_id) VALUES('Boi Azulao', '2008-01-01', '1233', 'M', 1);
INSERT INTO animal (descricao, dt_cadastro, indentificador, sexo, raca_id) VALUES('Boi To', '2008-01-01', '1234', 'M', 1);
INSERT INTO animal (descricao, dt_cadastro, indentificador, sexo, raca_id) VALUES('Vaca Amarela', '2008-01-01', '1235', 'F', 1);
INSERT INTO animal (descricao, dt_cadastro, indentificador, sexo, raca_id) VALUES('Vaca Lenga', '2008-01-01', '1236', 'F', 1);
INSERT INTO animal (descricao, dt_cadastro, indentificador, sexo, raca_id) VALUES('Vaca Truta', '2008-01-01', '1237', 'F', 1);
INSERT INTO animal (descricao, dt_cadastro, indentificador, sexo, raca_id) VALUES('Vaca Twister JR', '2008-01-01', '1238', 'F', 1);
INSERT INTO animal (descricao, dt_cadastro, indentificador, sexo, raca_id) VALUES('Vaca Macarrão', '2008-01-01', '1238', 'F', 1)
INSERT INTO animal (descricao, dt_cadastro, indentificador, sexo, raca_id) VALUES('Vaca Rei', '2008-01-01', '1238', 'F', 1)
INSERT INTO animal (descricao, dt_cadastro, indentificador, sexo, raca_id) VALUES('Vaca Zefa', '2008-01-01', '1238', 'F', 1)
INSERT INTO animal (descricao, dt_cadastro, indentificador, sexo, raca_id) VALUES('Vaca Zelda', '2008-01-01', '1238', 'F', 1)
INSERT INTO animal (descricao, dt_cadastro, indentificador, sexo, raca_id) VALUES('Boi Link', '2008-01-01', '1238', 'M', 1)
INSERT INTO animal (descricao, dt_cadastro, indentificador, sexo, raca_id) VALUES('Vaca Bat', '2008-01-01', '1238', 'F', 1)
INSERT INTO animal (descricao, dt_cadastro, indentificador, sexo, raca_id) VALUES('Vaca Lisa', '2008-01-01', '1238', 'F', 1)
INSERT INTO animal (descricao, dt_cadastro, indentificador, sexo, raca_id) VALUES('Vaca Xanaina', '2008-01-01', '1238', 'F', 1)
INSERT INTO animal (descricao, dt_cadastro, indentificador, sexo, raca_id, margemdiasdtnascimento) VALUES('Vaca Truco', '2008-01-01', '1238', 'F', 1, '17.5')


INSERT INTO estoque values  (20), (21), (22), (23), (24), (25), (26), (27), (28), (29), (30), (31);

INSERT INTo insumo (tipo, descricao, dt_cadastro, fornecedor, estoque_id) values('remedio', 'REMEDIO 01', '2017-01-01', 'FORNECEDOR 01', 20);
INSERT INTo insumo (tipo, descricao, dt_cadastro, fornecedor, estoque_id) values('remedio', 'REMEDIO 02', '2017-01-01', 'FORNECEDOR 01', 21);
INSERT INTo insumo (tipo, descricao, dt_cadastro, fornecedor, estoque_id) values('remedio', 'REMEDIO 03', '2017-01-04', 'FORNECEDOR 05', 22);
INSERT INTo insumo (tipo, descricao, dt_cadastro, fornecedor, estoque_id) values('remedio', 'REMEDIO 04', '2017-01-04', 'FORNECEDOR 01', 23);
INSERT INTo insumo (tipo, descricao, dt_cadastro, fornecedor, estoque_id) values('remedio', 'REMEDIO 05', '2017-01-06', 'FORNECEDOR 01', 24);
INSERT INTo insumo (tipo, descricao, dt_cadastro, fornecedor, estoque_id) values('remedio', 'REMEDIO 06', '2017-01-07', 'FORNECEDOR 02', 25);

INSERT INTo insumo (tipo, descricao, dt_cadastro, fornecedor, raca_id, estoque_id) values('semen', 'SEMEN 01', '2017-01-01', 'FORNECEDOR 01',1, 26);
INSERT INTo insumo (tipo, descricao, dt_cadastro, fornecedor, raca_id, estoque_id) values('semen', 'SEMEN 02', '2017-01-01', 'FORNECEDOR 01',1, 27);
INSERT INTo insumo (tipo, descricao, dt_cadastro, fornecedor, raca_id, estoque_id) values('semen', 'SEMEN 03', '2017-01-04', 'FORNECEDOR 05',1, 28);
INSERT INTo insumo (tipo, descricao, dt_cadastro, fornecedor, raca_id, estoque_id) values('semen', 'SEMEN 04', '2017-01-04', 'FORNECEDOR 01',1, 29);
INSERT INTo insumo (tipo, descricao, dt_cadastro, fornecedor, raca_id, estoque_id) values('semen', 'SEMEN 05', '2017-01-06', 'FORNECEDOR 01',2, 30);
INSERT INTo insumo (tipo, descricao, dt_cadastro, fornecedor, raca_id, estoque_id) values('semen', 'SEMEN 06', '2017-01-07', 'FORNECEDOR 02',1, 31);

INSERT INTO inseminacao (dtinsemincao, animal_id, semen_id, gestacao, dosagem) values ('2017-01-01', 4, 7,false, 0);
INSERT INTO inseminacao (dtinsemincao, animal_id, semen_id, gestacao, dosagem) values ('2017-01-01', 4, 8,true, 0);
INSERT INTO inseminacao (dtinsemincao, animal_id, semen_id, gestacao, dosagem) values ('2017-01-01', 5, 9,false, 0);
INSERT INTO inseminacao (dtinsemincao, animal_id, semen_id, gestacao, dosagem) values ('2017-01-01', 5, 9,false, 0);
INSERT INTO inseminacao (dtinsemincao, animal_id, semen_id, gestacao, dosagem) values ('2017-01-01', 4, 7,false, 0);
INSERT INTO inseminacao (dtinsemincao, animal_id, semen_id, gestacao, dosagem) values ('2017-01-01', 4, 7,false, 0);


INSERT INTO atualizacaoestoque (motivo, qtd, estoque_id, movimentacaotipo) values ('MOTIVO 01', 03, 20, 'ENTRADA');
INSERT INTO atualizacaoestoque (motivo, qtd, estoque_id, movimentacaotipo) values ('MOTIVO 02', 03, 20, 'ENTRADA');
INSERT INTO atualizacaoestoque (motivo, qtd, estoque_id, movimentacaotipo) values ('MOTIVO 03', 03, 20, 'BAIXA');
INSERT INTO atualizacaoestoque (motivo, qtd, estoque_id, movimentacaotipo) values ('MOTIVO 04', 03, 22, 'ENTRADA');
INSERT INTO atualizacaoestoque (motivo, qtd, estoque_id, movimentacaotipo) values ('MOTIVO 05', 03, 20, 'ENTRADA');
INSERT INTO atualizacaoestoque (motivo, qtd, estoque_id, movimentacaotipo) values ('MOTIVO 06', 03, 21, 'ENTRADA');
INSERT INTO atualizacaoestoque (motivo, qtd, estoque_id, movimentacaotipo) values ('MOTIVO 07', 03, 21, 'BAIXA');
INSERT INTO atualizacaoestoque (motivo, qtd, estoque_id, movimentacaotipo) values ('MOTIVO 08', 03, 20, 'ENTRADA');

INSERT INTO gestacao (dtiniciogestacao, dtparto, partosucesso, procedencia, animal_id, inseminacao_id) values ('2017-09-22', '2017-09-22', false, 'NASCIMENTO_INSEMINACAO', 5, 3)
INSERT INTO gestacao (dtiniciogestacao, dtparto, partosucesso, procedencia, animal_id, pai_id) values ('2017-09-22', '2017-09-22', false, 'NASCIMENTO_INSEMINACAO', 5, 1)



