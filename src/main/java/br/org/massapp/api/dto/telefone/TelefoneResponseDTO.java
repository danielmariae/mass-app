package br.org.massapp.api.dto.telefone;

import br.org.massapp.api.model.common.Telefone;

public record TelefoneResponseDTO(
    Long id,
    int ddd,
    String numero
) {
    public static TelefoneResponseDTO valueOf(Telefone tel){
        return new TelefoneResponseDTO(tel.getId(), tel.getDdd(), tel.getNumero());
    }
}
