package br.org.massapp.api.model;

import br.org.massapp.api.model.common.Contato;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Clerigo extends Contato {
    private String tipoClerigo;
    private String ordemCarisma;
}
