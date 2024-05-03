package com.nogueira.springexpert.config.beans.cliente;

import com.nogueira.springexpert.core.dataprovider.cliente.FindClienteById;
import com.nogueira.springexpert.core.usecase.impl.cliente.FindClienteByIdUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindClienteByIdConfig {
   @Bean
   public FindClienteByIdUseCaseImpl findClienteByIdUseCase(FindClienteById findClienteById) {
      return new FindClienteByIdUseCaseImpl(findClienteById);
   }
}
