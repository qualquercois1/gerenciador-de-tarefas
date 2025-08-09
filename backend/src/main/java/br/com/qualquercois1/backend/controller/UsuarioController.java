package br.com.qualquercois1.backend.controller;

import java.util.List;

import br.com.qualquercois1.backend.controller.dto.UsuarioCreateDTO;
import br.com.qualquercois1.backend.controller.dto.UsuarioResponseDTO;
import br.com.qualquercois1.backend.model.Usuario;
import br.com.qualquercois1.backend.service.UsuarioService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public List<Usuario> getUsuarios() {
        return usuarioService.getUsuarios();
    }

    @PostMapping
    public UsuarioResponseDTO saveUsuario(@RequestBody UsuarioCreateDTO usuarioCreateDTO) {
        return usuarioService.saveUsuario(usuarioCreateDTO);
    }
}
