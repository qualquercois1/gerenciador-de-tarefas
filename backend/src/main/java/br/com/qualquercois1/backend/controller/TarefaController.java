package br.com.qualquercois1.backend.controller;

import br.com.qualquercois1.backend.controller.dto.TarefaDTO;
import br.com.qualquercois1.backend.service.TarefaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
    public List<TarefaDTO> getTarefas(){
        return tarefaService.getTarefas();
    }
}
