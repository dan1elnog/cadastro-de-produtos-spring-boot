package com.nogueira.springexpert.core.usecase.pedido;

import com.nogueira.springexpert.core.domain.Pedido;

public interface FindPedidoByIdUseCase {
   Pedido find(Integer id);
}
