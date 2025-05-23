package br.org.massapp.api.dto.contato;

import br.org.massapp.api.dto.endereco.EnderecoResponseDTO;
import br.org.massapp.api.dto.telefone.TelefoneResponseDTO;
import br.org.massapp.api.model.common.Contato;

public record ContatoResponseDTO(
    Long id,
    String nome,
    String email,
    String cargo,
    TelefoneResponseDTO telefone,
    EnderecoResponseDTO endereco
) {
    public static ContatoResponseDTO valueOf(Contato c){
        return new ContatoResponseDTO(c.getId(), c.getNome(), c.getEmail(),
         c.getCargo(), TelefoneResponseDTO.valueOf(c.getTelefone()), EnderecoResponseDTO.valueOf(c.getEndereco()));
    }
}
