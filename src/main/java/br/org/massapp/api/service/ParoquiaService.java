package br.org.massapp.api.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.org.massapp.api.dto.contato.ContatoDTO;
import br.org.massapp.api.dto.endereco.EnderecoDTO;
import br.org.massapp.api.dto.horariofuncionamento.HorarioFuncionamentoDTO;
import br.org.massapp.api.dto.paroquia.ParoquiaDTO;
import br.org.massapp.api.dto.paroquia.ParoquiaResponseDTO;
import br.org.massapp.api.dto.telefone.TelefoneDTO;
import br.org.massapp.api.model.common.Contato;
import br.org.massapp.api.model.common.Endereco;
import br.org.massapp.api.model.common.HorarioFuncionamento;
import br.org.massapp.api.model.common.Telefone;
import br.org.massapp.api.model.enums.DiaDaSemana;
import br.org.massapp.api.model.paroquia.Paroquia;
import br.org.massapp.api.repository.ParoquiaRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;

@ApplicationScoped
public class ParoquiaService {
    @Inject
    ParoquiaRepository repository;

    @Transactional
    public ParoquiaResponseDTO create(ParoquiaDTO dto){
        Paroquia paroquia = new Paroquia();
        paroquia.setNome(dto.nome());
        paroquia.setDescricao(dto.descricao());
        paroquia.setLinkFacebook(dto.linkFacebook());
        paroquia.setLinkInstagram(dto.linkInstagram());
        paroquia.setLinkYoutube(dto.linkYoutube());
        paroquia.setHorariosFuncionamento(mockHorarios(dto.horarioFuncionamento()));
        paroquia.setResponsavel(mockResponsavel(dto.responsavel()));
        paroquia.setEndereco(mockEndereco(dto.endereco()));
        paroquia.setTelefone(mockTelefone(dto.telefone()));
        
        repository.persist(paroquia);
        return ParoquiaResponseDTO.valueOf(paroquia);
    }

    @Transactional
    public ParoquiaResponseDTO update(Long id, ParoquiaDTO dto){
        Paroquia paroquia = repository.findById(id);

        if (paroquia == null) {
            throw new NotFoundException("Paróquia não encontrada");
        }
        
        paroquia.setNome(dto.nome());
        paroquia.setDescricao(dto.descricao());
        paroquia.setLinkFacebook(dto.linkFacebook());
        paroquia.setLinkInstagram(dto.linkInstagram());
        paroquia.setLinkYoutube(dto.linkYoutube());

        atualizarHorarios(paroquia, dto.horarioFuncionamento());        
        paroquia.setEndereco(mockEndereco(dto.endereco()));
        paroquia.setTelefone(mockTelefone(dto.telefone()));

        return ParoquiaResponseDTO.valueOf(paroquia);
    }

    @Transactional
    public void delete(Long id){
        Paroquia paroquia = repository.findById(id);
        if (paroquia == null) {
            throw new NotFoundException("Paróquia não encontrada");
        }
        
        repository.delete(paroquia);
    }

    public List<ParoquiaResponseDTO> getAllUsers(){
        List<Paroquia> paroquias = repository.listAll();
        return paroquias.stream()
                    .map(ParoquiaResponseDTO::valueOf)
                    .collect(Collectors.toList());
    }
    
    public ParoquiaResponseDTO getUsuarioById(Long id){
        Paroquia paroquia = repository.findById(id);
        if(paroquia == null){
            throw new NotFoundException("Paróquia não encontrada.");
        }

        return ParoquiaResponseDTO.valueOf(paroquia);
    }


    private Endereco mockEndereco(EnderecoDTO dto){
        Endereco endereco = new Endereco();
        endereco.setCep(dto.cep());
        endereco.setLogradouro(dto.logradouro());
        endereco.setNumeroLote(dto.numeroLote());
        endereco.setComplemento(dto.complemento());
        endereco.setBairro(dto.bairro());
        endereco.setLocalidade(dto.localidade());
        endereco.setUF(dto.UF());
        
        return endereco;
    }

    private Telefone mockTelefone(TelefoneDTO dto){
        Telefone tel = new Telefone();
        tel.setDdd(dto.ddd());
        tel.setNumero(dto.numero());

        return tel;
    }

    private Contato mockResponsavel(ContatoDTO dto){
        Contato contato = new Contato();
        contato.setNome(dto.nome());
        contato.setEmail(dto.email());
        contato.setCargo(dto.cargo());
        contato.setTelefone(mockTelefone(dto.telefone()));
        contato.setEndereco(mockEndereco(dto.endereco()));
        return contato;
    }

    private List<HorarioFuncionamento> mockHorarios(List<HorarioFuncionamentoDTO> horarios){
        List<HorarioFuncionamento> horariosFuncionamento = new ArrayList<>();
        for (HorarioFuncionamentoDTO horarioDTO : horarios) {
            HorarioFuncionamento horario = new HorarioFuncionamento();
            horario.setDiaDaSemana(DiaDaSemana.valueOf(horarioDTO.diaDaSemana().enumName()));
            horario.setHorarioAbertura(horarioDTO.horarioAbertura());
            horario.setHorarioFechamento(horarioDTO.horarioFechamento());
            horariosFuncionamento.add(horario);
        }
        return horariosFuncionamento;
    }

    private void atualizarHorarios(Paroquia paroquia, List<HorarioFuncionamentoDTO> horariosDTO) {
        if (horariosDTO == null || horariosDTO.isEmpty()) {
            return; // Não faz nada se a lista for nula ou vazia
        }
    
        // Limpa os horários existentes (ou mantém se for null)
        if (paroquia.getHorariosFuncionamento() != null) {
            paroquia.getHorariosFuncionamento().clear();
        } else {
            paroquia.setHorariosFuncionamento(new ArrayList<>());
        }
    
        // Converte e adiciona os novos horários
        horariosDTO.stream()
            .map(this::convertToHorarioFuncionamento)
            .forEach(paroquia.getHorariosFuncionamento()::add);
    }
    
    private HorarioFuncionamento convertToHorarioFuncionamento(HorarioFuncionamentoDTO dto) {
        HorarioFuncionamento horario = new HorarioFuncionamento();
        horario.setDiaDaSemana(DiaDaSemana.valueOf(dto.diaDaSemana().enumName()));
        horario.setHorarioAbertura(dto.horarioAbertura());
        horario.setHorarioFechamento(dto.horarioFechamento());
        return horario;
    }
}
