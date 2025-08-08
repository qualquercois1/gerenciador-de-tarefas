package br.com.qualquercois1.backend.controller.dto;

import br.com.qualquercois1.backend.model.enums.StatusTarefa;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TarefaDTO {
    private Long id;
    private String titulo;
    private String descricao;
    private LocalDateTime data_criacao;
    private LocalDateTime data_conclusao;
    private StatusTarefa status;
    private UsuarioDTO usuario;
}
