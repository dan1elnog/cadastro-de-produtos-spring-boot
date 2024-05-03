package com.nogueira.springexpert.core.usecase.produto;

import com.nogueira.springexpert.core.domain.Produto;

public interface FindProdutoByIdUseCase {
   Produto find(Integer id);
}
