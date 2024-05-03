package com.nogueira.springexpert.dataprovider.impl.produto;

import com.nogueira.springexpert.core.dataprovider.produto.FindProdutosByIdIn;
import com.nogueira.springexpert.core.domain.Produto;
import com.nogueira.springexpert.dataprovider.repository.ProdutoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FindProdutosByIdImpl implements FindProdutosByIdIn {
   @Autowired
   private ProdutoRepository produtoRepository;

   public List<Produto> findByIdIn(List<Integer> ids) {
      return this.produtoRepository.findAllById(ids);
   }
}
