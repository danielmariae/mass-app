package br.org.massapp.api.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TipoClerigo {
    DIACONO(1, "Diácono"),
    PADRE(2, "Padre"),
    CONEGO(3, "Cônego"),
    MONSENHOR(4, "Monsenhor"),
    FREI(5, "Frei"),
    MONGE(5, "Monge"),
    BISPO(6, "Bispo"),
    CARDEAL(7, "Cardeal"),
    PAPA(8, "Papa");
    
    private final Integer id;
    private final String nome;

}
