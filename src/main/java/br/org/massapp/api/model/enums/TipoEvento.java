package br.org.massapp.api.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TipoEvento {
    RETIRO_FECHADO(1, "Retiro fechado", "Retiro onde os participantes dormem no local."),
    RETIRO_ABERTO(2, "Retiro aberto", "Retiro onde os participantes dormem no local."),
    CONGRESSO(3, "Congresso", "Congresso com grandes pregadores ou participantes."),
    ENCONTRO(4, "Encontro", "Encontro para formação/oração/espiritualidade."),
    REUNIAO(5, "Reunião", "Reunião para alinhamento e estratégias de evangelização.");
    
    private final Integer id;
    private final String nome;
    private final String descricao;
}
