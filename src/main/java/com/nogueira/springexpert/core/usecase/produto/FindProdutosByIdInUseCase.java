package com.nogueira.springexpert.core.usecase.produto;

import com.nogueira.springexpert.core.domain.Produto;
import java.util.List;

public interface FindProdutosByIdInUseCase {
   List<Produto> findByidIn(List<Integer> ids);
}
