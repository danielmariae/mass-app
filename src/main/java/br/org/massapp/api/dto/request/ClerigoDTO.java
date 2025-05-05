package br.org.massapp.api.dto.request;

import br.org.massapp.api.dto.enums.TipoClerigoDTO;
import jakarta.validation.Valid;

public record ClerigoDTO(
    String nome,
    String email,
    TipoClerigoDTO tipoClerigo,
    String ordemCarisma,
    @Valid TelefoneDTO telefone,
    @Valid EnderecoDTO endereco
) {

}
