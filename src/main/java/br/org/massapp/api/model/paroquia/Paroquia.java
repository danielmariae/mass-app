package br.org.massapp.api.model.paroquia;

import java.util.List;

import br.org.massapp.api.model.atendimento.Atendimento;
import br.org.massapp.api.model.clerigo.Clerigo;
import br.org.massapp.api.model.common.Contato;
import br.org.massapp.api.model.common.DefaultEntity;
import br.org.massapp.api.model.common.Endereco;
import br.org.massapp.api.model.common.HorarioFuncionamento;
import br.org.massapp.api.model.common.Telefone;
import br.org.massapp.api.model.comunidade.Comunidade;
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
public class Paroquia extends DefaultEntity {
    private String nome;
    private String descricao;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinTable(
        name = "paroquia_evento",
        joinColumns = @JoinColumn(name = "paroquia_id"),
        inverseJoinColumns = @JoinColumn(name = "evento_id")
    )
    private List<Evento> eventos;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinTable(
        name = "paroquia_comunidade",
        joinColumns = @JoinColumn(name = "paroquia_id"),
        inverseJoinColumns = @JoinColumn(name = "comunidade_id")
    )
    private List<Comunidade> comunidades;
    
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinTable(
        name = "paroquia_horario",
        joinColumns = @JoinColumn(name = "paroquia_id"),
        inverseJoinColumns = @JoinColumn(name = "horario_id")
    )
    private List<HorarioFuncionamento> horariosFuncionamento;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = false)
    @JoinColumn(name = "clerigo_paroco")
    private Clerigo paroco;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = false)
    @JoinTable(
        name = "paroquia_auxiliares",
        joinColumns = @JoinColumn(name = "paroquia_id"),
        inverseJoinColumns = @JoinColumn(name = "clerigo_id")
    )
    private List<Clerigo> auxiliares;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "contato_responsavel")
    private Contato responsavel;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "telefone_id")
    private Telefone telefone;

    @OneToMany(mappedBy = "paroquia")
    private List<Missa> missas;

    @OneToMany(mappedBy = "paroquia")
    private List<Confissao> confissoes;

    @OneToMany(mappedBy = "paroquia")
    private List<Atendimento> atendimentos;

    private String linkInstagram;
    private String linkFacebook;
    private String linkYoutube;
}
