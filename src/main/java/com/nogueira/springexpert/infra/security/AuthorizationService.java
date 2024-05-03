package com.nogueira.springexpert.infra.security;

import com.nogueira.springexpert.dataprovider.repository.UsuarioRepository;
import com.nogueira.springexpert.dataprovider.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthorizationService implements UserDetailsService {

   @Autowired
   private UsuarioRepository usuarioRepository;

   public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
      return this.usuarioRepository.findByLogin(username);
   }
}
