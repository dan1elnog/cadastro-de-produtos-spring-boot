package com.nogueira.springexpert.config.beans.cliente;

import com.nogueira.springexpert.core.dataprovider.cliente.DeleteClienteById;
import com.nogueira.springexpert.core.dataprovider.cliente.FindClienteById;
import com.nogueira.springexpert.core.usecase.impl.cliente.DeleteClienteByIdUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeleteClienteByIdConfig {

   @Bean
   public DeleteClienteByIdUseCaseImpl deleteClienteByIdUseCase(DeleteClienteById deleteClienteById, FindClienteById findClienteById) {
      return new DeleteClienteByIdUseCaseImpl(deleteClienteById, findClienteById);
   }
}
