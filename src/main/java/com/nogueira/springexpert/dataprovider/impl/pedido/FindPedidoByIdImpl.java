package com.nogueira.springexpert.dataprovider.impl.pedido;

import com.nogueira.springexpert.core.dataprovider.pedido.FindPedidoById;
import com.nogueira.springexpert.core.domain.Pedido;
import com.nogueira.springexpert.dataprovider.repository.PedidoRepository;
import com.nogueira.springexpert.util.exception.RegraNegocioException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FindPedidoByIdImpl implements FindPedidoById {
   @Autowired
   private PedidoRepository pedidoRepository;

   public Pedido find(Integer id) {
      return (Pedido)this.pedidoRepository.findById(id).orElseThrow(() -> {
         return new RegraNegocioException("PEDIDO NAO ENCONTRADO");
      });
   }
}
