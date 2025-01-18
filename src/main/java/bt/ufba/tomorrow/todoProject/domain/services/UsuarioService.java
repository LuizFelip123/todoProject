package bt.ufba.tomorrow.todoProject.domain.services;

import java.util.Optional;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import bt.ufba.tomorrow.todoProject.api.dto.UsuarioCreateDTO;
import bt.ufba.tomorrow.todoProject.api.dto.UsuarioDTO;
import bt.ufba.tomorrow.todoProject.domain.entities.Usuario;
import bt.ufba.tomorrow.todoProject.repository.UsuarioRepository;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;
    private final  PasswordEncoder passwordEncoder;

    public UsuarioService(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder){
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UsuarioDTO save(UsuarioCreateDTO dto)throws DataIntegrityViolationException{
        Optional<Usuario> usuario = this.usuarioRepository.findByEmail(dto.getEmail());
        if(usuario.isPresent()) throw new DataIntegrityViolationException("Já existe usuário cadastrado com este email!");
         Usuario newUsuario = new Usuario(dto);
         newUsuario.setSenha(passwordEncoder.encode(dto.getSenha()));
        return new UsuarioDTO(this.usuarioRepository.save(newUsuario));
    }

    
}
