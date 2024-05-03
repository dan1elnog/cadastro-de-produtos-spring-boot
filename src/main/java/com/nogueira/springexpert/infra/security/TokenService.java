package com.nogueira.springexpert.infra.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.nogueira.springexpert.core.domain.Usuario;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import com.nogueira.springexpert.core.domain.Usuario;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class TokenService {

//   @Value("${api.security.token.secret}")
   private String secret;

   public String generateToken(Usuario usuario) {
      try {
         Algorithm algorithm = Algorithm.HMAC256(this.secret);

         return JWT.create()
                 .withIssuer("spring-expert-auth-api")
                 .withSubject(usuario.getLogin())
                 .withExpiresAt(generateExpirationDate())
                 .sign(algorithm);
      } catch (JWTCreationException var3) {
         throw new RuntimeException("ERRO NA GERACAO DO TOKEN", var3);
      }
   }

   public String validateToken(String token) {
      try {
         Algorithm algorithm = Algorithm.HMAC256(this.secret);
         return JWT.require(algorithm).withIssuer("spring-expert-auth-api").build().verify(token).getSubject();
      } catch (JWTVerificationException var3) {
         return "";
      }
   }

   private Instant generateExpirationDate() {
      return LocalDateTime.now().plusHours(2L).toInstant(ZoneOffset.of("-03:00"));
   }
}
