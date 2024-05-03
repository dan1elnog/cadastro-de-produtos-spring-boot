package com.nogueira.springexpert.core.usecase.impl.produto;

import com.nogueira.springexpert.core.dataprovider.produto.FindProdutoById;
import com.nogueira.springexpert.core.domain.Produto;
import com.nogueira.springexpert.core.usecase.produto.FindProdutoByIdUseCase;

public class FindProdutoByIdUseCaseImpl implements FindProdutoByIdUseCase {
   private final FindProdutoById findProdutoById;

   public FindProdutoByIdUseCaseImpl(FindProdutoById findProdutoById) {
      this.findProdutoById = findProdutoById;
   }

   public Produto find(Integer id) {
      return this.findProdutoById.find(id);
   }
}
