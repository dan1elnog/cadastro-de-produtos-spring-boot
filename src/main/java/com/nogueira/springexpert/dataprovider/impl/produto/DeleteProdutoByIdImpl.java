package com.nogueira.springexpert.dataprovider.impl.produto;

import com.nogueira.springexpert.core.dataprovider.produto.DeleteProdutoById;
import com.nogueira.springexpert.dataprovider.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteProdutoByIdImpl implements DeleteProdutoById {
   @Autowired
   private ProdutoRepository produtoRepository;

   public void delete(Integer id) {
      this.produtoRepository.deleteById(id);
   }
}
