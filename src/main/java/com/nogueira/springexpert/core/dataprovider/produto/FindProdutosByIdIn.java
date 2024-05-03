package com.nogueira.springexpert.core.dataprovider.produto;

import com.nogueira.springexpert.core.domain.Produto;
import java.util.List;

public interface FindProdutosByIdIn {
   List<Produto> findByIdIn(List<Integer> ids);
}
