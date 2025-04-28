package br.org.massapp.api.model;

import java.time.LocalTime;

import br.org.massapp.api.model.common.Contato;
import br.org.massapp.api.model.common.DefaultEntity;
import br.org.massapp.api.model.enums.DiaDaSemana;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Confissao extends DefaultEntity {
    @Enumerated(EnumType.STRING)
    private DiaDaSemana diaDaSemana;
    private LocalTime horarioInicio;
    private LocalTime horarioFim;
    private Boolean agendamento;
    private String frequencia;
    private String observacao;


    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = false)
    @JoinColumn(name = "contato_id")
    private Contato contatoParaAgendamento;

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
