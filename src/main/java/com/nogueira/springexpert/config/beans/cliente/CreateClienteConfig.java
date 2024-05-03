package com.nogueira.springexpert.config.beans.cliente;

import com.nogueira.springexpert.core.dataprovider.cliente.CreateCliente;
import com.nogueira.springexpert.core.usecase.impl.cliente.CreateClienteUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CreateClienteConfig {

   @Bean
   public CreateClienteUseCaseImpl createClienteUseCase(CreateCliente createCliente) {
      return new CreateClienteUseCaseImpl(createCliente);
   }
}
