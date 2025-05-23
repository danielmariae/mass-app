package br.org.massapp.api.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.stream.Collectors;

import br.org.massapp.api.dto.usuario.UsuarioDTO;
import br.org.massapp.api.dto.usuario.UsuarioResponseDTO;
import br.org.massapp.api.model.common.Endereco;
import br.org.massapp.api.model.common.Telefone;
import br.org.massapp.api.model.usuario.Usuario;
import br.org.massapp.api.repository.UsuarioRepository;
import br.org.massapp.api.service.security.HashService;

import org.jboss.resteasy.reactive.multipart.FileUpload;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;

@ApplicationScoped
public class UsuarioService {
    
    @Inject
    UsuarioRepository userRepository;

    @Inject 
    HashService hashService;

    @Transactional
    public UsuarioResponseDTO create(UsuarioDTO dto){
        Usuario user = new Usuario();
        user.setNome(dto.nome());
        user.setEmail(dto.email());
        user.setSenha(hashService.getHashSenha(dto.senha()));
        user.setPertenca(dto.pertenca());

        Endereco end = new Endereco();
        end.setCep(dto.endereco().cep());
        end.setLogradouro(dto.endereco().logradouro());
        end.setNumeroLote(dto.endereco().numeroLote());
        end.setComplemento(dto.endereco().complemento());
        end.setBairro(dto.endereco().bairro());
        end.setLocalidade(dto.endereco().localidade());
        end.setUF(dto.endereco().UF());

        Telefone tel = new Telefone();
        tel.setDdd(dto.telefone().ddd());
        tel.setNumero(dto.telefone().numero());

        user.setEndereco(end);
        user.setTelefone(tel);
        userRepository.persist(user);
        return UsuarioResponseDTO.valueOf(user);
    }

    @Transactional
    public UsuarioResponseDTO update(Long id, UsuarioDTO dto) {
        Usuario user = userRepository.findById(id);
        if (user == null) {
            throw new NotFoundException("Usuário não encontrado");
        }

        // Atualiza dados básicos
        user.setNome(dto.nome());
        user.setEmail(dto.email());
        if (dto.senha() != null && !dto.senha().isEmpty()) {
            user.setSenha(hashService.getHashSenha(dto.senha()));
        }
        user.setPertenca(dto.pertenca());

        // Atualiza endereço
        Endereco end = user.getEndereco();
        end.setCep(dto.endereco().cep());
        end.setLogradouro(dto.endereco().logradouro());
        end.setNumeroLote(dto.endereco().numeroLote());
        end.setComplemento(dto.endereco().complemento());
        end.setBairro(dto.endereco().bairro());
        end.setLocalidade(dto.endereco().localidade());
        end.setUF(dto.endereco().UF());

        // Atualiza telefone
        Telefone tel = user.getTelefone();
        tel.setDdd(dto.telefone().ddd());
        tel.setNumero(dto.telefone().numero());

        return UsuarioResponseDTO.valueOf(user);
    }

    @Transactional
    public void delete(Long id) {
        Usuario user = userRepository.findById(id);
        if (user == null) {
            throw new NotFoundException("Usuário não encontrado");
        }
        
        userRepository.delete(user);
        
        // Opcional: Limpar entidades relacionadas
        // Panache. ("endereco_id = ?1", end.getId());
        // Panache.delete("telefone_id = ?1", tel.getId());
    }
    
    public List<UsuarioResponseDTO> getAllUsers(){
        List<Usuario> users = userRepository.listAll();
        return users.stream()
                    .map(UsuarioResponseDTO::valueOf)
                    .collect(Collectors.toList());
    }
    
    public UsuarioResponseDTO getUsuarioById(Long id){
        Usuario user = userRepository.findById(id);

        if(user == null){
            throw new NotFoundException("Usuário não encontrado.");
        }

        return UsuarioResponseDTO.valueOf(user);
    }

    @Transactional
    public String salvarImagem(Long userId, FileUpload imagem) throws IOException{
        Usuario usuario = userRepository.findById(userId);
        if (usuario == null){
            throw new NotFoundException("Usuário não encontrado!");
        }

        String nomeArquivo = userId + "_" + imagem.fileName();
        String caminhoImagem = "uploads/users/" + nomeArquivo;
        
        Files.createDirectories(Paths.get("uploads/users"));
        Files.copy(imagem.uploadedFile(), Paths.get(caminhoImagem), StandardCopyOption.REPLACE_EXISTING);

        usuario.setFotoPerfilPath(caminhoImagem);
        return caminhoImagem;
    }
    
    public File obterArquivoImagem(Long usuarioId) {
        Usuario usuario = userRepository.findById(usuarioId);
        if (usuario == null || usuario.getFotoPerfilPath() == null) {
            return null;
        }

        Path caminhoImagem = Paths.get(usuario.getFotoPerfilPath());
        return caminhoImagem.toFile();
    }
}

