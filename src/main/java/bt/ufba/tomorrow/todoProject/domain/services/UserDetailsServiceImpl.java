package bt.ufba.tomorrow.todoProject.domain.services;

import java.util.Optional;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import bt.ufba.tomorrow.todoProject.domain.entities.Usuario;
import bt.ufba.tomorrow.todoProject.repository.UsuarioRepository;
@Service
public class UserDetailsServiceImpl implements  UserDetailsService{
    private final UsuarioRepository usuarioRepository;

    public UserDetailsServiceImpl(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        // TODO Auto-generated method stub
       Optional<Usuario> currentUser = usuarioRepository.findByEmail(email);
        if(currentUser.isPresent()){
            UserDetails user = new User(email, currentUser.get().getSenha(), true, true, true, true, AuthorityUtils.createAuthorityList("USER"));
            return user;
        }
        throw new UsernameNotFoundException("Senha e/ou email inválidos!");
    }


}
