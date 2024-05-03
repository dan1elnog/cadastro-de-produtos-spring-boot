package com.nogueira.springexpert.entrypoint.controller.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ItemPedidoRequest {

   private Integer produtoId;
   private Integer quantidade;
}
