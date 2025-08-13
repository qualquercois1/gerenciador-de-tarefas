package br.com.qualquercois1.backend.service;

import br.com.qualquercois1.backend.controller.dto.UsuarioCreateDTO;
import br.com.qualquercois1.backend.controller.dto.UsuarioResponseDTO;
import br.com.qualquercois1.backend.controller.dto.UsuarioUpdateDTO;
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

    public boolean deleteUsuario(Long id) {
        if(usuarioRepository.existsById(id)){
            usuarioRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public UsuarioResponseDTO updateUsuario(UsuarioUpdateDTO usuarioUpdateDTO) {
        Usuario usuarioExistente = usuarioRepository.findById(usuarioUpdateDTO.getId()).orElseThrow(() -> new RuntimeException("Usuário não encontrado para update."));
    
        if (usuarioUpdateDTO.getNome() != null) {
            usuarioExistente.setNome(usuarioUpdateDTO.getNome());
        }
        if (usuarioUpdateDTO.getEmail() != null) {
            usuarioExistente.setEmail(usuarioUpdateDTO.getEmail());
        }
        if (usuarioUpdateDTO.getSenha() != null) {
            usuarioExistente.setSenha(usuarioUpdateDTO.getSenha());
        }
        Usuario usuarioRetorno = usuarioRepository.save(usuarioExistente);
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
