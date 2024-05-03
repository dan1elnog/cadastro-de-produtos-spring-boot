package com.nogueira.springexpert.core.usecase.impl.produto;

import com.nogueira.springexpert.core.dataprovider.produto.DeleteProdutoById;
import com.nogueira.springexpert.core.dataprovider.produto.FindProdutoById;
import com.nogueira.springexpert.core.domain.Produto;
import com.nogueira.springexpert.core.usecase.produto.DeleteProdutoByIdUseCase;

public class DeleteProdutoByIdUseCaseimpl implements DeleteProdutoByIdUseCase {
   private final FindProdutoById findProdutoById;
   private final DeleteProdutoById deleteProdutoById;

   public DeleteProdutoByIdUseCaseimpl(FindProdutoById findProdutoById, DeleteProdutoById deleteProdutoById) {
      this.findProdutoById = findProdutoById;
      this.deleteProdutoById = deleteProdutoById;
   }

   public void delete(Integer id) {
      Produto produto = this.findProdutoById.find(id);
      this.deleteProdutoById.delete(produto.getId());
   }
}
