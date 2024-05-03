package com.nogueira.springexpert.entrypoint.controller;

import com.nogueira.springexpert.core.enums.StatusPedido;
import com.nogueira.springexpert.core.usecase.pedido.CreatePedidoUseCase;
import com.nogueira.springexpert.core.usecase.pedido.UpdateStatusPedidoUseCase;
import com.nogueira.springexpert.entrypoint.controller.mapper.PedidoMapper;
import com.nogueira.springexpert.entrypoint.controller.request.PedidoRequest;
import com.nogueira.springexpert.entrypoint.controller.response.InformacoesPedidoResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/pedido")
@Tag(name = "Pedido", description = "Pedido Controller")
public class PedidoController {

   @Autowired
   private CreatePedidoUseCase createPedidoUseCase;

   @Autowired
   private UpdateStatusPedidoUseCase updateStatusPedidoUseCase;

   @Autowired
   private PedidoMapper pedidoMapper;

   @PostMapping
   @Operation(summary = "Requisição POST para criar um pedido")
   public ResponseEntity<Integer> create(@RequestBody @Valid PedidoRequest pedidoRequest) {
      return ResponseEntity.ok(this.createPedidoUseCase.create(pedidoRequest).getId());
   }

   @GetMapping(path = "/{id}")
   @Operation(summary = "Requisição GET para buscar um pedido por id")
   public ResponseEntity<InformacoesPedidoResponse> findById(@PathVariable("id") Integer id) {
      return ResponseEntity.ok(this.pedidoMapper.toInformacoesPedidoResponse(id));
   }

   @PatchMapping(path = "/atualizar-status-pedido/{id}")
   @Operation(summary = "Requisição PUT para atualizar um pedido")
   public ResponseEntity<Void> update(@PathVariable("id") Integer id, @RequestBody String statusPedido) {
      this.updateStatusPedidoUseCase.update(id, StatusPedido.valueOf(statusPedido));
      return ResponseEntity.ok().build();
   }
}
