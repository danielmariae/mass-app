package br.org.massapp.api.model.usuario;

import br.org.massapp.api.model.common.DefaultEntity;
import br.org.massapp.api.model.common.Endereco;
import br.org.massapp.api.model.common.Telefone;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Usuario extends DefaultEntity {
    private String nome;
    private String email;
    private String senha;
    private String pertenca;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "telefone_id")
    private Telefone telefone;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;
    private String fotoPerfilPath;
}
