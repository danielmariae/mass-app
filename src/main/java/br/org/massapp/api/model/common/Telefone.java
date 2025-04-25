package br.org.massapp.api.model.common;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Telefone extends DefaultEntity {
    private int ddd;
    private String numero;
}
