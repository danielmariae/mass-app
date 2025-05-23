package br.org.massapp.api.model.comunidade;

import java.util.Date;
import java.util.List;

import br.org.massapp.api.model.atendimento.Atendimento;
import br.org.massapp.api.model.common.Contato;
import br.org.massapp.api.model.common.DefaultEntity;
import br.org.massapp.api.model.common.Endereco;
import br.org.massapp.api.model.common.Telefone;
import br.org.massapp.api.model.confissao.Confissao;
import br.org.massapp.api.model.evento.Evento;
import br.org.massapp.api.model.missa.Missa;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Comunidade extends DefaultEntity {
    private String nome;
    private Date dataFundacao;
    private String descricao;
    
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinTable(
        name = "comunidade_evento",
        joinColumns = @JoinColumn(name = "comunidade_id"),
        inverseJoinColumns = @JoinColumn(name = "evento_id")
    )
    private List<Evento> eventos;

    @OneToOne
    @JoinColumn(name = "contato_id")
    private Contato contato;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "telefone_id")
    private Telefone telefone;

    @OneToMany(mappedBy = "comunidade")
    private List<Missa> missas;

    @OneToMany(mappedBy = "comunidade")
    private List<Confissao> confissoes;

    @OneToMany(mappedBy = "comunidade")
    private List<Atendimento> atendimentos;

    // Implementar missas, confissões, atendimentos.
    private String linkInstagram;
    private String linkFacebook;
    private String linkYoutube;
}
