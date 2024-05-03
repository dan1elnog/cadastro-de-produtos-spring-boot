package com.nogueira.springexpert.config.beans.usuario;

import com.nogueira.springexpert.core.dataprovider.usuario.CreateUsuario;
import com.nogueira.springexpert.core.usecase.impl.usuario.CreateUsuarioUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CreateUsuarioConfig {

   @Bean
   public CreateUsuarioUseCaseImpl createUsuarioUseCase(CreateUsuario createUsuario) {
      return new CreateUsuarioUseCaseImpl(createUsuario);
   }
}
