package br.org.massapp.api.dto.contato;

import br.org.massapp.api.dto.endereco.EnderecoDTO;
import br.org.massapp.api.dto.telefone.TelefoneDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

public record ContatoDTO(
    @NotBlank String nome,
    @NotBlank String email,
    @NotBlank String cargo,
    @Valid TelefoneDTO telefone,
    @Valid EnderecoDTO endereco
) {
    
}
