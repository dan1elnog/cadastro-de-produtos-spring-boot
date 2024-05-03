package com.nogueira.springexpert.entrypoint.controller.response;

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
public class InformacoesPedidoResponse {

   private String codigo;
   private String cpf;
   private String nomeCliente;
   private String dataPedido;
   private String status;
   private BigDecimal total;
   private List<InformacoesItemPedidoResponse> items;
}
