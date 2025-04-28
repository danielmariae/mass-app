-- Inserir em Endereco
insert into Endereco (id, UF, bairro, cep, complemento, localidade, logradouro, numeroLote, dataHoraAtualizacao, dataHoraCriacao)
values (1, 'SP', 'Centro', '01000-000', 'Apto 101', 'São Paulo', 'Rua Exemplo', '123', current_timestamp, current_timestamp);

-- Inserir em Telefone
insert into Telefone (id, ddd, numero, dataHoraAtualizacao, dataHoraCriacao)
values (1, 11, '99999-9999', current_timestamp, current_timestamp);

-- Inserir em Contato
insert into Contato (id, endereco_id, telefone_id, nome, email, cargo, dataHoraAtualizacao, dataHoraCriacao)
values (1, 1, 1, 'Contato Teste', 'contato@teste.com', 'Responsável', current_timestamp, current_timestamp);

-- Inserir em Clerigo
insert into Clerigo (id, endereco_id, telefone_id, nome, email, ordemCarisma, tipoClerigo, dataHoraAtualizacao, dataHoraCriacao)
values (1, 1, 1, 'Pe. João', 'pejoao@igreja.com', 'Franciscano', 'PADRE', current_timestamp, current_timestamp);

-- Inserir em Comunidade
insert into Comunidade (id, contato_id, endereco_id, telefone_id, nome, descricao, linkFacebook, linkInstagram, linkYoutube, dataFundacao, dataHoraAtualizacao, dataHoraCriacao)
values (1, 1, 1, 1, 'Comunidade São José', 'Comunidade Católica', 'fb.com/comunidade', 'instagram.com/comunidade', 'youtube.com/comunidade', current_timestamp, current_timestamp, current_timestamp);

-- Inserir em HorarioFuncionamento
insert into HorarioFuncionamento (id, diaDaSemana, horarioAbertura, horarioFechamento, dataHoraAtualizacao, dataHoraCriacao)
values (1, 'DOMINGO', '08:00:00', '18:00:00', current_timestamp, current_timestamp);

-- Inserir em Local
insert into Local (id, endereco_id, telefone_id, nome, linkFacebook, linkInstagram, linkYoutube, dataFundacao, dataHoraAtualizacao, dataHoraCriacao)
values (1, 1, 1, 'Salão Paroquial', 'fb.com/salao', 'instagram.com/salao', 'youtube.com/salao', current_date, current_timestamp, current_timestamp);

-- Inserir em Paroquia
insert into Paroquia (id, clerigo_paroco, contato_responsavel, endereco_id, telefone_id, nome, descricao, linkFacebook, linkInstagram, linkYoutube, dataHoraAtualizacao, dataHoraCriacao)
values (1, 1, 1, 1, 1, 'Paróquia Santa Maria', 'Paróquia no centro da cidade', 'fb.com/paroquia', 'instagram.com/paroquia', 'youtube.com/paroquia', current_timestamp, current_timestamp);

-- Inserir em Usuario
insert into Usuario (endereco_id, telefone_id, nome, email, fotoPerfilPath, senha, pertenca, dataHoraAtualizacao, dataHoraCriacao)
values (1, 1, 'Usuário Teste', 'usuario@teste.com', '/path/to/foto.jpg', 'senha123', 'comunidade', current_timestamp, current_timestamp);

-- Inserir em Evento
insert into Evento (contato_id, nome, descricao, observacoes, idadeMinina, idadeMaxima, dataInicio, dataFim, dataHoraAtualizacao, dataHoraCriacao)
values (1, 'Evento Anual', 'Evento importante', 'Levar documentos', 18, 60, current_timestamp, current_timestamp, current_timestamp, current_timestamp);

-- Inserir em comunidade_evento
insert into comunidade_evento (comunidade_id, evento_id)
values (1, 1);

-- Inserir em Atendimento
insert into Atendimento (comunidade_id, local_id, paroquia_id, diaDaSemana, tipoAtendimento, horarioInicio, horarioFim, dataHoraAtualizacao, dataHoraCriacao)
values (1, 1, 1, 'DOMINGO', 'Missa', '09:00:00', '10:00:00', current_timestamp, current_timestamp);

-- Inserir em Confissao
insert into Confissao (comunidade_id, contato_id, local_id, paroquia_id, diaDaSemana, agendamento, horarioInicio, horarioFim, dataHoraAtualizacao, dataHoraCriacao)
values (1, 1, 1, 1, 'SABADO', true, '15:00:00', '16:00:00', current_timestamp, current_timestamp);

-- Inserir em Missa
insert into Missa (comunidade_id, local_id, paroquia_id, dia, horario, sazonal, dataHoraAtualizacao, dataHoraCriacao)
values (1, 1, 1, 'DOMINGO', '10:00:00', false, current_timestamp, current_timestamp);

-- Inserir em paroquia_auxiliares
insert into paroquia_auxiliares (clerigo_id, paroquia_id)
values (1, 1);

-- Inserir em paroquia_comunidade
insert into paroquia_comunidade (comunidade_id, paroquia_id)
values (1, 1);

-- Inserir em paroquia_evento
insert into paroquia_evento (evento_id, paroquia_id)
values (1, 1);

-- Inserir em local_horario
insert into local_horario (horario_id, local_id)
values (1, 1);

-- Inserir em paroquia_horario
insert into paroquia_horario (horario_id, paroquia_id)
values (1, 1);