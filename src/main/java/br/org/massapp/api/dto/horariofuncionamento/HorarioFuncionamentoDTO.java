package br.org.massapp.api.dto.horariofuncionamento;

import java.time.LocalTime;

import br.org.massapp.api.dto.enums.DiaDaSemanaDTO;
import jakarta.validation.Valid;

public record HorarioFuncionamentoDTO(
    @Valid DiaDaSemanaDTO diaDaSemana,
    LocalTime horarioAbertura,
    LocalTime horarioFechamento
) {}
