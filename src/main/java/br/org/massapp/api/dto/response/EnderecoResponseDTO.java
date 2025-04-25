package br.org.massapp.api.dto.response;

import br.org.massapp.api.model.common.Endereco;

public record EnderecoResponseDTO(
    Long id,
    String cep,
    String logradouro,
    String numeroLote,
    String complemento,
    String bairro,
    String localidade,
    String UF   
) {
    public static EnderecoResponseDTO valueOf(Endereco end){
        return new EnderecoResponseDTO(end.getId(), 
                                       end.getCep(), 
                                       end.getLogradouro(), 
                                       end.getNumeroLote(),
                                       end.getComplemento(),
                                       end.getBairro(),
                                       end.getLocalidade(),
                                       end.getUF());
    }   
}
