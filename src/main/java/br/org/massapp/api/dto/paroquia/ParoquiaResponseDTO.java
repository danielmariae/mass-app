package br.org.massapp.api.dto.paroquia;

import java.util.List;
import java.util.stream.Collectors;

import br.org.massapp.api.dto.contato.ContatoResponseDTO;
import br.org.massapp.api.dto.endereco.EnderecoResponseDTO;
import br.org.massapp.api.dto.horariofuncionamento.HorarioFuncionamentoResponseDTO;
import br.org.massapp.api.dto.telefone.TelefoneResponseDTO;
import br.org.massapp.api.model.paroquia.Paroquia;

public record ParoquiaResponseDTO(
    Long id,
    String nome,
    String descricao,
    List<HorarioFuncionamentoResponseDTO> horarioFuncionamento,
    ContatoResponseDTO responsavel,
    EnderecoResponseDTO endereco,
    TelefoneResponseDTO telefone,
    String linkInstagram,
    String linkFacebook,
    String linkYoutube
) {
    public static ParoquiaResponseDTO valueOf(Paroquia p){
        return new ParoquiaResponseDTO(p.getId(),
                                       p.getNome(), 
                                       p.getDescricao(),
                                       p.getHorariosFuncionamento()
                                        .stream()
                                        .map(HorarioFuncionamentoResponseDTO::valueOf)
                                        .collect(Collectors.toList()),
                                       ContatoResponseDTO.valueOf(p.getResponsavel()),
                                       EnderecoResponseDTO.valueOf(p.getEndereco()),
                                       TelefoneResponseDTO.valueOf(p.getTelefone()), 
                                       p.getLinkInstagram(),
                                       p.getLinkFacebook(),
                                       p.getLinkYoutube());
    }
}
