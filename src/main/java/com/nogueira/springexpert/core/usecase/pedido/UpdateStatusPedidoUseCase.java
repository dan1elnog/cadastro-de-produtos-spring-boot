package com.nogueira.springexpert.core.usecase.pedido;

import com.nogueira.springexpert.core.enums.StatusPedido;

public interface UpdateStatusPedidoUseCase {
   void update(Integer id, StatusPedido statusPedido);
}
