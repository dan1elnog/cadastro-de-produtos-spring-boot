package com.nogueira.springexpert.infra.security;

import com.nogueira.springexpert.dataprovider.repository.UsuarioRepository;
import com.nogueira.springexpert.dataprovider.repository.UsuarioRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
public class SecurityFilter extends OncePerRequestFilter {
   @Autowired
   private TokenService tokenService;
   @Autowired
   private UsuarioRepository usuarioRepository;

   protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

      String token = recoverToken(request);

      if (Objects.nonNull(token)) {
         String login = this.tokenService.validateToken(token);
         UserDetails user = this.usuarioRepository.findByLogin(login);
         UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                 new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());

         SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
      }

      filterChain.doFilter(request, response);
   }

   private String recoverToken(HttpServletRequest request) {
      String authHeader = request.getHeader("Authorization");
      return Objects.isNull(authHeader) ? null : authHeader.replace("Bearer ", "");
   }
}
