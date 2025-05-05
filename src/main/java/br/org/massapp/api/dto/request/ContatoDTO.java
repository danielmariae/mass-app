package br.org.massapp.api.dto.request;

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
