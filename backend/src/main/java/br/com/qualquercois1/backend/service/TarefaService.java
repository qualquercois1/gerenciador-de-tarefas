package br.com.qualquercois1.backend.service;

import br.com.qualquercois1.backend.controller.dto.TarefaDTO;
import br.com.qualquercois1.backend.controller.dto.UsuarioDTO;
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

    public List<TarefaDTO> getTarefas(){
        List<Tarefa> tarefas = tarefaRepository.findAll();

        return tarefas.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    private TarefaDTO convertToDTO(Tarefa tarefa){
        Usuario usuario = tarefa.getUsuario();
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setId(usuario.getId());
        usuarioDTO.setNome(usuario.getNome());
        usuarioDTO.setEmail(usuario.getEmail());
        usuarioDTO.setSenha(usuario.getSenha());

        TarefaDTO dto = new TarefaDTO();
        dto.setId(tarefa.getId());
        dto.setTitulo(tarefa.getTitulo());
        dto.setDescricao(tarefa.getDescricao());
        dto.setData_criacao(tarefa.getData_criacao());
        dto.setData_conclusao(tarefa.getData_conclusao());
        dto.setStatus(tarefa.getStatus());
        dto.setUsuario(usuarioDTO);
        return dto;
    }
}
