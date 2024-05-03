package com.nogueira.springexpert.core.usecase.pedido;

import com.nogueira.springexpert.core.domain.ItemPedido;
import java.util.List;

public interface CreateItemPedidoUseCase {
   void create(List<ItemPedido> itemPedidoList);
}
