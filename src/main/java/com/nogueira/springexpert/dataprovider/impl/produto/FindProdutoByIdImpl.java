package com.nogueira.springexpert.dataprovider.impl.produto;

import com.nogueira.springexpert.core.dataprovider.produto.FindProdutoById;
import com.nogueira.springexpert.core.domain.Produto;
import com.nogueira.springexpert.dataprovider.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FindProdutoByIdImpl implements FindProdutoById {
   @Autowired
   private ProdutoRepository produtoRepository;

   public Produto find(Integer id) {
      return (Produto)this.produtoRepository.findById(id).orElseThrow(() -> {
         return new RuntimeException("PRODUTO NAO ENCONTRADO");
      });
   }
}
