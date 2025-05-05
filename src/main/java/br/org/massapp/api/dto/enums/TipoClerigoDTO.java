package br.org.massapp.api.dto.enums;

import br.org.massapp.api.model.enums.TipoClerigo;

public record TipoClerigoDTO(
    String enumName,    
    Integer id,
    String nome) 
{
    public static TipoClerigoDTO valueOf(TipoClerigo c){
        return new TipoClerigoDTO(c.toString(), c.getId(), c.getNome());
    } 
}
