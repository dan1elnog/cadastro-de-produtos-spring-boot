package com.nogueira.springexpert.core.usecase.pedido;

import com.nogueira.springexpert.core.domain.Pedido;
import com.nogueira.springexpert.entrypoint.controller.request.PedidoRequest;

public interface CreatePedidoUseCase {
   Pedido create(PedidoRequest pedidoRequest);
}
