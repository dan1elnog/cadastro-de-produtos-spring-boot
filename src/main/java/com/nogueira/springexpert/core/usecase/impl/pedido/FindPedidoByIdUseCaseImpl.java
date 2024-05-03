package com.nogueira.springexpert.core.usecase.impl.pedido;

import com.nogueira.springexpert.core.dataprovider.pedido.FindPedidoById;
import com.nogueira.springexpert.core.domain.Pedido;
import com.nogueira.springexpert.core.usecase.pedido.FindPedidoByIdUseCase;

public class FindPedidoByIdUseCaseImpl implements FindPedidoByIdUseCase {
   private final FindPedidoById findInformacoesPedidoById;

   public FindPedidoByIdUseCaseImpl(FindPedidoById findInformacoesPedidoById) {
      this.findInformacoesPedidoById = findInformacoesPedidoById;
   }

   public Pedido find(Integer id) {
      return this.findInformacoesPedidoById.find(id);
   }
}
