package br.org.massapp.api.model;

import java.time.LocalDate;
import java.util.List;

import br.org.massapp.api.model.common.DefaultEntity;
import br.org.massapp.api.model.common.Endereco;
import br.org.massapp.api.model.common.HorarioFuncionamento;
import br.org.massapp.api.model.common.Telefone;
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
public class Local extends DefaultEntity {
    private String nome;
    private LocalDate dataFundacao;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinTable(
        name = "local_horario",
        joinColumns = @JoinColumn(name = "local_id"),
        inverseJoinColumns = @JoinColumn(name = "horario_id")
    )
    private List<HorarioFuncionamento> horariosFuncionamento;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "telefone_id")
    private Telefone telefone;

    // Implementar missas, confissões, atendimentos.
    private String linkInstagram;
    private String linkFacebook;
    private String linkYoutube;
}
