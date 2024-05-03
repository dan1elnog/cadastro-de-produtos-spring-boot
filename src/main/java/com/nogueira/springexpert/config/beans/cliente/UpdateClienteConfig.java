package com.nogueira.springexpert.config.beans.cliente;

import com.nogueira.springexpert.core.dataprovider.cliente.FindClienteById;
import com.nogueira.springexpert.core.dataprovider.cliente.UpdateCliente;
import com.nogueira.springexpert.core.usecase.impl.cliente.UpdateClienteUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UpdateClienteConfig {

   @Bean
   public UpdateClienteUseCaseImpl updateClienteByIdUseCase(FindClienteById findClienteById, UpdateCliente updateCliente) {
      return new UpdateClienteUseCaseImpl(findClienteById, updateCliente);
   }
}
