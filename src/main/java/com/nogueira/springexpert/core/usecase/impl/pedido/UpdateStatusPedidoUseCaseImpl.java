package com.nogueira.springexpert.core.usecase.impl.pedido;

import com.nogueira.springexpert.core.dataprovider.pedido.FindPedidoById;
import com.nogueira.springexpert.core.dataprovider.pedido.UpdateStatusPedido;
import com.nogueira.springexpert.core.domain.Pedido;
import com.nogueira.springexpert.core.enums.StatusPedido;
import com.nogueira.springexpert.core.usecase.pedido.UpdateStatusPedidoUseCase;

public class UpdateStatusPedidoUseCaseImpl implements UpdateStatusPedidoUseCase {
   private final FindPedidoById findPedidoById;
   private final UpdateStatusPedido updateStatusPedido;

   public UpdateStatusPedidoUseCaseImpl(FindPedidoById findPedidoById, UpdateStatusPedido updateStatusPedido) {
      this.findPedidoById = findPedidoById;
      this.updateStatusPedido = updateStatusPedido;
   }

   public void update(Integer id, StatusPedido statusPedido) {
      Pedido pedido = this.findPedidoById.find(id);
      pedido.setStatusPedido(statusPedido);
      this.updateStatusPedido.update(pedido);
   }
}
