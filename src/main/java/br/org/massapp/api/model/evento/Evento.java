package br.org.massapp.api.model.evento;

import java.time.LocalDateTime;

import br.org.massapp.api.model.common.Contato;
import br.org.massapp.api.model.common.DefaultEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Evento extends DefaultEntity {
    private String nome;
    private String descricao;
    private LocalDateTime dataInicio;
    private LocalDateTime dataFim;
    private Integer idadeMinina;
    private Integer idadeMaxima;
    private String observacoes;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "contato_id")
    private Contato responsavel;
}
