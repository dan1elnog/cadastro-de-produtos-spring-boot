package com.nogueira.springexpert.core.usecase.impl.pedido;

import com.nogueira.springexpert.core.dataprovider.pedido.CreateItemPedido;
import com.nogueira.springexpert.core.domain.ItemPedido;
import com.nogueira.springexpert.core.usecase.pedido.CreateItemPedidoUseCase;
import java.util.List;

public class CreateItemPedidoUseCaseImpl implements CreateItemPedidoUseCase {
   private final CreateItemPedido createItemPedido;

   public CreateItemPedidoUseCaseImpl(CreateItemPedido createItemPedido) {
      this.createItemPedido = createItemPedido;
   }

   public void create(List<ItemPedido> itemPedidoList) {
      this.createItemPedido.create(itemPedidoList);
   }
}
