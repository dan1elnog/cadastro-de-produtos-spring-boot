package com.nogueira.springexpert.config.beans.pedido;

import com.nogueira.springexpert.core.dataprovider.cliente.FindClienteById;
import com.nogueira.springexpert.core.dataprovider.pedido.CreateItemPedido;
import com.nogueira.springexpert.core.dataprovider.pedido.CreatePedido;
import com.nogueira.springexpert.core.dataprovider.produto.FindProdutosByIdIn;
import com.nogueira.springexpert.core.usecase.impl.pedido.CreatePedidoUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CreatePedidoConfig {

   @Bean
   public CreatePedidoUseCaseImpl createPedidoUseCase(CreatePedido createPedido, FindClienteById findClienteById, FindProdutosByIdIn findProdutosByIdIn, CreateItemPedido createItemPedido) {
      return new CreatePedidoUseCaseImpl(createPedido, findClienteById, findProdutosByIdIn, createItemPedido);
   }
}
