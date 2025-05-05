package br.org.massapp.api.dto.response;

import java.time.LocalTime;

import br.org.massapp.api.model.common.HorarioFuncionamento;

public record HorarioFuncionamentoResponseDTO(
    Long id,
    String diaDaSemana,
    LocalTime horarioAbertura,
    LocalTime horarioFechamento
) {
    public static HorarioFuncionamentoResponseDTO valueOf(HorarioFuncionamento h){
        return new HorarioFuncionamentoResponseDTO(h.getId(), h.getDiaDaSemana().getDescricao(),
        h.getHorarioAbertura(), h.getHorarioFechamento());
    }
}
