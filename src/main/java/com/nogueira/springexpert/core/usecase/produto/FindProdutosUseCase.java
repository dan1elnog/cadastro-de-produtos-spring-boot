package com.nogueira.springexpert.core.usecase.produto;

import com.nogueira.springexpert.core.domain.Produto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface FindProdutosUseCase {
   Page<Produto> find(Pageable pageable);
}
