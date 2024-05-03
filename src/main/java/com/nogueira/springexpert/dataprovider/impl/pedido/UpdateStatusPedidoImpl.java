package com.nogueira.springexpert.dataprovider.impl.pedido;

import com.nogueira.springexpert.core.dataprovider.pedido.UpdateStatusPedido;
import com.nogueira.springexpert.core.domain.Pedido;
import com.nogueira.springexpert.dataprovider.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateStatusPedidoImpl implements UpdateStatusPedido {
   @Autowired
   private PedidoRepository pedidoRepository;

   public void update(Pedido pedido) {
      this.pedidoRepository.save(pedido);
   }
}
