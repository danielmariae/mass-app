package br.org.massapp.api.model;

import java.time.LocalTime;

import br.org.massapp.api.model.common.DefaultEntity;
import br.org.massapp.api.model.enums.DiaDaSemana;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Missa extends DefaultEntity{
    @Enumerated(EnumType.STRING)
    private DiaDaSemana dia;
    private LocalTime horario;
    // É de X em X tempo?
    private Boolean sazonal;
    private String frequencia;
    private String observacao;
    
    @ManyToOne(optional = true)
    @JoinColumn(name = "paroquia_id")
    private Paroquia paroquia;

    @ManyToOne(optional = true)
    @JoinColumn(name = "comunidade_id")
    private Comunidade comunidade;

    @ManyToOne(optional = true)
    @JoinColumn(name = "local_id")
    private Local local;

}
