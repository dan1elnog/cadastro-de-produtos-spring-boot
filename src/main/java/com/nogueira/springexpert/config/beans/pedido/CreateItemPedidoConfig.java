package com.nogueira.springexpert.config.beans.pedido;

import com.nogueira.springexpert.core.dataprovider.pedido.CreateItemPedido;
import com.nogueira.springexpert.core.usecase.impl.pedido.CreateItemPedidoUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CreateItemPedidoConfig {

   @Bean
   public CreateItemPedidoUseCaseImpl createItemPedidoUseCase(CreateItemPedido createItemPedido) {
      return new CreateItemPedidoUseCaseImpl(createItemPedido);
   }
}
