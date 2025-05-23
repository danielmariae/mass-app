package br.org.massapp.api.dto.clerigo;

import br.org.massapp.api.dto.endereco.EnderecoDTO;
import br.org.massapp.api.dto.enums.TipoClerigoDTO;
import br.org.massapp.api.dto.telefone.TelefoneDTO;
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
