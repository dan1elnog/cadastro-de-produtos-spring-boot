package com.nogueira.springexpert.entrypoint.controller;

import com.nogueira.springexpert.core.domain.Produto;
import com.nogueira.springexpert.core.usecase.produto.*;
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
@RequestMapping(path = "/api/produto")
@Tag(name = "Produto", description = "Produto Controller")
public class ProdutoController {

   @Autowired
   private FindProdutoByIdUseCase findProdutoByIdUseCase;

   @Autowired
   private CreateProdutoUseCase createProdutoUseCase;

   @Autowired
   private DeleteProdutoByIdUseCase deleteProdutoByIdUseCase;

   @Autowired
   private UpdateProdutoUseCase updateProdutoUseCase;

   @Autowired
   private FindProdutosUseCase findProdutosUseCase;

   @GetMapping(path = "/{id}")
   @Operation(summary = "Requisição GET para buscar um produto por id")
   public ResponseEntity<Produto> findProdutoById(@PathVariable("id") Integer id) {
      return ResponseEntity.ok(this.findProdutoByIdUseCase.find(id));
   }

   @PostMapping
   @Operation(summary = "Requisição POST para criar um produto")
   public ResponseEntity<Void> createProduto(@RequestBody @Valid Produto produto) {
      this.createProdutoUseCase.create(produto);
      return ResponseEntity.ok().build();
   }

   @DeleteMapping(path = {"/{id}"})
   @Operation(summary = "Requisição DELETE para excluir um produto por id")
   public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
      this.deleteProdutoByIdUseCase.delete(id);
      return ResponseEntity.noContent().build();
   }

   @PutMapping
   @Operation(summary = "Requisição PUT para atualizar um produto")
   public ResponseEntity<Void> update(@RequestBody @Valid Produto produto) {
      this.updateProdutoUseCase.update(produto);
      return ResponseEntity.ok().build();
   }

   @GetMapping
   @Operation(summary = "Requisição get para buscar um page de produto")
   public ResponseEntity<Page<Produto>> findProdutos(Pageable pageable) {
      return ResponseEntity.ok(this.findProdutosUseCase.find(pageable));
   }
}
