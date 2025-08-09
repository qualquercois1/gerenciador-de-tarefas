package br.com.qualquercois1.backend.controller.dto;

import lombok.Data;

@Data
public class UsuarioResponseDTO {
    private Long id;
    private String nome;
    private String email;
    private String senha;
}
