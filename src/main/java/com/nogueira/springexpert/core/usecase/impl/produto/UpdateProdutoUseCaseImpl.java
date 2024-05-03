package com.nogueira.springexpert.core.usecase.impl.produto;

import com.nogueira.springexpert.core.dataprovider.produto.FindProdutoById;
import com.nogueira.springexpert.core.dataprovider.produto.UpdateProduto;
import com.nogueira.springexpert.core.domain.Produto;
import com.nogueira.springexpert.core.usecase.produto.UpdateProdutoUseCase;

public class UpdateProdutoUseCaseImpl implements UpdateProdutoUseCase {
   private final FindProdutoById findProdutoById;
   private final UpdateProduto updateProduto;

   public UpdateProdutoUseCaseImpl(FindProdutoById findProdutoById, UpdateProduto updateProduto) {
      this.findProdutoById = findProdutoById;
      this.updateProduto = updateProduto;
   }

   public void update(Produto produtoRequest) {
      Produto produto = this.findProdutoById.find(produtoRequest.getId());
      produto.setPreco(produtoRequest.getPreco());
      produto.setDescricao(produtoRequest.getDescricao());
      this.updateProduto.update(produto);
   }
}
