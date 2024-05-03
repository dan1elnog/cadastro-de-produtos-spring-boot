package com.nogueira.springexpert.config.beans.cliente;

import com.nogueira.springexpert.core.dataprovider.cliente.FindClientes;
import com.nogueira.springexpert.core.usecase.impl.cliente.FindClientesUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindClientesConfig {

   @Bean
   public FindClientesUseCaseImpl findClientesUseCase(FindClientes findClientes) {
      return new FindClientesUseCaseImpl(findClientes);
   }
}
