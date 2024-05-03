package com.nogueira.springexpert.entrypoint.controller.mapper;

import com.nogueira.springexpert.core.domain.ItemPedido;
import com.nogueira.springexpert.core.domain.Pedido;
import com.nogueira.springexpert.core.usecase.pedido.FindPedidoByIdUseCase;
import com.nogueira.springexpert.entrypoint.controller.response.InformacoesItemPedidoResponse;
import com.nogueira.springexpert.entrypoint.controller.response.InformacoesPedidoResponse;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.nogueira.springexpert.entrypoint.controller.response.InformacoesItemPedidoResponse;
import com.nogueira.springexpert.entrypoint.controller.response.InformacoesPedidoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoMapper {
   @Autowired
   private FindPedidoByIdUseCase findPedidoByIdUseCase;

   public InformacoesPedidoResponse toInformacoesPedidoResponse(Integer id) {
      Pedido pedido = this.findPedidoByIdUseCase.find(id);
      return InformacoesPedidoResponse.builder().cpf(pedido.getCliente().getCpf()).items(this.getItemsInformacoesPedidoResponse(pedido.getItemPedidos())).total(pedido.getTotal()).codigo(pedido.getId().toString()).status(pedido.getStatusPedido().name()).dataPedido(pedido.getDataPedido().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))).nomeCliente(pedido.getCliente().getNome()).build();
   }

   private List<InformacoesItemPedidoResponse> getItemsInformacoesPedidoResponse(List<ItemPedido> itemsPedido) {
      List<InformacoesItemPedidoResponse> informacoesItemPedidoResponseList = new ArrayList();
      itemsPedido.forEach((item) -> {
         informacoesItemPedidoResponseList.add(InformacoesItemPedidoResponse.builder().quantidade(item.getQuantidade()).precoUnitario(item.getProduto().getPreco()).descricaoProduto(item.getProduto().getDescricao()).build());
      });
      return informacoesItemPedidoResponseList;
   }
}
