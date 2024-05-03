package com.nogueira.springexpert.entrypoint.controller.request;

import com.nogueira.springexpert.util.validation.NotEmptyList;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PedidoRequest {

   @NotNull(message = "{campo.codigo_cliente.obrigatorio}")
   private Integer clienteId;

   @NotNull(message = "{campo.total_pedido.obrigatorio}")
   private BigDecimal total;

   @NotEmptyList(message = "{campo.items_pedido.obrigatorio}")
   private List<ItemPedidoRequest> items;

}
