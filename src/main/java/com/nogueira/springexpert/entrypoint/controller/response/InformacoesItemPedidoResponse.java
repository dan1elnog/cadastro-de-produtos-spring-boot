package com.nogueira.springexpert.entrypoint.controller.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InformacoesItemPedidoResponse {

   private String descricaoProduto;
   private BigDecimal precoUnitario;
   private Integer quantidade;
}
