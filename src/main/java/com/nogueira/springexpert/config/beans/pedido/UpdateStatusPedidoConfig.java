package com.nogueira.springexpert.config.beans.pedido;

import com.nogueira.springexpert.core.dataprovider.pedido.FindPedidoById;
import com.nogueira.springexpert.core.dataprovider.pedido.UpdateStatusPedido;
import com.nogueira.springexpert.core.usecase.impl.pedido.UpdateStatusPedidoUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UpdateStatusPedidoConfig {

   @Bean
   public UpdateStatusPedidoUseCaseImpl updateStatusPedidoUseCase(FindPedidoById findPedidoById, UpdateStatusPedido updateStatusPedido) {
      return new UpdateStatusPedidoUseCaseImpl(findPedidoById, updateStatusPedido);
   }
}
