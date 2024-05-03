package com.nogueira.springexpert.core.usecase.impl.produto;

import com.nogueira.springexpert.core.dataprovider.produto.CreateProduto;
import com.nogueira.springexpert.core.domain.Produto;
import com.nogueira.springexpert.core.usecase.produto.CreateProdutoUseCase;

public class CreateProdutoUseCaseImpl implements CreateProdutoUseCase {
   private final CreateProduto createProduto;

   public CreateProdutoUseCaseImpl(CreateProduto createProduto) {
      this.createProduto = createProduto;
   }

   public void create(Produto produto) {
      this.createProduto.create(produto);
   }
}
