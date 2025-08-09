package br.com.qualquercois1.backend.controller.dto;

import lombok.Data;

@Data
public class UsuarioCreateDTO {
    private String nome;
    private String email;
    private String senha;
}
