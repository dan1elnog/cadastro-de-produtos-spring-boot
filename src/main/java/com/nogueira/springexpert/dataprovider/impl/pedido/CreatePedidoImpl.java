package com.nogueira.springexpert.dataprovider.impl.pedido;

import com.nogueira.springexpert.core.dataprovider.pedido.CreatePedido;
import com.nogueira.springexpert.core.domain.Pedido;
import com.nogueira.springexpert.dataprovider.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreatePedidoImpl implements CreatePedido {
   @Autowired
   private PedidoRepository pedidoRepository;

   public Pedido create(Pedido pedido) {
      return (Pedido)this.pedidoRepository.save(pedido);
   }
}
