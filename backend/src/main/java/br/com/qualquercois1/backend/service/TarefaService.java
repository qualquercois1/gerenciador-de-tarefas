package br.com.qualquercois1.backend.service;

import br.com.qualquercois1.backend.controller.dto.TarefaBuscarTituloDTO;
import br.com.qualquercois1.backend.controller.dto.TarefaCreateDTO;
import br.com.qualquercois1.backend.controller.dto.TarefaResponseDTO;
import br.com.qualquercois1.backend.controller.dto.UsuarioResponseDTO;
import br.com.qualquercois1.backend.model.Tarefa;
import br.com.qualquercois1.backend.model.Usuario;
import br.com.qualquercois1.backend.model.enums.StatusTarefa;
import br.com.qualquercois1.backend.repository.TarefaRepository;
import br.com.qualquercois1.backend.repository.UsuarioRepository;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TarefaService {

    private final TarefaRepository tarefaRepository;
    private final UsuarioRepository usuarioRepository;

    public TarefaService(TarefaRepository tarefaRepository, UsuarioRepository usuarioRepository) {
        this.tarefaRepository = tarefaRepository;
        this.usuarioRepository = usuarioRepository;
    }

    public List<TarefaResponseDTO> getTarefas(){
        List<Tarefa> tarefas = tarefaRepository.findAll();

        return tarefas.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public List<TarefaResponseDTO> buscarPorTitulo(TarefaBuscarTituloDTO tarefaBuscarTituloDTO) {
        List<Tarefa> tarefas = tarefaRepository.findByTituloContainingIgnoreCaseAndUsuarioId(tarefaBuscarTituloDTO.getTitulo(), tarefaBuscarTituloDTO.getUsuario_id());
        List<TarefaResponseDTO> tarefasResponseDTO = new ArrayList<>();
        for(Tarefa tarefa : tarefas) {
            tarefasResponseDTO.add(convertToDTO(tarefa));
        }
        return tarefasResponseDTO;
    }

    public TarefaResponseDTO saveTarefa(TarefaCreateDTO tarefaCreateDTO) {
        Tarefa tarefa = convertToEntity(tarefaCreateDTO);

        tarefa.setData_criacao(LocalDateTime.now());
        tarefa.setData_conclusao(null);
        tarefa.setStatus(StatusTarefa.PENDENTE);

        tarefaRepository.save(tarefa);
        return convertToDTO(tarefa);
    }

    private Tarefa convertToEntity(TarefaCreateDTO tarefaCreateDTO) {
        Usuario usuario = usuarioRepository.findById(tarefaCreateDTO.getUsuario_id()).orElseThrow(() -> new RuntimeException("Usuario não encontrado."));
        Tarefa tarefa = new Tarefa();

        tarefa.setTitulo(tarefaCreateDTO.getTitulo());
        tarefa.setDescricao(tarefaCreateDTO.getDescricao());
        tarefa.setUsuario(usuario);

        return tarefa;
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
