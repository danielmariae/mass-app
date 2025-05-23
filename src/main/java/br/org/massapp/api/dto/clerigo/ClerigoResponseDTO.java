package br.org.massapp.api.dto.clerigo;

import br.org.massapp.api.dto.endereco.EnderecoResponseDTO;
import br.org.massapp.api.dto.enums.TipoClerigoDTO;
import br.org.massapp.api.dto.telefone.TelefoneResponseDTO;
import br.org.massapp.api.model.clerigo.Clerigo;

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
