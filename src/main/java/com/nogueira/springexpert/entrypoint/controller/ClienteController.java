package com.nogueira.springexpert.entrypoint.controller;

import com.nogueira.springexpert.core.domain.Cliente;
import com.nogueira.springexpert.core.usecase.cliente.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/cliente")
@Tag(name = "Cliente", description = "Cliente Controller")
public class ClienteController {

   @Autowired
   private FindClienteByIdUseCase findClienteByIdUseCase;

   @Autowired
   private CreateClienteUseCase createClienteUseCase;

   @Autowired
   private DeleteClienteByIdUseCase deleteClienteByIdUseCase;

   @Autowired
   private UpdateClienteUseCase updateClienteUseCase;

   @Autowired
   private FindClientesUseCase findClientesUseCase;

   @GetMapping(path = "/{id}")
   @Operation(summary = "Requisição GET para encontrar um cliente por id")
   public ResponseEntity<Cliente> findClienteById(@PathVariable("id") Integer id) {
      return ResponseEntity.ok(this.findClienteByIdUseCase.find(id));
   }

   @PostMapping
   @Operation(summary = "Requisição POST para criar um cliente")
   public ResponseEntity createCliente(@RequestBody @Valid Cliente clienteRequest) {
      this.createClienteUseCase.create(clienteRequest);
      return ResponseEntity.ok().build();
   }

   @DeleteMapping(path = "/{id}")
   @Operation(summary = "Requisição DELETE para excluir um cliente por id")
   public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
      this.deleteClienteByIdUseCase.delete(id);
      return ResponseEntity.noContent().build();
   }

   @PutMapping
   @Operation(summary = "Requisição PUT para atualizar um cliente")
   public ResponseEntity<Void> update(@RequestBody @Valid Cliente cliente) {
      this.updateClienteUseCase.update(cliente);
      return ResponseEntity.ok().build();
   }

   @GetMapping
   @Operation(summary = "Requisição GET para retornar um Page de clientes")
   public ResponseEntity<Page<Cliente>> findClienteList(Pageable pageable) {
      return ResponseEntity.ok(this.findClientesUseCase.find(pageable));
   }
}
