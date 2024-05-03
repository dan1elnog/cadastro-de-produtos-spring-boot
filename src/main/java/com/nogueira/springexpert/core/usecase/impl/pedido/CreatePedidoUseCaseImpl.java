package com.nogueira.springexpert.core.usecase.impl.pedido;

import com.nogueira.springexpert.core.dataprovider.cliente.FindClienteById;
import com.nogueira.springexpert.core.dataprovider.pedido.CreateItemPedido;
import com.nogueira.springexpert.core.dataprovider.pedido.CreatePedido;
import com.nogueira.springexpert.core.dataprovider.produto.FindProdutosByIdIn;
import com.nogueira.springexpert.core.domain.ItemPedido;
import com.nogueira.springexpert.core.domain.Pedido;
import com.nogueira.springexpert.core.domain.Produto;
import com.nogueira.springexpert.core.usecase.pedido.CreatePedidoUseCase;
import com.nogueira.springexpert.entrypoint.controller.request.ItemPedidoRequest;
import com.nogueira.springexpert.entrypoint.controller.request.PedidoRequest;
import com.nogueira.springexpert.util.exception.RegraNegocioException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class CreatePedidoUseCaseImpl implements CreatePedidoUseCase {
   private final CreatePedido createPedido;
   private final FindClienteById findClienteById;
   private final FindProdutosByIdIn findProdutosByIdIn;
   private final CreateItemPedido createItemPedido;

   public CreatePedidoUseCaseImpl(CreatePedido createPedido, FindClienteById findClienteById, FindProdutosByIdIn findProdutosByIdIn, CreateItemPedido createItemPedido) {
      this.createPedido = createPedido;
      this.findClienteById = findClienteById;
      this.findProdutosByIdIn = findProdutosByIdIn;
      this.createItemPedido = createItemPedido;
   }

   public Pedido create(PedidoRequest pedidoRequest) {
      Pedido pedido = new Pedido();
      pedido.setTotal(pedidoRequest.getTotal());
      pedido.setDataPedido(LocalDate.now());
      pedido.setCliente(this.findClienteById.find(pedidoRequest.getClienteId()));
      pedido.setItemPedidos(this.gerarListaItemsPedido(pedidoRequest.getItems(), pedido));
      this.createPedido.create(pedido);
      this.createItemPedido.create(pedido.getItemPedidos());
      return pedido;
   }

   private List<ItemPedido> gerarListaItemsPedido(List<ItemPedidoRequest> pedidoRequestList, Pedido pedido) {
      if (!Objects.isNull(pedidoRequestList) && !pedidoRequestList.isEmpty()) {
         List<ItemPedido> itemPedidoList = new ArrayList();
         List<Integer> ids = (List)pedidoRequestList.stream().map(ItemPedidoRequest::getProdutoId).collect(Collectors.toList());
         List<Produto> produtos = this.findProdutosByIdIn.findByIdIn(ids);
         Map<Integer, Produto> produtosMap = (Map)produtos.stream().collect(Collectors.toMap(Produto::getId, Function.identity()));
         pedidoRequestList.forEach((pedidoRequest) -> {
            Produto produto = (Produto)produtosMap.get(pedidoRequest.getProdutoId());
            if (Objects.isNull(produto)) {
               throw new RegraNegocioException("NAO FOI POSSIVEL ENCONTRAR UM DOS PRODUTOS INFORMADOS!");
            } else {
               ItemPedido itemPedido = new ItemPedido();
               itemPedido.setPedido(pedido);
               itemPedido.setProduto(produto);
               itemPedido.setQuantidade(pedidoRequest.getQuantidade());
               itemPedidoList.add(itemPedido);
            }
         });
         return itemPedidoList;
      } else {
         throw new RegraNegocioException("NAO E POSSIVEL REALIZAR UM PEDIDO SEM ITEMS!");
      }
   }
}
