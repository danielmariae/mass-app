package br.org.massapp.api.model.common;

import java.time.LocalTime;

import br.org.massapp.api.model.enums.DiaDaSemana;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class HorarioFuncionamento extends DefaultEntity {
    
    @Enumerated(EnumType.STRING)
    private DiaDaSemana diaDaSemana;

    private LocalTime horarioAbertura;
    private LocalTime horarioFechamento;
}
