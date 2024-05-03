package com.nogueira.springexpert.core.dataprovider.produto;

import com.nogueira.springexpert.core.domain.Produto;

public interface FindProdutoById {
   Produto find(Integer id);
}
