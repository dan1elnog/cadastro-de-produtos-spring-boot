package com.nogueira.springexpert.dataprovider.impl.usuario;

import com.nogueira.springexpert.core.dataprovider.usuario.CreateUsuario;
import com.nogueira.springexpert.core.domain.Usuario;
import com.nogueira.springexpert.dataprovider.repository.UsuarioRepository;
import com.nogueira.springexpert.util.exception.LoginJaCadastradoException;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CreateUsuarioImpl implements CreateUsuario {
   @Autowired
   private UsuarioRepository usuarioRepository;

   public void create(Usuario usuario) {
      UserDetails usuarioSalvo = this.usuarioRepository.findByLogin(usuario.getLogin());
      if (Objects.nonNull(usuarioSalvo)) {
         throw new LoginJaCadastradoException("O LOGIN INFORMADO NÂO ESTA DISPONIVEL");
      } else {
         usuario.setPassword((new BCryptPasswordEncoder()).encode(usuario.getPassword()));
         this.usuarioRepository.save(usuario);
      }
   }
}
