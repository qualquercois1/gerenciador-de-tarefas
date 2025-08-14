package br.com.qualquercois1.backend.controller.dto;

import lombok.Data;

@Data
public class TarefaCreateDTO {
    private String titulo;
    private String descricao;
    private Long usuario_id;
}
