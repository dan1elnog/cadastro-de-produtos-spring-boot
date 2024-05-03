package com.nogueira.springexpert.core.dataprovider.pedido;

import com.nogueira.springexpert.core.domain.ItemPedido;
import java.util.List;

public interface CreateItemPedido {
   void create(List<ItemPedido> itemPedidoList);
}
