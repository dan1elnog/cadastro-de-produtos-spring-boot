package com.nogueira.springexpert.dataprovider.impl.produto;

import com.nogueira.springexpert.core.dataprovider.produto.CreateProduto;
import com.nogueira.springexpert.core.domain.Produto;
import com.nogueira.springexpert.dataprovider.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateProdutoImpl implements CreateProduto {
   @Autowired
   private ProdutoRepository produtoRepository;

   public void create(Produto produto) {
      this.produtoRepository.save(produto);
   }
}
