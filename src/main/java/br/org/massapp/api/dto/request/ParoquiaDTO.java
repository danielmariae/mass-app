package br.org.massapp.api.dto.request;

import java.util.List;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

public record ParoquiaDTO(
    @NotBlank String nome,
    @NotBlank String descricao,
    List<HorarioFuncionamentoDTO> horarioFuncionamento,
    @Valid ContatoDTO responsavel,
    @Valid EnderecoDTO endereco,
    @Valid TelefoneDTO telefone,
    String linkInstagram,
    String linkFacebook,
    String linkYoutube
) {
    
}
