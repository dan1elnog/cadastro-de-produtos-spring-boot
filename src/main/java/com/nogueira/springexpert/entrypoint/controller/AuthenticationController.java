package com.nogueira.springexpert.entrypoint.controller;

import com.nogueira.springexpert.core.domain.Usuario;
import com.nogueira.springexpert.core.usecase.usuario.CreateUsuarioUseCase;
import com.nogueira.springexpert.entrypoint.controller.request.AuthenticationRequest;
import com.nogueira.springexpert.infra.security.TokenService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/authentication")
@Tag(name = "Authentication", description = "Authentication Controller")
public class AuthenticationController {

   @Autowired
   private AuthenticationManager authenticationManager;

   @Autowired
   private CreateUsuarioUseCase createUsuarioUseCase;

   @Autowired
   private TokenService tokenService;

   @PostMapping(path = "/login")
   @Operation(summary = "Requisição POST para loggar na aplicação")
   public ResponseEntity<String> login(@RequestBody @Valid AuthenticationRequest request) {
      UsernamePasswordAuthenticationToken usernamePassword = new UsernamePasswordAuthenticationToken(request.getLogin(), request.getPassword());
      Authentication authenticate = this.authenticationManager.authenticate(usernamePassword);
      return ResponseEntity.ok(this.tokenService.generateToken((Usuario) authenticate.getPrincipal()));
   }

   @PostMapping(path = "/criar-usuario")
   @Operation(summary = "Requisição POST para criar um usuário")
   public ResponseEntity<Void> createUsuarior(@RequestBody Usuario usuarioRequest) {
      this.createUsuarioUseCase.create(usuarioRequest);
      return ResponseEntity.ok().build();
   }
}
