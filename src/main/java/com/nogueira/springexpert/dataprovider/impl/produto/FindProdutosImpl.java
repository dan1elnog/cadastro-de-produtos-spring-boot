package com.nogueira.springexpert.dataprovider.impl.produto;

import com.nogueira.springexpert.core.dataprovider.produto.FindProdutos;
import com.nogueira.springexpert.core.domain.Produto;
import com.nogueira.springexpert.dataprovider.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class FindProdutosImpl implements FindProdutos {
   @Autowired
   private ProdutoRepository produtoRepository;

   public Page<Produto> find(Pageable pageable) {
      return this.produtoRepository.findAll(pageable);
   }
}
