package br.com.qualquercois1.backend.service;

import br.com.qualquercois1.backend.controller.dto.UsuarioCreateDTO;
import br.com.qualquercois1.backend.controller.dto.UsuarioResponseDTO;
import br.com.qualquercois1.backend.model.Usuario;
import br.com.qualquercois1.backend.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<Usuario> getUsuarios() {
        return usuarioRepository.findAll();
    }

    public UsuarioResponseDTO saveUsuario(UsuarioCreateDTO usuarioCreateDTO) {
        Usuario usuario = toEntity(usuarioCreateDTO);
        Usuario usuarioRetorno = usuarioRepository.save(usuario);
        return toResponseDTO(usuarioRetorno);
    }

    private Usuario toEntity(UsuarioCreateDTO usuarioCreateDTO) {
        Usuario usuario = new Usuario();
        usuario.setNome(usuarioCreateDTO.getNome());
        usuario.setEmail(usuarioCreateDTO.getEmail());
        usuario.setSenha(usuarioCreateDTO.getSenha());
        return usuario;
    }

    private UsuarioResponseDTO toResponseDTO(Usuario usuario) {
        UsuarioResponseDTO usuarioResponseDTO = new UsuarioResponseDTO();
        usuarioResponseDTO.setId(usuario.getId());
        usuarioResponseDTO.setNome(usuario.getNome());
        usuarioResponseDTO.setEmail(usuario.getEmail());
        usuarioResponseDTO.setSenha(usuario.getSenha());
        return usuarioResponseDTO;
    }
}
