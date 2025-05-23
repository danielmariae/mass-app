package br.org.massapp.api.dto.paroquia;

import java.util.List;

import br.org.massapp.api.dto.contato.ContatoDTO;
import br.org.massapp.api.dto.endereco.EnderecoDTO;
import br.org.massapp.api.dto.horariofuncionamento.HorarioFuncionamentoDTO;
import br.org.massapp.api.dto.telefone.TelefoneDTO;
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
