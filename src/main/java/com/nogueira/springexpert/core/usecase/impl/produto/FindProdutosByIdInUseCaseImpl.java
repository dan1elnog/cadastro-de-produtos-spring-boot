package com.nogueira.springexpert.core.usecase.impl.produto;

import com.nogueira.springexpert.core.dataprovider.produto.FindProdutosByIdIn;
import com.nogueira.springexpert.core.domain.Produto;
import com.nogueira.springexpert.core.usecase.produto.FindProdutosByIdInUseCase;
import java.util.List;

public class FindProdutosByIdInUseCaseImpl implements FindProdutosByIdInUseCase {
   private final FindProdutosByIdIn findProdutosByIdIn;

   public FindProdutosByIdInUseCaseImpl(FindProdutosByIdIn findProdutosByIdIn) {
      this.findProdutosByIdIn = findProdutosByIdIn;
   }

   public List<Produto> findByidIn(List<Integer> ids) {
      return this.findProdutosByIdIn.findByIdIn(ids);
   }
}
