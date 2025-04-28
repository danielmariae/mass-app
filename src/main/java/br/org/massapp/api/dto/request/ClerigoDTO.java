package br.org.massapp.api.dto.request;

import br.org.massapp.api.model.enums.TipoClerigo;

public record ClerigoDTO(
    String nome,
    String email
) {
    
}
