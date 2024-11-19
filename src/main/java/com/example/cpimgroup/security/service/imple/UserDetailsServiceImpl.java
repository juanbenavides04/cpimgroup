package com.example.cpimgroup.security.service.imple;

import com.example.cpimgroup.entities.Usuario;
import com.example.cpimgroup.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service("userDetailService")
@Transactional(readOnly=true)
public class UserDetailsServiceImpl implements UserDetailsService {


    
    @Autowired
    private UsuarioRepository usuarioRepository;
    
    // valida que el usuario exista y retorna el mail, password y roles.
    @Override
    @Transactional(readOnly=true)
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Usuario user = usuarioRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado!"));
        ArrayList<GrantedAuthority> roles = new ArrayList<>();
      /*  for (Rol rol : user.getRoles()) {
            roles.add(new SimpleGrantedAuthority(rol.getName()));
        }*/
        return new User(user.getEmail() , user.getPassword(), roles);
    }
}
