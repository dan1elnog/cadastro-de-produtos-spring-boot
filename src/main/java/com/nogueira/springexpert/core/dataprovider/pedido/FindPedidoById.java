package com.nogueira.springexpert.core.dataprovider.pedido;

import com.nogueira.springexpert.core.domain.Pedido;

public interface FindPedidoById {
   Pedido find(Integer id);
}
