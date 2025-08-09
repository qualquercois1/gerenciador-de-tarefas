package br.com.qualquercois1.backend.service;

import br.com.qualquercois1.backend.controller.dto.TarefaResponseDTO;
import br.com.qualquercois1.backend.controller.dto.UsuarioResponseDTO;
import br.com.qualquercois1.backend.model.Tarefa;
import br.com.qualquercois1.backend.model.Usuario;
import br.com.qualquercois1.backend.repository.TarefaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TarefaService {

    private final TarefaRepository tarefaRepository;

    public TarefaService(TarefaRepository tarefaRepository) {
        this.tarefaRepository = tarefaRepository;
    }

    public List<TarefaResponseDTO> getTarefas(){
        List<Tarefa> tarefas = tarefaRepository.findAll();

        return tarefas.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    private TarefaResponseDTO convertToDTO(Tarefa tarefa){
        Usuario usuario = tarefa.getUsuario();
        UsuarioResponseDTO usuarioResponseDTO = new UsuarioResponseDTO();
        usuarioResponseDTO.setId(usuario.getId());
        usuarioResponseDTO.setNome(usuario.getNome());
        usuarioResponseDTO.setEmail(usuario.getEmail());
        usuarioResponseDTO.setSenha(usuario.getSenha());

        TarefaResponseDTO dto = new TarefaResponseDTO();
        dto.setId(tarefa.getId());
        dto.setTitulo(tarefa.getTitulo());
        dto.setDescricao(tarefa.getDescricao());
        dto.setData_criacao(tarefa.getData_criacao());
        dto.setData_conclusao(tarefa.getData_conclusao());
        dto.setStatus(tarefa.getStatus());
        dto.setUsuario(usuarioResponseDTO);
        return dto;
    }
}
