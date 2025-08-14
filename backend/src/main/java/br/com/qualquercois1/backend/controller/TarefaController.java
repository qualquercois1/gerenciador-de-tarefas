package br.com.qualquercois1.backend.controller;

import br.com.qualquercois1.backend.controller.dto.TarefaBuscarTituloDTO;
import br.com.qualquercois1.backend.controller.dto.TarefaCreateDTO;
import br.com.qualquercois1.backend.controller.dto.TarefaResponseDTO;
import br.com.qualquercois1.backend.model.Tarefa;
import br.com.qualquercois1.backend.service.TarefaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tarefa")
public class TarefaController {

    private final TarefaService tarefaService;

    public TarefaController(TarefaService tarefaService) {
        this.tarefaService = tarefaService;
    }

    @GetMapping
    public List<TarefaResponseDTO> getTarefas(){
        return tarefaService.getTarefas();
    }

    @GetMapping("/buscar")
    public List<TarefaResponseDTO> buscarPorTitulo(@RequestParam("titulo") String titulo, @RequestParam("usuarioId") Long usuarioId) {
        TarefaBuscarTituloDTO tarefaBuscarTituloDTO = new TarefaBuscarTituloDTO();
        tarefaBuscarTituloDTO.setTitulo(titulo);
        tarefaBuscarTituloDTO.setUsuario_id(usuarioId);
        return tarefaService.buscarPorTitulo(tarefaBuscarTituloDTO);
    }

    @PostMapping
    public TarefaResponseDTO saveTarefa(@RequestBody TarefaCreateDTO tarefaCreateDTO) {
        return tarefaService.saveTarefa(tarefaCreateDTO);
    }
}
