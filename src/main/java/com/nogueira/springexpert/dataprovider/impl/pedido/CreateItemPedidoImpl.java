package com.nogueira.springexpert.dataprovider.impl.pedido;

import com.nogueira.springexpert.core.dataprovider.pedido.CreateItemPedido;
import com.nogueira.springexpert.core.domain.ItemPedido;
import com.nogueira.springexpert.dataprovider.repository.ItemPedidoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateItemPedidoImpl implements CreateItemPedido {
   @Autowired
   private ItemPedidoRepository itemPedidoRepository;

   public void create(List<ItemPedido> itemPedidoList) {
      this.itemPedidoRepository.saveAll(itemPedidoList);
   }
}
