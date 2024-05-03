package com.nogueira.springexpert.core.usecase.impl.produto;

import com.nogueira.springexpert.core.dataprovider.produto.FindProdutos;
import com.nogueira.springexpert.core.domain.Produto;
import com.nogueira.springexpert.core.usecase.produto.FindProdutosUseCase;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class FindProdutosUseCaseImpl implements FindProdutosUseCase {
   private final FindProdutos findProdutos;

   public FindProdutosUseCaseImpl(FindProdutos findProdutos) {
      this.findProdutos = findProdutos;
   }

   public Page<Produto> find(Pageable pageable) {
      return this.findProdutos.find(pageable);
   }
}
