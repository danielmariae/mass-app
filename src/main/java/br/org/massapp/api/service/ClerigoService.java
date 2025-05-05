package br.org.massapp.api.service;

import java.util.List;
import java.util.stream.Collectors;


import br.org.massapp.api.dto.request.ClerigoDTO;
import br.org.massapp.api.dto.response.ClerigoResponseDTO;
import br.org.massapp.api.model.Clerigo;
import br.org.massapp.api.model.common.Endereco;
import br.org.massapp.api.model.common.Telefone;
import br.org.massapp.api.model.enums.TipoClerigo;
import br.org.massapp.api.repository.ClerigoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;

@ApplicationScoped
public class ClerigoService {
    
    @Inject
    ClerigoRepository repository;
    
    @Transactional
    public ClerigoResponseDTO create(ClerigoDTO dto){
        Clerigo clerigo = new Clerigo();
        clerigo.setNome(dto.nome());
        clerigo.setEmail(dto.email());
        clerigo.setTipoClerigo(TipoClerigo.valueOf(dto.tipoClerigo().enumName()));
        clerigo.setOrdemCarisma(dto.ordemCarisma());

        Telefone tel = new Telefone();
        tel.setDdd(dto.telefone().ddd());
        tel.setNumero(dto.telefone().numero());
        
        Endereco end = new Endereco();
        end.setCep(dto.endereco().cep());
        end.setLogradouro(dto.endereco().logradouro());
        end.setNumeroLote(dto.endereco().numeroLote());
        end.setComplemento(dto.endereco().complemento());
        end.setBairro(dto.endereco().bairro());
        end.setLocalidade(dto.endereco().localidade());
        end.setUF(dto.endereco().UF());
        
        clerigo.setTelefone(tel);
        clerigo.setEndereco(end);
        repository.persist(clerigo);
        return ClerigoResponseDTO.valueOf(clerigo);
    }
    
    @Transactional
    public ClerigoResponseDTO update(Long id, ClerigoDTO dto){
        Clerigo clerigo = repository.findById(id);
        
        clerigo.setNome(dto.nome());
        clerigo.setEmail(dto.email());
        clerigo.setTipoClerigo(TipoClerigo.valueOf(dto.tipoClerigo().enumName()));
        clerigo.setOrdemCarisma(dto.ordemCarisma());

        Telefone tel = clerigo.getTelefone();
        tel.setDdd(dto.telefone().ddd());
        tel.setNumero(dto.telefone().numero());

        Endereco end = clerigo.getEndereco();
        end.setCep(dto.endereco().cep());
        end.setLogradouro(dto.endereco().logradouro());
        end.setNumeroLote(dto.endereco().numeroLote());
        end.setComplemento(dto.endereco().complemento());
        end.setBairro(dto.endereco().bairro());
        end.setLocalidade(dto.endereco().localidade());
        end.setUF(dto.endereco().UF());

        return ClerigoResponseDTO.valueOf(clerigo);
    }

    @Transactional
    public void delete(Long id){
        Clerigo clerigo = repository.findById(id);
        if (clerigo == null) {
            throw new NotFoundException("Clérigo não encontrado");
        }

        repository.delete(clerigo);
    }

    public List<ClerigoResponseDTO> getAllUsers(){
        List<Clerigo> clerigos = repository.listAll();
        return clerigos.stream()
                    .map(ClerigoResponseDTO::valueOf)
                    .collect(Collectors.toList());
    }
    
    public ClerigoResponseDTO getUsuarioById(Long id){
        Clerigo clerigo = repository.findById(id);

        if(clerigo == null){
            throw new NotFoundException("Usuário não encontrado.");
        }

        return ClerigoResponseDTO.valueOf(clerigo);
    }
}
