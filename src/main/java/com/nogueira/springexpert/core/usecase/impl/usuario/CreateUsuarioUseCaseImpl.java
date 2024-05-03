package com.nogueira.springexpert.core.usecase.impl.usuario;

import com.nogueira.springexpert.core.dataprovider.usuario.CreateUsuario;
import com.nogueira.springexpert.core.domain.Usuario;
import com.nogueira.springexpert.core.usecase.usuario.CreateUsuarioUseCase;

public class CreateUsuarioUseCaseImpl implements CreateUsuarioUseCase {
   private final CreateUsuario createUsuario;

   public CreateUsuarioUseCaseImpl(CreateUsuario createUsuario) {
      this.createUsuario = createUsuario;
   }

   public void create(Usuario usuario) {
      this.createUsuario.create(usuario);
   }
}
