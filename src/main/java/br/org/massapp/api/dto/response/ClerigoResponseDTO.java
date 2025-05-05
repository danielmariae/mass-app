package br.org.massapp.api.dto.response;

import br.org.massapp.api.dto.enums.TipoClerigoDTO;
import br.org.massapp.api.model.Clerigo;

public record ClerigoResponseDTO(
    Long id,
    String nome,
    String email,
    TipoClerigoDTO tipoClerigo,
    String ordemCarisma,
    TelefoneResponseDTO telefone,
    EnderecoResponseDTO endereco
) {
    public static ClerigoResponseDTO valueOf(Clerigo c){
        return new ClerigoResponseDTO(c.getId(), c.getNome(), c.getEmail(), TipoClerigoDTO.valueOf(c.getTipoClerigo()), 
        c.getOrdemCarisma(), TelefoneResponseDTO.valueOf(c.getTelefone()), EnderecoResponseDTO.valueOf(c.getEndereco()));
    }    
}
