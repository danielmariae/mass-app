package br.org.massapp.api.dto.enums;

import br.org.massapp.api.model.enums.DiaDaSemana;

public record DiaDaSemanaDTO(
    String enumName,    
    Integer id,
    String descricao
) {
    public static DiaDaSemanaDTO valueOf(DiaDaSemana d){
        return new DiaDaSemanaDTO(d.toString(), d.getId(), d.getDescricao());
    }
}
